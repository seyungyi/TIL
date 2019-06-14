# [ Servlet Programming ]

- Java 언어로 구현하는 웹 서버 프로그래밍 기술
  - 웹 서버 프로그래밍 기술=CGI : 웹서버 프로그래밍 기술의 표준( C, VisualBasic, Perl..) -> ASP, PHP
    - 단점
      1. 여러 클라이언트의  동시 요청이 있을 시 **멀티프로세스** 방식으로 처리 : 요청때마다 메모리에 프로세스가 실행되기에 많은 메모리를 할당하게 되어 속도가 저하
    - 해결 방법
      1. FastCGI 를 만듬( 미리 메모리에 프로세스를 할당시켜놓는다. 단, 구현이 어려움 )
      2. Servlet 출현(1998, 9) : **멀티스레드** 방식( 하나의 메모리에 여러 스레드가 공유하는 방식 )
      3. JSP 등장 : Servlet보다 쉬우며 수행상에서는 Servlet보다 간편함

| CGI, FastCGI                           | Wer Server | Tomcat                               |
| -------------------------------------- | ---------- | ------------------------------------ |
| Servlet<br />Servlet 엔진( Container ) | Web Server | Web Server + Servlet Container = WAS |

- MIME : HTTP와 같은 통신 프로토콜에서 사용되거나 전자우편에서 사용되는 인터넷 표준 포맷

- Query를 보내는 방법
  - 기본 접속 URL에 ?속성=값 의 형식으로 접소하면 된다.
    - (ex)http://localhost:8000/sedu/FirstServlet?name속성=값
  
- 서블릿의 특징
  
  - 응답을 할 시 객체를 전달받아서 해야한다(변수에 담아서)
  - 자바와는 다르게 매핑이 필요 : 웹은 확장자를 통해 요청을 확인한다
    1. 서블릿은 수행파일이 .class 확장자인데 서버에서 인식시키기 위해 등록과 매핑이라는 설정을 web.xml이라는 디스크립터 파일에 등록할 때마다 작성해야한다(WEB-INF 폴더에 생성)
    2. 서블릿 3.0이후부터는 java소스 안에 애노테이션을 작성해 자동으로 매핑기능 설정 가능
  
  ## [ 1차 정리 ]
  
  - HttpServlet 클래스를 상속
  
    - Tomcat(Web Server(코요테) + Application Server(카탈리나) : WAS)
  
    - GET방식 : doGet() 오버라이딩
  
    - POSET방식 : doPost() 오버라이딩
  
    - 둘 다 사용 : doGet(), doPost(), `service()`-> 수행방식이 같다라는 의미
  
    - HttpServletRequest : 쿼리 문자열을 추출하는 용도. 요청을 보내온 클라이언트의 정보를 추출
  
      즉. 요청 정보를 추출하고자 할 때(쿼리 문자열) 사용
  
    - HttpServletResponse : 응답과 관련하여 응답스트림객체를 생성
  
       컨텐트 타입 설정(한글 폰트 깨짐 등의 설정을 위함)
  
  - 서블릿의 수행상의 특징
  
    - 서블릿은 단독으로 수행할 수 없음. 서블릿 컨테이너가 객체를 전달받아 수행하는 방식
    - 한 번 메모리 할당(객체생성)이 되면 할당 상태를 게속 유지한다(메모리 재사용 방식)
    - 여러 클라이언트 요청에 대해서 하나의 서블릿 객체를 공유해서 수행한다
    - 각 시점마다 호출되는 메서드가 정해져 있다
      - 객체 생성후 - init()
      - 요청이 올 떄마다 - service() - doGet(), doPost()
      - 객체 해제 전 - destroy()
  
  - 쿼리 문자열 추출 방법
  
    - name=value&name=value&name=value..........
    - HttpServletRequest 객체의 getParameter() 사용
      - String getParameter(String) : 리턴값이 value값 또는 null 또는 " "
      - String[] getParameterValues(String) : value값들의 배열(예: checkbox 등) 또는 null
    - GET 방식의 경우에는 Query 문자열 추출시 한글이 깨지지 않는다
    - POST 방식은 깨짐 : 추출하기 전에 request.setCharacterEncoding("UTF-8"); 을 호출한 후 추출

