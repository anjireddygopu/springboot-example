package com.p3.SpringExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args){
		
		SpringApplication.run(SpringExampleApplication.class, args);
		
		System.out.println("Sample Curd Application");
	}
}
