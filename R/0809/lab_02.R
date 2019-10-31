# 문제2
vec<-seq(10, 38, 2)
m1 <- matrix(vec, nrow=3, ncol=5, byrow=T)
m2 <- m1+100
m_max_v <- max(m1)
m_min_v <- min(m1)
row_max <- matrix(c(max(m1[1,]), max(m1[2,]), max(m1[3,])))
col_max <- matrix(c(max(m1[,1]), max(m1[,2]), max(m1[,3]),
                    max(m1[,4]), max(m1[,5])))
m1;m2;m_max_v;m_min_v;row_max;col_max;

# 문제6
n1 <- c(1,2,3)
n2 <- c(4,5,6)
n3 <- c(7,8,9)
m1 <- rbind(n1, n2, n3)
rownames(m1) <- NULL
m1

# 문제 7
vec <- c(1:9)
m2<-matrix(vec, nrow=3, ncol=3 , byrow=TRUE)
m2

# 문제8
rownames(m2) <- c("row1","row2","row3")
colnames(m2) <- c("col1","col2","col3")
m2

# 문제 9
vec<-letters[1:6]
alpha <- matrix(vec, nrow=2, ncol=3)
alpha2<-rbind(alpha,c("x","y","z"))
alpha3<-cbind(alpha,c("s","p"))
vec;alpha;alpha2; alpha3
