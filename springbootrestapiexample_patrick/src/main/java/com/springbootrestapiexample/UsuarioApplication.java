package com.springbootrestapiexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UsuarioApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(UsuarioApplication.class, args);
	}

}
