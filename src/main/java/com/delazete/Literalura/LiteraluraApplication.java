package com.delazete.Literalura;
import com.delazete.Literalura.interfaz.Menu;
import com.delazete.Literalura.repository.IAutorRepository;
import com.delazete.Literalura.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private ILibroRepository repotorio;

	@Autowired
	private IAutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}


	public void run(String... args) throws Exception {
		Menu menu = new Menu(repotorio, autorRepository);
		menu.muestraMenu();
	}

}
