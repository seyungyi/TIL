(today<-Sys.Date())
#"2019-08-22"
today<-Sys.Date()
today
#"2019-08-22"

format(today,"%H %M %S")
weekdays(today);months(today);quarters(today)

unclass(today)
#19700101기준으로 얼마나 날짜가 지났는지 값

Sys.Date();Sys.time()
#"2019-08-22"
#"2019-08-22 10:22:45 KST"
Sys.timezone()
as.Date('1/15/2018',format='%m/%d/%y')
#"2020-01-15"
as.Date('4월26, 2018',format='%B,%d,%Y')
#NA
as.Date('22118',format='%d%b%y')
#"2018-01-22"

t<-Sys.time() #"2019-08-22 10:30:29 KST"
ct<-as.POSIXct(t)
ct#"2019-08-22 10:30:29 KST"
lt<-as.POSIXlt(t)
lt#"2019-08-22 10:30:29 KST"
#저장용은 아무거나 / 객체로 해서 각 정보얻을때lt
unclass(ct)
unclass(lt)
lt$mon
lt$hour
lt$year+1900 #2019
as.POSIXct(1449894437,origin="1970-01-01")
#"2015-12-12 13:27:17 KST"
as.POSIXlt(1449894437,origin="1970-01-01")
#"2015-12-12 13:27:17 KST"

#실습
#태어난 요일
myBirth<-as.Date('1992-07-10')
weekdays(myBirth)

#태어난지 며칠
today<-Sys.Date()
today-myBirth

#올해 크리스마스 어떤 요일 ->2가지 요일명/ 숫자 
xmas<-as.Date('2019-12-25')
weekdays(xmas)
as.POSIXlt(xmas)$wday

#1월1일 2020 요일
weekdays(as.Date("2020-01-01"))

#"오늘은 xxxx년 x월 xx일 xx요일 입니다" 형식
today<-Sys.Date()
year <- format(today, "%Y")
month<-format(today, "%m")
date<-format(today, "%d")
weekdays<-format(today,"%A")
cat("오늘은",year,"년",month,"월",date,"일",weekdays,"입니다")

#예제 적기
d<-matrix(1:9,ncol=3);d
apply(d,1,sum) #1은 행 ,2는 열
apply(d,2,sum)

weight<-c(65.4,55,380,72.2,51,NA)
height<-c(170,155,NA,173,161,166)
gender<-c("M","F","M","M","F","F")
df<-data.frame(w=weight,h=height)
df
apply(df,1,sum,na.rm=TRUE)
apply(df,2,sum,na.rm=TRUE)

lapply(df,sum,na.rm=TRUE)
sapply(df,sum,na.rm=TRUE)
tapply(df$w,gender,mean,na.rm=TRUE)
tapply(1:6,gender,sum,na.rm=TRUE)
mapply(paste,1:5,LETTERS[1:5],month.abb[1:5])


weight<-c(65.4,55,380,72.2,51,NA)
count<-1
myf<-function(x,wt=T){
  print(paste(x,"(",count,")" ))
  if(wt)
    r<-paste("*",x,"*")
  else
    r<-paste("#",x,"#")
  count<<-count+1; #전역변수에 +1됨
  return(r)
}
sapply(df$w,myf) #if절 count증가
sapply(df$w,myf,F) #else로 들어감 count 증가
sapply(df$w,myf,wt=F) #else로 들어감 count계속증가
rr1<-sapply(df$w,myf,wt=F) #count계속증가
#[1] "# 65.4 #" "# 55 #"   "# 380 #"  "# 72.2 #"
#[5] "# 51 #"   "# NA #"  
str(rr1)
count<-1
sapply(df,myf) #한 컬럼이 끝날때까지 같은 count값
rr2<-sapply(df,myf) #r에 모았다가 리턴됨 
str(rr2)
rr2[1,1]
rr2[1,"w"]

#stringr패키지.pdf
install.packages("stringr")
library(stringr)

str_detect() #특정 문자 포함 여부확인
fruits<-c('apple','Apple','banana','pineapple')
str_detect(fruits,'A')
str_detect(fruits,'^a')
str_detect(fruits,'e$') #끝나는 글자가 소문자 e
str_detect(fruits,'^[aA]')#첫글자
str_detect(fruits,'[aA]') #포함

ignore.case() #대소문자 무시하기
str_detect(fruits.ignore.case('a'))

str_count() #특정문자 출현 횟수
fruits
str_count(fruits,ignore.case('a'))
str_count(fruits,'a')

str_c() #문자열 합치기
str_detect(fruits,ignore.case('a'))
str_c("apple","banana")
str_c("Fruits: ",fruits)
str_c(fruits,collapse = "")
str_c(fruits,collapse="-")

