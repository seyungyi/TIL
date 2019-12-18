# [ R과 Oracle의 연동 ]

## 구현 과정

1. 드라이버프로그램 로딩(JDBC() 함수)
2. DBMS 서버 접속(dbConnect() 함수)
3. 수행하려는 데이터 처리 기능에 따라 삽입, 삭제, 수정, 추출관련 SQL 문을 전달하거나 관련 함수를 수행시켜 데이터베이스를 사용

```
R <-> ojdbc6.jar(JDBC드라이버) <-> Oracle, MySQL
```

## 패키지

- R언어에서 RDBMS를 연동해 데이터를 처리하려는 경우 RJDBC, DBI 패키지 필요

  ```R
  install.packages("DBI")
  install.packages("RJDBC")
  # MySQL와 연동하고자할 경우
  install.packages("RMySQL")
  library(DBI)
  library(RJDBC)
  library(RMySQL)
  ```

- RJDBC 패키지가 제공하는 함수들

  ```R
  JDBC
  JDBCConnection
  JDBCDrive
  JDBCResult
  ```

- RMySQL 패키지 제공 함수

  ```R
  db-meta  dbApply  dbConnect  dbDataType  dbEscapeStrings  dbFetch  dbGetInfo  dbNextResult  dbReadTable  dbUnloadDriver  dbWriteTable  IdCurrent 
  MySQLConnection  mysqlClientLibraryVersions  mysqlHasDefaultr transactions 
  ```

- DBI패키지가 제공하는 함수들

  ```R
  dbBind   dbClearResult   dbColumnInfo   dbConnect   dbDataType   dbDisconnect   dbExecute   dbExistsTable   dbFetch   dbGetException   dbGetInfo
  dbGetQuery   dbGetRowCount   dbGetRowsAffected   dbGetStatement   dbHasCompleted   DBIConnection   DBIDriver   DBIObject   DBIResult   dbQuoteString   dbReadTable   dbRemoveTable   dbSendQuery
  dbSendStatement   dbSendUpdate   dbWithTransaction dbWriteTable   makedbnames   rownames   SQL   sqlAppendTable   sqlCreateTable   sqlData   sqlInterpolate   Table   dbIsValid   dbListConnections   dbListFields   dbListResults   dbListTables   dbQuoteIdentifier
  ```

## DB 연동

- DB 서버 접속

  ```R
  # Oracle
  # 드라이버 : oracle.jdbc.driver.OracleDriver
  # URL : jdbc:oracle:this:@localhost:1521:xe
  drv <- JDBC("JDBC드라이버", "JDBC드라이버압축파일패스")
  conn <- dbConnect(drv, "JDBC URL", "계정", "암호")
  
  # MySQL 접속
  con <- dbConnect(RMySQL::MySQL(), host="", port="", dbName="", user="", password="")
  ```

- DB 접속 해제

  ```R
  dbDisconnect(conn)
  ```

- 테이블 리스트 추출

  ```R
  dbLIstTables(conn)
  ```

- 테이블에 저장된 데이터 읽기

  - 방법 1

    ```R
    result1 <- dbReadTable(conn, "VISITOR")
    ```

  - 방법 2

    ```R
    result2 <- dbGetQuery(conn, "SELECT * FROM VISITOR")
    ```

  - 방법 3

    ```R
    result3 <- dbSendQuery(conn, "SELECT * FROM VISITOR")
    ret1 <- dbFetch(result3, 1)
    ret2 <- dbFetch(result3, 2)
    ```

- 테이블에 데이터 저장하기

  - 방법 1

    ```R
    dbWriteTable(conn, "book",
                 data.frame(bookname=c("자바의 정석", "하둡 완벽 입문", "이것이 리눅스다"), price=c(30000, 25000, 32000)))
                            
    dbWriteTable(conn, "cars", head(cars, 3))
    ```

  - 방법 2

    ```R
    dbSendUpdate(conn, "INSERT INTO VISITOR VALUES
                 ('R언어', sysdate, 'R 언어로 데이터를 입력해요', visitor_seq.nextval)")
                 
    dbSendUpdate(conn, "INSERT INTO VISITOR VALUES('하둡', sysdate, '대용량 데이터 분산저장 & 처리기술', visitor_seq.nextval)")
    ```

- 데이터 수정

  ```R
  dbSendUpdate(conn, "INSERT INTO 테이블명 (컬럼1, 컬럼2,....) VALUES(수정값1,수정값2,.....)")
  dbSendUpdate(conn, "UPDATE 테이블명 SET 컬럼명=변경값 WHERE 찾을컬럼명=값")
  dbReadTable(conn, "테이블명")
  ```

- 테이블 삭제

  ```R
  ddbRemoveTable(conn, "테이블명")
  ```

- DB 연동

  - 예제 1

    ```R
    df <- read.table("DataFile/product_click.log", stringsAsFactors = F)
    names(df) <- c("click_time", "pid")
    df$click_time <- as.character(df$click_time)
    dbWriteTable(conn, "productlog", df)
    result4 <- dbReadTable(conn, "PRODUCTLOG")
    result4
    ```

  - 예제 2

    ```R
    dbWriteTable(conn, "mtcars", mtcars)
    rs <- dbSendQuery(conn, "SELECT * FROM mtcars WHERE cyl=4")
    rs
    dbFetch(rs)
    dbClearResult(rs)
    
    rs <- dbSendQuery(conn, "SELECT * FROM mtcars")
    ret1 <- dbFetch(rs, 10)
    ret2 <- dbFetch(rs)
    dbClearResult(rs)
    
    nrow(ret1)
    nrow(ret2)
    ```

## SQL Injection Prevent Methods

- dbSendQuery에서 Insert Query에 값을 담아 전송할 때 paste를 이용해 문자를 붙여 쿼리문을 전달하면 SQL Injection Attack 위험도가 높다

- paste 문자 안에 세미콜론(;)을 경계로 쿼리문이 실행된다

- 만약, DROP 쿼리문 다음에 세미콜론을 붙이는 쿼리가 주입되면 테이블이 삭제되어 다음 실행할 쿼리에서 에러가 발생함

- R DBI 패키지의 sqlInterpolate() 함수를 사용하면 해당 공격을 예방할 수 있다

  ```R
  # sqlInterpolate(con, sql, ..., .dots=list())
  query <- "insert into table (name) values (?name)"
  sql <- sqlInterpolate(con, query, name="test")
  dbSendQuery(con, sql)
  ```

  