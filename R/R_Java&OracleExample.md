# [ R과 Java Oracle 예제 ]

## Controller

- RDBController.java

  ```java
  package edu.spring.redu;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.servlet.ModelAndView;
  
  import rtest.ROracleDB;
  import rtest.RTestDAO;
  @Controller
  public class RDBController {
  	@Autowired
  	ROracleDB rdb;
  	@Autowired
  	RTestDAO rtb;
  	@RequestMapping("/visitorAll")
  	public ModelAndView get1() {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("result", rdb.returnDBData(1));
  		mav.setViewName("rdbview");
  		return mav;
  	}	
  	@RequestMapping("/visitorAllOrderByName")
  	public ModelAndView get2() {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("result", rdb.returnDBData(2));
  		mav.setViewName("rdbview");
  		return mav;
  	}	
  	@RequestMapping("/visitorByName")
  	public ModelAndView get3(String name) {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("result", rdb.returnDBData("\\'"+name+"\\'"));
  		mav.setViewName("rdbview");
  		return mav;
  	}	
  	@RequestMapping("/insertVisitor")
  	public ModelAndView proc(String name, String content) {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("result", rdb.insertDBData("\\'"+name+"\\'", "\\'"+content+"\\'"));
  		mav.setViewName("rdbview");
  		return mav;
  	}	
  	@RequestMapping("/createTable")
  	public ModelAndView create() {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("result", rtb.createTable());
  		mav.setViewName("rdbview");
  		return mav;
  	}	
  	@RequestMapping("/dropTable")
  	public ModelAndView drop() {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("result", rtb.dropTable());
  		mav.setViewName("rdbview");
  		return mav;
  	}	
  	@RequestMapping("/listTable")
  	public ModelAndView list() {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("result", rtb.listTable());
  		mav.setViewName("rdbview");
  		return mav;
  	}	
  }
  ```

- RGraphController.java

  ```java
  package edu.spring.redu;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.servlet.ModelAndView;
  
  import rtest.RGraph;
  @Controller
  public class RGraphController1 {
  	@Autowired
  	RGraph rg;
  		
  	@RequestMapping("/graph1")
  	public ModelAndView get1() {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("img_content", rg.returnRImg1());
  		mav.setViewName("rgraph");
  		return mav;
  	}	
  	@RequestMapping("/graph2")
  	public ModelAndView get2() {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("img_content", rg.returnRImg2());
  		mav.setViewName("rgraph");
  		return mav;
  	}		
  	@RequestMapping("/wordcloud1")
  	public ModelAndView get3() {
  		ModelAndView mav = new ModelAndView();
  		mav.addObject("img_content", rg.returnRImg3());
  		mav.setViewName("rgraph");
  		return mav;
  	}
  }
  ```

## DAO

- ROracleDB.java

  ```java
  package rtest;
  
  import org.rosuda.REngine.RList;
  import org.rosuda.REngine.Rserve.RConnection;
  import org.springframework.stereotype.Repository;
  
  @Repository
  public class ROracleDB {
  	public String returnDBData(int type) {
  		String retStr = "";
  		RConnection r = null;
  		try {
  			r = new RConnection();			
  			r.eval("library(DBI)");
  			r.eval("library(RJDBC)");
  			r.eval("library(rJava)"); 
  			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','c:/H/ojdbc6.jar')");
  			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
  			if( type == 1)
  				r.eval("query = 'SELECT * FROM VISITOR'");
  			else if (type == 2)
  				r.eval("query = 'SELECT * FROM VISITOR order by name'");
  			RList list = r.eval("dbGetQuery(conn,query)").asList();
  			int cols = list.size();
  			int rows = list.at(0).length();
  			String[][]s = new String[cols][];
  			for(int i=0; i<cols; i++) {
  				s[i] = list.at(i).asStrings();				
  			}
  			for(int j=0; j<rows; j++) {
  				for(int i=0; i<cols; i++) {
  					retStr += (s[i][j])+"";
  				}
  				retStr += "</br>";
  			}			
  		} catch(Exception e) {
  			System.out.println(e);
  			retStr = "오류 발생!!";
  		} finally {
  			r.close();
  		}
  		return retStr;
  	}
  	public String returnDBData(String name) {
  		String retStr = "";
  		RConnection r = null;
  		System.out.println("---->"+name);
  		try {
  			r = new RConnection();			
  			r.eval("library(DBI)");
  			r.eval("library(RJDBC)");
  			r.eval("library(rJava)"); 
  			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','c:/H/ojdbc6.jar')");
  			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
  			r.eval("query <- 'SELECT * FROM VISITOR WHERE NAME = "+name+"'"); 
  			RList list = r.eval("dbGetQuery(conn,query)").asList();
  			int cols = list.size();
  			int rows = list.at(0).length();
  			String[][]s = new String[cols][];
  			for(int i=0; i<cols; i++) {
  				s[i] = list.at(i).asStrings();				
  			}
  			for(int j=0; j<rows; j++) {
  				for(int i=0; i<cols; i++) {
  					retStr += (s[i][j])+"";
  				}
  				retStr += "</br>";
  			}					
  		} catch(Exception e) {
  			System.out.println(e);
  			retStr = "오류 발생!!";
  		} finally {
  			r.close();
  		}
  		return retStr;
  	}
  	public String insertDBData(String name, String content) {
  		String retStr = "";
  		RConnection r = null;
  		System.out.println("---->"+name);
  		System.out.println("---->"+content);
  		try {
  			r = new RConnection();			
  			r.eval("library(DBI)");
  			r.eval("library(RJDBC)");
  			r.eval("library(rJava)"); 
  			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','c:/H/ojdbc6.jar')");
  			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
  			r.eval("insertSQL <- 'INSERT INTO visitor VALUES ("+name+",sysdate,"+content+", visitor_seq.nextval)'");
  			r.eval("dbSendUpdate (conn, insertSQL)");
  			retStr = r.eval("'정상적으로 저장되었어요..'").asString();			
  		} catch(Exception e) {
  			System.out.println(e);
  			retStr = "오류 발생!!";
  		} finally {
  			r.close();
  		}
  		return retStr;
  	}
  }
  ```

