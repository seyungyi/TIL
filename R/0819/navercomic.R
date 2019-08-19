install.packages("rvest"); 
library(rvest)
install.packages("XML")
library(XML)
install.packages("httr")
library(httr)

site <- "https://comic.naver.com/genre/bestChallenge.nhn?&page="
result <- data.frame()
for(i in 1:114) {
  url <- paste(site, i, sep="")
  text <- read_html(url, encoding="UTF-8")
    
  # 만화제목
  nodes <- html_nodes(text, ".challengeTitle")
  comicName <- html_text(nodes)
  comicName <- gsub("[[:space:]]", "", comicName) 
  
  # 만화요약
  nodes <- html_nodes(text, ".summary")
  comicSummary <- html_text(nodes)
  # comicSummary <- gsub("[[:space:]]", "", comicSummary)
  
  # 만화점수
  nodes <- html_nodes(text, ".rating_type strong")
  comicGrade <- html_text(nodes)
  
  page <- data.frame(comicName, comicSummary, comicGrade)
  result <- rbind(result, page)
}
write.csv(result, "navercomic.csv", row.names = FALSE)
