library(RSelenium)
library(ggplot2)
library(wordcloud2)
remDr <- remoteDriver(remoteServerAddr = "localhost", port=4445, browserName="chrome")
remDr$open()
site <- "https://www.jobkorea.co.kr/"
remDr$navigate(site)

clickSearch <- remDr$findElement(using='css', '#stext')
clickSearch$sendKeysToElement(list("자바", key="enter"))

page <- 1
viewNum <- 30
result <- NULL
endCount <- 1
repeat {
  for(i in 1:viewNum) {
    linkContent <- paste("#smGiList > div.list > ul > li:nth-child(",i,") > span.detailInfo > p.gibInfo > a")
    tagLink <- remDr$findElements(using="css", linkContent)
    tag <- sapply(tagLink, function(x) {x$getElementText()})
    result <- c(result, unlist(tag))
  }
  page <- page + 1
  endCount <- endCount + 1
  if(page > 10) {
    page <- 1
    pageLink <- "#smGiList > div.tplPagination > p > a"
  } else {
    pageLink <- paste("#smGiList > div.tplPagination > ul > li:nth-child(",page,") > a")
  }
  clickPage <- remDr$findElements(using='css', pageLink)
  sapply(clickPage, function(x) {x$clickElement()})
  if(endCount > 20) {
    break;
  }
  Sys.sleep(1)
}
# options(encoding="CP949")
tmp <- result
result <-tmp
write(result, "jobwithjava.txt")
#tagText <- scan("jobwithjava.txt", what="")
tagText <- readLines("jobwithjava.txt")
tagWord <- strsplit(tagText, ", ")
undata <- unlist(tagWord)
tagCount <- table(undata)
tableCount <- sort(tagCount, decreasing=T)
real_result <- head(tableCount, 30)
write.csv(real_result ,"jobwithjava.csv", row.names = FALSE)

# wordcloud2
wordcloud2(word_table2)
wordcloud2(tagCount, fontFamily="궁서체", size=1.2, color="random-light",background="black",
           shape="star")

