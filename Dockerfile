FROM frekele/gradle:3.3-jdk8
MAINTAINER shuimu <shuimu625@gmail.com>

ADD ./build/libs/spring-sandbox.jar /app/
WORKDIR /app

ADD . /app

EXPOSE 8080

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./spring-sandbox.jar"]
