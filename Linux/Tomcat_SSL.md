# [ Tomcat SSL Certificate ]

## Index

- Tomcat이 설치된 Web site의 기본 통신 프로토콜은 HTTP이다. 여기서 보안 인증서를 적용한 신뢰가능한 사이트로 변경하고싶다면 HTTPS 프로토콜을 사용한 접속 방식을 사용해야한다.
- HTTPS 프로토콜을 사용하기위해서는 먼저 SSL 인증서가 필요하다.
  - SSL 공식 인증서와 개발 환경에서 테스트하기 위한 OpenSSL 방식 존재

## Keystore

- SSL 인증서 적용시 사용되는 보안 인증 파일
  - 확장자는 대표적으로 JKS, PKCS12 등이 존재

### Step 1 - Create a Keystore

```bash
$ keytool -genkey -alias svr1.tecadmin.net -keyalg RSA -keystore /etc/pki/keystore
```

```bash
[Output]
Enter keystore password:
Re-enter new password:
What is your first and last name?
  [Unknown]:  Rahul Kumar
What is the name of your organizational unit?
  [Unknown]:  Web
What is the name of your organization?
  [Unknown]:  TecAdmin Inc.
What is the name of your City or Locality?
  [Unknown]:  Delhi
What is the name of your State or Province?
  [Unknown]:  Delhi
What is the two-letter country code for this unit?
  [Unknown]:  IN
Is CN=Rahul Kumar, OU=Web, O=TecAdmin Inc., L=Delhi, ST=Delhi, C=IN correct?
  [no]:  yes

Enter key password for 
        (RETURN if same as keystore password):
Re-enter new password:
```

### Step 2 - Get CA Signed SSL

- Create CSR

  ```bash
  $ keytool -certreq -keyalg RSA -alias svr1.tecadmin.net -file svr1.csr -keystore /etc/pki/keystore
  ```

- Install the root certificate

  ```bash
  $ keytool -import -alias root -keystore /etc/pki/keystore -trustcacerts -file root.crt
  ```

- Install the intermediate certificate

  ```bash
  $ keytool -import -alias intermed -keystore /etc/pki/keystore -trustcacerts -file intermediate.crt
  ```

- Install the issued ceritificate

  ```bash
  $ keytool -import -alias svr1.tecadmin.net -keystore /etc/pki/keystore -trustcacerts -file svr1.tecadmin.net.crt
  ```

### Step 3 - Setup Tomcat Keystore

- tomcat 경로의 설정 파일 수정

```xml
<!-- tomcat/conf/server.xml -->
...
<Connector port="8443" protocol="HTTP/1.1"
           connectionTimeout="20000"
           redirectPort="8443"
           SSLEnabled="true"
           scheme="https"
           secure="true"
           sslProtocol="TLS"
           keystoreFile="/etc/pki/keystore"
           keystorePass="_password_" />
...
```

### Step 4 - Restart Tomcat

- Tomcat의 설정 정보가 변경될 경우 재새작 필수

  ````bash
  $./bin/shutdown.sh
  $./bin/startup.sh
  ````

### Step 5 - Tomcat Website Access

- 기존 http로 접속하던 웹사이트를 https로 변경하여 접속한 후 톰캣 기본 페이지 출력 여부 확인