# [ JPA ]

## JPA(Java Persistence API)란?

- EJB

  - 과거의 자바 표준(Entity Bean)
  - 과거의 ORM
  - 문제점
    - 코드가 매우 지저분하다
    - API의 복잡성이 높음(interface를 많이 구현해야함)
    - 속도가 느림

- Hibernate

  - ORM 프레임워크, Open Source SW
  - 'Gavin King'과 시러스 테크놀로지 출신 동료들이 EJB2 스타일의 Entity Beans 이용을 대체할 목적으로 개발

- JPA

  - 현재 자바 진영의 ORM 기술 표준으로, 인터페이스의 모음을 말한다

    - 즉, 실제로 동작하는 것을 말하는 것이 아니다
    - JPA 인터페이스를 구현한 대표적인 오픈소스로 Hibernate가 대표적이다

  - JPA 2.1 표준 명세를 구현한 3가지 구현체

    - Hibernate
    - EclipseLink
    - DataNucleus

    ```
    [ 애플리케이션 ] --- 사용 ---> [ JPA 표준 인터페이스 ]
    											 |------ Hibernate
    											 |------ EclipseLink
    											 |------ DataNucleus
    ```

  - Version

    - JPA 1.0(JSR 220) 2006년 : 초기 버전. 복합 키와 연관관계 기능이 부족
    - JPA 2.0(JSR 317) 2009년 : 대부분의 ORM 기능을 포함, JPA Criteria 추가
    - JPA 2.1(JSR 338) 2013년 : 스토어드 프로시저 접근, 컨버터(Converter), 엔티티 그래프 기능이 추가

  - cf) Spring Framework

    - Application 프레임워크, Open Source SW
    - 'Rod Johnson'이 EJB의 여러 문제를 해결하고, 엔터프라이즈 애플리케이션 개발을 좀 더 쉽게 하기 위한 목적으로 만듬

## JPA의 동작 과정

- JPA는 애플리케이션과 JDBC 사이에서 동작한다
  - 개발자가 JPA를 사용하면, JPA 내부에서 JDBC AP를 사용하여  SQL을 호출하여 DB와 통신한다
  - 즉, 개발자가 직접 JDBC API를 쓰는 것이 아니다

### 저장 과정

- EX) MemberDAO에서 객체를 저장하고 싶을 때
  - 개발자는 JPA에 Member 객체를 넘긴다
  - JPA는
    1. Member 엔티티를 분석한다
    2. INSERT SQl을 생성한다
    3. JDBC API를 사용하여 SQL을 DB에 날린다

### 조회 과정

- EX) Member 객체를 조회하고 싶을 때
  - 개발자는 member의 pk 값을 JPA에 넘긴다
  - JPA는
    1. 엔티티의 매핑 정보를 바탕으로 적절한 SELECT SQL을 생성한다
    2. JDBC API를 사용하여 SQL을 DBdp skfflsek
    3. DB로부터 결과를 받아온다
    4. 결과(ResultSet)를 객체애 모두 매핑한다
  - 쿼리를 JPA가 만들어 주기 때문에 Object와 RDB 간의 패러다임 불일치를 해결할 수 있다

## JPA를 사용하는 이유

1. SQL 중심적인 개발에서 객체 중심으로 개발

   > 참고 주소 : [SQL 중심 개발 문제점](https://gmlwjd9405.github.io/2019/08/03/reason-why-use-jpa.html)

2. 생산성

   - JPA를 사용하는 것은 Java Collection에 데이터를 넣었다 뺴는 것처럼 사용할 수 있게 만든 것이디ㅏ
   - 간단한 CRUD
     - 저장 : jpa.persist(member)
     - 조회 : Member member = jpa.find(memberId)
     - 수정 : member.setName("변경할 이름")
     - 삭제 : jpa.remove(member)
   - 특히, 수정이 간단함
     - 객체를 변경하면 그냥 알아서 DB에 Update Query가 전송된다

3. 유지보수

   - 기존 : 필드 변경 시 모든  SQL을 수정해야 한다
   - JPA : 필드만 추가하면 되는 간편함. SQL은 JPA가 처리하기 때문에 손댈 것이 없다

4. Object와 RDB 간의 패러다임 불일치 해결

   1. JPA와 상속

      - 객체 상속 관계, Table 슈퍼타입 서브타입 관계

      - 저장
        - 개발자가 할 일
          - jpa.persist(album);
        - 나머진 JPA가 처리
          - INSERT INTO ITEM ...
          - INSERT INTO ALBUM ...
      - 조회
        - 개발자가 할 일
          - Album album = jpa.find(Album.class, albumId);
        - 나머진 JPA가 처리
          - SELECT I.*, A.* FROM ITEM I JOIN ALBUM A ON I.ITEM_ID = A.ITEM_ID

   2. JPA와 연관관계

      - 객체의 참조로 연관관계 저장 가능
        - member.setTeam(team);
        - japa.persist(member);

   3. JPA와 객체 그래프 탐색

      - 신뢰할 수 있는 엔티티, 계층

        ```java
        class MemberService { 
              ...
              public void process() { 
                  /* 직접 구현한 DAO에서 객체를 가져온 경우 */
                  Member member1 = memberDAO.find(memberId); 
                  member1.getTeam(); // 엔티티를 신뢰할 수 없음 
                  member1.getOrder().getDelivery(); 
                  /* JPA를 통해서 객체를 가져온 경우 */
                  Member member2 = jpa.find(Member.class, memberId); 
                  member2.getTeam(); // 자유로운 객체 그래프 탐색
                  member2.getOrder().getDelivery(); 
              } 
        }
        https://gmlwjd9405.github.io/2019/08/04/what-is-jpa.html
        ```

      - 내가 아닌 다른 개발자가 직접 구현한 DAO에서 가져온은 경우

        - DAO에서 직접 어떤 쿼리를 날렸는지 확인하지 않는 이상, 그래프 형태의 관련된 객체들을 모두 잘 가져왔는지 알 수 없음
        - 즉, 반환한 엔티티를 신뢰하고 사용할 수 없음

      - JPA를 통해서 가져오는 경우

        - 객체 그래프를 완전히 자유롭게 탐색할 수 있게 된다.
        - 지연 로딩 전략(Lazy Loading) 사용
          - 관련된 객체를 사용하는 그 시점에 SELECT Query를 날려서 객체를 가져오는 전략

   4. JPA와 비교하기

      - 동일한 트랜잭션에서 조회한 엔티티는 같음을 보장함

        ```java
        String memberId = "100";
        Member member1 = jpa.find(Member.class, memberId);	// DB에서 가져옴
        Member member2 = jpa.find(Member.class, memberId);	// 1차 캐시에서 가져옴
        member1 == member2;	// 같음
        ```

## JPA의 성능 최적화 기능

## 데이터 접근 추상화와 벤더 독립성

