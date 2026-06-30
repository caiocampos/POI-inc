package br.campos.poi

import br.campos.poi.model.transfer.POIDTO
import br.campos.poi.service.abst.IPOIService
import br.campos.poi.util.POIException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * Testes para o componente IPOIService e POIService
 *
 * @author Caio
 */
@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [POIIncApplication::class])
class POIServiceTests {

	@Autowired
	lateinit var poiService: IPOIService

	private val mOne = -1.0
	private val dValue = 1435674.003

	// Testes em create
	@Test
	fun create() {
		assertThrows(POIException::class.java) { poiService.create(null) }
		assertThrows(POIException::class.java) { poiService.create(POIDTO(null, null, null)) }
		assertThrows(POIException::class.java) { poiService.create(POIDTO(null, mOne, null)) }
		assertThrows(POIException::class.java) { poiService.create(POIDTO(null, null, mOne)) }
		assertThrows(POIException::class.java) { poiService.create(POIDTO("A", null, null)) }
		assertThrows(POIException::class.java) { poiService.create(POIDTO("B", mOne, null)) }
		assertThrows(POIException::class.java) { poiService.create(POIDTO("C", null, mOne)) }
		assertThrows(POIException::class.java) { poiService.create(POIDTO("D", mOne, dValue)) }
		assertThrows(POIException::class.java) { poiService.create(POIDTO("E", dValue, mOne)) }
		assertThrows(POIException::class.java) { poiService.create(POIDTO("", dValue, dValue)) }
		// Desabilitado para base em atividade
		// val dtoO = POIDTO("F", dValue, dValue)
		// assertNotNull(poiService.create(dtoO))
		// assertThrows(POIException::class.java) { poiService.create(POIDTO("F", dValue, dValue)) }
		// dtoO = POIDTO("G", 0.0, 10.0)
		// assertNotNull(poiService.create(dtoO))
		// dtoO = POIDTO("H", 10.0, 0.0)
		// assertNotNull(poiService.create(dtoO))
	}

	// Testes em update
	@Test
	fun update() {
		assertThrows(POIException::class.java) { poiService.update(null) }
		assertThrows(POIException::class.java) { poiService.update(POIDTO(null, null, null)) }
		assertThrows(POIException::class.java) { poiService.update(POIDTO("", dValue, dValue)) }
		assertThrows(POIException::class.java) { poiService.update(POIDTO("F", mOne, null)) }
		assertThrows(POIException::class.java) { poiService.update(POIDTO("F", null, mOne)) }
		assertThrows(POIException::class.java) { poiService.update(POIDTO("F", mOne, dValue)) }
		assertThrows(POIException::class.java) { poiService.update(POIDTO("F", dValue, mOne)) }
		// Desabilitado para base em atividade
		// assertThrows(POIException::class.java) { poiService.update(POIDTO("A", dValue, dValue)) }
		// val dtoO = POIDTO("F", 1.0, 10.0)
		// assertNotNull(poiService.update(dtoO))
	}

	// Testes em find e findDTO
	@Test
	fun findDTO() {
		assertThrows(POIException::class.java) { poiService.findDTO(null) }
		assertThrows(POIException::class.java) { poiService.findDTO(POIDTO(null, null, null)) }
		assertThrows(POIException::class.java) { poiService.findDTO(POIDTO("", null, null)) }
		// Desabilitado para base em atividade
		// assertThrows(POIException::class.java) { poiService.findDTO(POIDTO("A", null, null)) }
		// val dtoO = POIDTO("H", null, null)
		// assertNotEquals(poiService.findDTO(dtoO).toString(), "POIDTO(nome=H, x=10, y=0)")
		// assertTrue(poiService.findDTO(0.0, 0.0, 0.0).isEmpty())
		// assertTrue(poiService.findDTO(0.0, 0.0, 10.0).size == 2)
		// assertTrue(poiService.findDTO().size == 3)
	}

	// Testes em delete
	@Test
	fun delete() {
		assertThrows(POIException::class.java) { poiService.delete(null) }
		assertThrows(POIException::class.java) { poiService.delete(POIDTO(null, null, null)) }
		assertThrows(POIException::class.java) { poiService.delete(POIDTO("", null, null)) }
		// Desabilitado para base em atividade
		// assertThrows(POIException::class.java) { poiService.delete(POIDTO("A", null, null)) }
		// val dtoO = POIDTO("G", null, null)
		// poiService.delete(dtoO)
	}

	// Desabilitado para não alterar a base de dados
	// Testes em deleteAll
	// @Test
	fun deleteAll() {
		poiService.deleteAll()
	}
}
