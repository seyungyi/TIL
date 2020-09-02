# [ Proxy Pattern ]

## 정의

- 프록시 클래스가 Wrapper의 역할을 함으로써, 클라이언트는 프록시 클래스를 통해 간접적으로 주체 클래스를 사용하는 방식

- 주체 클래스는 민감 정보 또는 인스턴스화하기에 자원 집약적(=heavy한) 일 수 있기에 해당 객체가 실제로 필요할 경우에만 사용할 수 있음

- 프록시는 메서드 수행시 주체 클래스에게 요청을 위임하기 위해 동일한 인터페이스를 구현함으로써 다형성(=polymorphism)을 가짐
  - 즉, 클라이언트에서는 프록시와 주체 클래스의 인터페이스 타입으로 접근하여 사용할 수 있게 된다

> 다형성 : 여러 가지 형태를 가질수 있는 능력으로, 하나의 타입으로 여러 종류의 객체를 여러가지 모습으로 해석될 수 있는 특성



## 구조도

![image-20200902233412706](/Users/ysgo/Library/Application Support/typora-user-images/image-20200902233412706.png)

- 프록시 클래스는 주체 클래스를 감싸면서 클라이언트의 요청을 주체 클래스에게 위임하거나 리다이렉트한다.
- 프록시 클래스는 주체 클래스의 경량화 버전으로 사용되기 때문에 항상 모든 요청을 위임하는 것은 아니고, 보다 실질적인(or 독립적인) 요청들을 주체 클래스에 위임하는 것이다.



## 사용 방법

1. Virtual Proxy

   - 주체 클래스가 리소스 집약적인 경우에 사용됨

   - 프록시 클래스에서 가벼운 작업들을 선처리하고, 리소스가 많이 요구되는 작업들에 대해서만 주체 클래스를 사용하도록 구현(ex: 이미지 처리)

2. Protection Proxy

   - 주체 클래스에 대한 접근을 제어할 경우에 사용됨

   - 프록시 클래스에서 주체 클래스에 대한 접근을 허용할지에 대하여 결정하도록 할 수 있음

   - 접근 권한에 따라서 주체 클래스의 메소드를 호출하도록 구현할 수 있음

3. Remote Proxy

   - 프록시 클래스는 Local에 두고, 주체 클레스는 Remote 형태로 존재하는 경우에 사용됨

   - 대표적으로 Google Docs 가 있음
     - 브라우저는 브라우저대로 필요한 자원을 Local에 가지며, 또다른 일부 자원은 Google 서버에 있는 형태



## 사용 예제

1. 클라이언트가 시스템과 상호작용할 인터페이스 정의

   ```java
   public interface Subject {
     String runDiscuss();
   }
   ```

2. 주체 클래스 구현 : 실질적으로 처리하는 메서드를 가지는 클래스

   ```java
   public class RealSubject implements Subject {
     @Override
     public String runDiscuss() {
       return "프록시 패턴에 대하여 토론을 시작해봅시다.";
     }
   }
   ```

3. 프록시 클래스 구현 : 주체 클래스를 우회하여 접근 가능

   ```java
   public class Proxy implements Subject {
     Subject subject;
     
     @Override
     public String runDiscuss() {
       System.out.println("반환 결과를 그대로 전달함. 호출에 대한 흐름 제어가 주목적이다.");
       subject = new RealSubject();
       return subject.runDiscuss();
     }
   }
   ```

4. 클라이언트가 Proxy Class를 통한 요청

   ```java
   public class Main {
     public static void main(String[] args) {
       // 주체 클래스인 RealSubject 대신 Proxy Class를 호출함
       Subject proxy = new Proxy();
       System.out.println(proxy.runDiscuss());
     }
   }
   ```

   ```java
   // 출력
   반환 결과를 그대로 전달함. 호출에 대한 흐름 제어가 주목적이다.
   프록시 패턴에 대하여 토론을 시작해봅시다.
   ```