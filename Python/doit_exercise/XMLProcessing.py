# ElementTree를 이용해 XML 문서를 작성
from xml.etree.ElementTree import Element, SubElement, ElementTree

blog = Element("blog")
blog.attrib["data"] = "20151231"

SubElement(blog, "subject").text = "Why python?"
SubElement(blog, "author").text = "Eric"
SubElement(blog, "content").text = "Life is too short, You need Python!"

ElementTree(blog).write("blog.xml")

# 결과
# <blog date="20151231">
#   <subject>Why python?</subject>
#   <author>Eric</author>
#   <content>Life is too short, You need Python!</content>
# </blog>