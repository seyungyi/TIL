# [ Spring Scheduling(TASK) ]

## 정의

- 스프링에서는 특정 시간에 반복적으로 처리되는 코드르 스케줄링할 수 있는 구현 방법 지원함
- 이 때 반복적으로 수행되는 코드를 Task라 함

## Task 수행 환경 설정

1. `springmvc-context.xml` 파일에 스케쥴링 기능과 관련된 태그 추가

2. `<beans>` 루트엘리먼트에 다음 태그를 추가

   ```xml
   xmlns:task="http://www.springframework.org/schema/task"
   또는
   [Namespaces] 탭을 눌러 Task를 추가하면 간편함
   ```

3. `xsi:schemaLocation` 속성의 마지막 값으로 다음 내용 추가

   ```xml
   http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-버전.xsd
   ```

4. 다음 태그 추가

   ```xml
   <task:annotation-driven/>
   ```

## Task 기능의 메서드 정의

- 설정된 주기(스케쥴링)에 맞춰 호출되는 Task 메서드 앞에 `@Scheduled`라는 애노테이션을 다음에 제시된 속성 중 하나를 정의하여 추가함

  - cron : CronTab에서의 설정과 같이 cron="10 * * * * *"과 같은 설정이 가능

  - fixedDelay : 이전에 실행된 Task의 종료시간으로 부터 정의된 시간만큼 지난 후 Task를 실행

  - fixedRate : 이전에 실행된 Task의 시작시간으로 부터 정의된 시간만큼 지난 후 Task를 실행

    | 순서 | 필드명          | 사용 가능한 값               |
    | ---- | --------------- | ---------------------------- |
    | 1    | seconds         | 0~59, - * /                  |
    | 2    | minutes         | 0~59, - * /                  |
    | 3    | hours           | 0~23, - * /                  |
    | 4    | day of month    | 1~31, - * ? / L W            |
    | 5    | month           | 1~12 or JAN-DEC , - * /      |
    | 6    | day of week     | 1-7 or SUN-SAT , - * ? / L # |
    | 7    | years(optional) | 1970~2099, - * /             |

## 특수문자의 의미

- `*` : 모든 수를 의미. seconds에서 사용하면 매초, minutes에서 사용하면 매분, hours에서 사용하면 매시간
- `?` : 해당 항목을 사용하지 않음. day of month에서 사용하면 월중 날짜를 지정하지 않음. day of week에서 사용하면 주중 요일을 지정하지 않음
- `-` : 기간을 설정 hours에서 10-12이면 10시, 11시, 12시에 동작, minutes에서 58-59분에 동작
- `,` : 특정 시간을 지정, day of week에서 2,4,6 이면 월,수,금에만 동작함
- `/` : 시작시간과 반복 간격 설정, seconds위치에 0/15로 설정하면 0초에 시작해서 15초 간격으로 동작, minutes위치에 5/10으로 설정하면 5분에 시작해 10분 간격으로 동작
- `L` : 마지막 기간에 동작, day of month, day of week에서만 사용, day of month에서 사용하면 해당월 마지막 날에 수행, day of week에서 사용하면 토요일에 수행
- `W` : 가장 가까운 평일 동작, day of month에만 사용, 15W로 설정하면 15일이 토요일이면 가장 가까운 14일 금요일에 실행, 15W로 설정하고 15일이 일요일이면 16일에 실행, 15W로 설정하고 15일이 평일이면 15일 실행
- `LW` : L과 W의 조합. 그달의 마지막 평일에 동작
- `#` : 몇 번째 주와 요일 설정, day of week에 사용, 6#3이면 3번째 주 금요일에 동작, 4#2이면 2번째 주 수요일에 동작

## 사용 예시

- 표현식 예제

  - `0 0 12 * * *` : 매일 12시에 실행
  - `0 15 10 * * *` : 매일 10시 15분에 실행
  - `0 * 14 * * *` : 매일 14시에 0분~59분까지 매분 실행
  - `0 0/5 14 * * *` : 매일 14시에 시작해서 5분 간격으로 실행
  - `0 0/5 14, 18 * * *` : 매일 14시, 18시에 시작해서 5분 간격으로 실행
  - `0 0-5 14 * * *` : 매일 14시에 0분, 1분, 2분, 3분, 4분, 5분에 실행
  - `0 0 20 ? * MON-FRI` : 월~금일 20시 0분 0초에 실행
  - `0 0/5 14 * * ?` : 아무요일, 매월, 매일, 14:00부터 14:05분까지 매분 0초 실행(6번 실행됨)
  - `0 15 10 ? * 6L` : 매월 마지막 금요일 아무날이나 10:15:00에 실행
  - `0 15 10 15 * ?` : 아무요일, 매월 15일 10:15:00에 실행
  - `* /1 * * * *` : 매 1분마다 실행
  - `* /10 * * * *` : 매 10분마다 실행

- 자바 클래스 예제

  ```java
  package service;
  
  import java.text.SimpleDateFormat;
  import java.util.Calendar;
  
  import org.springframework.scheduling.annotation.Scheduled;
  import org.springframework.stereotype.Service;
  
  @Service
  public class ScrapingScheduler {
  	@Scheduled(cron = "10 * * * * *")	// 초,분,시,일,월,요일(1:일요일)
  	// @Scheduled(fixedDelay=10000) // 10초간격으로
  	public void scheduleRun() {
  		Calendar calendar = Calendar.getInstance();
  		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  		
  		try {
  			Thread.sleep(2000);
  		} catch(Exception e) {
  			
  		}
  		System.out.println(new java.util.Date() + "스케줄 실행: " + dateFormat.format(calendar.getTime()));
  	}
  }
  ```