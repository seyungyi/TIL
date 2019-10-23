from selenium import webdriver

# url path string
url = 'https://www.google.com/'

# selenium webdriver Add setting argument
options = webdriver.ChromeOptions()
options.add_argument('headless')
options.add_argument('window-size=1920x1080')
options.add_argument('disable-gpu') 
# options.add_argument('--disable-gpu')

# UserAgent 값을 변경하여 Headless 탐지 방지
# options.add_argument("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")

# webdriver browser selecting and Add setting options
driver = webdriver.Chrome('chromedriver', chrome_options=options)

# selenium time delay setting
driver.implicitly_wait(2)

# selenium open url on web browser
driver.get(url)

# Take a screenshot from the Selenium web browser
driver.get_screenshot_as_file('screen_shot.png')

# Acquiring an element of a DOM object with a css selector
test = driver.find_element_by_css_selector('#search-box > div.main-search > div > h1').text
print(test)

# quit web browser
driver.quit()