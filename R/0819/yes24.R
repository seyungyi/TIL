library(RSelenium)
remDr <- remoteDriver(remoteServerAddr = "localhost", port=4445, browserName="chrome")
remDr$open()

site <- paste("http://www.yes24.com/24/goods/40936880")
remDr$navigate(site)
webElem <- remDr$findElement("css", "body")
#remDr$executeScript("scrollTo(0, document.body.scrollHeight-200)", args = list(webElem))
remDr$executeScript("scrollBy(0, 2500)", args = list(webElem))
Sys.sleep(1)
remDr$executeScript("scrollBy(0, 2500)", args = list(webElem))
Sys.sleep(1)
remDr$executeScript("scrollBy(0, 2500)", args = list(webElem))
Sys.sleep(1)
remDr$executeScript("scrollBy(0, 1000)", args = list(webElem))
Sys.sleep(3)
repl_v = NULL
endFlag <- FALSE
page <- 3
repeat {
  for(index in 1:5) {
    fullContentLinkCSS <- paste('#PartContent', index, sep='')
    fullContentLink<-remDr$findElements(using='css',  fullContentLinkCSS)
    if (length(fullContentLink) == 0) {
      endFlag <- TRUE
      break
    }
    sapply(fullContentLink,function(x){x$clickElement()})      
    Sys.sleep(1)
    fullContentCSS <- paste('#FullContent', index, sep='')
    fullContent<-remDr$findElements(using='css', fullContentCSS)
    print(fullContent)
    repl <-sapply(fullContent,function(x){x$getElementText()})    
    print(repl)
    repl_v <- c(repl_v, unlist(repl))
  }
  if(endFlag)
    break;  
  page <- page+1;
  if(page == 5)
    page <- page+1;
  nextPageCSS <- paste("#Div_Review > p:nth-child(11) > a:nth-child(",page,")",sep="")
  nextPageLink<-remDr$findElements(using='css',nextPageCSS)  
  if(page == 14)
    page<-3
  sapply(nextPageLink,function(x){x$clickElement()})  
  Sys.sleep(5)
  remDr$executeScript("scrollBy(0, -3000)", args = list(webElem))
  print(page)
}
write(repl_v, "yes24.txt")
