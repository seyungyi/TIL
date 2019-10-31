# Web Socket

웹에서 서버 푸시 구현을 위한 최적의 기술이다. 웹 브라우저가 웹 서버와 연결하고 있는 상태에서 필요한 정보를 주고 받는 기술이다. 웹은 요청헤더와 응답헤더를 같이 보내고 같이 받는다. 웹통신은 단방향으로 한 번 주고 받으면 다시 요청해야한다.

- 웹 소켓 구현 방법

  (1) var ws = new WebSocket("ws://echo.websocket.org/echo"); : 서버연결

  (2) ws.send ("웹소켓님 반가워요!") : 데이터 송신

  (3) ws.onmessage = function(e) { : 데이터 수신 log("웹소켓 에코서버로 부터 메시지 도착: " + e.data); // 메시지가 하나 도착하면 소켓을 닫음 }

- 웹 소켓 관련 이벤트

  (1) open

  (2) close

  (3) message

  (4) error