from selenium import webdriver

# url path string
url = 'https://google.com/'

# webdriver browser selecting and setting
driver = webdriver.Chrome('chromedriver')

# selenium time delay setting
driver.implicitly_wait(2)

# selenium open url on web browser
driver.get(url)

# quit web browser
driver.quit()