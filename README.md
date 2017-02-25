# spring-sandbox

spring-sandbox 仅供学习及验证特性使用

* gradle
* docker
* spring-boot
* mysql + jpa
* retrofit2
* rabbitmq

### 快速运行

```bash
10:04:22 › cd YOUR_PATH/spring-sandbox
10:04:22 › docker-compose up
```

### 本地开发

为了方便容器内部网络链接使用 `docker-compose.yml` `--link`，在 `spring-sandbox/src/main/resources/application-dev.yml` 文件中增加了 alias 指向 MQ MYSQL 的连接。

所以本地开发时，需要在本地解析 alias 指向，可在 `/etc/hosts` 增加如下配置项：

```bash
# for spring-sandbox
127.0.0.1       mysql_server
127.0.0.1       mq_server
```


