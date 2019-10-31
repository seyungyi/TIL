# 문제 10
a <- array(1:24, dim=c(2,3,4))
a[2,3,4]
a[2,,]
a[,1,]
a[,,3]
a + 100
a[,,4]*100
a[1,c(2,3),]
a[2,,2] <- a[2,,2]+100
a[,,1] <- a[,,1]-2
a <- a*10
rm(a)

# 문제 11
x <- c(1,2,3,4,5) # c(1:5)
y <- c(2,4,6,8,10) # c(seq(2,10,2))
df1 <- data.frame(x, y); df1

# 문제12
df2 <- data.frame(col1=c(1:5),
                  col2=letters[1:5],
                  col3=c(6:10)); df2

# 문제13
제품명<-c('사과', '딸기', '수박')
가격<-c(1800,1500,3000)
판매량<-c(24,38,13)
df3<-data.frame(제품명, 가격, 판매량)
df3$제품명 = as.character(df3$제품명)
str(df3)

# 문제14
mean(df3$가격) # mean(df3[,2])
mean(df3$판매량) # mean(df3[1:3,2]*df3[1:3,3])

# 문제15
name <- c('Potter', 'Elsa', 'Gates', 'Wendy', 'Ben')
gender <- factor(c('M', 'F', 'M', 'F', 'M'))
math <- c(85, 76, 99, 88, 40)
df4<-data.frame(name, gender,math);str(df4)
df4$name = as.character(df4$name)
str(df4)
df4$stat <- c(76, 73, 95, 82, 35)
df4$score <- df4$math + df4$stat
df4$grade <- ifelse(df4$score>=150, "A",
                   ifelse(df4$score>=100,"B","C"))
df4

# 문제 16
str(emp)

# 문제 17
emp[c(3:5),]; emp[3:5,]

# 문제 18
emp["ename"]

# 문제 19
emp[,c("ename", "sal")]

# 문제 20
subset(emp, select=c("ename","sal","job"), subset=emp$job=="SALESMAN")

# 문제 21
emp[emp$sal>=1000&emp$sal<=3000, c("ename", "sal", "deptno")]

# 문제 22
subset(emp, select=c("ename", "job", "sal"), subset=emp$job!="ANALYST")

# 문제 23
emp[emp$job=="SALESMAN" | emp$job=="ANALYST", c("ename", "job")]

# 문제 24
emp[is.na(emp$comm),]

# 문제 25
emp[order(emp$sal,decreasing=F),]
