package com.screenmatch.projeto.ProjetoSpring;

import com.screenmatch.projeto.ProjetoSpring.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.util.ArrayList;
//import java.util.List;

@SpringBootApplication
public class ProjetoSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringApplication.class, args);


	}

	public void run(String... args){
		System.out.println("Projeto Spring Boot Application");
		Principal principal = new Principal();
		principal.exiberMenu();
	}

}