str_dup() #반복출력하기
str_dup(fruits,3)

str_length() #문자열의 길이 출력
str_length('apple')
str_length(fruits)

str_locate #특정 문자의 위치 값 찾기
str_locate('apple','a')
str_locate(fruits,'a')

str_replace()
str_replace('apple','p','*')
str_replace('apple','p','**')
str_replace_all('apple','p','*')

str_split()
fruits<-str_c('apple','/','orange','/','banana')
fruits
str_split(fruits,"/")

str_sub()
fruits
str_sub(fruits,start=1,end=3)
str_sub(fruits,start=6,end=9)
str_sub(fruits,start=-5)

str_trim() #제거하기
str_trim(' apple bananan berry ')

#시각화 .pdf
#소스.txt
국어<- c(4,7,6,8,5,5,9,10,4,10)
plot(국어)
plot(국어, type="o", col="blue")
title(main="성적그래프", col.main="red", font.main=4)

국어 <- c(4,7,6,8,5,5,9,10,4,10)
수학 <- c(7,4,7,3,8,10,4,10,5,7)
plot(국어, type="o", col="blue")
lines(수학, type="o", pch=16, lty=2, col="red")
title(main="성적그래프", col.main="red", font.main=4)

국어 <- c(4,7,6,8,5,5,9,10,4,10)
par(mar=c(1,1,1,1), mfrow=c(4,2))
#mar : 여백, c(아래,좌, 위, 우) #mfrow : 행우선, mfcol : 열 우선

plot(국어, type="p", col="blue", main="type = p", xaxt="n", yaxt="n")
plot(국어, type="l", col="blue", main="type = l", xaxt="n", yaxt="n")
plot(국어, type="b", col="blue", main="type = b", xaxt="n", yaxt="n")
plot(국어, type="c", col="blue", main="type = c", xaxt="n", yaxt="n")
plot(국어, type="o", col="blue", main="type = o", xaxt="n", yaxt="n")
plot(국어, type="h", col="blue", main="type = h", xaxt="n", yaxt="n")
plot(국어, type="s", col="blue", main="type = s", xaxt="n", yaxt="n")
plot(국어, type="S", col="blue", main="type = S", xaxt="n", yaxt="n")

국어 <- c(4,7,6,8,5,5,9,10,4,10); 
수학 <- c(7,4,7,3,8,10,4,10,5,7)
par(mar=c(5,5,5,5), mfrow=c(1,1))
plot(국어, type="o", col="blue", ylim=c(0,10), axes=FALSE, ann=FALSE)
#ann=F: x, y축을 표시하지 않습니다
#axes=F : x, y축 제목을 지정하지 않습니다
#xlim ylim : 한계값

# x축 추가 1씩 증가
axis(1, at=1:10, lab=c("01","02","03","04", "05","06","07","08","09","10")) 
# y축 추가 2씩 증가
axis(2, at=c(0,2,4,6,8,10))  

# 그래프 추가하고, 그래프에 박스 그리기
lines(수학, type="o", pch=16, lty=2, col="red")    
box()   # 박스 그리기

# 그래프 제목, 축의 제목, 범례 나타내기
title(main="성적그래프", col.main="red", font.main=4) 
title(xlab="학번", col.lab=rgb(0,1,0)) 
title(ylab="점수", col.lab=rgb(1,0,0)) 
#범례
legend(1, 10, c("국어","수학"), cex=0.8, col=c("blue","red"), pch=c(21,16), lty=c(1,2))  
#legend(x 축 위치, y 축 위치, 내용, cex=글자크기, col=색상, pch=크기, lty=선모양)



(성적 <- read.table("성적.txt", header=TRUE))
plot(성적$학번, 성적$국어, main="성적그래프", xlab="학번", ylab="점수",  xlim=c(0, 11), ylim=c(0, 11)) 

ymax <- max(성적[3:5]) 
#성적 데이터 중에서 최대값을 찾는다(y 축의 크기 제한)
ymax
pcols<- c("red","blue","green")
png(filename="성적.png", height=400, width=700, bg="white") 
# 출력을 png파일로 설정 출력방향: 리다이렉트
#그래프를 파일그리고 - dev.off 로 저장
plot(성적$국어, type="o", col=pcols[1], ylim=c(0, ymax), axes=FALSE, ann=FALSE)
axis(1, at=1:10, lab=c("01","02","03","04","05","06","07","08","09","10"))
axis(2, at=0:5, lab=c(0,2,4,6,8,10))
box()
lines(성적$수학, type="o", pch=16, lty=2, col=pcols[2])
lines(성적$영어, type="o", pch=23, lty=3, col=pcols[3] )

