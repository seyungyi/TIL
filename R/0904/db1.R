library(ggplot2)
library(DBI)
library(RJDBC)
drv <- JDBC("oracle.jdbc.OracleDriver", "C:/H/ojdbc6.jar")
conn <- dbConnect(drv, "jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest")
dbWriteTable(conn, "IRIS", data.frame(SLENGTH=iris$Sepal.Length, 
        SWIDTH=iris$Sepal.Width, 
        PLENGTH=iris$Petal.Length, PWIDTH=iris$Petal.Width, 
        SPECIES=iris$Species))
iris
resultIris <- dbReadTable(conn, "IRIS")

ggplot(resultIris, aes(x=SLENGTH, y=SWIDTH)) + 
  geom_point(aes(group=SPECIES, colour=SPECIES))
ggsave("db1.jpg")


ggplot(resultIris, aes(x=PLENGTH, y=PWIDTH)) +
  geom_point(aes(group=SPECIES, colour=SPECIES))
ggsave("db2.jpg")
