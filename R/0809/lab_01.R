# 문제1
v1 <- c(1:10)
v2 <- v1 * 2
max_v <- c(max(v2))
min_v <- c(min(v2))
avg_v <- c(mean(v2))
sum_v <- c(sum(v2))
v3 <- v2[-5]
v1;v2;max_v;min_v;avg_v;sum_v;v3;

# 문제3
r1 <- seq(1, 10, 2)
r2 <- c(rep(1, 5))
r3 <- rep(seq(1:3), 3)
r4 <- rep(1:4, each=2)
r1; r2; r3; r4;

# 문제4
v3 <- seq(1, 10, 3)
LETTERS
names(v3) <- LETTERS[1:4]
v3

# 문제5
count <- sample(1:100,7)
month.korname <- c("일요일", "월요일", "화요일",
                   "수요일", "목요일", 
                   "금요일", "토요일")
names(count) <- month.korname
month.korname[which.max(count)]
month.korname[which.min(count)]
month.korname[which(count > 50)]
count
