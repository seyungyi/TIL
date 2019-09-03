library("readxl")
ck <- read_excel("book/치킨집_가공.xlsx")
head(ck)

# 소재저전체주소 열에서 11번째 글자부터 16번째 글자 앞까지 추출
addr <- substr(ck$소재지전체주소, 11, 16)
head(addr)

addr_num <- gsub("[0-9]", "", addr)
addr_trim <- gsub(" ", "", addr_num)
head(addr_trim)

# 동별 업소 개수 확인하기
library(dplyr)

# 도수분포표 작성 후 데이터 프레임으로 변환
addr_count <- addr_trim %>% table() %>% data.frame()
head(addr_count)

install.packages("treemap")
library(treemap)

# 동이름 열(.)과 치킨집 개수 열(Freq)로 트리맵 표현
treemap(addr_count, index=".", vSize="Freq", title="서대문구 동별 치킨집 분표")

# 내림차순으로 실제 데이터 확인
arrange(addr_count, desc(Freq)) %>% head()


## 지역별 미세먼저 농도 비교하기!!!
# 상자 그림으로 시각화 및 t 검정

install.packages("readxl")
install.packages("dplyr")
library(readxl)
library(dplyr)
# dustdata.xlsx 파일을 불러온 후 dustdata_anal에 할당
dustdata <- read_excel("book/dustdata.xlsx")

View(dustdata)
str(dustdata)

# 성북구와 중구 데이터만 추출 및 확인
dustdata_anal <- dustdata %>% filter(area %in% c("성북구", "중구"))
View(dustdata_anal)

# 데이터 현황 파악하기
#dustdata_anal 데이터 세트에 yyymmdd에 따른 데이터 수 파악
count(dustdata_anal, yyyymmdd) %>% arrange(desc(n))

# dustdata_anal 데이터 세트에 area에 따른 데이터 수 파악
count(dustdata_anal, area) %>% arrange(desc(n))

# area 값이 성북구인 데이터를 dust_anal_area_sb에 할당
dust_anal_area_sb <- subset(dustdata_anal, area=="성북구")

# area 값이 중구인 데이터를 dust_anal_area_jg에 할당
dust_anal_area_jg <- subset(dustdata_anal, area=="중구")

#데이터 확인
dust_anal_area_sb
dust_anal_area_jg

# psych 패키지 설치
install.packages("psych")
library(psych)

# 성북구의 미세먼지량에 대한 기초 통계량 도출
describe(dust_anal_area_sb$finedust)

# 중구의 미세먼지량에 대한 기초 통계량 도출
describe(dust_anal_area_jg$finedust)

# 분포 확인 및 가설 검정
# 성북구와 중구의 미세먼지 농도에 대해 boxplot을 통한 분포 차이 확인
boxplot(dust_anal_area_sb$finedust, dust_anal_area_jg$finedust,
        main="finddust_compare", xlab="AREA", names=c("성북구", "중구"),
        ylab="FINEDUST_PM", col=c("blue", "green"))

# dustdata_anal 데이터 세트에서 측정소명(area)에 따라 미세먼지 농도 평균에 대한 차이를 검정
t.test(data=dustdata_anal, finedust~area, var.equal=T)


## 트위터 크롤링으로 워드클라우드 그리기
install.packages("twitteR")
library(twitteR)
consumerKey = "gjUkHgO8bFmNobRk4g0Jas8xb"
consumerSecret = "loF0mtnzLhtQDFjahdRHox6wcR1fiD6Fw95DP5QCSy3rLTTP1K"
accessToekn = "607145164-8L5HtzopZzhjuBCgusUGKE3MHOa9P4RbmhUrM0E1"
accessToeknSecret = "2wn2bsCA7JIH5DZ5Ss1deS5BNLabzaX2xSpM2ZLMIqwQf"
setup_twitter_oauth(consumerKey, consumerSecret, access_token, access_token_secret)

keyword <- enc2utf8("취업")
bigdata <- searchTwitter(keyword, n=100, lang="ko")

bigdata_df <- twListToDF(bigdata)

str(bigdata_df)
bigdata_text <- bigdata_df$text
head(bigdata_text)

library()
library(KoNLP)
useSejongDic()
bigdata_noun <- sapply(bigdata_text, extractNoun, USE.NAMES = F)
bigdata_noun <- unlist(bigdata_noun)

bigdata_noun <- Filter(function(x) { nchar(x) >= 2}, bigdata_noun)
bigdata_noun <- gsub("[A-Za-z0-9]", "", bigdata_noun)
bigdata_noun <- gsub("[~!@#$%^&*()-_|+=?:]", "", bigdata_noun)
bigdata_noun <- gsub("[ㄱ-ㅎ]", "", bigdata_noun)
bigdata_noun <- gsub("[ㅜ|ㅠ]", "", bigdata_noun)

word_table <- table(bigdata_noun)
library(wordcloud2)
wordcloud2(word_table, fontFamily="맑은 고딕", size=5, color="random-light",
           backgroundColor="black")

# 지하철역 주변 아파트 가격

library(dplyr)
library(ggmap)
register_google(key='AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY')
# 다음 소스는 참고만 하고 10개행 밑에 있는 load() 함수만 수행시키세용
station_data <- read.csv("book/13._역별_주소_및_전화번호.csv")
str(station_data)
station_code <- as.character(station_data$"구주소")
station_code <- geocode(station_code)
station_code <- as.character(station_data$"구주소") %>% enc2utf8() %>% geocode()
head(station_code)
station_code_final <- cbind(station_data, station_code)
head(station_code_final)
save(station_code_final, file="station.rda")
load(file="station.rda")  # 이것만 수행시키세용

