# Spring Framework

스프링 프레임워크란 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크로서 간단히 스프링이라고 한다. 소스 코드의 코딩량을 줄여주고 유지보수성이 좋은 프로그램이다.

웹 서버 프로그래밍 - Spring MVC, Spring Ioc(Spring DI)

Eclipse EE = Eclipse for Java Developer +WTP(Web Tools Platform) + **STS(Spring Tool Suite) 추가설치**

- Eclipse-Help-Eclipse Marketplace-STS검색-Spring Tools 3 Add-On설치

프레임워크(framework) - 1998, 2004~2006 : 스마트 라이브러리(라이브러리+디스크립터 파일( XML))

- 최초 프레임워크는 EJB(1998)(Java+XML) 였다. 그러나 구현이 어려웠다.
- Servlet, Struts, iBatis(MyBatis), Spring, Spring MVC

## 학습 순서

(1) **Spring IoC**

외부에서 객체를 만들어서 프로그램에 넣어주는 기술이다. 객체 생성을 Spring DI 컨테이너가 대신하게 한다. Spring Framework에서 프로그램에서 필요한 객체를 생성한다. 또한 객체를 필요로 하는 곳에 주입하고 객체를 찾을 때 제공한다.

- **DL**(Dependency Lookup) : 객체를 달라고 할 때마다 주는 것이다.
- **DI**(Dependency Injection) : 어떤 상황에서 객체를 달라고 하는 것을 xml에 작성하면 주는 것이다.
  - **Setter Injection** : setter 메서드를 이용해서 객체를 바인딩(의존관계를 연결)한다.
  - **Constructor Injection** : 생성자를 통해 객체를 바인딩(의존관계를 연결)한다.

Maven Project 추가 방법

- Springioc Java Project 생성

- Springioc-오른쪽마우스-configure-convert to Maven Project 선택

- Name : Springioc_project, Description : 스프링 IOC 학습용 자바프로젝트입니다. 입력

- pom.xml을 수정해서 프로젝트에서 의존하는 추가라이브러리에 대한 정보를 작성

  - 오류 발생할 경우 .m2 파일에 repository파일이 만들어졌는지 확인한다.

  ```
  <dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.0.2.RELEASE</version>
  </dependency>
  </dependencies> 
  ```

Annotation 설정

- @Component

  클래스에 선언하며 해당 클래스를 자동으로 bean 으로 등록한다

- @autowired

  - autowired="**byType**" : **setter**

    (1) 타입으로 찾아서 1개이면 해당 객체 주입 (2) 타입으로 찾아서 2개 이상이면 NoUniqueBeanDefinitionException 발생 (3) 없으면 null 주입 : 주입을 포기한다는 의미이다.

  - autowired="**byName**" : setter (1) 프로퍼티명과 동일한 명칭의 빈을 찾아서 해당 객체 주입 (2) 없으면 null 주입

  - autowired="**constructor**" : (1) 타입으로 찾아서 1개이면 해당 객체 주입 (2) 타입으로 찾아서 2개 이상이면 **매개변수명과 동일한 id 값**을 갖는 객체 주입 (3) 없으면 null 주입

  - 필드(멤버변수)에 설정된 @Autowired (디폴트는 required = true다.) - Spring Framework 전용 /멤버변수,생성자메서드,setter메서드,일반메서드에 적용가능하다. (1) 타입으로 찾아서 1개이면 해당 객체 주입 (2) 타입으로 찾아서 2개 이상이면 **변수명과 동일한 id 값을 갖는 객체** 주입 (3) 없으면 NoSuchBeanDefinitionException 발생 (**required = false** 속성을 사용하여 없으면 null 이 되게 지정 가능) (4) **@Qualifier(value="xxx")**를 추가로 사용해서 변수명이 아닌 다른 이름 지정 가능

    간단하게 멤버변수와 setter메서드를 입력할 수 있다.

  - 필드에 설정된 @Resource - Java 전용 (1) **변수명과 동일한 id 값을 갖는 빈**을 찾아서 해당 객체 주입 - 변수명이 우선이다. (2) 타입으로 찾아서 1개이면 객체 주입 (3) 타입으로 찾아서 2개이상 이면 NoUniqueBeanDefinitionException 발생 (4) 없으면 NoSuchBeanDefinitionException 발생

