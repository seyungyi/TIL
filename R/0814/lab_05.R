# 실습 1
exam1 <- function(x,y) {
  result <- 0
  if(x > y) {
    result <- (x - y)
  } else if(x < y) {
    result <- (y - x)
  } else {
    result <- 0
  }
  return(result)
}; exam1(10, 20)

# 실습 2
exam2 <- function(num1, oper, num2) {
  result
  if(oper == '%%' | oper == '%/%') {
    if(num1 == 0) {
      return('리턴1')
    } else if(num2 == 0) {
      return('리턴2')
    } else {
      if(oper=='%%') {
        result <- num1 %% num2
      } else {
        result <- num1 %/% num2
      }
    }
  } else if(oper=='+') {
    result <- num1 + num2
  } else if(oper=='-') {
    result <- num1 - num2
  } else if(oper=='*') {
    result <- num1 * num2
  } else {
    result <- '규격의 연산자만 전달하세요'
  }
  return(result)
}
exam2(4, '%%', 2); exam2(4, '%/%', 2)

# 실습 3
exam3 <- function(p, c='#') {
  if(is.numeric(p) && is.character(c)) {
    if(p >= 0) {
      for(i in 1:p) {
        cat(c)
      }
    }
  }
}
exam3(3, ); exam3(-2, '$')

# 실습 4
exam4 <- function(p) {
  for(i in 1:length(p)) {
    if(is.na(p[i])) {
      print("NA는 처리 불가")
    } else {
      if(is.numeric(p[i])){
        if(p[i]>=85){
          print(paste(p[i],"점은 상급입니다"))
        }else if(p[i]>=70){
          print(paste(p[i],"점은 중급입니다"))
        }else{
          print(paste(p[i],"점은 하급입니다"))
        }
      }
    }
  }
}

exam4(c(95,80,77, 42, 55))

# 실습 5
countEvenOdd <- function(p) {
  even<-0; odd<-0
  if(is.vector(p) && !is.list(p)) {
      for(i in p[1]:p[length(p)]) {
        if(i %% 2 == 0) {
          even = even+1
        } else {
          odd = odd+1
        }
      }
    result<-list(even=even,odd=odd)
  } else {
    return()
  }
  return(result)
}
countEvenOdd((2:5)); countEvenOdd(list())

# 실습 6
vmSum <- function(p) {
  if(is.vector(p) && !is.list(p)) {
    if(!is.numeric(p)) {
      warning('숫자 벡터를 전달하숑!')
      return(0)
    } else {
       return(sum(p))
    }
  } else {
    stop('벡터만 전달하숑!')
  }
}
vmSum(c(10, 20 ,30)); vmSum(c(10, 'error'))

# 실습 7
createVector <- function(...) {
  data <- c(...)
  num=NULL; char=NULL; log=NULL;
    if(length(data) == 0) {
        return()
    } else {
        for(i in 1:length(data)) {
          if(is.numeric(data[i])) {
            num <- append(num, data[i])
          } else if(is.character(data[i])) {
            char <- char.append(char, data[i])
          } else if(is.logical(data[i])) {
            log <- log.append(log, data[i])
          }
          result<-list(numeric=num, character=char, logical=log)
        }
      return(result)
  }
}
createVector(c(10,20,30))

# 실습 8
word1 <- as.numeric(scan(file="iotest1.txt",what=""))
cat("오름차순:",sort(word1))
cat("내림차순:",sort(word1, decreasing=T))
cat("합:",sum(word1))
cat("평균:", mean(word1))

# 실습 9
word2 <- scan("iotest2.txt", what="")
table <- table(word2); table; summary(factor(word2))
maxChar <- names(which.max(table))
cat("가장 많이 등장한 단어는", maxChar, "입니다.")

