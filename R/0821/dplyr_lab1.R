library(ggplot2)
str(ggplot2::mpg)
mpg <- as.data.frame(ggplot2::mpg)

# 문제 1-1
dim(mpg)

# 문제 1-2
mpg %>% head(10)

# 문제 1-3
mpg %>% tail(10)

# 문제 1-5
summary(mpg)

# 문제 1-6
str(ggplot2::mpg)

# 문제 2-1
mpg_cp <- rename(mpg, city=cty, highway=hwy)

# 문제 2-2
mpg_cp %>% head()

# 문제 3-1
midwest <- as.data.frame(ggplot2::midwest)
summary(midwest); str(ggplot2::midwest)

# 문제 3-2
midwest <- rename(midwest, total=poptotal, asian=popasian)
head(midwest)

# 문제 3-3
percentage <- midwest %>% mutate(percentage=(asian/total)*100) %>% head

# 문제 3-4
mean(percentage$percentage)
percentage %>%
  mutate(result=ifelse(percentage>mean(percentage), "large", "small")) %>%
  head()

# 문제 4-1
head(mpg)
mpg %>% filter(displ <= 4 | displ >= 5) %>%
  mutate(mpgMean = ifelse(displ<=4,"연비가 더 좋다","연비가 떨어진다")) %>%
  group_by(mpgMean) %>% summarise(hwyMean = mean(hwy))

# mpg1 <- mpg %>% filter(displ <= 4)
# mpg2 <- mpg %>% filter(displ >= 5)
# mean(mpg1$hwy); mean(mpg2$hwy)
# mpg %>% mutate(result=ifelse(mean(mpg1$hwy) > mean(mpg2$hwy), "배기량 4이하가 연비가 더 좋다", "배기량 5이상이 연비가 더 좋다"))

# 문제 4-2
mpg %>% filter(manufacturer=="audi" | manufacturer=="toyota") %>%
  group_by(manufacturer) %>% summarise(ctyMean = mean(hwy))

#mpg1 <- mpg %>% group_by() %>% filter(manufacturer=="audi")
#pg2 <- mpg %>% group_by() %>% filter(manufacturer=="toyota")
#mean(mpg1$cty); mean(mpg2$cty)



# 문제 4-3
mpg %>% filter(manufacturer == "chevrolet" | manufacturer == "ford" | manufacturer == "honda")  %>%
  summarise(hwymean = mean(hwy))


# 문제 5-1
mpgPart <- mpg %>% select(class, cty)
mpgPart <- data.frame(mpgPart)
head(mpgPart); str(mpgPart)
head(mpgframe)

# 문제 5-2
#part1 <- mpgPart %>% filter(class=="suv")
#part2 <- mpgPart %>% filter(class=="compact")
#mean(part1$cty); mean(part2$cty)

mpgPart %>% filter(class=='suv' | class=='compact') %>%
  group_by(class) %>% summarise(mean = mean(cty))


# 문제 6-1
mpg %>% filter(manufacturer=="audi") %>% arrange(desc(hwy)) %>% head(5)
  
