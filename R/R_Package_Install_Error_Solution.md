# [ R_Package_Install_Error_Solution ]

## Index

- 리눅스에 R을 설치했을 경우 외부 패키지를 설치할 경우 존재하지 않거나 기타 요인에 의해 정상 설치가 되지 않는 에러 발생함
- 에러를 해결해나간 방법을 기술

## Non-exist-packages Error

-  R 패키지 설치할 때 non-exist-packages 에러가 발생하며 설치가 비정상적으로 마무리 되는 증상 발생

- packages : rJava, RSelenium, Rserve, RJDBC 등

- 해결

  - root 권한으로 접속 후 설치 권장

    ```bash
  $ sudo su
    ```
    
  - ubuntu 터미널에서 패키지 설치
  
    ```bash
    ## For dependency of devtools in R
    $ sudo apt-get install build-essential libcurl4-gnutls-dev libxml2-dev libssl-dev
    ## Preinstall some useful R Packages
    $ sudo apt-get install r-base-dev
    $ sudo apt-get build-dep r-cran-foo
    ## On Terminal install R Package
    $ R -e "install.packages('devtools', repos='http://cran.rstudio.com/')"
    
    ## Rselenium 설치
    # Before we can install the package "RSelenium" from within R
    $ sudo apt-get install r-cran-xml
    $ sudo apt-get install r-cran-RCurl
    
    # xml 설치시 의존성 문제 발생
    $ sudo add-apt-repository ppa:marutter/c2d4u3.5
    $ sudo apt update
    
    # RSelenium을 설치하기 위해서는 xml, httr, RCurl 패키지가 필요하다는 것을 알았음
    $ R
    >> install.packages("RSelenium")
    >> library(RSelenium)
    >> checkForServer()
    
    ## rJava 설치
    # 우분투에 jdk가 필수적으로 설치되어있어야함 -> java -version 으로 확인
    $ sudo apt-get install r-cran-rjava
    > install.packages("rJava") <- R에 접속하여 실행
    
    # rJava 설치시 여전히 non-exist-package 발생시 실행 -> 반드시 root 권한에서
    $ sudo R CMD javareconf
    
    ## curl 설치
    $ sudo apt-get install libcurl4-openssl-dev
    (참고 : https://stackoverflow.com/questions/42115972/r-rstudio-configuration-failed-because-libcurl-was-not-found)
    $ sudo apt install r-cran-curl
    
    ## RSQLite 설치
    $ sudo apt-get install r-cran-rsqlite
    > install.packages("RSQLite", dependencies=TRUE, INSTALL_opts = c('--no-lock'))
    (참고 : https://stackoverflow.com/questions/14382209/r-install-packages-returns-failed-to-create-lock-directory)
    
    ## Rcpp 설치
    # library가 lock 걸리는 에러만 발생했기에 바로 설치 가능
    > install.packages("Rcpp", dependencies=TRUE, INSTALL_opts = c('--no-lock'))
    
    ## KoNLP 설치
    # 의존되는 패키지를 자동으로 설치해주는 윈도우와 달리 리눅스는 권한문제 때문에 선행 패키지 수동 설치
    # rJava, curl, RSQLite, Rcpp 패키지가 설치되어있어야함
    # 필요에 따라서 Rserve와 tm 패키지를 설치할 수 있음
    > install.packages("KoNLP")
    > library(KoNLP)
    
    ## devtools, dplyr는 KoNLP가 설치되었다면 정상 설치됨
    ```

##  During the installation of the stop occurrence

- AWS EC2 t2.micro 프리티어와 같은 너무 작은 메모리를 갖는 인스턴스를 사용할 경우 발생함
- 일정 용량 이상의 메모리 환경에서만 설치되는 패키지를 설치한다면 중간에 진행이 멈춰버리는 증상 발생
- packages : dplyr, devtools, KoNLP 등
- 해결
  - AWS EC2 t2.micro 프리티어는 무료 인스턴스인 만큼 최저의 성능만을 제공하는 환경이다
  - R 패키지의 설치는 cpu의 영향을 많이 받기에 업그레이드가 필요함(고성능 인스턴스 등으로)
  - AWS EC2 t2.micro 인스턴스를 start나 medium으로 업그레이드
    - [인스턴스 중지] 후 대기
    - [인스턴스 설정] - [인스턴스 유형 변경] 클릭
    - [t2.medium] 설정 후 적용
    - [인스턴스 상태] - [시작]
    - 재접속 후 R package 설치





