# [ MySQL ]

## Index

- 전세계적으로 널리 사용되고 있는 오픈 소스 데이터베이스
- MySQL AB사가 개발하여 배포/판매하고 있는 데이터베이스

## Features

- 표준 데이터베이스 질의 언어 SQL(Structured Query Language)을 사용하는 개방 소스의 관계형 데이터베이스 관리 시스템(RDBMS)
- 매우 빠르고, 유연하며 사용하기 쉽다
- 다중 사용자, 다중 쓰레드를 지원
- C, C++, Eiffel, Java, Perl, PHP, Python 스크립트 등을 위한 응용프로그램 인터페이스(API) 지원
- 유닉스, 리눅스, WIndows 운영체제에서 사용 가능

## Install

```bash
$ sudo apt update
$ sudo apt install mysql-server
$ sudo mysql_secure_installation # Configuring MySQL
$ sudo mysql # password skip
```

```mysql
mysql> SELECT user, authentication_string, plugin, host FROM mysql.user;
```

```mysql
Output
+------------------+-------------------------------------------+-----------------------+-----------+
| user             | authentication_string                     | plugin                | host      |
+------------------+-------------------------------------------+-----------------------+-----------+
| root             |                                           | auth_socket           | localhost |
| mysql.session    | *THISISNOTAVALIDPASSWORDTHATCANBEUSEDHERE | mysql_native_password | localhost |
| mysql.sys        | *THISISNOTAVALIDPASSWORDTHATCANBEUSEDHERE | mysql_native_password | localhost |
| debian-sys-maint | *CC744277A401A7D25BE1CA89AFF17BF607F876FF | mysql_native_password | localhost |
+------------------+-------------------------------------------+-----------------------+-----------+
4 rows in set (0.00 sec)
```

```mysql
mysql> 
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
mysql> FLUSH PRIVILEGES;
mysql> exit
```

## Create User

```mysql
mysql> CREATE USER 'sammy'@'localhost' IDENTIFIED BY 'password';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'sammy'@'localhost' WITH GRANT OPTION;
mysql> exit;
```

### Testing MySQL

```bash
$ systemctl status mysql.service
# if mysql status stop
$ systemctl start mysql.service
# or
$ systemctl restart mysql.service
# if you want mysql stop
$ systemctl stop mysql.service
```

## Using Method

```bash
$ sudo mysqladmin -p -u root version

# mysql connect
$ sudo mysql -u [username] -p
password: [password]
```