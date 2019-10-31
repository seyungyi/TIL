# [ JQuery ]

- 정의

  - HTML 문서 안의 스크립트 코드를 단순화하도록 설계된 자바스크립트 라이브러리이다.

- 선언 및 메서드 사용 방법

  -  `<script src="http://code.jquery.com/jquery-버전.min.js"></script>` 필수선언
  - **jQuery(자바스크립트객체).xxx();** : 자바스크립트 객체를 생성해서 메서드를 호출한다.
  - **jQuery.xxx(); **또는 **$.xxx();** : jQuery라는 생성자 함수 이름을 통해서 메서드를 호출한다.
  - jQuery API Document에서 .xxx()는 *jQuery(아큐먼트).xxx(); 형식으로 호출하고 jQuery.xxx();는 $.xxx(); 형식으로 호출한다.

  - jQuery는 내부적으로 `표준이벤트모델`을 사용하기에 순서대로 작동한다.

  ```javascript
  $(아규먼트)에서 아규먼트에 들어가는 값
  $(자바스크립트객체)
  $("CSS선택자문자열") : 전체에서 찾는다.
  $("CSS선택자문자열", DOM객체) : 선언한 DOM객체의 자손에서만 첫번째 아규먼트(CSS선택자)를 찾게된다.
  $("HTML태그문자열") : HTML 태그에 알맞는 DOM객체를 생성한다. 문자열 안에있는 HTML태그에 알맞은 DOM객체를 생성(=자동 포장)한다.
  $(함수) == $(document).ready(함수) == window.onload = 함수 : 문서렌더링이 끝나면 함수호출한다.
  $((콜백)함수) : (== window.onload(함수) ) 문서에 대한 함수가 끝날시 발생되는 load이벤트에 대한 핸들러 등록
  ```

  - $(...).val() 사용시 : 값을 얻어오는 메서드이다.

  1. val() : getter ---> 아규먼트가 하나일 경우는 getter의 기능을 수행한다
  2. val(아규먼트) : setter -> 아규먼트로 값, 함수를 세팅할 수 있다

  - $(...).html() -> 자바스크립트의 innerHTML 속성과 유사함

  1. html() : getter  //javascript의 innerHTML 속성과 비슷하다.
  2. html(아규먼트) : setter : 모든 DOM객체에 대하서 세팅을 실시함 -> val(아규먼트)와 동일

  - css() 사용시 : 스타일과 관련된 속성값을 조정한다.

  1. css("속성명") : getter -> 찾아낸 DOM객체의 ㅁ를 읽어들인다
  2. css("속성명", "속성값")
  3. css('속성명", 함수) : css속성값을 함수 안에서 해당 ㅁ를 추출하여 값을 리턴해라
  4.  css( {"속성명", "속성값" ... } ) : setter로서 아규먼트를 여러 개 줄 경우 사용

  - text() 사용시

  1. text("속성명")  : getter  //javascript의 textContent 속성과 비슷하다. //모든 태그의 content를 꺼낸다.
  2. text("속성명", "속성값")
  3. text('속성명", 함수) 
  4. text( {"속성명", "속성값" ... } ) : setter   //textContent는 1개만 꺼낸다.

  - attr() 사용시 : 태그의 고유 속성값을 조정한다.

  1. attr("속성명") : getter
  2. attr("속성명", "속성값")
  3. attr('속성명", 함수) 
  4. attr( {"속성명", "속성값" ... } )  : setter

- 호출 방법 : $.xxx()

- each() 메소드

```javascript
var ary = [10, 20, 30, 40, 50];
아래 두가지 중 하나를 주로 사용하는 방식
1. $(ary).each(function(index, data) { .... });->ary 자바스크립트를 jquery 함수로 자동변형(포장)시킨다
2. $.each(ary, function(index,data) { ... }); 
```

- .filter(' 태그 및 선택자 ') : 해당 태그 및 선택자를 찾아 범위를 제한.  .end()와 어울려서 수행되는 경우 많음
- .end( ) : 마지막으로 수행한 .filter()의 전단계(또는 전전단계)로 이동하여 수행하라
- .addClass(), .removeClass(), removeAttr(), attr() : 클래스 또는 속성을 추가하고 제거
- jQuery는 설정에 대해서는 모두 설정. 
  - 추출하는 것에 대해서는 최초 하나만을 추출한다.(첫번째 돔객체에 대해서만)
  - 모두 추출하고자 한다면 each()를 이용해 각 인덱스별로 추출할 수 있다
  - 설정은 모든 돔객체에 적용

## < JQuery에서 이벤트 핸들러 등록시 >

- 제이쿼리에서 이벤트를 연결(등록)하고자 할 때
  1. 이벤트이름(함수)
  2. on("이벤트이름", 함수)  -> 이벤트 등록 메소드  --> off메소드를 통해 이벤트를 제거할 수 있다.  // addEventListener
  3. off("이벤트이름", 함수)  -> 등록된 모든 이벤트 제거 메소드.  // removeEventListener
  4. one("이벤트이름", 함수)  -> 무조건 한번만 수행되는 이벤트 핸들러
- 이벤트 핸들러 등록은 ready가 끝나는 시점에 등록된 DOM객체에만 적용된다 -> 예로 클릭이벤트로 새로 추가되는 태그에는 이벤트가 등록되지 않는다

```
단, $(document)로 등록하고자 하는 해당 document의 DOM객체를 생성할 시 앞으로 추가되는 태그에도 동일하게 이벤트 핸들러가 적용되는 결과가 나온다
```

- 일반태그의 컨텐트를 읽을 때: html(), text()
- `<form>` 태그의 서브태그들 : val()이라는 메소드로 값을 설정, 추출하는 일이 가능
- `<form>` 태그의 서브태그 중 `<textarea>` : html(), text(), val() 모두 사용 가능하다
- prop()메소드를 사용해야 checkbox 의 'checked' 속성값을 체크할 수 있다
- find()메소드는 getElementByTagName() 과 같은 기능을 수행한다 : 해당 TagName을 가진 DOM 객체를 찾는다



## < JQuery에서 Ajax 프로그래밍 지원 API >

- $.getXXX메소드

  - **$.ajax()** : jQuery.ajax()와 같다

  - $.get()

  - $.post()

  - $.getJSON()] : $.ajax()를 확장한 개념. 응답이 JSON일때만 사용

  - $(Ajax요청으로 응답받은 내용을 추가하려는 부모태그).load()

     : ajax를 이용해 끌어온 것을 '괄호 안 태그'에 붙이라는 말이다. (바로 붙일 수 있다.) (get 방식이다.)

- $.param : 자바스크립트 객체를 Query 문자열로 만드는 메소드

- $('id등').serialize() : 폼 태그를 구성하고 있는 각종 입력태그의 내용을 가지고 Query 문자를 만든다