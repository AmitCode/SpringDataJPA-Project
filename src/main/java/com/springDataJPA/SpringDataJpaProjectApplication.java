package com.springDataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaProjectApplication {

	public static void main(String[] args) {
		//System.out.println("SpringApplication.run class : 7567");
		Class object = SpringApplication.run(SpringDataJpaProjectApplication.class, args).getClass();
		//System.out.println("SpringApplication.run class : " +object.getName());
	}

}
