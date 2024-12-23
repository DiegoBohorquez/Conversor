package com.alura.cursos.conversor;

import com.alura.cursos.conversor.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConversorApplication.class, args);
	}

}
