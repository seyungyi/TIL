# 정규식을 사용해 .com, .net이 아닌 이메일 주소는 제외시키는 코드
import re

pat = re.compile(".*[@].*[.](?:com$|net$).*$")

print(pat.match("pahkey@gmail.com"))
print(pat.match("kim@daum.net"))
print(pat.match("lee@myhome.co.kr"))
