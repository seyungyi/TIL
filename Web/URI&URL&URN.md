# [ URI & URL & URN ]

## 개요

- 웹 프로그램을 개발하는 과정에서 내가 무의식적으로 URI와 URL이라는 용어를 혼용해서 사용한다는 것을 깨달음
- 두 가지 용어의 차이가 무엇인지와 어떤 경우에 사용하는 것이 목적에 맞는지 알아내는 것이 목표
- URN이라는 용어가 같이 설명 되어있어 같이 정리함



## 개념

### URI(Uniform Resource Identifier) : 통합 자원 식별자

- 인터넷에 있는 자원을 나타내는 유일한 주소를 의미. 즉, 정보의 리소스를 고유하게 식별하고 위치를 지정할 수 있다는 개념
- 인터넷에서 요구되는 기본 조건이기에 인터넷 프로토콜에 항상 붙어다님
- URI의 하위 개념에는 두 가지 형태가 존재
  - URL
  - URN

### URL(Uniform Resource Locator) : 파일식별자, 유일자원지시기

- 네트워크상에서 자원이 어디 있는지를 알려주기 위한 규약. 즉, 특정 서버의 한 리소스에 대한 구체적인 위치를 서술함
- 웹 사이트의 주소뿐만 아니라 컴퓨터 네트워크상의 자원을 모두 나타낼 수 있음
  - 해당 URL에 맞는 프로토콜과 동일하게 접속해야한다

### URN(Uniform Resource Name) : 통합 자원 이름

- urn:scheme을 사용하는 URI를 위한 역사적인 이름

- URN은 영속적이고, 위치에 독립적인 자원을 위한 지시자로 사용하기 위해 1997년도에 RFC 2141 문서에서 정의됨

  > 위키백과에서 정의된 URN에 대한 내용. 어떤 의미를 가지는가?

- 리소스가 어디에 위치해 있든 찾을 수 있는 방식을 말함. 즉, 리소스의 위치에 영향 받지 않는 유일무이한 이름 역할을 함

  - 리소스가 이름을 변하지 않고 유지하는 한, 여러 종류의 네트워크 접속 프로토콜로 접속해도 문제가 없음

  > (예) 인터넷 표준 문서 'RFC 2141'이 어디에 있는지 상관없이 그것을 지칭하기 위해 사용 가능하다
  >
  > `urn:ietf:rfc:2141 - 'RFC 2141' 문서`

- URL의 한계로 인하여 착수되었음

  - `URL의 한계` : URL은 주소를 의미하는 것이지 실제 이름을 의미하는 것은 아니다.
    - 이 말의 의미는 특정 시점에 어떤 것이 위치한 곳을 알려준다는 것을 의미한다!

  > (예) 구글의 주소 http://google.com이 존재 --> http://google,com/test로 URL 변경
  >
  > 리소스의 변경으로 해당 객체를 찾을 방법이 없어짐. URN의 경우 객체의 위치랑 상관없이 실제 객체의 이름을 사용하기에 위치가 바뀌더라도 리소스의 위치를 찾아 사용할 수 있음



## 구조

[ 예시 주소 ]  http://opentutorials.org:3000/main?id=HTML&page=2#a

- http : protocol

  - 사용할 프로토콜을 의미. 리소스에 어떻게 요청, 접근할 것인지를 명시함
  - 웹은 HTTP 프로토콜을 사용함
  - ftp, mailto(email), rtsp(streaming) 등

- opentutorials.org : host(domain)

  - 서버에 접근하기 위한 주소

  - ftp와 같은 서버들은 데이터에 접근하기 위해 사용자의 이름과 비밀번호를 요구함

    > (ex) ftp://username:port@host/test.pdf

- 3000 : port

- main : path

  - 호스트에서 제공하는 자원의 경로를 의미함

- id=HTML&page=2 : query string

  - 클라이언트가 자원을 GET 방식으로 요청할 때, 필요한 데이터를 함께 넘겨 줄 목적으로 사용함

  - 개발시 함수를 호출하면 파라미터를 전달하는 것과 비슷함

    > (ex) http://localhost:3000/index?id=3&page=1

- #a : 프래그먼트

  - HTML에는 각각의 요소에 id 속성을 부여하였을 경우, URL에 프래그먼트를 전달하면 해당 id가 있는 곳으로 스크롤이 이동함

    > (ex) http://localhost:3000/index?id=&page=1#bottom --> 해당 페이지의 하단으로 이동



## 참조

- https://velog.io/@jch9537/URI-URL
- https://mygumi.tistory.com/139
- https://victorydntmd.tistory.com/287#recentComments