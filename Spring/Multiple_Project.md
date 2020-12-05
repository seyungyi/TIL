# [ Multiple Project Structure ]

## Index

- Spring의 프로젝트 구조를 Root 하위에 여러 프로젝트가 존재하는 형태로 구성하는 방법을 작성하였다.

## 개발환경

- Spring Boot 2.2.6 : 각 버전별로 설정 시 약간의 차이가 있을 수 있으므로 주의해야함
- Gradle
- JDK 1.8
- Intellij

##  프로젝트 만들기

### 1. Create Root Project

- [ New Project ] > [ Gradle ] > [ Additional Libraries and Frameworks] > Java 선택 > Next
- GroupId, ArtifactId 입력 > Next
- Use auto-import 체크 확인 > Next > Finish

### 2. Create Sub Project

- [ File ] > [ New ] > [ Module ]
- [ Gradle ] > [ Additional Libraries and Frameworks ] > Java 선택 > Next
- Group, Version Inherit 체크 확인
- ArtifactId 입력 > Next
- Content Root 경로 확인 > Finish
  - **Sub Project 생성 위치** : Root Project 바로 아래에 모듈이 생성되어야함

### 3. Project 기본 구조 맞추기

- Root Project 하위에 src 폴더 생성되었을 경우 삭제하기
- Build는 항상 Root Project를 기준으로 실행하기 때문에 Sub Project의 gradle 폴더, Gradlew, gradlew.bat, settings.gradle 등의 파일은 필요 없다 (== src 폴더와 build.gradle만 존재하도록 한다)
  - Sub Project를 Gradle project로 생성하였을 경우, build.gradle만 존재한다. 만약, Spring Initializer로 생성하였다면 gradle 폴더, gradlew 등이 존재한다.

### 4. Root Project와 Sub Project의 관계 설정

- Root Project의 settings.gradle 안에 sub project name을 include 한다.

- Root Project가 하위 프로젝트들을 관리하겠다는 의미

  ````java
  rootProject.name = 'multiple-module'
  include 'module-common'
  include 'module-api'
  include 'module-web' 
  ````

### 5. Root Project의 build.gradle 수정

````java
buildscript {
    ext {
        springBootVersion = '2.2.6.RELEASE'
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath "io.spring.gradle:dependency-management-plugin:1.0.6.RELEASE"
    }
}

allprojects {
    group 'org.example'
    version '1.0-SNAPSHOT'
}

subprojects {
    apply plugin: 'java'
    apply plugin: 'org.springframework.boot'
    apply plugin: 'io.spring.dependency-management'

    sourceCompatibility = 1.8

    repositories {
        mavenCentral()
    }
    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-actuator'
        compileOnly 'org.springframework.boot:spring-boot-devtools'
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
        testImplementation('org.springframework.boot:spring-boot-starter-test') {
            exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
        }
    }
    test {
        useJUnitPlatform()
    }
}

project(':spring-boot-websocket') {
    dependencies {
        compile project(':spring-boot-common')
    }
}
````

### 6. 각 Sub Project의 build.gradle 수정

- 각 프로젝트별 필요한 dependencies만 설정하면 된다.

  ````java
  bootJar {
      enabled = false
  }
  jar {
      enabled = true
  }
  dependencies {
      compile('org.springframework.boot:spring-boot-starter-web')
  }
  ````

## 다른 프로젝트에서 다른 프로젝트의 Class나, Repository를 사용하려면?

- 어노테이션을 이용하여 간단하게 다른 프로젝트의 클래스 등을 이용할 수 있다.

  ````java
  // 다른 프로젝트의 Class를 사용하는 경우
  @EntityScan("com.example.*")
  
  // 다른 프로젝트의 Repository를 사용하는 경우
  @EnableJpaRepositories("com.example.*")
  ````