# [ AJAX (Asynchronous JavaScript And XML)]

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

- GML( IBM : 출판문서 작성 용도 )

  `-` SGML( 표준 : 출판뿐만 아니라 규격 문서를 작성하는 범용 용도 )

  ​	`-` HTML( 웹 페이지 제작용 )  => 태그가 정해져 있음

  ​	`-` XML( 다목적 ...., 규격화된 문서 작성용 ) => 직접 태그 정의(=용도에 맞춰서 정의)

  ​		`-` 시작 태그와 종료태그가 반드시 존재하는 규칙. 엄격함

  ​		`-` <태그명> .... </태그명>

  ​		`-` <태그명 속성명 = "속성값">

- 크롬 개발자도구에서 Network탭의 xhr 이 ajax 응답을 뜻하는 것임



- 크로스 오리진(Cross-Origin)

  `-` pdf 파일 참고 or 웹사이트 참고(내가 참조한 url)