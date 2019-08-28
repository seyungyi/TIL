import requests
# url
# token은 공개적이면 안됨
token = ''
base_url = f'https://api.telegram.org/bot{token}'

# 요청 내용
chat_id = 
text = '안녕하세요?'
url = f'{base_url}/sendMessage?chat_id={chat_id}&text={text}'

# 요청 보내기
requests.get(url)
