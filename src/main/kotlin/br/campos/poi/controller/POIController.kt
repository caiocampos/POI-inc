package br.campos.poi.controller

import br.campos.poi.model.transfer.POIDTO
import br.campos.poi.model.transfer.POINearDTO
import br.campos.poi.service.abst.IPOIService
import br.campos.poi.util.POIException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Controle de Pontos de Interesse
 *
 * @author Caio
 */
@RestController("poi")
class POIController {

	/**
	 * Instância de Serviço de Pontos de Interesse
	 */
	@Autowired
	lateinit var poiService: IPOIService

	/**
	 * Busca todos os Pontos de Interesse
	 */
	@GetMapping("/")
	@Throws(POIException::class)
	fun findAll(): ResponseEntity<List<POIDTO>> = ResponseEntity(poiService.findDTO(), HttpStatus.OK)

	/**
	 * Busca os Pontos de Interesse a uma certa distancia
	 */
	@GetMapping("/near")
	@Throws(POIException::class)
	fun findNear(@RequestBody req: POINearDTO): ResponseEntity<List<POIDTO>> =
		ResponseEntity(poiService.findDTO(req.x, req.y, req.distance), HttpStatus.OK)

	/**
	 * Cria Pontos de Interesse
	 */
	@PostMapping("/")
	@Throws(POIException::class)
	fun create(@RequestBody req: POIDTO): ResponseEntity<Any> =
		ResponseEntity(poiService.create(req), HttpStatus.OK)
}
