package br.campos.poi.model.factory

import br.campos.poi.model.abst.Document
import br.campos.poi.model.abst.ObjectDTO

/**
 * Fábrica de Documentos Mongo
 *
 * @author Caio
 */
fun interface DocumentFactory {

	/**
	 * Cria um Documento a partir de um DTO
	 */
	fun create(dto: ObjectDTO): Document
}
