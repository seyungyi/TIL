library(ggplot2)
str(ggplot2::mpg)
mpg <- as.data.frame(ggplot2::mpg)

# 문제 7-1
cpMpg <- mpg
cpMpg <- cpMpg %>% mutate(total= cty+hwy)

# 문제 7-2
cpMpg <- cpMpg %>% mutate(average = total/2)

# 문제 7-3
cpMpg %>% arrange(desc(average)) %>% head(3)

# 문제 7-4 
mpg %>% mutate(total=cty+hwy, average=total/2) %>% arrange(desc(average)) %>% head(3)

# 문제 8-1 
mpg %>% group_by(class) %>% summarise(mean(cty))

# 문제 8-2 
mpg %>% group_by(class) %>% summarise(mean_cty = mean(cty)) %>% arrange(desc(mean_cty))

# 문제 8-3 
mpg %>% group_by(manufacturer) %>% summarise(mean_hwy = mean(hwy)) %>%
  arrange(desc(mean_hwy)) %>% head(3)  

# 문제 8-4
mpg %>% filter(class=="compact") %>% group_by(manufacturer) %>%
  summarise(count = n()) %>% arrange(desc(count))

# 문제 9-1
fuel <- data.frame(fl = c("c", "d", "e", "p", "r"),
                   price_fl = c(2.35, 2.38, 2.11,2.76, 2.22),
                   stringsAsFactors = F)
fuel
mpg <- left_join(mpg, fuel, by="fl")

# 문제 9-2
mpg %>% select(model, fl, price_fl) %>% head()

midwest <- as.data.frame(ggplot2::midwest)
# 문제 10-1
midwest %>% mutate(ratio=(poptotal-popadults)/poptotal*100)
midwest$ratio %>% head()

# 문제 10-2
midwest %>% arrange(desc(ratio)) %>% select(county, ratio) %>% head(5)

# 문제 10-3
midwest %>% mutate(grade = ifelse(ratio >= 40, "large", ifelse(ratio >= 30, "middle", "small")))
midwest %>% select(county, ratio, grade)

# 문제 10-4
midwest %>% mutate(ratioTotal=(popasian/poptotal)*100) %>%
  arrange(ratioTotal) %>% select(state, county, ratioTotal) %>% head(10)

# 문제 11-1
mpg <- as.data.frame(ggplot2::mpg)
mpg[c(65, 124, 131, 153, 212), "hwy"] <- NA

table(is.na(mpg$drv))
table(is.na(mpg$hwy))

# 문제 11-2
mpg %>% filter(!is.na(mpg$hwy)) %>% group_by(drv) %>% summarise(mean_hwy = mean(hwy)) %>%
  arrange(desc(mean_hwy)) %>% head(1)

# 문제 12-1
mpg <- as.data.frame(ggplot2::mpg)
mpg[c(10, 14, 58, 93), "drv"] <- "k"
mpg[c(29, 43, 129, 203), "cty"] <- c(3, 4, 39, 42)

table(mpg$drv)
mpg$drv <- ifelse(mpg$drv %in% "k",NA,mpg$drv)

# 문제 12-2
boxplot(mpg$cty)
table(mpg$cty)
mpg$cty<-ifelse(mpg$cty<9|mpg$cty>26, NA, mpg$cty)

# 문제 12-3
mpg %>% filter(!is.na(drv) & !is.na(cty)) %>%
  group_by(drv) %>% summarise(cty_mean = mean(cty))

