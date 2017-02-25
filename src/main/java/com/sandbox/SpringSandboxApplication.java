package com.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class SpringSandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSandboxApplication.class, args);
	}

	// 把 404 500 502 错误重定向 ErrorController 处理
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container -> {
			ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
			ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
			ErrorPage error502 = new ErrorPage(HttpStatus.GATEWAY_TIMEOUT, "/502");
			container.addErrorPages(error404, error500, error502);
		});
	}
}
