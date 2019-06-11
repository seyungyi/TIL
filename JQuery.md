# [ JQuery ]

- 선언 및 사용 방법

  `-` `<script src="http://code.jquery.com/jquery-버전.min.js"></script>` 필수선언

  `-` $(아규먼트).xxx()

  `-` $(자바스크립트객체)

  `-` $("CSS선택자문자열", DOM객체) : DOM객체의 자손에서만 첫번째 아규먼트(CSS선택자)를 찾게된다.

  `-` $("HTML태그문자열") : 문자열 안에있는 HTML태그문자열을 모두 DOM객체로 자동 포장한다.

  `-` $((콜백)함수) : (== window.onload(함수) ) 문서에 대한 함수가 끝날시 발생되는 load이벤트에 대한 핸들러 등록

  ```
  $(함수) == $(document).ready(함수) == window.onload = 함수
  ```

  `-` jQuery는 내부적으로 `표준이벤트모델`을 사용하기에 순서대로 작동한다.

  `-` $(...).val() 사용시

  1. val() : getter
  2. val(아규먼트) : setter -> 아규먼트로 값, 함수를 세팅할 수 있다

  `-` $(...).html() -> 자바스크립트의 innerHTML

  1. html() : getter
  2. html(아규먼트) : setter -> val(아규먼트)와 동일

  `-` css() 사용시

  1. css("속성명") : getter -> 찾아낸 DOM객체의 ㅁ를 읽어들인다

  2. css("속성명", "속성값")

  3.  css('속성명", 함수) : css속성값을 함수 안에서 해당 ㅁ를 추출하여 값을 리턴해라

  4.  css( {"속성명", "속성값" ... } ) : setter로서 아규먼트를 여러 개 줄 경우 사용

- 호출 방법 : $.xxx()

- each() 메소드

```
var ary = [10, 20, 30, 40, 50];
아래 두가지 중 하나를 주로 사용하는 방식
1. $(ary).each(function(index, data) { .... });->ary 자바스크립트를 jquery 함수로 자동변형(포장)시킨다
2. $.each(ary, function(index,data) { ... }); 
```