## (2) **Spring MVC**

**웹 어플리케이션**

복수의 사용자가 인터넷을 통해 DB에 접근하고 안전하게 정보를 읽고 쓸 수 있게 지원하는 어플리케이션이다.

기본적으로 Forword방식으로 전송한다. redirect방식으로 전송하고 싶으면 "redirect:에 context명을 제외한 path정보"를 사용한다. 그러면 302라는 응답과 함께 다시 끌어간다.

- 웹 어플리케이션 구조

  - 티어 : 어플리케이션의 구조를 물리적으로 나눈 것
  - 레이어 : 어플리케이션의 구조를 논리적으로 나눈 것
    - 프레젠테이션 레이어 : 컨트롤러, 뷰
    - 비즈니스 로직 레이어 : 서비스, 도메인
    - 데이터 엑세스 레이어 : DAO

- 스프링 MVC

  프론트 컨트롤러 패턴을 적용한다. 프론트 컨트롤러 패턴이란, 하나의 핸들러 객체를 통해서 요청을 할당하고, 일관된 처리를 작성할 수 있게 하는 개발 패턴이다.

  - Spring Framework가 제공하는 것
    - **Dispatcher Servlet** : 클라이언트가 요청하는 모든 요청을 받는다.
    - **Handler Mapping** : Handler Mapping을 통해 Dispatcher Servlet에서 클라이언트가 무엇을 요청했는지 판단한다.
    - **View Resolver** : 출력할 뷰를 Dispatcher Servlet에 전송한다.

- Spring MVC 패키지 만들기

  Spring MVC project명 : springedu

  package명 : my.spring.springedu

  server 추가

  property-utf-8로 변경, properties-web project settings - context명 확인

  - webapp : 최상위 폴더이다.
  - resources :html 등 정적 리소스(클라이언트한테 바로 줄 수 있는 리소스)를 보관한다.
  - views : jsp를 보관한다.
  - my.spring.springedu : controller를 보관한다.

  ```
  pom.xml 환경 변경
  <java-version>1.8</java-version>
  <org.springframework-version>5.0.2.RELEASE</org.springframework-version>
  ```

  ```
  web.xml에 추가
  <filter> <!-- spring MVC에서 post방식으로 전송하여도 깨지지 않는다. post방식 setCharacterEncoding -->
      <filter-name>encodingFilter</filter-name>
      <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
      <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
      </init-param>
    </filter>
    <filter-mapping>
      <filter-name>encodingFilter</filter-name>
      <url-pattern>/*</url-pattern>
    </filter-mapping>
  ```

  - javax.servlet.forward.request_uri : 클라이언트가 요청한 uri 다.

- vo에 담아 보낼 떄(Dispatcher Servlet이 처리해준다.)

1. Controller 매개변수 값이 3개 이상일 때 VO model에 담아 사용한다.
2. vo 멤버변수 이름과 쿼리문자열 이름이 같아야한다.
3. Dispatcher Servlet이 클래스 이름에서 앞에 첫문자를 소문자로 만들어 request객체에 저장해준다.
4. vo에 담을 쿼리문자열 값을 주지 않으면 setter메서드를 호출하지 않는다.
5. @ModelAttribute("사용하고자 하는 이름")를 사용해서 request객체이름을 저장할 수 있다.

- 쿼리문자열을 @PathVariable를 사용하여 추출하기

