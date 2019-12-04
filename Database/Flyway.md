# [ Flyway ]

## Flyway란?

- 데이터베이스 형상관리 툴을 말한다

## 사용 이유

- 로컬에서 변경한 DB의 스키마나 데이터를 운영 DB에 반영하는 것을 누락하는 것을 막기 위해 사용한다
- 개발 DB와 운영 DB의 스키마를 비교하거나 운영 DB에 수작업을 가하는 노가다의 위험성을 줄이기 위해 사용
- 마이그레이션 : 생성한 형상을 새로운 DB에 적용하는 것

## 동작 방식

- Flyway가 연결된 데이터베이스에 자동으로 SCHEMA_VERSION이라는 메타데이터 테이블을 생성
- 사용자가 정의한 sql의 파일명을 자동으로 스캔하여, SCHEMA_VERSION에 버전 정보를 남기는 동시에 데이터 베이스에 변경내용을 적용

## 명령어의 종류

- `init` : SCHEMA_VERSION을 baseline과 함께 생성. 테이블이 이미 생성되어 있으면 수행되지 않음
- `migrate` : 스키마정보를 리얼DB에 마이그레이션함
- `clean` : Flyway로 생성한 스키마를 모두 삭제한다고 하지만, 해당 데이터베이스의 모든 테이블을 삭제함
- `info` : DB에 적용된 스키마 정보와 로컬의 변경 정보를 보여줌
- `validate` : DB에 적용된 스키마 정보와 로컬의 변경 정보를 비교하여 보여줌
- `repair` : 마이그레이션 실패한 내역을 수정함(삭제, 교체)
- `baseline` : Flyway로 형상버전관리를 시작 할 baseline을 설정함

## 설정

- 파일명의 규칙 : V와 숫자로 버전명을 지정, 언더바 두개로 시작되어야 한다

  > V2__Add_new_table.sql

## Tool 실행 방법

1. 설치

   - Command-line tool 다운로드

     > Download = https://flywaydb.org/download/

   - flyway 설치 폴더로 이동

2. 설정

   ```bash
   flyway.url=jdbc:mysql://localhost:3306/테이블명
   flyway.user=아이디
   flyway.password=비번
   ```

3. 마이그레이션 sql문 생성

   - sql 폴더(생성)에 파일 생성
   - init을 이용해 SCHEMA_VERSION 테이블을 생성시 V1으로 생성됨

   ```mysql
   # V1__Create_person_table.sql
   create table PERSON (
       ID int not null,
       NAME varchar(100) not null
   );
   ```

4. Migrate Execute

   ```visual basic
   flyway-6.1.0> flyway migrate
   Database: jdbc:h2:file:./foobardb (H2 1.4)
   Successfully validated 1 migration (execution time 00:00.008s)
   Creating Schema History table: "PUBLIC"."flyway_schema_history"
   Current version of schema "PUBLIC": << Empty Schema >>
   Migrating schema "PUBLIC" to version 1 - Create person table
   Successfully applied 1 migration to schema "PUBLIC" (execution time 00:00.033s)
   ```

5. 마이그레이션 sql문 추가 생성

   ```mysql
   # V2__Add_people.sql
   insert into PERSON (ID, NAME) values (1, 'Axel');
   insert into PERSON (ID, NAME) values (2, 'Mr. Foo');
   insert into PERSON (ID, NAME) values (3, 'Ms. Bar');
   ```

6. Migtate Execute

   ```visual basic
   flyway-6.1.0> flyway migrate
   Database: jdbc:h2:file:./foobardb (H2 1.4)
   Successfully validated 2 migrations (execution time 00:00.018s)
   Current version of schema "PUBLIC": 1
   Migrating schema "PUBLIC" to version 2 - Add people
   Successfully applied 1 migration to schema "PUBLIC" (execution time 00:00.016s)
   ```