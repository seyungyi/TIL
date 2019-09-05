library(KoNLP)
hotel<-readLines('c:/Rstudy/hotel2.txt')

N <- sapply(hotel, extractNoun, USE.NAMES = F)
c <- unlist(N)
N <- Filter(function(x){ nchar(x) >= 2}, c)
wordcount <- table(unlist(N))
# N <- gsub('\\d+', '', N)
# names(head(sort(wordcount, decreasing = T), 10))

tmp <- data.frame(sort(wordcount, decreasing=T))
head(tmp, 10)
# str(tmp)
