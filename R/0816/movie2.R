install.packages("rvest"); 
library(rvest)
site<- "https://movie.daum.net/moviedb/grade?movieId=121137&type=netizen&page="
movie.review <- data.frame()

for(i in 1: 20) {
  url <- paste(site, i, sep="")
  text <- read_html(url,  encoding="UTF-8")

# 평점
nodes <- html_nodes(text, ".emph_grade")
point <- html_text(nodes); point

# 리뷰
nodes <- html_nodes(text, ".desc_review")
review <- html_text(nodes, trim=TRUE)
review <- gsub("\t", "", review)
review <- gsub("[\r\n]", "", review); review

page <- data.frame(point, review)
movie.review <- rbind(movie.review, page)
}
write.csv(movie.review, "daummovie2.csv", row.names = FALSE)


