# 데이터 세트 구조 파악하기
head(airquality) # 기본 내장 데이터 세트
str(airquality)
dim(airquality)
View(airquality)
names(airquality)

# 변수명 대소문자 섞일시 발생 문제 해결위한 변수명 소문자로 변경
names(airquality) <- tolower(names(airquality))
head(airquality)

# melt()함수 패키지 로드
install.packages("reshape2")
library(reshape2)

# melt()함수 실습
melt_test <- melt(airquality)
head(melt_test)

# 1.KoNLP 패키지와 wordclud 패키지 설치
install.packages("KoNLP")
library(KoNLP)
useSejongDic()
useSystemDic()
useNIADic()

# 2.텍스트 데이터 가져오기
# 행정안전부 웹 사이트(http://www.mois.go.kr/frt/sub/a06/b08/nationalIcon_3/screen.do)
# 접속 후 [애국가 가사]를 클릭하여 다운로드

# 3.텍스트 파일을 데이터로 가져온 후 word_data 변수에 할당
word_data <- readLines("book/애국가(가사).txt")
word_data

# 4.명사만 추출하기
word_data2 <- sapply(word_data, extractNoun, USE.NAMES = F)
word_data2

# 5.사전에 등록되지 않은 단어를 직접 등록 == 사용자 정의 사전 추가 코드
add_words <- c("백두산", "남산", "철갑", "가을", "하늘", "달")
buildDictionary(user_dic = data.frame(add_words, rep("ncn", length(add_words))),
                replace_usr_dic = T)

# 6.word_data 변수의 각 행에서 명사를 word_data2 변수에 할당
word_data2 <- sapply(word_data, extractNoun, USE.NAMES = F)
word_data2

# 7.행렬을 벡터로 변환
undata <- unlist(word_data2)
undata

# 8.사용 빈도 확인하기
word_table <- table(undata)
word_table

# 9.필터링하기
# undata에서 두 글자 이상인 단어만 선별한 후 undata2 변수에 할당
undata2 <- Filter(function(x) { nchar(x) >= 2 }, undata)
word_table2 <- table(undata2) # undata2의 빈도 확인 후 word_table2 변수에 할당
word_table2 # word_table2 확인

# 10.데이터 정렬하기
sort(word_table2, decreasing = T) # 내림차순 정렬

# 특정 단어를 제외하거나 삭제하기
# gsub(찾는 단어, 바꿀 단어, 찾을 위치)

# wordcloud2() 함수 사용하기
# 1.기본형 워드클라우드 생성하기
install.packages("wordcloud2")
library(wordcloud2)
wordcloud2(word_table2)

# 2.배경 등 색상 변경하기
# color(색상), background(배경색) 옵션 사용
wordcloud2(word_table2, color="random-light", backgroundColor = "black")

# 3.모양 변경하기
# fontFamily(글꼴), size(크기), shape(모양) 옵션 사용
wordcloud2(word_table2, fontFamily="맑은 고딕", size = 1.2, color="random-light",
           backgroundColor="black", shape="star")

# demoFreq 데이터 세트로 다양한 워드클라우드 만들기
wordcloud2(demoFreq, size=1.6, color=rep_len(c("red", "blue"), nrow(demoFreq)))
wordcloud2(demoFreq, minRotation=-pi/6, maxRotation=-pi/6, rotateRatio = 1)           
wordcloud2(demoFreq, figPath="book/peace.png")

(words <- read.csv("wc.csv", stringsAsFactors = F))
head(words)
wordcloud2(words)
wordcloud2(words, rotateRatio = 1)
wordcloud2(words, rotateRatio = 0.5)
wordcloud2(words, rotateRatio = 0)
wordcloud2(words, size=0.5, col="random-light")
wordcloud2(words, size=0.7, col="random-light", backgroundColor = "black")
?wordcloud2