# [ AJAX (Asynchronous JavaScript And XML)]

- 정의
  - Ajax란 전체 페이지를 변경하는 것이 아닌 페이지의 일부분만 변경하는 web 통신 방식이다. (비동기 통신방식)
- 사용이유
  - 웹브라우저와 서버의 데이터 전송을 조각방식으로 나눠 전체 페이지를 리로드하지 않아도 되는 유용성 때문이다
  - 기존 XML이 데이터 교환시 전체 페이지를 모두 전송하여 대역폭 낭비가 심했음
- AJAX 동작구조
  1. 웹 브라우저의 인터페이스에서 자바스크립트 함수 호출시킴
  2. XMLHttpRequest 객체의 인스터스를 생성시킴
  3. HTML의 상태를 가지고 있는 XML을 서버로 전송
  4. 서버에서 전송된 요청을 자체 처리 후 다시 웹브라우저로 재전송
  5. XML의 데이터를 받은 XMLHttpRequest 객체는HTML의 상태를 포함시켜 인터페이스로 전송하여 업데이트 한다
- AJAX 기본 세팅 코드

```javascript
<script language="javascript" type="text/javascript" src="js/createXMLHttpRequest.js"></script>
function createXMLHttpRequest() {
    var xmlHttp; // XMLHttpRequest 객체를 담기 위해 생성
    // 브라우저가 ActiveX 지원시 객체 생성(익스 5~10 까지)
    if(window.ActiveXObject) {
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch(e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
            } catch(e1) {
                xmlHttp = null;
            }
        }
        // 익스 11이상, 크롬, 사파리, 파폭 등)
    } else if(window.XMLHttpRequest) {
        try {
            xmlHttp = new XMLHttpRequest();
        } catch(e) {
            xmlHttp = null;
        }
    }
    if(xmlHttp = null)
        errorMessage();
    return xmlHttp;
}

function errorMessage() {
    alert("에러가 났어요");
}
```

- 비동기 요청 함수 코드

```javascript
var xmlHttp;
var xmlDoc;
var message;

function contextprev(seq) {
    // seq를 통해 본문을 미리보기 위해 함수 만들고 AJAX 컨트롤러로 보내기 위한 URL을 작성
    var url = "boardAjax.action?seq=" + seq;// 미리보기 서블릿 호출
    // XMLHttpRequest 객체를 담기 위해 생성
    xmlHttp = createXMLHttpRequest();
    // 웹브라우저에서 서버로 보낸 데이터가 재전송 오게되면 onreadystatechange 이벤트 발생
    // handleStateChange에 담음
    xmlHttp.onreadystatechange = handleStateChange;
    // 서버로 요청을 보내는 코드
    // xmlHttp.open(메소드, URL, 비동기 사용유무)
    xmlHttp.open("get", url, true);
    xmlHttp.send(null);
}

function handleStateChange() {
//readyState는 요청에 대한 상태로 각 숫자마다 기능이 담겨있습니다. 0번 → 요청이 초기화 되지 않은 상태 // 1번 → 서버와 연결이 됨 // 2번 → 요청이 수신됨 // 3번→ 요청을 처리중인 상태 // 4번 → 요청처리가 종료되어 응답이 준비된 상태 또한 status == 200 은 HTTP status 코드로 숫자마다 기능이 담겨있습니다. 100번 → 전송이 계속된다 // 200번 → 에러없이 전송 성공 // 201번 → 요청이 충족되었고 새로운 자원을 만들었다. // 302번 → 요청된 페이지는 새로운 임시 URL에 전송 등등 http://www.w3schools.com/tags/ref_httpmessages.asp 추가로 링크를 통해 다양한 코드상태를 알 수 있습니다. 즉 제가 사용한 코드는 " 요청처리가 종료되어 응답이 준비되어 있는 상태에서 에러없이 전송을 성공한다면 " 이란 조건을 건 것이죠.
    if(xmlHttp.readyState == 4) {
        if(xmlHttp.status == 200) {
//위의 조건일때 텍스트 형식의 응답을 받아와 재전송된 HTML상태를 업데이트합니다. 여기서 layer1은 제가 Board_list.jsp에 정의해 놓은 스타일 태그이름입니다. 여기서는 따로 명시하지 않았지만 본문 미리보기에 해당하는 CSS 코드가 요청을 받을때마다 전체페이지를 리로드 하지 않고, 그 부분만 리로드 되는것이죠. 
            xmlDoc = xmlHttp.responseText;
            document.getElementById("layer1").innerHTML = xmlDoc;
        }
    }
}
```



## < XML >

- **GML**(Geography Markup Language)(IBM에서 만듬 : 출판문서 작성용도로 사용)

  ---> GML을 표준화시켜 만든 것이 **SGML**(Standard Generalized Markup Language)이다.

  ​	(표준 : 출판뿐만 아니라 규격문서를 작성하는 범용용도로 사용)

  ---> **HTML**(웹페이지 제작용도) - 태그가 정해져 있음

  ---> **XML**(Extensible Markup Language)(다목적 규격화된 문서 작성용) - 직접 태그 정의

  ​	<태그명>...<태그명/> : 종료태그를 반드시 명시해야한다.

  ​	<태그명/>

  ​	<태그명 속성명="속성값">

- 크롬 개발자도구에서 Network탭의 xhr 이 ajax 응답을 뜻하는 것임

