package com.example.prove2022;

import com.example.prove2022.test.aop.Performance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Prove2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Prove2022Application.class, args);
	}

	@Bean
	public Performance performance(){
		return new Performance();
	}

}
