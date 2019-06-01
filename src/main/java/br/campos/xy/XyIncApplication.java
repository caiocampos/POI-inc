package br.campos.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;

/**
 * Classe principal da aplicação
 *
 * @author Caio
 */
@Controller
@SpringBootApplication
@EnableMongoRepositories(basePackages = "br.campos.xy.repository")
public class XyIncApplication {

	/**
	 * Inicia a aplicação
	 *
	 * @param args Argumentos passados na inicialização
	 */
	public static void main(String[] args) {
		SpringApplication.run(XyIncApplication.class, args);
	}

}
