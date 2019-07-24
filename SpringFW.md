# [ Spring FrameWork ]

### < FrameWork >

- 1998, 2004~2006
- 스마트 라이브러리 ( 라이브러리 + 다스크립터 파일(XML))
- EJB(1998), Servlet, Struts, iBatis(MyBatis), Spring, Spring MVC, Java+XML

---

## < Spring FrameWork >

- 장점
  - 소스 코드의 코딩량을 줄여주고 유지보수성이 좋은 프로그램을 개발시 사용되는 FX
- 웹 서버 프로그래밍
  - Spring MVC
  - Spring IoC(Spring DI : Spring Dependency Injection)
    - 의존성 : 프로그래밍에서는 객체와 객체간의 의존 의미
      - A라는 클래스에서 B라는 클래스의 메소드를 불러와 실행할때 그것을 의존한다 생각하면됨
      - B클래스 메소드 이름이 바뀔시 A에서는 메소드를 찾을 수 없기에 똑같이 변경하는 불편함 발생
- Eclipse EE = Eclipse for Java Developer + WTP + STS추가설치
- Spring Exercise Step
  1. Spring IoC
     - springioc 이름의 Java Project 생성
     - springioc를 Maven Project로 변환 -> [configure] - [convert to maven project] 선택
     - pom.xml을 수정하여 이 프로젝트에서 의존하는 추가라이브러리에 대한 정보 작성
  2. Spring MVC
  3. MyBatis
- DI
  - 기본방식의 의존성을 제거 후 별도로 3자가 만들어주는 의존객체를 각 클래스에 뿌려주는 기능으로 변경의 유연성을 제공하는 역할을 한다
  - [참고주소](<https://hunit.tistory.com/186>)
  - 의존객체 주입 방법
    - 생성자 방식(Constructor) - Constructor Injection
    - 메소드 방식(Property) - Setter Injection

---

## [ 추가 라이브러리 준비하는 방법 ]

1. 해당 라이브러리 압축파일( xxx.jar )을 사이트에서 다운로드 후 정해진 디렉토리에 저장 또는 Path설정
2. 추가로 설치하려는 라이브러리를 관리해주는 툴 존재( build tool )
   - 종류 : Maven, Graddle ..... 등
   - 확장자 : pom, xml .....

---

- autowired="byType"  : setter
  (1) 타입으로 찾아서 1개이면 해당 객체 주입
  (2) 타입으로 찾아서 2개 이상이면 NoUniqueBeanDefinitionException 발생
  (3) 없으면 null 주입

- autowired="byName"  : setter
  (1) 프로퍼티명과 동일한 명칭의 빈을 찾아서 해당 객체 주입
  (2) 없으면 null 주입

- autowired="constructor"  : constructor
  (1) 타입으로 찾아서 1개이면 해당 객체 주입
  (2) 타입으로 찾아서 2개 이상이면 매개변수명과 동일한 id 값을 갖는 객체 주입
  (3) 없으면 null 주입

- 필드에 설정된 @Autowired
  (1) 타입으로 찾아서 1개이면 해당 객체 주입
  (2) 타입으로 찾아서 2개 이상이면 변수명과 동일한 id 값을 갖는 객체 주입
  (3) 없으면 NoSuchBeanDefinitionException 발생 

  - required = false 속성을 사용하여 없으면 null 이 되게 지정 가능

  (4) @Qualifier(value="xxx")를 추가로 사용해서 변수명이 아닌 다른 이름 지정 가능

- 필드에 설정된 @Resource
  (1) 변수명과 동일한 id 값을 갖는 빈을 찾아서 해당 객체 주입
  (2) 타입으로 찾아서 1개이면 객체 주입
  (3) 타입으로 찾아서 2개이상 이면 NoUniqueBeanDefinitionException 발생
  (4) 없으면 NoSuchBeanDefinitionException 발생

---

- @RequestController : Controller 클래스 사용시 필수
- @RequestMapping("매핑명") : 매핑명 설정 애노테이션
- @RequestParam("파라미터 이름" 타입 변수명) : 파라미터로 설정된 값을 변수명 주소에 저장
  - 만약 파라미터명이 동일한 경우 애노테이션부분을 생략할 수 있다
  - 매개변수안에서만 사용이 가능한 애노테이션이다
- DisPatcherServlet와 VO객체 사용
  - DispatcherServlet이 자동으로 VO객체의 변수명과 일치하는 경우 자동으로 VO객체에 값을 저장한다
  - jsp에서 VO객체를 사용할 경우 Class 이름의 첫 글자를 소문자로 바꾸어 객체참조를 할 수 있다.(  ex = queryVO.변수명 )
- Locale객체는 내장객체 ( 지역 정보에 대한 API )
- SessionAttributes("데이터이름")
  - 데이터이름으로 된 객체를 세션으로 보관하겠다는 의미
  - 복수개를 저장할 수 있다

---

## [ Spring MVC Project 개발 순서 ]

1. Spring Legecy Project 생성

   - 패키지명 네이밍규칙에 따라 생성
     1. 클래스나 메소드명은 파스칼 표기법을 따른다(첫문자 대문자)
     2. 변수, 파라미터 등은 카멜 표기법(최초사용단어를 제외한 단어 첫문자는 대문자)
     3. 변수에 모든 의미를 충분히 담을 것(접두사 제외)
     4. a, i, j 같이 하나의 문자로 된 이름은 사용하지 말것(반복문 제외)
     5. 네임스페이스(패키지명 등)은 회사 표준 패턴을 사용(ex: <com/org>.<회사명>.<제품명/프로젝트명>.<최상위모듈>.<하위모듈>)
     6. 키워드와 비슷한 이름은 사용하지 말 것(다른 단어와의 조합은 제외)
     7. Boolean 변수에는 is접두어를 사용(ex: isFind, isExist)

2. Config Setting

   - Character encoding setting

   ```xml
   web.xml 아래부분에 추가할 소스
   <!-- Character Set Filter -->
   <filter>
   		<filter-name>encodingFilter</filter-name>
   		<filter-class>			org.springframework.web.filter.CharacterEncodingFilter
   		</filter-class>
   		<init-param>
   			<param-name>encoding</param-name>
   			<param-value>UTF-8</param-value>
   		</init-param>
   
   		<init-param>
   			<param-name>forceEncoding</param-name>
   			<param-value>true</param-value>
   		</init-param>
   	</filter>
   
   	<filter-mapping>
   		<filter-name>encodingFilter</filter-name>
   		<url-pattern>/*</url-pattern>
   	</filter-mapping>
   ```

   - Dependency
     - `<Dependencies>`태그 안에 `<Dependency>`로 설정
     - 사용할 라이브러리마다 추가 필수
   - Version Config
     - pom.xml에서 1.6version을 현재 설치한 jdk버전으로 변경
     - 그 아래 릴리즈 버전도 5.0.2로 변경
   - 만약 Config파일을 한 곳에서 관리하고자 할때
     - [참고1](<https://freehoon.tistory.com/101>)