# spring-sandbox

spring-sandbox 仅供学习及验证特性使用

* gradle
* docker
* spring-boot
* mysql + jpa
* retrofit2

### 运行

**构建镜像**

```bash
cd YOUR_PATH/spring-sandbox
docker build . -t spring-sandbox
```

**MYSQL 数据库**

```bash
docker run --rm -it -P --name mysql \
	-e MYSQL_ROOT_PASSWORD=root \
	-e MYSQL_DATABASE=sandbox \
	mysql
```

**启动容器**

```bash
docker run --rm -it -p 127.0.0.1:8080:8080 --link mysql:localhost spring-sandbox
```

**访问**

```bash
11:40:56 › curl http://127.0.0.1:8080/hello
{"a":11,"b":"hello"}%

```


