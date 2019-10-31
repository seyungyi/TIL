library(dplyr)
library(ggmap)
library(ggplot2)
library(leaflet)

register_google(key='AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY')

map <- geocode('Seoul', source = 'google')
read_data = read.csv('./DataFile/지역별장애인도서관정보.csv', 
                      encoding = 'utf-8', stringsAsFactors = FALSE)
map <- qmap('seoul', zoom = 11, maptype = 'roadmap')
map + geom_point(data = read_data, aes(x = LON, y = LAT),
                 colour = 'blue', size=5) +
  geom_text(data=read_data, aes(x=read_data$LON, y=read_data$LAT, label=read_data$도서관명, vjust=0, hjust=0), 
            colour="black", size=5)

ggsave("map1.png")
