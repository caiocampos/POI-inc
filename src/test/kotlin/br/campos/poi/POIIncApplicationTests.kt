package br.campos.poi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * Teste de inicialização
 *
 * @author Caio
 */
@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [POIIncApplication::class])
class POIIncApplicationTests {

	@Test
	fun contextLoads() {
	}
}