- RTestDAO.java

  ```java
  package rtest;
  
  import org.rosuda.REngine.RList;
  import org.rosuda.REngine.Rserve.RConnection;
  import org.springframework.stereotype.Repository;
  
  @Repository
  public class RTestDAO {
  
  	// 테이블 생성
  	public String createTable() {
  		String retStr = "";
  		RConnection r = null;
  		try {
  			// R과 연결, 패키지 메모리에 로딩
  			r = new RConnection();
  			r.eval("library(DBI)");
  			r.eval("library(RJDBC)");
  			r.eval("library(rJava)");
  			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','C:/H/ojdbc6.jar')");
  			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
  			// 1. 파일 읽기
  			r.eval("student<-read.csv('C:/Rstudy/example_studentlist.csv')");
  			// 2. dataframe형식으로 oracle에 저장하기
  			r.eval("dbWriteTable(conn, 'student', student)");
  			System.out.println("테이블 생성과 데이터 저장 성공.......");
  			retStr = r.eval("'테이블 생성과 데이터 저장 성공.......'").asString();	
  		} catch (Exception e) {
  			System.out.println(e.getMessage());
  //			e.printStackTrace();
  		} finally {
  			r.close();
  		}
  		return retStr;
  	}
  
  	// 테이블 삭제
  	public String dropTable() {
  		String retStr = "";
  		RConnection r = null;
  		try {
  			r = new RConnection();
  			r.eval("library(DBI)");
  			r.eval("library(RJDBC)");
  			r.eval("library(rJava)");
  			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','C:/H/ojdbc6.jar')");
  			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
  			r.eval("dbRemoveTable(conn, 'STUDENT')");
  			System.out.println("삭제 성공.......");
  			retStr = r.eval("'삭제 성공.......'").asString();	
  		} catch (Exception e) {
  			System.out.println(e.getMessage());
  		} finally {
  			r.close();
  		}
  		return retStr;
  	}
  
  	// 데이터 가져와서 보여주기
  	public Object listTable() {
  		String retStr = "";
  		RConnection r = null;
  		try {
  			r = new RConnection();
  			r.eval("library(DBI)");
  			r.eval("library(RJDBC)");
  			r.eval("library(rJava)");
  			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','C:/H/ojdbc6.jar')");
  			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
  			//이게 실패
  			r.eval("query <- 'SELECT * FROM STUDENT'");
  			System.out.println("select success1");
  			RList list = r.eval("dbGetQuery(conn,query)").asList();
  			System.out.println("select success2");
  			int cols = list.size();
  			int rows = list.at(0).length();
  			String[][] s = new String[cols][];
  			for (int i = 0; i < cols; i++) {
  				s[i] = list.at(i).asStrings();
  			}
  			for (int j = 0; j < rows; j++) {
  				for (int i = 0; i < cols; i++) {
  					retStr += (s[i][j]) + "";
  				}
  				retStr += "</br>";
  			}
  		} catch (Exception e) {
  			System.out.println(e.getMessage());
  		} finally {
  			r.close();
  		}
  		return retStr;
  	}
  }
  ```

