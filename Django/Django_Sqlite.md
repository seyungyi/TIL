# [ Django Sqlite Setting ]

## Setup

### 1. Window

1. [SQLite_Home`_Page](https://www.sqlite.org/index.html) - Download Page 접속

2. [ **Precompiled Binaries for Windows** ] 항목에서 .zip 설치

   ```bash
   # window version에 따라 선택
   sqlite-dll-win32-x86-3300100.zip
   sqlite-dll-win64-x64-3300100.zip
   
   # 필수적으로 설치
   sqlite-tools-win32-x86-3300100.zip
   ```

3. 폴더 하나에 압축 푼 파일 전부 세팅

   - C드라이브에 폴더 생성(sqlite)
   - sqlite 안에 압축 파일 전부 복사

4. 환경 변수 등록

   - Path의 마지막에 경로 등록 : `C:\sqlite\ `
   - VSCode 재실행

5. python 가상환경에서 sqlite3 실행

   ```bash
   (venv) $ sqlite3 db.sqlite3
   ...
   >> 
   ```

   
