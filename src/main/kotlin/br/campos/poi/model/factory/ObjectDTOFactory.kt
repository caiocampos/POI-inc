package br.campos.poi.model.factory

import br.campos.poi.model.abst.Document
import br.campos.poi.model.abst.ObjectDTO

/**
 * Fábrica de DTOs
 *
 * @author Caio
 */
fun interface ObjectDTOFactory {

	/**
	 * Cria um DTO a partir de um Documento
	 */
	fun create(doc: Document): ObjectDTO
}
