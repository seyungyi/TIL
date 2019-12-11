- ```
  Web Client & Web Server에서 다루는 언어
  web Client : ex) Browser HTML, CSS, Javascript, Ajax, jQuery
  
  Web Server : Servlet(java로 구현하는 web server 프로그램), JSP, MVC패턴(servlet과 jsp를 함께사용), 				MyBatis, Spring Ioc, Spring MVC
  ```

  # [ Servlet Programming ]

  Servlet이란 **Java 언어로 구현하는 웹 서버 프로그래밍 기술**이다. 초기 웹 서버 프로그래밍 표준 기술은 CGI(Common Gateway Interface)였다. 언어로는 C, VisualBasic, Perl을 사용한다. CGI는 멀티프로세스 방식으로 처리하여 메모리를 많이 사용하는 단점을 가졌고 이러한 단점을 보완하기 위해 FastCGI가 나왔다. 후에 구현하기 어려운 FastCGI의 단점을 보완하기 위해 1998년 9월에 Servlet이 나왔다. Servlet은 **멀티스레드 방식**으로 처리한다. 즉 하나의 실행프로그램을 공유해서 수행한다.

  ------

  ## 1.1 구조

  Servlet은 단독으로 수행될 수 없으며 Tomcat(Web Server(코요테) + Application Server(카탈리나) : WAS)와 함께 사용해야한다. Web Server에서 Servlet클래스와 매핑되어있는지 확인하여 매핑되어있으면 Application Server로 넘겨 Servlet 클래스 객체를 생성해 수행한다.

  - CGI, FastCGI Servlet -> JSP

    ​	**Servlet 엔진(컨테이너)**

    Web Server	Web Server

  Tomcat : Web Server + Servlet Container -> WAS(Web Application Server)

  ## 1.2 수행 특징

  (1) Servlet은 한 번 메모리가 할당(객체 생성)되면 할당된 상태를 계속 유지한다. (서버가 죽을 떄까지)

  (2) 여러 클라이언트 요청에 대해서 하나의 서블릿 객체를 공유해서 수행한다.

  (3) 각 시점마다 호출되는 메서드가 정해져 있다.

  ​	객체 생성후 - init()

  ​	요청 올 때마다 - service() - doGet(), doPost()

  ​	객체 해제전 - destory()

  ## 1.3 Servlet 구현과 메서드

  **HttpServlet 클래스**를 **상속**해야 하며 main() 메서드는 구현하지 않는다. 아래 메서드는 HttpServlet 클래스가 가지고 있는 메서드로 기능에 따라 선택적으로 오버라이딩하여 구현한다.

  ```
  @WebServlet("/test")
  public class TestServlet extends HttpServlet {
  	private static final long serialVersionUID = 1L;
  
  	public void init(ServletConfig config) throws ServletException {
          //Servlet 클래스의 객체가 생성된 후 호출되는 메서드, 최초에 1번만 호출
  	}
  
  	public void destroy() {
          //Servlet 객체가 메모리에서 해제될 때 호출되는 메서드
  	}
  
  	protected void service(HttpServletRequest request, 
  			HttpServletResponse response) throws ServletException, IOException {
          //요청방식에 관계없이 브라우저로부터 요청이 전달되면 호출되는 메서드
  	}
     
  	protected void doGet(HttpServletRequest request, 
  			HttpServletResponse response) throws ServletException, IOException {
  		response.getWriter().append("Served at: ").append(request.getContextPath());
          //브라우저로부터 GET 방식으로 요청이 전달되면 호출되는 메서드
  	}
  
  	protected void doPost(HttpServletRequest request, 
  			HttpServletResponse response) throws ServletException, IOException {
  		doGet(request, response);
          //브라우저로부터 POST 방식으로 요청이 전달되면 호출되는 메서드
  	}
  }
  
  //오류
  //404 오류 : 요청된 파일을 못 찾겠다는 것으로 Servlet 클래스의 URL mappings명을 확인해야 한다.
  //405 오류 : Servlet 요청방식에 문제가 있다는 것이다. doGet() 또는 doPost() 부분의 오류를 확인해야 한다.
  //505 오류 : 실행오류이다.
  ```

  ## 1.4 Servlet 등록과 매핑

  대부분의 웹 자원들은 파일의 확장자로 파일의 종류를 구분하지만 Servlet의 경우에는 불가능하기 때문이다. Servlet의 경우에는 컴파일을 통해서 .class 확장자를 갖는데 이미 Java Applet에서 사용하고 있어 사용할 수가 없다. 따라서 Servlet 클래스 파일의 경우에는 서버에서 Servlet프로그램으로 인식되어 처리되도록 등록과 매핑이라는 설정을 주어야한다. web.xml이라는 디스크립터 파일 또는 **Servlet 소스 안에 Java의 애노테이션 구문으로 선언**(Servlet 3.0부터 추가)하는 방법이 있다.

  - Servlet 정의 애노테이션 : @WebServlet (Url mappings)
  - 매핑명이 같은 Servlet 클래스가 여러 개 있으면 Tomcat 서버가 아예 구동되지 않는다. **Url mapping명은 유일**해야한다.
  - Servlet API

  ## 1.5 쿼리 문자열 추출 방법

  쿼리 문자열은 웹 클라이언트에서 웹 서버에 요청을 보낼 때 추가로 전달하는 문자열이다. name=value&name=value... 형식의 키,값 쌍으로 이루어져있다. HttpServletRequest 객체의 **getParameter()**를 활용한다.

  ```
  String getParameter(String) : value 값 또는 null 또는 "" 리턴한다.
  String[] getParameterValues(String) : value 값의 배열 또는 null 리턴한다.
  ```

  Get 방식의 경우에는 Query 문자열 추출시 한글이 깨지지 않는다. Post 방식의 경우에는 깨지므로 추출하기 전에 request.setCharacterEncoding("UTF-8"); 을 호출한 후 추출한다.

  ```
  request.setCharacterEncoding("UTF-8");
  ```

  ## 1.6 요청 및 응답 객체 생성

  - **HttpServletRequest** : 클라이언트에서 전달되는 다양한 요청 정보를 Servlet 에 전달하는 기능을 수행한다. 쿼리 문자열을 꺼낼 때 사용한다.

  - **HttpServletResponse** : 클라이언트의 응답에 사용되는 객체로 응답과 관련하여 응답스트림 객체를 생성한다. 컨텐트 타입을 설정할 수 있다.

  - Servlet 객체가 생성된 상태인지에 따른 수행흐름

    (1) **Servlet을 객체 생성하여 수행**시킬 때

    ​	Servlet 클래스를 로딩하여 객체 생성 -> Servlet 객체의 init() 메서드 호출 -> Servlet 객체의 service() 메서드 호출

    (2) **이미 생성된 Servlet을 객체 수행**시킬 때

    ​	Servlet 객체의 service() 메서드 호출

    (3) **Servlet 객체가 메모리에서 해제**될 때의 처리

    ​	Servlet 객체의 destroy() 메서드 호출

  ## 1.7 요청 재지정 (Forward와 Redirect)

  요청 재지정이란 클라이언트에서 요청한 Servlet의 응답 대신 다른 자원(Servlet, JSP, HTML 등)의 수행 결과를 클라이언트에 대신 응답하는 기능이다. 요청 재지정에는 Forward와 Redirect하는 방법이 있다.

  - **Forward** 방식

    ```
    @WebServlet("/forward") 
    //http://localhost:8000/sedu/forward 주소가 출력된다.
    public class ForwardServlet extends HttpServlet {
    	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 	ServletException, IOException {
    		System.out.println("ForwardServlet 수행");
    		RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp"); 
    		RequestDispatcher rd = request.getRequestDispatcher("/sedu/welcome.jsp"); //오류발생 
    		RequestDispatcher rd = request.getRequestDispatcher("https://naver.com/"); //오류발생
    		//RequestDispatcher 인터페이스이다.
            //동일한 프로젝트 안에서만 forward하기 때문에 자동으로 컨텍스트패스명을 붙여준다.
            //따라서 컨텍스트패스명을 따로 주면 안된다!
    		rd.forward(request, response);
    	}
    }
    ```

  - **Redirect** 방식

    ```
    //http://localhost:8000/sedu/forward 주소가 출력된다.
    public class RedirectServlet extends HttpServlet {
    	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		System.out.println("RedirectServlet 수행");
    		//response.sendRedirect("/sedu/welcome.jsp");
    		//response.sendRedirect("http://www.naver.com/"); //다른 웹사이트의 자원을 요청 재지정가능
    		response.sendRedirect("/edu/first.html");
    	}
    }
    ```

  <<<<<<< HEAD

  ## edu, sedu

  - Dynamic Web Project : Eclipse
  - Context : WAS (Context 단위로 관리한다.)
  - Web Application : Develper

  ## Session [HttpSession 객체]

  =======

  - edu, sedu
    - Dynamic Web Project : Eclipse
    - Context : WAS (Context 단위로 관리한다.)
    - Web Application : Develper

  ## 1.8 Session [HttpSession 객체]

  > > > > > > > c55cccca7c5bfb4ba51ce2527593e568ba9909dd

  **HttpSession 객체**는 요청을 보내온 클라이언트 단위로 객체가 한 개만 생성되는 객체이다. 한 번 생성되면 해당 클라이언트가 종료될 때까지 객체가 유지된다. 클라이언트별로 어떤 정보를 원하는 시간까지 유지하고 싶을 때 사용한다.

  ex) 클라이언트가 주문할 때까지 또는 로그아웃할 때까지 선택한 정보를 유지

  - Scope : 메모리에 저장장소가 만들어진 후 언제까지 유지되느냐를 말한다.

    ```
    * page scope 
    	요청된 서버 프로그램이 수행하는 동안 유지된다. ex)지역변수
    * request scope  
    	요청된 서버 프로그램이 수행하고 응답하기 전까지 유지된다.
    				HttpServletRequest 객체에 저장된 객체
    * session scope 
    	세션이 유지되는 동안(클라이언트가 살아있는 동안)
    				HttpServlet 객체에 저장된 객체
    * application scope 
    	서버가 기동되고 나서 종료될 때까지 ex) 멤버변수, ServletContext 객체에 저장된 객체
    ```

  - 지역변수 : 수행하는 동안, 클라이언트별로 각각 메모리 할당

  - 멤버변수 : 서버가 종료될 때까지 메모리영역을 할당한다. 모든 클라이언트에 의해 공유된다.

  - 클라이언트 별로 개별적 저장, 원할 때까지 유지하고 싶을 때 -> **HttpSession 객체에 보관**한다.

  - 개별적으로 증가된다.

  - HttpSession 브라우저가 기동되어 있는 동안

  - invalidate() 메서드가 호출되기 전까지

  - **쿠키** : 서버가 클라이언트를 잊지 않기 위해서 브라우저에 보관하는 name,value 쌍 데이터를 말한다.

  - 브라우저에 쿠키가 있으면 그 session id값에 해당하는 객체를 생성하고 없으면 session id를 생성한다.

  - session 객체는 고유의 id값을 가지고 브라우저가 살아있는동안 유지된다.

  - session 생성,저장,삭제,추출

    (1) 객체로 만든다. (배열객체)

  <<<<<<< HEAD 	- request.getSession(), request.getSession(true) : HttpSession이 존재하면 현재 HttpSession

  # 	- request.getSession(false)

  ​	- request.getSession(), request.getSession(true) : HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로운 Session 객체를 사용할 수 있도록 준비해준다.

  ​	- request.getSession(false) : HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로운 Session을 생성하지 않고 null을 반환한다.

  > > > > > > > c55cccca7c5bfb4ba51ce2527593e568ba9909dd

  (2) 저장 : session.setAttribute("이름",객체)

  (3) 삭제 : session.removeAttribute("이름")

  # <<<<<<< HEAD (4) 추출 : session.getAttribute("이름") //return 값이 object이므로 강제 형변환이 필수이다.

  (4) 추출 : session.getAttribute("이름") //return 값이 object이므로 강제 형변환이 필수이다.

  - 상태 정보 관리

    - **Cookie** 기술

      상태정보를 클라이언트에 저장하는 방법을 말한다. ex) 계정 저장, 하룻동안 광고 안보게 하기

    - **HttpSession** 기술

      클라이언트마다 만들어지는 HttpSession 객체에 상태정보를 저장하는 방법을 말한다. 보안이 중요한 정보를 저장할 수 있으며 브라우저가 구동되어있는 동안만 저장을 유지할 수 있다. 내부적으로 Cookie도 사용한다.

      cf) 상태정보를 계속 유지하고 싶을 경우 : Database에 저장

  ## referer

  요청헤더정보이다. 최초의 루트를 가리킨다. 정해진 루트를 통해 왔는지 다른 사이트를 거쳐왔는지 알 수 있다.

  ```
  <a href='" + request.getHeader("referer") + "'>상품선택화면</a> //http://localhost:8000/sedu/html/productlog2.html
  <a href='"+request.getRequestURL()+"'>상품비우기</a>
  //http://xx.xx.xxx.xxx:8000/sedu/basket2
  ```

  ## 1.9 파일 업로드

  클라이언트(브라우저)에서 서버에게 요청을 보낼 때, name=value&name=value...로 구성된 쿼리 문자열을 전달할 수 있다. (영문,숫자, 일부특수문자는 그대로 전달, 나머지는 %기호와 함께 16진수로 인코딩된다.)

  --->name=value&name=value... (**application/x-www-form-urlencoded**)

  서버에게 전달하는 데이터에 클라이언트에 존재하는 파일을 첨부해서 요청하려는 경우에는 다른 형식으로 전달해야 한다.

  ---> **multipart/form-data** : 데이터를 여러 개의 파티션으로 나눠서 보내라는 것이다. ex)이메일

  **@MultipartConfig**

  클라이언트에서 전송되는 multipart/form-data 형식의 데이터를 처리하는 Servlet이 정의해야 하는 애노테이션이다.

  Collection<Part> parts = request.getParts();

  String filename = part.getSubmittedFileName(); //실제 클라이언트가 전송한 파일이름을 추출한다.