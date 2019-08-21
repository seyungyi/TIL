install.packages("dplyr")
library(dplyr)
exam <- read.csv(file="DataFile/csv_exam.csv")
dim(exam)
# exam 에서 class가 1인 경우만 추출하여 출력
exam %>% filter(class==1)
exam %>% filter(class==2)
exam %>% filter(class!=1)
exam %>% filter(class!=3)
exam %>% filter(math > 50)
exam %>% filter(math < 50)
exam %>% filter(enlish >= 80)
exam %>% filter(enlish <= 80)
exam %>% filter(class == 1 & math >= 50)
exam %>% filter(class == 2 & english >= 50)
exam %>% filter(math >= 90 | english >= 90)
exam %>% filter(english < 90 | science < 50)
exam %>% filter(class==1 | class==3 | class==5)
exam %>% filter(class %in% c(1,3,5))
class1 <- exam %>% filter(class==1)
class2 <- exam %>% filter(class==2)
mean(class1$math)
mean(class2$math)

# 필요한 변수만 추출하기
exam %>% select(math)
exam %>% select(english)
exam %>% select(class, math, english)
exam %>% select(-math)
exam %>% select(-math, -english)
exam %>% filter(class==1) %>% select(english)
# 가독성 있게 줄 바꾸기
exam%>%
  filter(class==1) %>%
  select(english)
exam %>% select(id, math) %>% head
# 일부만 출력하기
exam %>% select(id, math) %>% head(10)

# 순서대로 정렬하기
exam %>% arrange(math) # 오름차순
exam %>% arrange(desc(math)) # 내림차순순
exam %>% arrange(class, math) # class 및 math 오름차순 정렬렬

# 파생변수 추가하기(중간 조건을 통한 출력 가능)
exam %>% mutate(total = math+english+science) %>% head
exam %>% mutate(total = math+english+science, mean=(math+english+science)/3) %>% head
exam %>% mutate(test = ifelse(science>=60, "pass", "fail")) %>% head
exam %>% mutate(total = math+english+science) %>%
  arrange(total) %>% head
exam %>% mutate(total = math+english+science) %>%
  arrange(desc(total)) %>% head(1)

# 집단별로 요약하기
exam %>% summarise(mean_math = mean(math))
exam %>% group_by(class) %>% summarise(mean_math = mean(math))
exam %>% group_by(class) %>%
  summarise(mean_math=mean(math),
  sum_math = sum(math), 
  median_math = median(math), 
  n = n())

# 각 집단별로 다시 집단 나누기

install.packages("ggplot2")
str(ggplot2::mpg)
library(ggplot2)
head(ggplot2::mpg)
mpg <- as.data.frame(ggplot2::mpg)
head(mpg)
mpg %>%
  group_by(manufacturer, drv) %>%
  summarise(mean_cty = mean(cty)) %>%
  head(10)

# 데이터 합치기
test1 <- data.frame(id=c(1,2,3,4,5), midterm = c(60,80, 70, 90, 85)) #중간고사 데이터 생성
test2 <- data.frame(id=c(1,2,3,4,5), final = c(70,83, 65, 95, 80)) #기말고사 데이터 생성
total <- left_join(test1, test2, by="id") # id 기준으로 합쳐 total에 할당
#[주의] by에 변수명을 지정할 떄 변수명 앞 뒤에 겹따옴표 입력
#반별 담임교사 명단 생성
name <- data.frame(class=c(1,2,3,4,5), teacher=c("kim", "lee", "park", "choi", "jung"))
exam_new <- left_join(exam, name, by="class") # class 기준 합치기

group_a <- data.frame(id=c(1,2,3,4,5), test=c(60, 80,70,90,85)) # 학생 1~5번 시험 데이터 생성
group_b <- data.frame(id=c(6,7,8,9,10), test=c(70,83,65,95,80)) # 학생 6~10번 시험 데이터 생성
group_all <- bind_rows(group_a, group_b) # 데이터 합쳐서 grup_all에 할당

