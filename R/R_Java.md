# [ R과 Java의 연동 ]

## 패키지

- RServe

  - R 바이너리 서버라고 불리우는 프로그램으로서 Java나 다른 언어에서 R 코드를 연동할 때 필요한 기능을 서포트하는 서버.

  - Java, C, PHP 등의 다른 프로그램에서 TCP/IP로 R에 원격 접속, 인증, 파일전송을 가능하게 해준다.

    ```R
    install.packages("Rserve")
    ```

- rJava

  - Java 언어로서 R 기술을 연동할 때 필요한 기본 API를 담고 있는 패키지

## Spring으로 R과 Java 연결하기

1. redu라는 Spring MVC Project 생성
   - 중간에 입력하는 top-level 패키지명 : edu.spring.redu
2. pom.xml 에 `<dependency>` 태그 추가하기
   - Rserve를 사용하기 위해 API 설치를 위해
3. pom.xml 에서 Java버전과 Spring 버전 정보 수정하기
   - project facet 도 수정. Java 1.8 로 변경
4. Query 문자열 추출시 한글 문제가 해결되도록 환경 설정 추가하기
   - web.xml에 한글 Filter 클래스 등록
5. 소스 내용을 검토하고 servlet-context.xml 에 component-scan 태그를 추가한다. 

## Rserve를 사용하기 위한 pom.xml 설정

- Java에서 R을 사용하기 위해서는 Rserve와 REngine 2개 라이브러리가 필요
- 홈페이지 다운로드 또는 dependency 등록해 사용 가능

```xml
<!-- Rserve & REngine -->
<dependency>
	<groupId>com.github.lucarosellini.rJava</groupId>
	<artifactId>JRIEngine</artifactId>
	<version>0.9-7</version>
</dependency>
<dependency>
	<groupId>net.rforge</groupId>
	<artifactId>Rserve</artifactId>
	<version>0.6-8.1</version>
</dependency>
```

## Rserve에 접속하는 명령 실행 - RConnection

- RConnection은 R에 접속하여 핵심적인 역할을 수행하는 클래스
- R에 접속, 인증, 세션 종료, 파일 생성, 파일 읽기, 자료 전송, 자료 조회 등을 처리
- eval() : R에 직접적인 명령을 내리고 REXP 타입으로 데이터를 반환
- assign() : R의 변수에 REXP 또는 String 형태로 데이터를 지정해 설정함

## REXP 타입

- R과 Java에서 서로의 자료구조와 타입을 서로 사용할 수 있도록 지원하는 데이터 모델 형의 클래스
- 클래스에서 데이터 프레임과 행렬 구조로 데이터 모델을 생성 시킬 수 있음

```
asBytes	- Byte 일차원 배열형으로 반환하여 준다
asDouble - double 형으로 반환해 준다
asDoubleMatrix - double 이차원 배열형으로 반환해 준다
asDoubles - double 일차원 배열형으로 반환해 준다
asList - RList 형으로 반환해 준다
asString - String 형으로 반환해 준다
asStrings - String 일차원 배열형으로 반환해 준다
length - 데이터의 개수를 알 수 있다
```

## R 데이터 프레임을 Java에서 사용 - RList

- Map 인터페이스를 구현하고 있는 RList는 내부적으로 Vector 값들을 지닌 리스트들이 관리하고있다.
- RList를 이용하여 데이터 프레임과 같은 자료 구조를 사용할 수 있음
- at : Index 또는 변수명에 해당하는 열 데이터들을 REXP 객체로 반환
- size : 리스트의 개수를 알 수 있다

## Rserve 기동하기

1. RStudio 에서 기동시키기

   ```R
   Rserve(args="--RS-encoding utf8")
   ```

2. CMD 창에서 단독으로 기동시키기(단독 기동 기능, 오류 메시지 확인 장점)

   ```
   1. C:\Program Files\R\R-xxxx\library\Rserve\libs\x64 의 모든 파일 복사
   2. C:\Program Files\R\R-xxxx\bin\x64 에 붙여넣기
   3. 붙여넣은 폴더경로로 CMD 이동
   4. 아래 명령어 수행
   Rserve --RS-encoding utf8
   ```
   
3. Rserve 예제

```java
package rjava;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RServeExample {
	public static void getString() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("R.version.string");
		System.out.println("R 버전 정보 : " + x.asString());
		rc.close();
	}
	public static void getInteger() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("length(LETTERS)");
		System.out.println("알파벳 갯수 : " + x.asInteger());
		rc.close();
	}
	public static void getDoubles() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("rnorm(20)");
		double[] d = x.asDoubles();
		for(int i=0; i<d.length; i++) {
			System.out.println(d[i]);
		}
		rc.close();
	}
	public static void getIntegers() throws REngineException, REXPMismatchException {
		RConnection rc = new RConnection();
		double[] dataX = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		rc.assign("x",  dataX);
		rc.eval("y <- x + 10");
		int[] resultX = rc.eval("y").asIntegers();
		for(int i=0; i<resultX.length; i++) {
			System.out.println(resultX[i]);
		}
		rc.close();
	}
	public static void getDataFrame1() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("d <- data.frame(LETTERS[11:20], c(11:20), stringsAsFactors=F)");
		RList list = x.asList();
		int v_size = list.size();
		int d_length = list.at(0).length();
		System.out.println("데이터(관측치)의 갯수 : " + d_length);
		System.out.println("변수의 갯수 : " + v_size);
		
		int arrayRows = v_size;
		int arrayCols = d_length;
		String[][] s = new String[arrayRows][];	// 데이터프레임의 변수 갯수로 행의 크기
		for(int i=0; i<arrayRows; i++) {
			s[i] = list.at(i).asStrings();
		}
		for(int i=0; i<arrayRows; i++) {
			for(int j=0; j<arrayCols; j++) {
				System.out.print(s[i][j] + "\t");
			}
			System.out.println();
		}
		rc.close();
	}
	public static void main(String[] args) throws REXPMismatchException, REngineException {
		System.out.println("--------------- R 에서 버젼정보 가져오기 ------------------");
		RServeExample.getString();
		System.out.println("--------------- R 에서 정수 데이터 가져오기 ------------------");
		RServeExample.getInteger();
		System.out.println("--------------- R 에서 더블 데이터들가져오기 ------------------");
		RServeExample.getDoubles();
		System.out.println("--------------- R 에서 데이터 주입 연산후 가져오기 ------------------");
		RServeExample.getIntegers();
		System.out.println("--------------- R 에서 데이터 생성(데이터 프레임) 연산후 가져오기 ------------------");
		RServeExample.getDataFrame1();
	}
}
```