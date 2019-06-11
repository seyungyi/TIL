## [ HTTP 요청 방식(웹 클라이언트가 웹 서버에게 요청하는 방식) ]

- GET 방식

  `-` http://localhost:8000/edu/first.jsp

  `-` http://localhost:8000/edu/first.jsp?page=1&id=1000   ( ? 뒤의 문자열를 우리는 Query문자열라고 부른다 )

  `-` 직접 URL입력할 때, `<A>`, location.href, `<FROM>`태그의 method속성값이 "GET"일 때, Ajax요청시 GET 지정할때 GET 방식이다. 

  `-` 단점

  1. 전달되는 Query 문자열이 외부에 보여진다.
  2. 전달되는 Query 문자열의 길이에 제한이 있다.( 128byte, 256byte, 512byte..... ) 
     

- POST 방식

  `-` 요청하면서 서버에 전달할 name과 value로 구성된 데이터를 요청 바디에 담아서 전달한다.

  `-` Query 문자열이 외부에 보여지지 않는다.

  `-` 길이에 제한이 없다.

  `-` `<FORM>`태그의 method 속성값이 "POST" 일 때 POST 방식

  `-` Ajax 요청시 POST를 지정하면 POST 방식


## [ Query 문자열 인코딩 규칙 ]

1. 영문자, 숫자 그리고 일부 특수문자를 제외한 문자들은 %기호와 함께 16진수 코드값으로 변환되어 전달
2. 공백은 '+' 기호로 변환되어 전달
3. name과 value로 구성되어야 하며, 여러개 전달될 때는 '&' 개호로 연결한다.

```
ex) id=%E3%85%87%E3%85%81%E3%84%B4%E3%84%B9&passwd=123
```

