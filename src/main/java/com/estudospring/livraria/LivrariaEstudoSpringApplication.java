package com.estudospring.livraria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class LivrariaEstudoSpringApplication implements CommandLineRunner, WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS");
		WebMvcConfigurer.super.addCorsMappings(registry);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LivrariaEstudoSpringApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}
}