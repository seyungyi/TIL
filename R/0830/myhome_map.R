library(ggmap)
register_google(key='AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY')

names <- c("이성당")
addr <- c("전북 군산시 중앙로 177")
gc <- geocode(enc2utf8(addr))
gc
df <- data.frame(name=names,
                 lon=gc$lon,
                 lat=gc$lat)
cen <- c(mean(df$lon),mean(df$lat))

today <- weekdays(Sys.Date())

if(today %in% c("월요일", "화요일")) {
  type <- "terrain"
} else if(today %in% c("수요일", "목요일")) {
  type <- "satellite"
} else if(today %in% c("금요일")) {
  type <- "roadmap"
} else {
  type <- "hybrid"
}

map <- get_googlemap(center=cen,
                     maptype=type,
                     zoom=17,
                     size=c(640,640),
                     marker=gc)
ggmap(map) + labs(title="이성당 빵집", x="위도", y="경도")

ggsave("mymap.png")  
