# [ Python Django ]

## Environment

- Visual Studio Code (recommend latest version)
- Git Bash
- Python(Above 3.7.0)

## Summary

- 성격

  - 독선적인 성향(Opinionated)

- 활용

  - HTML 문에서 사용할 수 있음

  - for문
  
    ```python
    ## for문 사용 시작시 선언
    {% for 변수 in 변수 %}
    	<HTML 태그>
    {% endfor %}
    ## for문 종료시 끝에 필수로 종료선언
    ```
  
  - if문
  
    ```python
    ## if문 사용시 선언
    {% if 값 in [리스트 or 딕셔녀리] %}
    	<HTML 태그>
    {% endif %}
    ## if문 종료시 필수 선언
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

- [app 폴더] 하위에 templates 관리를 위한 폴더 생성

  - Flask와 동일하게 기본 View Load 위치는 templates로 설정되어있음
  
  - 모든 *.html 구성은 해당 폴더에 저장
  
  - 중복된 html 파일 구분을 위해 [app 폴더]와 동일한 이름 폴더 안에 관ㄹ
  
    > [app 폴더] - [templates] - [app 폴더] - [*.html]
  
- Django Namespace (=static 파일)

  - 설정

    - static 파일 사용시 -> {% load static %}

      ```python
      ex) {{% extends 'utilities/base.html' %}}
      ```

    - url 요청시 -> {% url 'name' %}

      ```python
      ex) {% url 'utilities/[요청url명]/' %}
      # urls.py 등록 조건
      path('[url명]/', views.[함수명], name='[url명]')
      ```

- Models 등록

  - Python 내장 sqlite와 매칭될 클래스 생성

    ```python
    from django.db import models
    class Movie(models.Model):
        title = models.CharField(max_length=30)
        audience = models.IntegerField()
        open_date = models.DateField()
        score = models.FloatField()
        description = models.TextField()
    ```

- Migrations

  - 모델의 변경 히스토리를 관리

  - 모델의 변경 내역을 DB Schema(DB 데이터 구조)로 반영시키는 효율적인 방법을 제공

    ```bash
    $ python manage.py makemigrations
    ```

- Migrate

  -  적용되지 않은 migrations들을(설정값들을) 적용시키는 역할 

    ```bash
    $ python manage.py migrate
    ```

- Django shell

  - Python에 내장된 관계형 데이터베이스 관리시스템(RDBMS)

  - 기본적으로 sqlite3 설치되어있음

  - django-extensions 필수 설치

    ```bash
    $ pip install django-extensions
    ```

    ```bash
    $ python manage.py shell
    ...
    >>> from [app명].models import [Class명] # shell과 연결 후 작성
    >>> [Class명].objects.all() # 모든 데이터를 확인(QuerySet으로 확인)
    ```

  - import를 자동해주는 방식으로 shell 기동

    ```bash
    $ python manage.py shell_plus
    ```

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