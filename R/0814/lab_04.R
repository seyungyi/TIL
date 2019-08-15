# 문제 26
L1 <- list(
  name = "scott",
  sal = 3000
); L1$name; L1$sal
result1 <- L1$sal*2; result1

# 문제 27
L2 <- list("scott", seq(100,300,100))
print(L2)

# 문제 28
L3<- list(c(3,5,7), c('A', 'B', 'C'))
L3[[2]][1] <- "Alpha"
print(L3)

# 문제 29
L4<- list(alpha=0:4, beta=sqrt(1:5), gamma=log(1:5))
L4$alpha<-L4$alpha+10
print(L4)

# 문제 30
L5 <- list(
  math=list(95, 90),
  writing=list(90, 85),
  reading=list(85, 80)
)
print(L5[[1]])
mean(unlist(L5))

# 제어문
#문제 1
grade <- sample(1:6,1); grade
if(grade ==1 || grade == 2 || grade == 3) {
  cat(grade, " 학년은 저학년입니다.", "\n")
} else {
  cat(grade, " 학년은 고학년입니다.", "\n")
}

#문제 2
choice <- sample(1:5, 1); cat(choice)
result <- switch(EXPR=choice, 300+50, 300-50,300*50,
                 300/50,300%%50); print(result)
cat("결과값 :", result)

#문제 3
time <- 31250; time
cat(floor(time/3600),"시간", floor((time%%3600)/60),"분",
    floor((time%%3600%%60)), "초")

#문제 4
count <- sample(3:10, 1); count
deco <- sample(1:3, 1); deco
if(deco == 1) {
  str <- '*'
} else if(deco == 2) {
  str <- '$'
} else {
  str <- '#'
}
for(data in 1:count)
  cat(str)

#문제 5
score<-sample(0:100, 1); score
char <- as.character(score%/%10)
level <- switch(EXPR=char, 
                '10'='A', 
                '9'='A', 
                '8'='B', 
                '7'='C', 
                '6'='D', 'F'); level
cat(score,"점은 ", level, "등급입니다.")

#문제 6
cat(paste(LETTERS,letters, sep=""))
