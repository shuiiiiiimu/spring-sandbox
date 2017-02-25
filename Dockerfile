FROM frekele/gradle:3.3-jdk8
MAINTAINER shuimu <shuimu625@gmail.com>

ADD build.gradle /app/
WORKDIR /app

ADD . /app
RUN gradle build -Pspeed=true -x test --parallel \
 && touch ./build/libs/spring-sandbox.jar

EXPOSE 8080

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./build/libs/spring-sandbox.jar"]
