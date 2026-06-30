package br.campos.poi.service.abst

import br.campos.poi.model.document.POIDocument
import br.campos.poi.model.transfer.POIDTO
import br.campos.poi.util.POIException

/**
 * Interface de Serviço de Pontos de Interesse
 *
 * @author Caio
 */
interface IPOIService {

	/**
	 * Cria um Ponto de Interesse
	 */
	@Throws(POIException::class)
	fun create(dto: POIDTO?): POIDocument

	/**
	 * Atualiza um Ponto de Interesse
	 */
	@Throws(POIException::class)
	fun update(dto: POIDTO?): POIDocument

	/**
	 * Busca um Ponto de Interesse
	 */
	@Throws(POIException::class)
	fun find(dto: POIDTO?): POIDocument

	/**
	 * Busca por Pontos próximos a um ponto de referência
	 */
	@Throws(POIException::class)
	fun find(x: Double?, y: Double?, distance: Double?): List<POIDocument>

	/**
	 * Busca todos os Pontos de Interesse
	 */
	@Throws(POIException::class)
	fun find(): List<POIDocument>

	/**
	 * Busca um Ponto de Interesse
	 */
	@Throws(POIException::class)
	fun findDTO(dto: POIDTO?): POIDTO

	/**
	 * Busca por Pontos próximos a um ponto de referência
	 */
	@Throws(POIException::class)
	fun findDTO(x: Double?, y: Double?, distance: Double?): List<POIDTO>

	/**
	 * Busca todos os Pontos de Interesse
	 */
	@Throws(POIException::class)
	fun findDTO(): List<POIDTO>

	/**
	 * Apaga um Ponto de Interesse
	 */
	@Throws(POIException::class)
	fun delete(dto: POIDTO?)

	/**
	 * Apaga todos os Pontos de Interesse
	 */
	@Throws(POIException::class)
	fun deleteAll()
}
