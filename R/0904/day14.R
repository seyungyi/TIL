# R과 Oracle 연동
install.packages("DBI")
install.packages("RJDBC")
library(DBI)
library(RJDBC)

# DB 서버 접속
drv <- JDBC("oracle.jdbc.OracleDriver", "C:/H/ojdbc6.jar")
conn <- dbConnect(drv, "jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest")
conn

# DB 접속 해제
dbDisconnect(conn)

# 테이블 리스트 추출
dbListTables(conn)

# 테이블에 저장된 데이터 읽기
# 방법 1
reuslt1 <- dbReadTable(conn, "VISITOR")
class(result1)

# 방법 2
result2 <- dbGetQuery(conn, "SELECT * FROM VISITOR")
result2
class(result2)

# 방법 3
result3 <- dbSendQuery(conn, "SELECT * FROM VISITOR")
class(result3)
ret1 <- dbFetch(result3, 1)
ret2 <- dbFetch(result3, 2)

# 테이블에 데이터 저장하기
# 방법 1
dbWriteTable(conn, "book",
             data.frame(bookname=c("자바의 정석", "하둡 완벽 입문", "이것이 리눅스다"),
                        price=c(30000, 25000, 32000)))
dbWriteTable(conn, "cars", head(cars, 3))

# 방법 2
dbSendUpdate(conn, "INSERT INTO VISITOR VALUES
             ('R언어', sysdate, 'R 언어로 데이터를 입력해요', visitor_seq.nextval)")
dbSendUpdate(conn, "INSERT INTO VISITOR VALUES('하둡', sysdate, '대용량 데이터 분산저장 & 처리기술',
             visitor_seq.nextval)")

# 데이터 수정
dbSendUpdate(conn, "INSERT INTO cars (speed, dist) VALUES(1,1)")
dbSendUpdate(conn, "INSERT INTO cars (speed, dist) VALUES (2, 2)")
dbReadTable(conn, "CARS")
dbSendUpdate(conn, "UPDATE CARS SET DIST=DIST*100 WHERE SPEED=1")
dbReadTable(conn, "CARS")
dbSendUpdate(conn, "UPDATE CARS SET DIST=DIST*3 WHERE SPEED=1")
dbReadTable(conn, "CARS")

#테이블 삭제
dbRemoveTable(conn, "CARS")

# 다양한 DB 예제
# 예제 1
df <- read.table("DataFile/product_click.log", stringsAsFactors = F)
names(df) <- c("click_time", "pid")
df$click_time <- as.character(df$click_time)
dbWriteTable(conn, "productlog", df)
result4 <- dbReadTable(conn, "PRODUCTLOG")
result4

# 예제 2
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


# Java와 R 연동
# RServe : 다른 언어들과 R코드를 연동할 떄 필요한 기능을 서포트하는 서버
install.packages("Rserve")
library(Rserve)
