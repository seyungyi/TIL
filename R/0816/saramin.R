url <- GET("http://www.saramin.co.kr/zf_user/search?search_area=main&search_done=y&search_optional_item=n&searchType=default_mysearch&searchword=%EC%9E%90%EB%B0%94")
text <- read_html(url, encoding="UTF-8")
# imsi <- read_html("URL")
# t <- htmlParse(imsi)
tag <- NULL
# 기술이름
nodes <- html_nodes(text, "div#async_sfilter span.txt")
tech_name <- html_text(nodes)
tech_name <- tech_name[-length(tech_name)]
tech_name<- gsub("[[:punct:]]", "", tech_name)

# 채용 건수
nodes <- html_nodes(text, "div#async_sfilter span.count")
info_count <- html_text(nodes)
info_count <- gsub("[[:punct:]]", "", info_count)
tag <- data.frame(tech_name, info_count)

write.csv(tag, "saramin.csv")
