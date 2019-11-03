# Desktop Direct Icon Create Method

- 데스크탑에 바로가기 아이콘 만들기

  ```bash
  $ sudo vi /usr/share/applications/[실행파일명].desktop
  ```

- 개인 환경에 맞춰 내용 수정

  ```vi
  [Desktop Entry]
  Name=Eclipse
  Type=Application
  Icon=/usr/local/eclipse/icon.xpm
  Exec=/usr/local/eclipse/eclipse
  Comment=Integrated Development Environment
  NoDisplay=false
  Terminal=false
  Categories=Development; IDE;
  ```

- 바로가기 아이콘에 권한 부여

  ```bash
  $ sudo chmod 755 /usr/share/applications/[실행파일명].desktop
  ```

- 아이콘 속성에서 [ Permissions ] - [ Execute ] 체크

