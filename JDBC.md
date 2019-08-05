# [JDBC 프로그래밍 정리]

## JDBC란?

- JDBC (Java DataBase Connectivity)

  -> **java에서 DB에 접속할 수 있게 해주는 API**이다. DB서버와 무관하게 구동된다.

  -> **(JDBC API + JDBC Driver)**로 구성된다.

  - JDBC API

    -> java.sql, javax.sql 패키지에 속하고 **대부분의 API가 interface**이다.

     ex) Connection, Statement, PreparedStatement, ResultSet 등

  - JDBC Driver

    -> **JDBC API의 자식 클래스를 제공**하며 DB서버에 따로 추가해서 준비해야 한다.

- cf) ODBC (Open DataBase Connectivity)

  -> 프로그래밍 언어와 무관하게 모든 응용프로그램에서 모든 데이터베이스 시스템과 통신 가능한

   개방형 인터페이스이다.

## JDBC 프로그램의 구현과정

1. JDBC 드라이버 로딩(Class.forName(대표 클래스이름))

2. DB 서버 접속(DriverManager.getConnection("JDBC URL","ID","PASSWORD"))

3. 수행하고자 하는 sql문장에 따라 Statement, PreparedStatement 객체 생성

   -> Connection 객체를 통해 팩토리 메서드를 호출한다.

   - Statement : createStatement()를 통해 객체 생성한다.

   - PreparedStatement : prepareStatement(sql)과 같이 sql문을 포함해 객체 생성한다.

     - Statement, PreparedStatement 모두 select 명령어에 의한 ResultSet은 1개만 만들어진다.

   - 팩토리 메서드란?

     -> 다른 클래스의 객체생성을 대신해주는 메서드이다.

4. executeQuery(), executeUpdate()

   - executeQuery()

     -> select 전용이다.

     -> 리턴값이 ResultSet으로 커서를 옮겨서 추출하고자 하는 열값을 추출한다.

     -> select 된 결과가 없으면 추출된 결과가 없다.

   - executeUpdate()

   - -> insert, update, delete 전용이다.

   -> 리턴값이 int 로 sql문 수행에 따라 변화된 행의 개수를 의미한다.

5. close()

   -> 연결된 자원을 해제한다.

## 실습결과

```java
package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEmp2 {
	public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		String sql="select ename, dname from emp e right join dept d using(deptno)" 
            		+"where dname=upper(?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = null;
		String dname = null, yesorno = null;

		label : while (true) {
			System.out.print("부서명을 입력해주세요. : ");
			dname = scan.next();
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if (rs.isBeforeFirst()) {
				while(rs.next()) {
					if (rs.getString(1)==null)
						System.out.println(dname + "부서에서 근무하는 직원이 없습니다.");
					else {
						do {
							System.out.println(rs.getString(1) + "부서에서 근무하는 직원들");
						} while (rs.next());
					}
				}
			}else 
				System.out.println(dname + "부서는 존재하지 않아요.");
			
			while (true) {
				System.out.print("계속 검토하시겠습니까? [yes/no] : ");
				yesorno = scan.next();
				if (yesorno.equals("yes"))
					continue label;
				else if (yesorno.equals("no"))
					break label;
				else {
					System.out.println("yes 또는 no로 다시 입력해주세요.");
					continue;
				}
			}
		}
		rs.close();
		pstmt.close();
		conn.close();	
        scan.close();
	}
}
```

출력>

```
부서명을 입력해주세요. : operations
operations부서에서 근무하는 직원이 없습니다.
계속 검토하시겠습니까? [yes/no] : yes
부서명을 입력해주세요. : sales
JAMES 부서에서 근무하는 직원들
TURNER 부서에서 근무하는 직원들
MARTIN 부서에서 근무하는 직원들
WARD 부서에서 근무하는 직원들
ALLEN 부서에서 근무하는 직원들
BLAKE 부서에서 근무하는 직원들
계속 검토하시겠습니까? [yes/no] : yes
부서명을 입력해주세요. : op
op부서는 존재하지 않아요.
계속 검토하시겠습니까? [yes/no] : no
```