# 다음 소스는 참고만 하고 마지막에 있는 load() 함수만 수행시키세용
apart_data <- read.csv("book/아파트(매매)__실거래가_20180513144733.csv")
head(apart_data)
names(apart_data)
apart_data <- rename(apart_data, "거래금액" = "거래금액.만원.")
apart_data$전용면적 = round(apart_data$전용면적)
head(apart_data)
count(apart_data, 전용면적) %>% arrange(desc(n))
apart_data_85 <- subset(apart_data, 전용면적=="85")
head(apart_data_85)
apart_data_85$거래금액 <- gsub(",", "", apart_data_85$거래금액)
head(apart_data_85)
apart_data_85_cost <- aggregate(as.integer(거래금액)~단지명, apart_data_85, mean)
head(apart_data_85_cost)

apart_data_85 <- apart_data_85[!duplicated(apart_data_85$단지명),]
head(apart_data_85)
apart_data_85 <- left_join(apart_data_85, apart_data_85_cost, by='단지명')
head(apart_data_85)
apart_data_85 <- apart_data_85 %>% select("단지명", "시군구", "번지", "전용면적", "거래금액")

head(apart_data_85)
apart_address <- paste(apart_data_85$"시군구", apart_data_85$번지)
head(apart_address)
apart_address <- paste(apart_data_85$"시군구", apart_data_85$번지) %>% data.frame()
head(apart_address)
apart_address <- rename(apart_address, "주소"=".")
head(apart_address)
apart_address_code <- as.character(apart_address$"주소") %>% enc2utf8() %>% geocode()
apart_code_final <- cbind(apart_data_85, apart_address, apart_address_code) %>% select("단지명", "전용면적", "거래금액", "주소", lon, lat)
head(apart_code_final)
save(apart_code_final, file="apart.rda")
load(file="apart.rda")  # 이것만 수행시키세용

# 마포구 지도 표시
mapo_map <- get_googlemap("mapogu", maptype="roadmap", zoom=12)
ggmap(mapo_map)

# 지하철역 위치 및 아파트 가격 정보 표시
install.packages("ggplot2")
library(ggplot2)
#산점도로 위치 및 역명 표시
ggmap(mapo_map) + geom_point(data=station_code_final, aes(x=lon, y=lat),
                             colour="red", size=3) +
  geom_text(data=station_code_final, aes(label=역명, vjust=-1))

# 아파트 정보 표시. 수가 많아 홍대입구역쪽을 세밀히 표현
hongdae_map <- get_googlemap("hongdae station", maptype="roadmap", zoom=15)
ggmap(hongdae_map) + geom_point(data=station_code_final, aes(x=lon, y=lat),
                             colour="red", size=3) +
  geom_text(data=station_code_final, aes(label=역명, vjust=-1)) +
  geom_point(data=apart_code_final, aes(x=lon, y=lat)) +
  geom_text(data=apart_code_final, aes(label=단지명, vjust=-1)) +
  geom_text(data=apart_code_final, aes(label=거래금액, vjust=1))

install.packages("tm")
library(tm)

lunch <- c("커피 파스타 치킨 샐러드 아이스크림",
           "커피 우동 소고기김밥 귤",
           "참치김밥 커피 오뎅",
           "샐러드 피자 파스타 콜라",
           "티라무슈 햄버거 콜라",
           "파스타 샐러드 커피"
)

cps <- VCorpus(VectorSource(lunch))
tdm <- TermDocumentMatrix(cps)
tdm

cps <- VCorpus(VectorSource(lunch))
tdm <- TermDocumentMatrix(cps, 
                          control=list(wordLengths = c(1, Inf)))
tdm
(m <- as.matrix(tdm))

rowSums(m)
colSums(m)

com <- m %*% t(m)


install.packages("tm")
library(tm)

lunch <- c("커피 파스타 치킨 샐러드 아이스크림",
           "커피 우동 소고기김밥 귤",
           "참치김밥 커피 오뎅",
           "샐러드 피자 파스타 콜라",
           "티라무슈 햄버거 콜라",
           "파스타 샐러드 커피"
)

cps <- VCorpus(VectorSource(lunch))
tdm <- TermDocumentMatrix(cps)
tdm
as.matrix(tdm)

cps <- VCorpus(VectorSource(lunch))
tdm <- TermDocumentMatrix(cps, 
                          control=list(wordLengths = c(1, Inf)))
tdm
(m <- as.matrix(tdm))

rowSums(m)
colSums(m)

com <- m %*% t(m)  
com

install.packages("qgraph")
library(qgraph)

qgraph(com, labels=rownames(com), diag=F, 
       layout='spring',  edge.color='blue', 
       vsize=log(diag(com)*800))


install.packages("proxy")
library(proxy)
dd <- NULL
d1 <- c("aaa bbb ccc")
d2 <- c("aaa bbb ddd")
d3 <- c("aaa bbb ccc")
d4 <- c("xxx yyy zzz")
dd <- c(d1, d2, d3, d4)
cps <- Corpus(VectorSource(dd))
dtm <- DocumentTermMatrix(cps)
as.matrix(dtm)
inspect(dtm)
m <- as.matrix(dtm)
com <- m %*% t(m)

dist(com, method = "cosine")
dist(com, method = "Euclidean")
