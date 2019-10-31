library(ggplot2)
str(ggplot2::mpg)
mpg <- as.data.frame(ggplot2::mpg)

# 문제 1
plot(x=mpg$cty, y=mpg$hwy, xlab="고속도로연비", ylab="도시연비", pch="+")

# 문제 2
barplot(table(mpg$drv), col=rainbow(3))

# 문제 3
boxplot(hwy~manufacturer,data=mpg, col=heat.colors(15),
        ylab="고속도로연비", main="*제조사별 고속도로연비",
        col.main="magenta", las=2, ylim=c(5,40))