title(main="성적그래프", col.main="red", font.main=4)
title(xlab="학번", col.lab=rgb(1,0,0))
title(ylab="점수", col.lab=rgb(0,0,1))

legend(1, ymax, names(성적)[c(3,4,5)], cex=0.8, col=pcols, pch=c(21,16,23), lty=c(1,2,3))
dev.off() #close

barplot(국어)
coldens <- seq(from=10, to=100, by=10)
# 막대그래프의 색밀도 설정을 위한 벡터
xname <- 성적$학번                                         # X 축 값 설정위한  벡터
barplot(성적$국어, main="성적그래프", xlab="학번", ylab="점수", border="red", col="green", density=coldens, names.arg=xname)

# 학생의 각 과목에 대한 각각의 점수에 대한 그래프
성적1<- 성적[3:5]                                           
barplot(as.matrix(성적1), main="성적그래프", ylab="점수", beside=TRUE, col=rainbow(10))

# 학생의 각 과목에 대한 합계 점수에 대한 그래프
xname <- 성적$학번;    
#  x축 레이블용 벡터
par(xpd=T, mar=par()$mar+c(0,0,0,4));   
#우측에 범례가 들어갈 여백을 확보
barplot(t(성적1), main="성적그래프", ylab="점수", col=rainbow(3), space=0.1, cex.axis=0.8, names.arg=xname, cex=0.8)
legend(11,30, names(성적1), cex=0.8, fill=rainbow(3))


# 파이그래프
(성적 <- read.table("성적.txt", header=TRUE));
pie(성적$국어, labels=paste(성적$성명, "-", 성적$국어), col=rainbow(10))
pie(성적$국어, labels=paste(성적$성명, "-", 성적$국어), col=rainbow(10), main="국어성적", edges=10)
pie(성적$국어, labels=paste(성적$성명,"\n","(",성적$국어,")"), col=rainbow(10))

#8월23일부터
# 히스토그램
hist(성적$국어, main="성적분포-국어", xlab="점수", breaks=5, col = "lightblue", border = "pink")
hist(성적$수학, main="성적분포-수학", xlab="점수", col = "lightblue", border = "pink")
hist(성적$국어, main="성적분포-국어", xlab="점수", ylab="도수", col=rainbow(12), border = "pink")

nums <- sample(1:100, 30)
hist(nums)
hist(nums, breaks=c(0,33,66,100))#breaks= 구간나눔- 직접 명시 : 잘나뉨

score <- sample(1:100, 30)
barplot(score)
hist(score)
hist(score, breaks=10)#breaks= 구간나눔
hist(score, breaks=2)#breaks= 구간나눔 -2개
hist(score, breaks=3)#breaks= 구간나눔 -2개: 가장 적합한 갯수로 나뉨
hist(score, breaks=4)
hist(score, breaks=5)
hist(score, breaks=6)
hist(score, breaks=7)
hist(score, breaks=8)
hist(score, breaks=9)

# 추세선 추가
hist(성적$국어, main="성적분포-국어", xlab="점수", ylab="도수", col=rainbow(12), border = "pink",prob=T)
lines(density(성적$국어, bw=0.5), col="blue", lwd=3)
lines(density(성적$국어, bw=1), col="black", lwd=3)

# 박스플롯
summary(성적$국어)
boxplot(성적$국어, col="yellow",  ylim=c(0,10), xlab="국어", ylab="성적")

성적2 <- 성적[,3:5]
boxplot(성적2, col=rainbow(3), ylim=c(0,10), ylab="성적")

data <- read.table("온도.txt", header=TRUE, sep=",")
head(data, n=5); 
boxplot(data)
boxplot(data, las = 2)
boxplot(data, las = 2, at = c(1,2,3,4, 6,7,8,9, 11,12,13,14))
chtcols = rep(c("red","sienna","palevioletred1","royalblue2"), times=3)
chtcols
boxplot(data, las = 2, at = c(1,2,3,4, 6,7,8,9, 11,12,13,14), col=chtcols)

grid(col="gray", lty=2, lwd=1)

#r내장 팔레트 따로 설치 필요 , 나중에 함
rainbow()
heat.colors()
terrain.colors()
topo.colors()
cm.colors()
gray.colors()


#책 - 자료 book폴더이용 p102
install.packages("readxl")
library(readxl)
exdata1<-read_excel("C:/Rstudy/book/sample1.xlsx")
View(exdata1)
str(exdata1)
dim(exdata1)
ls(exdata1)

hist(exdata1$AGE)
hist(exdata1$AGE,xlim=c(0,60),ylim=c(0,5),main="AGE분포")

install.packages("descr")
library(descr)
freq(exdata1$SEX, plot=T, main="성별(barplot)")
