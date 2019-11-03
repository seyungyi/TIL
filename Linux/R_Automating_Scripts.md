# [ R_Automating_Scripts ]

- R 소스 파일을 리눅스가 자동화하여 실행할 수 있도록 하는 방법

- Rscript 파일 생성과 권한 부여

  1. Locate the Rscript command on your EC2 instance:

  ```bash
  $ which Rscript
  /usr/bin/Rscript
  ```

  2. Prepend the result with “#!”, and add it to the *first* line of your R script

  ```bash
  $ #!/usr/bin/Rscript
  ```

  3. In Terminal, navigate to the location of your R script:

  ```bash
  $ cd ~/my_R_scripts
  ```

  4. Make the R script executable:

  ```bash
  $ chmod u+x my_script.R
  ```

  5. Test executing the R Script:

  ```bash
  $ ./my_script.R
  ```

- Script를 자동화하기 위한 crontab 설정

  1. Open the crontab file in the terminal editor

  ```bash
  $ crontab -e
  ```

  2. Add a cron job for your script to the cron file. An example to run a script every 10 minutes is below, but if you’re new to cron job syntax, read the following [tutorial.](http://www.adminschoice.com/crontab-quick-reference)

  ```bash
  $ */10 * * * * ~/my_R_scripts/my_script.R
  ```