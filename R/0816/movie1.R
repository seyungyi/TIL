install.packages("rvest"); 
library(rvest)
url<- "https://movie.daum.net/moviedb/grade?movieId=121137&type=netizen"
text <- read_html(url,  encoding="UTF-8"); text

# 평점
nodes <- html_nodes(text, ".emph_grade")
nodesAll <- html_nodes(text, ".txt_grade")
point <- html_text(nodes); point

# 리뷰
nodes <- html_nodes(text, ".desc_review")
review <- html_text(nodes, trim=TRUE)
review <- gsub("\t", "", review)
review <- gsub("[\r\n]", "", review); print(review)
#page <- list(cbind(point, review)) 없이 바로 data.frame 생성가능
page <- data.frame(point, review)
# write.csv 내장객체 사용으로 좌측 번호 제거 가능(TRUE, FALSE)
write.csv(page, "daummovie1.csv", row.names = FALSE)
