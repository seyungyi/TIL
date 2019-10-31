library(ggplot2)
str(ggplot2::mpg)
mpg <- as.data.frame(ggplot2::mpg)
midwest <- as.data.frame(ggplot2::midwest)
# 문제 1
ggplot(mpg, aes(x=cty, y=hwy)) + geom_point(size=2, color="blue")
ggsave("ggplot1.png")

# 문제 2
ggplot(mpg, aes(x=factor(class))) + geom_bar(width=0.5)
ggsave("ggplot2.png")

# 문제 3
ggplot(midwest, aes(x=poptotal, y=popasian)) + geom_point(size=2, color="red") +
  xlim(0, 500000) + ylim(0, 10000)
ggsave("ggplot3.png")  

# 문제 4
mpg_box <- mpg %>% filter(class=="compact" | class=="subcompact" | class=="suv")
ggplot(mpg_box, aes(x=class, y=cty)) + geom_boxplot()
ggsave("ggplot4.png")

# 문제 5
data <- read.table("./DataFile/product_click.log")
ggplot(data, aes(x=V2)) + geom_bar(width=0.5)
ggsave("ggplot5.png")

# 문제 6
dataDay <- substr(data$V1, 1, 12)
day <- weekdays(as.Date(dataDay, "%Y%m%d"))
day <- as.data.frame(day)
ggplot(day, aes(x=day)) + geom_bar(width=0.5) + ylim(0, 200)
ggsave("ggplot6.png")