```
(value="/character/detail/{name}/{number}") //{}를 씌우면 동적 패스가 된다. 어떤 값이 오든 상관없다.
public String getAllBoards(@PathVariable("number") int num, @PathVariable String name, Model model){
     if(name.equals("kakao")) {
	    	 if (num == 1) 
	    		 model.addAttribute("imgname", "ryan");
     }
}
//@PathVariable("number") int num :에는 이번 요청에서 사용된 매핑명에서 number라는 이름으로 저장된 값이 저장된다. 
//@PathVariable String name : 전달받을 매개변수 이름과 pathVariable에 의해 추출되는 이름이 같으면 따로 이름을 지정하지 않아도 된다.
//Model model : 매개변수로 Map,Model,ModelMap을 생성하여 사용하면 자원을 재사용할 수 있다.
			   model.addAttribute로 view로 보낸다.
//java객체를 json 또는 xml로 변환하기 위해 사용한다. pom_xml 파일의 종료 dependencies태그 바로 위에 삽입
<dependency>
    	<groupId>com.fasterxml.jackson.core</groupId>
    	<artifactId>jackson-databind</artifactId>
    	<version>2.9.9</version>
</dependency>
	
<dependency>
	<groupId>commons-fileupload</groupId>
	<artifactId>commons-fileupload</artifactId>
	<version>1.3.1</version>
</dependency>
//annotation을 사용하기 위해 작성한다. servlet-context_xml 파일종료 beans태그 바로 위에 삽입한다.
<beans:bean id="multipartResolver"
		class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />

<context:component-scan base-package="service" /> 
<context:component-scan base-package="dao" />
<context:component-scan base-package="vo" />
```

- Lotto : LottoVO, LottoDAO, LottoService, lottoForm1, LottoController, lottoView1

- **Annotation은 singletone으로 객체가 생성될 떄 미리 생성한다.**

- @Component [springioc]

- [springmvc] : spring container에 의해 관리된다.

  - @Controller : Controller클래스로 객체 생성해달라는 것이다.
  - @Service : spring container에 의해 관리되는 객체로 역할은 service이다.
  - @Repository : spring이 대신 객체 생성해주는 것으로 저장소와 관련된 것이다.

- **@Autowired로 객체를 생성하면 이 객체를 사용하는 다른 클래스에도 @Autowired를 사용해야 한다.**

- @RestController = @Controller + **@ResponseBody**

  @ResponseBody //뷰를 거치치 않고 클라이언트에 바로 응답한다.

- FileUpload

  - **enctype="multipart/form-data" method="post"**

  - <beans:bean id="multipartResolver"

    class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />

  - 클라이언트에서 업로드되는 파일은 하나의 파트(다중파일이 업로드 될 때는 여러 개의 파트로) 구성되어 전달된다.

  - 이 파트를 아규먼트로 받기 위해서는 컨트롤러메서드의 매개변수타입을 다음 3가지 중 하나로 지정한다. xxx(MultipartFile타입을멤버변수로정의한VO클래스 vo) xxx(MultipartRequest mreq)  다중 파일일 때

  - MultipartFile의 주요 메소드

    | 메서드 이름                          | 메서드 설명                                           |
    | ------------------------------------ | ----------------------------------------------------- |
    | String getName()                     | 파라미터 이름을 구한다 .                              |
    | String getOriginalFilename()         | 업로드 한 파일의 실제 이름을 구한다.                  |
    | boolean isEmpty()                    | 업로드 한 파일이 존재하지 않는 경우 true 를 리턴한다. |
    | long getSize()                       | 업로드한 파일의 크기를 구한다.                        |
    | byte[] getBytes() throws IOException | 업로드 한 파일 데이터를 구한다.                       |
    | InputStream getInputStream()         | InputStrem을 구한다.                                  |
    | void transferTo(File dest)           | 업로드 한 파일 데이터를 지정한 파일에 저장한다 .      |

- **@ResponseBody**

  : 뷰를 거치지 않고 controller가 직접 클라이언트한테 응답한다.

  - pom.xml **jackson-databind** 라이브러리를 통해 json, xml 등 형식으로 변환 가능하다.

    cf) jackson : Json 뿐만 아니라 XML/YAML/CSV 등 다양한 형식의 데이타를 지원하는 data-processing 툴이다.

- @XmlRootElement : VO객체에 붙여주어야한다.

