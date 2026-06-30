package br.campos.poi.model.transfer

import br.campos.poi.model.abst.Document
import br.campos.poi.model.abst.ObjectDTO
import br.campos.poi.model.document.POIDocument
import br.campos.poi.util.DataType
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

/**
 * DTO para Pontos de Interesse
 *
 * @author Caio
 */
data class POIDTO @JsonCreator constructor(
	/** Nome do ponto */
	@JsonProperty("name") var name: String?,
	/** Posição X do ponto */
	@JsonProperty("x") var x: Double?,
	/** Posição Y do ponto */
	@JsonProperty("y") var y: Double?
) : ObjectDTO(), Serializable {

	/**
	 * Construtor de DTO de Ponto de Interesse
	 */
	constructor() : this(null, null, null)

	/**
	 * Construtor de DTO de Ponto de Interesse
	 *
	 * @param doc Documento Mongo de Ponto de Interesse
	 */
	constructor(doc: Document) : this(
		(doc as POIDocument).name,
		doc.x,
		doc.y
	)

	/**
	 * Define o tipo de dado o TypedData possui
	 */
	@get:JsonIgnore
	override val type: DataType
		get() = DataType.POI_TYPE

	companion object {
		private const val serialVersionUID: Long = -4827112214578752089L
	}
}
