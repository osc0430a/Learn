# admin 포탈 대시보드 에러 이슈

## 발생 이슈

PaaS-TA Portal 배포시 admin 포탈 접속시 에러 메세지가 출력되며 대시보드 화면이 정상적으로 출력되지 않는 문제가 발생했다.

![그림1](img\admin-portal-err.png)

portal-web-admin VM 에 접속하여 로그를 확인하면 아래와 같은 에러 로그를 확인할 수 있다.

```
Caused by: org.springframework.jdbc.CannotGetJdbcConnectionException: Could not get JDBC Connection; nested excep
tion is java.sql.SQLNonTransientConnectionException: Could not connect to address=(host=10.200.14.135)(port=13306
)(type=master) : Socket fail to connect to host:10.200.14.135, port:13306. Connection refused (Connection refused
)
        at org.springframework.jdbc.datasource.DataSourceUtils.getConnection(DataSourceUtils.java:80) ~[spring-jd
bc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]
        at org.springframework.jdbc.support.JdbcUtils.extractDatabaseMetaData(JdbcUtils.java:326) ~[spring-jdbc-4
.3.13.RELEASE.jar!/:4.3.13.RELEASE]
        ... 41 common frames omitted
Caused by: java.sql.SQLNonTransientConnectionException: Could not connect to address=(host=10.200.14.135)(port=13
306)(type=master) : Socket fail to connect to host:10.200.14.135, port:13306. Connection refused (Connection refu
sed)
        at org.mariadb.jdbc.internal.util.exceptions.ExceptionFactory.createException(ExceptionFactory.java:73) ~
[mariadb-java-client-2.7.2.jar!/:na]
        at org.mariadb.jdbc.internal.util.exceptions.ExceptionFactory.create(ExceptionFactory.java:192) ~[mariadb
-java-client-2.7.2.jar!/:na]
        at org.mariadb.jdbc.internal.protocol.AbstractConnectProtocol.connectWithoutProxy(AbstractConnectProtocol
.java:1392) ~[mariadb-java-client-2.7.2.jar!/:na]
        at org.mariadb.jdbc.internal.util.Utils.retrieveProxy(Utils.java:635) ~[mariadb-java-client-2.7.2.jar!/:n
a]
        at org.mariadb.jdbc.MariaDbConnection.newConnection(MariaDbConnection.java:150) ~[mariadb-java-client-2.7
.2.jar!/:na]
        at org.mariadb.jdbc.Driver.connect(Driver.java:89) ~[mariadb-java-client-2.7.2.jar!/:na]
        at java.sql.DriverManager.getConnection(DriverManager.java:664) ~[na:1.8.0_121]
        at java.sql.DriverManager.getConnection(DriverManager.java:208) ~[na:1.8.0_121]
        at org.springframework.jdbc.datasource.DriverManagerDataSource.getConnectionFromDriverManager(DriverManag
erDataSource.java:153) ~[spring-jdbc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]
        at org.springframework.jdbc.datasource.DriverManagerDataSource.getConnectionFromDriver(DriverManagerDataS
ource.java:144) ~[spring-jdbc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]
        at org.springframework.jdbc.datasource.AbstractDriverBasedDataSource.getConnectionFromDriver(AbstractDriv
erBasedDataSource.java:196) ~[spring-jdbc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]
        at org.springframework.jdbc.datasource.AbstractDriverBasedDataSource.getConnection(AbstractDriverBasedDat
aSource.java:159) ~[spring-jdbc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]
        at org.springframework.jdbc.datasource.DataSourceUtils.doGetConnection(DataSourceUtils.java:111) ~[spring
-jdbc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]
        at org.springframework.jdbc.datasource.DataSourceUtils.getConnection(DataSourceUtils.java:77) ~[spring-jd
bc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]
        ... 42 common frames omitted
Caused by: java.sql.SQLNonTransientConnectionException: Socket fail to connect to host:10.200.14.135, port:13306.
 Connection refused (Connection refused)
```

## 원인

PaaS-TA Portal 배포시 common_vars.yml 의 **paasta_database_ips** 의 수정이 정상적으로 진행되지 않아 Portal 에서 PaaS-TA database 에 정상적으로 접근하지 못해 발생한 문제다.

## 해결 방법

### 1. paasta_database_ips 을 올바르게 수정 한 뒤 Portal 을 재 배포한다.
common_vars.yml 내의 해당 설정을 정상적으로 복원한 뒤 Portal 을 재배포 하자 **paasta_database_ips** 의 경우 아래의 명령으로 확인이 가능하다.

```
$ bosh -e {BOSH director alias} -d paasta vms | grep database
```