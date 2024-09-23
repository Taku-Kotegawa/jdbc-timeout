package com.example.jdbc_timeout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcTimeoutApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JdbcTimeoutApplication.class, args);

		String[] strArr = ctx.getBeanDefinitionNames();
		for (String string : strArr) {
			System.out.println(string);
		}
	}

}
