library(rvest)
library(httr)
url <- GET('http://media.daum.net/ranking/popular')
text <- read_html(url, encoding="UTF-8")

result <- NULL
for(i in 1:5) {
  tag <- paste("#mArticle > div.rank_news > ul.list_news2 > li:nth-child(",i,") > div.cont_thumb > strong > a")
  nodes <- html_nodes(text, tag)
  newstitle <- html_text(nodes)
  newstitle <- gsub("[\r\n]", "", newstitle)
  newstitle <- gsub("\t", "", newstitle)
  
  tag <- paste("#mArticle > div.rank_news > ul.list_news2 > li:nth-child(",i,") > div.cont_thumb > strong > span")
  nodes <- html_nodes(text, tag)
  newspapername <- html_text(nodes)
  
  page <- data.frame(newstitle, newspapername)
  result <- rbind(result, page)
}
result
