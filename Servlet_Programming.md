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

### < edu, sedu 라는 프로젝트 폴더 > 2019/06/17

- Dynamic Web Project : Eclipse 측면에서의 프로젝트 명칭
- Context : WAS (등록의 개수제한이 없지만 실행시간이 걸림)
  - 각각의 컨테스트로 구축시 관리 및 유지보수가 수월해짐( 관리자폴더 수정시 학습폴더 수행 가능 )
- Web Application : Developer 기준에서의 프로젝트 명칭

### [ 세션 : HttpSession 객체 ]

- HttpSession 객체

  - 요청을 보내온 클라이언트 단위로 객체가 한 개만 생성되는 객체로서 한 번 생성되면 해당 클라이언트가 종료될 때까지 객체가 유지된다
  - 클라이언트별로 어떤 정보를 원하는 시각까지 유지하고 싶을 때 사용한다

  -  scope : 메모리에 저장장소가 만들어진 후 언제까지 유지되는가?
    - page scope : 요청된 서버 프로그램이 수행하는 동안 유지 - 지역변수(가 가진다)
    - request scope : 요청된 서버 프로그램이 수행하고 응답하기 전까지 유지 - HttpServletRequest 객체에 저장된 객체
    - session scope : 세션이 유지되는 동안 - HttpSession 객체에 저장된 객체
    - application scope : 서버가 기동되고 나서 종료될때 까지 - 멤버변수, ServletContext 객체에 저장된 객체

- 지역변수 : 수행하는 동안 지속되며 종료되면 사라진다. 클라이언트별로 각각 메모리 할당
- 멤버변수 : 서버가 종료될 때까지 메모리 영역을 할당한다. 모든 클라이언트에 의해서 공유됨
- 클라이언트 별로 개별적 저장, 원할 때까지 유지 ----> HttpSession 객체에 보관한다
- HttpSession 객체는 언제까지 유지되는가?
  1. 브라우저가 기동되어 있는 동안 유지
  2. invalidate() 메소드가 호출되기 전까지
  3. inactive interval 시간이 적용되기 전까지 - 30분
- 객체로 만든다(배열 객체)
  - 저장 : session.setAttribute("이름", 객체);
  - 삭제 : session.removeAttribute("이름");
  - 추출 : session.getAttribute("이름"); ---> 강제 형변환은 필수

### [ 파일 업로드 ] 2019/06/18

- (웹) 클라이언트에서 서버(HttpServer)에게  요청을 보낼 때  name=value로 구성된 쿼리 문자열을 전달할 수 있다(영문, 숫자, 일부특수문자는 그대로 전달, 나머지는 인코딩)
  - name=value&name=value.......
  - form 태그의 action 속성 -> application/x-www-form-urlencoded : POST 방식 요청시 namevalue설정에 대한 정보
- 서버에게 전달하는 데이터에 클라리언트에 존재하는 파일을 첨부해서 요청하려는 경우에는 다른 형식으로 전달해야 함(applicaion방식은 X)
  - multipart/form-data

### [ MVC 패턴 간략히 ]

- 소프트웨어공학에서 사용되는 아키텍처 패턴
- 사용자 인터페이스로부터 비지니스 로직을 분리해 시각적 요소와 이면에서 실행되는 비지니스 로직을 영향없이 쉽게 고칠 수 있게하는 패턴