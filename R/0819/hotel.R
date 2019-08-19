library(RSelenium)
remDr <- remoteDriver(remoteServerAddr = "localhost", port=4445, browserName="chrome")
remDr$open()

remDr$navigate("https://www.agoda.com/ko-kr/shilla-stay-seocho/hotel/seoul-kr.html?cid=-204")

more<-remDr$findElements(using='css','#SearchBoxContainer > div > div > div.Popup__container.Popup__container--garage-door > div > div > div.AlertMessage.CalendarAlertMessage > a')
sapply(more,function(x){x$clickElement()})

remDr$executeScript("scrollBy(0, 8000)")
more<-remDr$findElements(using='css', "#dismiss-btn > p")
sapply(more,function(x){x$clickElement()})
result <- NULL
for(i in 1:15) {
  #linkCss <- "reviewSection > div:nth-child(4) > div > span:nth-child(3)"
  if(i <= 3) {
    linkCss <- paste0("#reviewSection > div:nth-child(4) > div > span.Review-paginator-numbers > span:nth-child(",i,")")
  } else {
    linkCss <- paste0("#reviewSection > div:nth-child(4) > div > span.Review-paginator-numbers > span:nth-child(4)") 
  }
    print(linkCss)
    linkDom <- remDr$findElements(using='css selector', linkCss)
    #print(linkDom)
    
    sapply(linkDom, function (x) {x$clickElement()})
    Sys.sleep(3)
    doms <- remDr$findElements(using='css selector', ".Review-comment-bodyText")
    contents <- sapply(doms, function (x) {x$getElementText()})
    result <- c(result, unlist(contents))
}
  print(result)
write(result, "hotel.txt")