- RGraph.java

  ```java
  package rtest;
  
  import org.rosuda.REngine.Rserve.RConnection;
  import org.springframework.stereotype.Service;
  @Service
  public class RGraph {
  	public byte[] returnRImg1() {
  		RConnection r = null;
  		byte retImg [] = null;
  		try {
  			r = new RConnection();		
  			r.eval("jpeg('test.jpg')");
  			r.eval("x <- 1:10");
  			r.eval("barplot(x, names='SALES', col=rainbow(15))");
  			r.eval("dev.off()");
  			r.eval("r<-readBin('test.jpg','raw',1024*1024)");
  			r.eval("unlink('test.jpg')");
  			retImg = r.eval("r").asBytes();
  		} catch(Exception e) {
  			System.out.println(e);	
  			e.printStackTrace();
  		} finally {
  			r.close();
  		}
  		return retImg; 
  	}
  	public byte[] returnRImg2() {
  		RConnection r = null;
  		byte retImg [] = null;
  		try {
  			r = new RConnection();		
  			r.eval("library(DBI)");
  			r.eval("library(rJava)"); 
  			r.eval("setwd('c:/Rstudy')");
  			r.eval("result <- read.table('product_click.log')");
  			r.eval("names(result) <- c('CLICK_TIME', 'PID')");
  			r.eval("data_p <- table(result$PID)");
  			r.eval("data_t <- table(substr(result$CLICK_TIME,9,10)) ");
  			r.eval("jpeg('test.jpg')");
  			r.eval("par(mfrow=c(1,2))");
  			r.eval("pie(data_p, radius = 1, col=rainbow(10))");
  			r.eval("barplot(data_t, col=terrain.colors(10))");
  			r.eval("dev.off()");
  			r.eval("r=readBin('test.jpg','raw',1020*1020)");
  			r.eval("unlink('test.jpg')");
  			retImg = r.eval("r").asBytes();
  		} catch(Exception e) {
  			System.out.println(e);	
  			e.printStackTrace();
  		} finally {
  			r.close();
  		}
  		return retImg; 
  	}
  	
  	public byte[] returnRImg3() {
  		RConnection r = null;
  		byte retImg [] = null;
  		try {
  			r = new RConnection();	
  			r.eval("jpeg('test.jpg')");
  			r.eval("library(rJava)");
  			r.eval("library(KoNLP)");
  			r.eval("library(XML)");
  			r.eval("library(rvest)");			
  			r.eval("imsi <- read_html('http://hankookilbo.com')");
  			r.eval("t <- htmlParse(imsi)");
  			r.eval("content<- xpathSApply(t,\"//p[@class='title']\", xmlValue)");
  			r.eval("content <- gsub('[[:punct:][:cntrl:]]', '', content)");
  			r.eval("content <- trimws(content)");
  			r.eval("useSejongDic()");
  			r.eval("word <- sapply(content,extractNoun,USE.NAMES=F)");
  			r.eval("cdata <- unlist(word)");
  			/*r.eval("cdata <- str_replace_all(cdata,'[^[가-힣]]','');"+
  					  "cdata <- str_replace_all(cdata,'한국일보닷컴','');"+
  					  "cdata <- str_replace_all(cdata,'한국일보','');"+
  					  "cdata <- str_replace_all(cdata,'보기','')");*/
  			r.eval("cdata <- Filter(function(x) {nchar(x) >= 2} ,cdata)");
  			r.eval("wordcount <- table(cdata)");
  			r.eval("wordcount <- head(sort(wordcount, decreasing=T),20)");
  			r.eval("wordcloud(names(wordcount),freq=wordcount,scale=c(5,1),"+
  					  "rot.per=0.35,min.freq=2,random.order=F,random.color=T,colors=rainbow(20))");
  			r.eval("dev.off()");
  			r.eval("r=readBin('test.jpg','raw',1020*1020)");
  			r.eval("unlink('test.jpg')");
  			retImg = r.eval("r").asBytes();			
  		} catch(Exception e) {
  			System.out.println(e);
  			e.printStackTrace();
  		} finally {
  			r.close();			
  		}
  		return retImg;
  	}	
  }
  ```

## VIEW(결과값을 화면에 출력하는 단순한 기능 -> 개인 커스터마이징)

- rdbview.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
  
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  </head>
  <body>
  <h1>R에서 Oracle 을 연동하여 처리한 결과</h1>
  <hr>
  ${ result }
  </body>
  </html>
  ```

- rgraph.jsp

  ```jsp
  <%@page import="java.util.Base64"%>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  </head>
  <body>
  <h1>R 시각화 결과 표현하기</h1>
  <hr>
  <%
  if(request.getAttribute("img_content") != null) {		
  	byte src[] = (byte[])request.getAttribute("img_content");
  %>
  	<img src="
  	   data:image/jpg;base64, <%= Base64.getEncoder().encodeToString(src) %>"
  	   width="500" height="400">
  <%
  } 
  %>	
  </body>
  </html>
  ```