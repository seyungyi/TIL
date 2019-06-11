## [ JDBC 프로그래밍 정리 ]

ODBC --> C, C++

- JDBC API(Interface) + JDBC Driver 로 구동이 된다.
  	Java.sql이 내장			DB서버에 따로 추가로 준비(Oracle에서 제공하는 thin:)

- JDBC 프로그래밍의 구현 과정
  1. JDBC 드라이버 로딩(Class.forName(JDBC드라이버의 대표 클래스이름))
  2. DB서버 접속(DriverManager.getConnection(JDBC URL, ID, PASSWD))
  3. Statement, PreparedStatement 객체 생성(Connection이 팩토리메소드를 가짐)
  4. executeQuery(),   executeUpdate()
        ResultSet            int  (<-- 리턴값의 유형들)
     next(), getXXX()    변화된 행의 갯수
  5. 연결된 자원 해제 : 순차적으로 close()