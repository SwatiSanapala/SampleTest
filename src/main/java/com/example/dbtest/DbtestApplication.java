package com.example.dbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//This is the SpringBoot main class, that bootstraps the project
@SpringBootApplication
public class DbtestApplication {
	@Autowired
	private Environment env;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				String urls = env.getProperty("cors.urls");
				CorsRegistration reg = registry.addMapping("/**");
				for (String url : urls.split(",")) {
					reg.allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins(url).allowedHeaders("*");
					System.out.println(url);
				}
			}
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(DbtestApplication.class, args);
	}

}