- XMLHttpRequest 객체

  서버 측과의 비동기 통신을 제어한다.

  XMLHttpRequest 객체 생성 : new XMLHttpRequest()

  - open( ... ) : HTTP 요청을 초기화한다.

  - send([body]) : HTTP 요청을 송신한다.

  - onreadystatechange : 통신 상태가 변화된 타이밍에 호출되는 이벤트 핸들러이다.

    readyState 값

    | 반환값 | 설명                                                         |
    | ------ | ------------------------------------------------------------ |
    | 0      | 미초기화(open메서드가 호출되지 않음)                         |
    | 1      | 로드 중(open메서드가 호출됨, send메서드는 호출되지 않음)     |
    | 2      | 로드 완료(send 메서드가 호출됨, 응답스테이터스/헤더는 미취득) |
    | 3      | 일부 응답을 취득(응답스테이터스/헤더만 취득, 본체는 미취득)  |
    | 4      | 모든 응답데이터를 취득 완료                                  |

  - status : HTTP Status코드를 취득한다.

    ```
    function requestAjax() { //페이지 이동없이 데이터를 받아온다.
    	var req = new XMLHttpRequest(); //브라우저 내부에 있는 ajax엔진을 초기화한다.
    	var result = document.getElementById("result");
    	req.onreadystatechange = function() {		
    		alert("req.readyState : "+req.readyState);       
    		if(req.status == 200 && req.readyState == 4) 
             	//readyState 값 200은 서버로부터 응답이 성공적으로 왔다는 것이다.
                //readyState 값 4는 서버로부터 응답이 다왔다는 것이다.
    			result.innerHTML += req.responseText; 
    	}	
    	req.open("GET", "content/sample.txt", true); //true : 비동기방식으로 보내겠다는 것이다.	
    	req.send(); 	
    }
    ```

  - [ XMLHttpRequest 객체에서 제공되는 이벤트 관련 속성 ]

    - onloadstart
    - onprogress
    - onabort
    - onerror
    - onload
    - ontimeout
    - onloadend : 항상 마지막에 발생하는 이벤트이다.
    - onreadystatechange

- **JSON**(JavaScript Object Notation)

  인터넷에서 자료를 주고 받을 때 그 자료를 표현하는 방법이다.

  ```
  <script>
  window.onload = function() {
  	setInterval(function() { //폴링 - 주기적으로 서버한테 요청해서 데이터를 받아오는 기술이다.
  		var request = new XMLHttpRequest(); //이용시간이 많을 때 더 자주 받아온다.
  		request.onload = function(event) {
  			if (request.status == 200) {
  				var str = request.responseText;
  				var obj = JSON.parse(str);
  				var target = document.getElementById('news');
  				target.innerHTML = obj.news;
  			}
  		};
  		request.open('GET', 'content/newsjson.jsp', true);
  		request.send();
  	}, 2000);
  };	
  </script>
  ```

- Same Origin Policy(SOP)

  브라우저에서 보안상의 이슈로 동일 사이트의 자원(Resource)만 접근해야 한다는 제약이다.

- Cross Origin Resource Sharing(CORS)

  ```
  response.addHeader("Access-Control-Allow-Origin", "*");
  ```

  Origin이 아닌 다른 사이트의 자원을 접근하여 사용한다는 의미이다. 따라서 ajax로 직접 요청해서 가져올 수 있다.

- HTTP 요청 방식(웹 클라이언트가 웹 서버에게 요청하는 방식)

  - GET 방식 :
    - <http://localhost:8000/edu/first.jsp>

  ​	<http://localhost:8000/edu/first.jsp?page=1&id=1000(>? 뒤 문자열을 **쿼리 문자열**이라고 한다.)

  ​	쿼리 문자열 : name, value로 구성된 문자열을 말한다.

  ​	* GET 방식 단점

  ​	(1) 전달되는 Query 문자열이 외부에 보여진다.

  ​	(2) 전달되는 Query 문자열의 길이에 제한이 있다. (128b, 256b, 512b 등)

  - GET 방식일 경우 : 직접 URL입력해서, <a>, location.href, <Form>태그의 method 속성값이 "GET"일 때

  - POST 방식 : 요청하면서 서버에 전달할 name과 value로 구성된 데이터를 **요청 바디**에 담아서 전달한다.

    - POST 방식 장점

      (1) Query 문자열이 외부에 보여지지 않는다.

      (2) 길이에 제한이 없다.

    - POST 방식일 경우 : <Form>태그의 method 속성값이 "POST"일 때, Ajax 요청시 POST를 지정하면

- Query 문자열 인코딩 규칙

  [https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EA%B0%80%EB%82%98%EB%8B%A4+123abc](https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=가나다+123abc)

  (1) 영문자, 숫자 그리고 일부 특수문자를 제외한 문자들은 **%기호와 함께 16진수 코드값으로 변환**되어 전달된다.

  (2) 공백은 '+' 기호(%20)로 변환되어 전달된다.

  (3) name과 value로 구성되어야 하며, 여러 개가 전달될 때는 '&' 기호로 연결한다.

  ex) id,passwd에 가나다를 입력한 경우 : id=%EA%B0%80%EB%82%98%EB%8B%A4&passwd=rkskek

  ​	id에 ABC abc를 입력한 경우 : id=ABC%20abc&passwd=12345

  encodeURIComponent

- 크로스 오리진(Cross-Origin)

  `-` pdf 파일 참고 or 웹사이트 참고(내가 참조한 url)
