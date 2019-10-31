# [ Python Django ]

## Environment

- Visual Studio Code (recommend latest version)
- Git Bash
- Python(Above 3.7.0)

## Summary

- 성격

  - 독선적인 성향(Opinionated)

- 활용

  - for문

    ```python
    ## for문 사용 시작시 선언
    {% for 변수 in 변수 %}
    
    {% endfor %}
    ## for문 종료시 끝에 필수로 종료선언
    ```

## Configuration Setting

- django 라이브러리 설치

  ```bash
  $ pip install django
  ```

- django project 생성

  ```bash
  $ django-admin startproject [project명]
  ```

- setting.py 수정 -> 지역 및 타임 설정

  ```bash
  cd [project명]/[proeject명]
  ```

  ```python
  ...
  LANGUAGE_CODE = 'ko-kr'
  
  TIME_ZONE = 'Asiz/Seoul'
  ...
  ```

- create django project

  ```bash
  $ cd [project명]
  $ python manage.py runserver
  
  ## App 종료
  [Ctrl] + [c]
  ```

- create django app 생성

  ```bash
  $ django-admin startapp [app명]
  ```

- settings.py 수정 -> 추가한 App 등록

  ```python
  ...
  ## 추가한 app 등록
  INSTALLED_APPS = [
      '추가 app명',
      ...
  ]
  ...
  ```

- [app 폴더] 밑에 templates 폴더 생성

  - Flask와 동일하게 기본 View Load 위치는 templates로 설정되어있음
  - 모든 *.html 구성은 해당 폴더에 저장

## Exercise

- views.py -> 웹 브라우저 화면에 출력하는 View

  ```python
  from django.shortcuts import render, HttpResponse
  import random
  
  def index(request):
      #return HttpRequest('Welcome to Django')
      return render(request, 'index.html')
  
  def dinner(request):
      menus = ['피자', '치킨', '족발', '라면']
      dinner = random.choice(menus)
      # return HttpRequest(f'오늘의 저녁 메뉴는 {dinner}입니다.')
      return render(request, 'dinner.html', {'menus':menus, 'dinner':dinner})
  ```

- urls.py -> 웹 브라우저에 접속하기 위한 Path 경로

  ```python
  path('[path경로]', views.[함수명])
  #앞에는 url주소, 뒤에는 views의 값
  ```

  ```python
  from django.contrib import admin
  from django.urls import path
  from [app명] import views
  
  urlpatterns = [
      path('admin/', admin.site.urls),
      path('home/dinner', views.dinner)
  ]
  ```

- dinner.html -> templates 파일

  ```html
  <!DOCTYPE html>
  <html>
      <head>
          <meta charset="UTF-8">
          <title>Document</title>
      </head>
      <body>
          <h1>오늘의 저녁 메뉴는 {{ dinner }}</h1>
          <hr>
          {% for menu in menus %}
          	<p>{{ menu }}</p>
          {% endfor %}
      </body>
  </html>
  ```