- **@ExceptionHandler**

  : controller 내에서 오류가 발생했을 때 처리한다. (지역적)

- **@ControllerAdvice**

  : 비슷한 로그, 예외를 따로 전담하여 처리한다. (전역적)

## (3) MyBatis

## : JDBC 프로그래밍을 더 효율적으로 할 수 있게 해준다. (HiberNate라는 것도 있다.)

예외처리, 반복문 처리할 때 사용한다. dao 프로그램과 dao에서 사용하는 sql문 명령어를 분리시킨다.

sql mapper와 프로그램 구동방법을 알아야한다.

: 객체 지향 어플리케이션에서 관계형 데이터베이스를 쉽게 사용할 수 있도록 도와주는 데이터 맵핑 프레임워크이다.

- MyBatis 설치

  : mybatis-3.4.1.jar 파일을 WEB-INF/lib 폴더에 저장한다.

- MyBatis3 주요 구성 요소

  | 구성요소 / 구성파일                                | 설명                                                         |
  | -------------------------------------------------- | ------------------------------------------------------------ |
  | MyBatis configuration file                         | Mybatis3의 작업 설정을 설명하는 xml파일이다. 데이터베이스 연결 대상, 매핑 파일의 경로 등 세부사항을 작성한다. |
  | org.apache.ibatis.session.SqlSessionFactoryBuilder | SqlSessionFactory 객체를 생성한다.                           |
  | org.apache.ibatis.session.SqlSessionFactory        | SqlSession 객체를 생성한다.                                  |
  | org.apache.ibatis.session.SqlSession               | SQL 실행 및 트랜잭션 제어를 위한 API를 제공한다.             |
  | Mapper interface                                   | Mybatis3는 Mapper interface에 대한 구현 클래스를 자동으로 생성한다. |
  | Mapping file                                       | SQL 및 O/R 매핑 설정을 설명하는 XML파일이다.                 |

- Mybatis 매핑파일

  ```
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  <mapper namespace="resource.VisitorMapper">
   	<select id="selectVisitor"  resultType="model.vo.VisitorVO">
      	select id, name, to_char(writedate,'yyyy"년"mm"월"dd"일"') writedate, memo from visitor
   	</select>
   	 <select id="selectVisitor1"  resultType="model.vo.VisitorVO"><!-- <![CDATA[<]]> : cdata section이라는 의미이다. < 대괄호 안에 담아서 사용해야한다.  -->
      	select id, name, to_char(writedate,'yyyy"년"mm"월"dd"일"') writedate, memo from visitor where id <![CDATA[<]]> 5 
   	</select>
    	<insert id="insertVisitor"  parameterType="model.vo.VisitorVO">
    		<selectKey resultType="_int" keyProperty="id" order="BEFORE">
        		select visitor_seq.nextval from dual     
      	</selectKey>  
      		insert into visitor (id, name, writedate, memo) values (#{id}, #{name},sysdate, #{memo})
  	</insert>
  	<select id="searchVisitor"  parameterType="java.lang.String" resultType="model.vo.VisitorVO">
      	select id, name, to_char(writedate,'yyyy"년"mm"월"dd"일"') writedate, memo from visitor where memo like '%'||#{key}||'%'
      </select>
  	<delete id="deleteVisitor"  parameterType="_int"  >
      	delete from visitor where id = #{id}
  	</delete>
  </mapper>
  ```

```
[추가 라이브러리 준비 방법]
(1) 해당 라이브러리 압축파일(xxx.jar)을 사이트에서 다운로드하여 정해진 디렉토리에 저장하거나 패스 설정을 한다. -> 관리하기가 쉽지 않다..
(2) 추가로 설치하려는 라이브러리를 관리해주는 툴(빌드 툴)
- Maven, Gradle 등 (pom.xml에 내려받을 것을 작성하면 빌드 툴이 다운로드해준다.)
```

- xmlns:p="<http://www.springframework.org/schema/p>" - property를 대신한다. xmlns:c="<http://www.springframework.org/schema/c>" - constructor-arg를 대신한다.