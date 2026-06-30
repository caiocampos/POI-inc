package br.campos.poi.repository

import br.campos.poi.model.document.POIDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

/**
 * Repositório de Pontos de Interesse
 *
 * @author Caio
 */
interface POIMongoRepository : MongoRepository<POIDocument, String> {

	/**
	 * Busca por nome
	 *
	 * @param name nome do Ponto de Interesse
	 * @return Ponto de Interesse
	 */
	fun findByName(name: String): POIDocument?

	/**
	 * Busca por Pontos de Interesse próximos
	 *
	 * @param x        posição X do ponto
	 * @param y        posição Y do ponto
	 * @param distance distancia a procurar
	 * @return lista de Pontos de Interesse
	 */
	@Query("{ 'location': { \$near: [ ?0, ?1 ], \$maxDistance: ?2} }")
	fun findByLocationDistance(x: Double, y: Double, distance: Double): List<POIDocument>
}
