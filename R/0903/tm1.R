library(tm)
library(proxy)

duke <- c("사과 포도 망고")
duli <- c("포도 자몽 자두")
ddochi <- c("복숭아 사과 포도")
dounu <- c("오렌지 바나나 복숭아")
kildong <- c("포도 바나나 망고")
heidong <- c("포도 귤 오렌지")
student <- c(duke, duli, ddochi, dounu, kildong, heidong)

# (1)
proxyEx <- DocumentTermMatrix(cpsEx, control=list(wordLengths = c(1, Inf)))
pEx <- as.matrix(proxyEx)
pCom <- pEx %*% t(pEx)

dist(pCom, method = "cosine")

# (2, 3)
cpsEx <- VCorpus(VectorSource(student))
tdmEx <- TermDocumentMatrix(cpsEx, 
                          control=list(wordLengths = c(1, Inf)))
inspect(tdmEx)
mEx <- as.matrix(tdmEx)
mCom <- t(mEx) %*% mEx
mCom <- mEx %*% t(mEx)
rowSums(mEx)

