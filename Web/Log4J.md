# Log4J

프로그램을 작성하는 도중에 로그를 남기기 위해 사용되는 자바 기반 로깅 유틸리티이다.

## Log Level

| 로그 레벨 | 설명                                                         |
| --------- | ------------------------------------------------------------ |
| fatal     | 아주 심각한 에러가 발생한 상태를 나타냄                      |
| error     | 요청을 처리하는 도중에 문제가 발생한 상태를 나타냄           |
| warn      | 향후 시스템 에러의 원인이 될 수 있는 경고성 메시지를 나타냄  |
| info      | 로그인, 상태변경과 같은 정보성 메시지를 나타냄               |
| debug     | 개발시 디버그 용도로 사용한 메시지를 나타냄                  |
| trace     | 디버그 레벨이 광범위한 것을 해결하기 위해 좀 더 상세한 상태를 나타냄 |

## Log4J Spring Framework에서 사용방법

1. pom.xml에 <dependency> 태그 추가

   ```xml
   <dependency>
       <groupId>org.apache.logging.log4j</groupId>
       <artifactId>log4j-api</artifactId>
       <version>2.11.1</version>
     </dependency>
     <dependency>
       <groupId>org.apache.logging.log4j</groupId>
       <artifactId>log4j-core</artifactId>
       <version>2.11.1</version>
     </dependency>
   ```

2. mybatis-config.xml 에 <settings>태그 안에 <setting>태그 추가

   ```xml
   <setting name="logImpl" value="LOG4J2"/>
   ```

3. 'Java Resources - src/main/java'에 Log4J2.xml 설정파일 추가

4. Log4J2.xml에 <Logger>태그 추가

   ```xml
   <Logger name="resource.mapper파일이름" level="DEBUG"  additivity="false">
   	<AppenderRef ref="xxxxx"  />		
   </Logger>
   ```