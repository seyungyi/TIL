# 자바스크립트 사용하기
#remDr$executeScript(script="return arguments[0] + arguments[1];", args=list(1,2))

# 스타벅스 위치 스크롤 내리기
remDr$executeScript("var su = arguments[0];
              var dom=document.querySelectorAll('#mCSB_3_container>ul>li')[su];
              dom.scrollIntoView();", list(3))

# 정규표현식 사용
?gsub
word <- "JAVA javascript Aa 가나다 AAaAaA123 %^&*"
gsub("A", "", word) 
gsub("a", "", word) 
gsub("Aa", "", word) 
gsub("(Aa){2}", "", word) 
gsub("[Aa]", "", word) 
gsub("[가-힣]", "", word) 
gsub("[^가-힣]", "", word) 
gsub("[&^%*]", "", word) 
gsub("[[:punct:]]", "", word) 
gsub("[[:alnum:]]", "", word) 
gsub("[1234567890]", "", word) 
gsub("[1-9]", "", word)
gsub("[[:digit:]]", "", word) 
gsub("[^[:alnum:]]", "", word) 
gsub("[[:space:]]", "", word)

install.packages("dplyr")
library(dplyr)
