package br.campos.poi.model.factory

import br.campos.poi.model.abst.Document
import br.campos.poi.model.abst.ObjectDTO
import br.campos.poi.model.document.POIDocument
import br.campos.poi.model.transfer.POIDTO
import br.campos.poi.util.DataType

/**
 * Fábrica abstrata de DocumentFactory e ObjectDTOFactory
 *
 * @author caio
 */
object AbstractDataFactory {

	/**
	 * Gera a fábrica adequada ao tipo de dado
	 *
	 * @param dto Objeto de amostra para a identificação da fábrica necessária
	 */
	fun getFactory(dto: ObjectDTO): DocumentFactory? = when (dto.type) {
		DataType.POI_TYPE -> DocumentFactory { d -> POIDocument(d) }
		else -> null
	}

	/**
	 * Gera a fábrica adequada ao tipo de dado
	 *
	 * @param doc Objeto de amostra para a identificação da fábrica necessária
	 */
	fun getFactory(doc: Document): ObjectDTOFactory? = when (doc.type) {
		DataType.POI_TYPE -> ObjectDTOFactory { d -> POIDTO(d) }
		else -> null
	}
}
