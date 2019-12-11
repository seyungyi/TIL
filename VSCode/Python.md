# [ Python Development Environment In VSCode ]

## Table of Contents

- [Install](#install)
- [Settings](#settings)

## Install

### Window(10 기준)

- Python 설치(Add Path 등록 필수로 해야 다른 설정작업 필요없음)

  > https://www.python.org/downloads/

- VSCode 설치

  > https://code.visualstudio.com/

- VSCode Python 확장프로그램 설치

  - Korean Language Pack
  - Python
  - Beautify(선택)



### Linux(Ubuntu 기준)

- Python 설치

  - 리눅스의 경우 기본적으로 깔려있음. 버전 확인 후 최신 버전 설치

    ```bash
    (python 2.7인 경우)
    $ python --version
    $ sudo apt-get update
    $ sudo apt-get install python2.7
    $ sudo apt-get install python-pip python-dev python-setuptools
    $ python --version
    python 2.7.xx
    $ python
    >> python 실행 커맨드
    
    (python 3인 경우)
    $ sudo apt-get install python3-pip python3-dev
    $ python3
    >> python3 실행 커맨드
    ```

- VSCode 설치

  ```bash
  # curl을 설치해줍니다. 이미 설치되어 있다고 메시지가 보일 수도 있음
  $ sudo apt-get install curl
  # 마이크로소프트 GPG 키를 다운로드하여 /etc/apt/trusted.gpg.d/ 경로에 복사
  $ sudo sh -c 'curl https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > /etc/apt/trusted.gpg.d/microsoft.gpg'
  # Visual Studio Code를 다운로드 받기 위한 저장소를 추가
  $ sudo sh -c 'echo "deb [arch=amd64] https://packages.microsoft.com/repos/vscode stable main" > /etc/apt/sources.list.d/vscode.list'
  # 추가한 저장소로부터 패키지 목록을 가져옴
  $ sudo apt-get update
  # vscode 설치
  $ sudo apt-get install code
  # vscode 실행
  $ code
  # 실행시 git이 없다는 에러 발생시 아래 명령 수행
  $ sudo apt-get install git
  ```

- VSCode 확장프로그램 설치 - Window와 동일



## Settings

- Virtual Environment

  ```bash
  # 파이썬 가상환경 생성
  $ python -m venv [가상폴더명]
  
  # window일 때
  방법 1 : $ source .venv/Scripts/activate
  방법 2 : $ .venv/Scripts/activate
  방법 3 : $ . .venv/Scripts/activate
  # linux일 때(bin폴더로 가야하는 것이 차이)
  $ source .venv/bin/activate
  
  # 보안오류(:)[], PSSecurityException 발생시
  방법 1 : Set-ExecutionPolicy Unrestricted-Scope CurrentUser
  방법 2 : Set-ExecutionPolicy Unrestricted -Force
  
  # vscode 빌드 설정하기
  [Ctrl] + [shift] + [p] -> python 검색 -> Python:Select Interperter 선택 -> .venv 있는 것 선택 --> 완료!
  !!! 한개 가상환경을 [activate] 명령어로 실행 후, 다른 프로젝트 진행시 기존 가상환경은 [deactivate] 명령어로 기존 환경 종료 후 새로 실행해야함
  ```

- configurate *.json

  - settings.json

    ```json
    {   
        // venv environment path settings
        // [window일 때]
        "python.pythonPath": "venv\\Scripts\\python.exe",
        // pylint environment path settings
        "python.linting.pylintPath": "venv\\Scripts\\python.exe"
        // [linux일 때]
        "python.pythonPath": "venv/bin/python.exe",
        "python.linting.pylintPath": "venv/bin/python.exe"
    }
    /// 중요 : 설치된 python의 버전과 실행되는 버전에 따라 실행하는 .exe파일이 달라짐
    /// python, python3 등 [Ctrl] + [Space]로 환경에 맞춰 수정
    ```

  - tasks.json

    - [Ctrl]+[Shift]+[B]
    - [No build task to rn found.Configure Build Task...]
    - [Create tasks.json file from template]
    - [Others]

    ```json
    {
        "version": "2.0.0",
        "tasks": [
            {
                "label": "python execute",
                "type": "shell",
                "command": "python",
                "args": [
                    "${file}"
                ],
                "group":{
                    "kind": "build",
                    "isDefault": true
                },
                "presentation": {
                    "echo": true,
                    "reveal": "always",
                    "focus": false,
                    "panel": "shared",
                    "showReuseMessage": true,
                    "clear": true
                }
            }
        ]
    }
    ```

- .gitignore

  ```
  ### VSCode ###
  .vscode/ ---> vscode 설정폴더
  
  ### Add Python Settings ###
  venv/ ---> 가상환경 폴더
  *.env ---> 추후 공개하면 안될 키값들 관리하는 파일
  *.exe ---> 실행파일들
  
  # Created by https://www.gitignore.io/api/python
  # Edit at https://www.gitignore.io/?templates=python
  
  ### Python ###
  # Byte-compiled / optimized / DLL files
  __pycache__/
  *.py[cod]
  *$py.class
  
  # C extensions
  *.so
  
  # Distribution / packaging
  .Python
  build/
  develop-eggs/
  dist/
  downloads/
  eggs/
  .eggs/
  lib/
  lib64/
  parts/
  sdist/
  var/
  wheels/
  pip-wheel-metadata/
  share/python-wheels/
  *.egg-info/
  .installed.cfg
  *.egg
  MANIFEST
  
  # PyInstaller
  #  Usually these files are written by a python script from a template
  #  before PyInstaller builds the exe, so as to inject date/other infos into it.
  *.manifest
  *.spec
  
  # Installer logs
  pip-log.txt
  pip-delete-this-directory.txt
  
  # Unit test / coverage reports
  htmlcov/
  .tox/
  .nox/
  .coverage
  .coverage.*
  .cache
  nosetests.xml
  coverage.xml
  *.cover
  .hypothesis/
  .pytest_cache/
  
  # Translations
  *.mo
  *.pot
  
  # Scrapy stuff:
  .scrapy
  
  # Sphinx documentation
  docs/_build/
  
  # PyBuilder
  target/
  
  # pyenv
  .python-version
  
  # pipenv
  #   According to pypa/pipenv#598, it is recommended to include Pipfile.lock in version control.
  #   However, in case of collaboration, if having platform-specific dependencies or dependencies
  #   having no cross-platform support, pipenv may install dependencies that don't work, or not
  #   install all needed dependencies.
  #Pipfile.lock
  
  # celery beat schedule file
  celerybeat-schedule
  
  # SageMath parsed files
  *.sage.py
  
  # Spyder project settings
  .spyderproject
  .spyproject
  
  # Rope project settings
  .ropeproject
  
  # Mr Developer
  .mr.developer.cfg
  .project
  .pydevproject
  
  # mkdocs documentation
  /site
  
  # mypy
  .mypy_cache/
  .dmypy.json
  dmypy.json
  
  # Pyre type checker
  .pyre/
  
  # End of https://www.gitignore.io/api/python
  ```







