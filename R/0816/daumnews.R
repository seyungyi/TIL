url <- GET('https://media.daum.net/ranking/popular/')
news.review <- data.frame()
text <- read_html(url, encoding="UTF-8")
# imsi <- read_html("URL")
# t <- htmlParse(imsi)

 # 뉴스 타이틀
 nodes <- html_nodes(text, "ul.list_news2 a.link_txt")
 newstitle <- html_text(nodes)
 # (1)
 # title <- xpathSApply(t,"//div[@class='rank_news']//div/strong/a", xmlValue)
 # title <- gsub("[[:punct:][:cntrl:]]", "", title)
 
 # (2)
 # newstitle = html_nodes(htxt, '.list_news2 .tit_thumb a')
 # newstitle<-html_text(newstitle)
 # newstitle <- gsub("[[:punct:][:cntrl:]]", "", newstitle)
 # newspapername =html_nodes(htxt, '.info_news')
 
 # 뉴스 신문사
 nodes <- html_nodes(text, "ul.list_news2 span.info_news")
 newspapername  <- html_text(nodes)
 
 page <- data.frame(newstitle, newspapername)
 news.review <- rbind(news.review, page)
write.csv(news.review, "daumnews.csv", row.names = FALSE)
