install.packages("RSelenium")
library(RSelenium)
remDr <- remoteDriver(remoteServerAddr = "localhost", port=4445, browserName="chrome")
remDr$open()

site <- paste("http://www.yes24.com/24/goods/40936880")
remDr$navigate(site)
webElem <- remDr$findElement("css", "body")
#remDr$executeScript("scrollTo(0, document.body.scrollHeight-5000)", args = list(webElem))
repl_v = NULL
endFlag <- FALSE
page <- 3
repeat {
  # 펼쳐보기 클릭하기
  for(index in 3:7) {
    fullContentLinkCSS <- paste("#infoset_reviewContentList > div:nth-child(", index ,") > div.btn_halfMore > a > em.txt.txt_open", sep='')
    fullContentLink<-remDr$findElements(using='css',  fullContentLinkCSS)
    if (length(fullContentLink) == 0) {
      endFlag <- TRUE
      break
    }
    # 댓글 읽어오기
    sapply(fullContentLink,function(x){x$clickElement()})      
    Sys.sleep(1)
    fullContentCSS <- paste('#infoset_reviewContentList > div:nth-child(', index, ') > div.reviewInfoBot.origin > div.review_cont', sep='')
    fullContent<-remDr$findElements(using='css', fullContentCSS)
    #print(fullContent)
    repl <-sapply(fullContent,function(x){x$getElementText()})
    print(repl)
    repl_v <- c(repl_v, unlist(repl))
  }
  pageMove <- remDr$findElements(using='css', '#yDetailTabNavWrap > div > div > ul > li.tabOn > a > em.txt_mnu')
  sapply(pageMove, function(x) {x$clickElement()})
  if(endFlag)
    break;  
  # 다음 페이지 이동
  page <- page+1;
  if(page == 13) {
    nextPageLink <- remDr$findElements(using='css', '#infoset_reviewContentList > div.review_sort.sortTop > div.review_sortLft > div > a.bgYUI.next')
    page <- 3
  } else {
    nextPageCSS <- paste("#infoset_reviewContentList > div.review_sort.sortTop > div.review_sortLft > div > a:nth-child(",page,")",sep="")
    nextPageLink<-remDr$findElements(using='css',nextPageCSS)  
  }
  Sys.sleep(3)
  sapply(nextPageLink,function(x){x$clickElement()})
  Sys.sleep(3)
  #print(page)
}
write(repl_v, "yes24.txt")
