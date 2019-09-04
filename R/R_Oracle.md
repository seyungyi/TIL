# [ R과 Oracle의 연동 ]

## 구현 과정

1. 드라이버프로그램 로딩(JDBC() 함수)
2. DBMS 서버 접속(dbConnect() 함수)
3. 수행하려는 데이터 처리 기능에 따라 삽입, 삭제, 수정, 추출관련 SQL 문을 전달하거나 관련 함수를 수행시켜 데이터베이스를 사용

## 패키지

- R언어에서 RDBMS를 연동해 데이터를 처리하려는 경우 RJDBC, DBI 패키지 필요

  ```R
  install.packages("DBI")
  install.packages("RJDBC")
  library(DBI)
  library(RJDBC)
  ```

- RJDBC 패키지가 제공하는 함수들

  ```
  JDBC
  JDBCConnection
  JDBCDrive
  JDBCResult
  ```

- DBI패키지가 제공하는 함수들

  ```
  
  ```

## DB 연동

- DB 서버 접속

  ```
  drv <- JDBC("oracle.jdbc.driver.OracleDriver", "JDBC드라이버압축파일패스")
  conn <- dbConnect(drv, "jdbc:oracle:this:@localhost:1521:xe", "계정", "암호")
  ```

- DB 접속 해제

  ```
  dbDisconnect(conn)
  ```

- 테이블 리스트 추출

  ```
  dbLIstTables(conn)
  ```

- 테이블에 저장된 데이터 읽기

  - 방법 1
  - 방법 2
  - 방법 3

- 테이블에 데이터 저장하기

- 데이터 수정

- 테이블 삭제

- DB 연동 예제