# system.time comparison : rbind vs. cbind
one <- data.frame(c(x=1:1000000, y=1:1000000))
two <- data.frame(c(x=1:1000000, y=1:1000000))

system.time(rbind(one, two)) # elapsed 7.85
system.time(cbind(one, two)) # elpased 0.03

# stystem.time comparison : cbind() vs. bind_cols()
one <- data.frame(c(x=1:1000000, y=1:1000000))
two <- data.frame(c(x=1:1000000, y=1:1000000))

system.time(cbind(one, two)) # elapsed 0.61
system.time(bind_cols(one, two)) # elpased 0.03

# 데이터 정제
df <- data.frame(sex=c("M", "F", NA, "M", "F"), score=c(5,4,3,4,NA))
is.na(df); table(is.na(df)); table(is.na(df$sex)); table(is.na(df$score))
mean(df$score)
sum(df$score)
df %>% filter(is.na(score)) # score가 NA인 데이터만 출력
df %>% filter(!is.na(score)) # score 결측치 제거
# 결측치 제외한 데이터로 분석하기
df_nomiss <- df %>% filter(!is.na(score))
mean(df_nomiss$score)
sum(df_nomiss$score)
df_nomiss <- df %>% filter(!is.na(score) & !is.na(sex))
df_nomiss
df_nomis2 <- na.omit(df)

# 함수의 결측치 제외한 기능 이용하기- na.rm = T
mean(df$score, na.rm = T)
sum(df$score, na.rm = T)

exam <- read.csv("csv_exam.csv")
exam[c(3,8,15), "math"] <- NA # 3,8,15행의 math에 NA 할당
exam %>% summarise(mean_math = mean(math)) # 평균 산출
exam %>% summarise(mean_math = mean(math, na.rm = T)) # 결측치 제외하고 평균 산출
exam %>% summarise(mean_math=mean(math, na.rm = T),  # 평균 산출
                   sum_math=sum(math, na.rm = T),    # 합계 산출
                   median_math = median(math, na.rm = T))  # 중앙값 산출

mean(exam$math, na.rm = T) # 결측치 제외하고 math 평균 산출
# 평균으로 대체하기
exam$math <- ifelse(is.na(exam$math), 55, exam$math) # math가 NA면 55로 대체
table(is.na(exam$math))  # 결측치 빈도표 생성
mean(exam$math) # math 평균 산출

# 문제 해결을 위한 데이터 구성
mpg <- as.data.frame(ggplot2::mpg) # mpg 데이터 불러오기
mpg[c(65,124,131,153,212), "hwy"] <- NA # NA 할당하기

# 이상치 - 정삼범주에서 크게 벗어난 값
outlier <- data.frame(sex=c(1,2,1,3,2,1), score=c(5,4,3,4,2,6))
# 이상치 확인하기
table(outlier$sex)
table(outlier$score)
# 결측 처리하기 - sex
# sex가 3이면 NA 할당
outlier$sex <- ifelse(outlier$sex == 3, NA, outlier$sex)
# 결측 처리하기 - score
# sex가 1~5 아니면 NA 할당
outlier$score <- ifelse(outlier$score > 5, NA, outlier$score)
#결측치 제외하고 분석
outlier %>% filter(!is.na(sex) & !is.na(score)) %>% group_by(sex) %>%
  summarise(mean_score = mean(score))

# 이상치 제거하기 - 2.극단적인 값
mpg <- as.data.frame(ggplot2::mpg)
boxplot(mpg$hwy)

# 상자그림 통계치 출력
boxplot(mpg$hwy)$stats # 상자그림 통계치 출력
mpg$hwy <- ifelse(mpg$hwy < 12 | mpg$hwy > 37, NA, mpg$hwy)
table(is.na(mpg$hwy))
# 결측치 제외하고 분석하기
mpg %>% group_by(drv) %>% summarise(mean_hwy = mean(hwy, na.rm = T))
