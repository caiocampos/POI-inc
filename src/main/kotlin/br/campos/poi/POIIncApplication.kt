package br.campos.poi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Controller

/**
 * Classe principal da aplicação
 *
 * @author Caio
 */
@Controller
@SpringBootApplication
@EnableMongoRepositories(basePackages = ["br.campos.poi.repository"])
class POIIncApplication

/**
 * Inicia a aplicação
 */
fun main(args: Array<String>) {
	runApplication<POIIncApplication>(*args)
}
