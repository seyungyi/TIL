# Desktop Direct Icon Create Method

- 데스크탑에 바로가기 아이콘 만들기

  ```bash
  $ sudo vi /usr/share/applications/[실행파일명].desktop
  ```

- 개인 환경에 맞춰 내용 수정

  ```visual basic
  [Desktop Entry]
  Name=[바로가기 아이콘 이름]
  Type=Application
  Icon=[아이콘 이미지 URL]
  Exec=[실행 파일 URL] # 실행파일 경로와 실행파일명을 정확히 일치시켜야 정상적으로 생성된다
  Comment=[바로가기 아이콘 설명글]
  NoDisplay=false
  Terminal=false
  Categories=Development; IDE;
  ```

- 바로가기 아이콘에 권한 부여

  ```bash
  $ sudo chmod 755 /usr/share/applications/[실행파일명].desktop
  ```

- 아이콘 속성에서 [ Permissions ] - [ Execute ] 체크

