library(rvest)
url<-"http://media.daum.net/ranking/popular/"
text <- read_html(url)

result <- NULL
tag <- '.list_news2 .tit_thumb a'
nodes <- html_nodes(text, tag)
newstitle <- html_text(nodes)
newstitle <- gsub("[[:punct:][:cntrl:]]", "", newstitle[1:5])
newstitle <- gsub("\t", "", newstitle)

tag <- '.info_news'
newspapername <- html_nodes(text, tag)
newspapername <- html_text(newspapername)[1:5]

result<-data.frame(newstitle, newspapername, stringsAsFactors = F)
result
  
