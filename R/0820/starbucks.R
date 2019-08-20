library(RSelenium)
remDr <- remoteDriver(remoteServerAddr = "localhost", port=4445, browserName="chrome")
remDr$open()
site <- "https://www.istarbucks.co.kr/store/store_map.do?disp=locale"
remDr$navigate(site)

clickLocale <- remDr$findElements(using='css', '#container > div > form > fieldset > div > section > article.find_store_cont > article > article:nth-child(4) > div.loca_step1 > div.loca_step1_cont > ul > li:nth-child(1) > a')
sapply(clickLocale, function(x) {x$clickElement()})

clickLocale <- remDr$findElements(using='css', '#mCSB_2_container > ul > li:nth-child(1) > a')
sapply(clickLocale, function(x) {x$clickElement()})

n <- "#container > div > form > fieldset > div > section > article.find_store_cont > article > article:nth-child(4) > div.loca_step3 > div.result_num_wrap > span"
num <- remDr$findElements(using='css', n)
number <-sapply(num,function(x){x$getElementText()})

repl_v <- NULL
endFlag <- FALSE
result<- NULL
for(i in number) {
  fullContentCSS <- paste("#mCSB_3_container > ul > li:nth-child(",i,") > strong", sep="")
  nodes <- remDr$findElements(using='css',  fullContentCSS)
  shopname <-sapply(nodes,function(x){x$getElementText()})

  fullContentCSS <- paste("#mCSB_3_container > ul > li:nth-child(",i,") > p", sep="")
  tag <- remDr$findElements(using='css', fullContentCSS)
  repl2 <-sapply(tag,function(x){x$getElementText()})
  tagFull <- strsplit(repl2[[1]], "\n")[[1]]
  addr <- tagFull[1]
  telephone <- tagFull[2]
  
  result <- data.frame(shopname=unlist(shopname), addr, telephone)
  repl_v <- rbind(repl_v, result)
  
  remDr$executeScript("var su = arguments[0]; var dom=document.querySelectorAll('#mCSB_3_container>ul>li')[su]; dom.scrollIntoView();", list(3))
  
}
  print(repl_v)
write.csv(result, "starbucks.csv", row.names=FALSE)