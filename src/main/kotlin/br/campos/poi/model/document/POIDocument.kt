package br.campos.poi.model.document

import br.campos.poi.model.abst.Document as AbstractDocument
import br.campos.poi.model.abst.ObjectDTO
import br.campos.poi.model.transfer.POIDTO
import br.campos.poi.util.Cartesian
import br.campos.poi.util.DataType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

/**
 * Documento mongo para Pontos de Interesse
 *
 * @author Caio
 */
@Document(collection = "poi")
class POIDocument() : AbstractDocument(), Serializable {

	/**
	 * Id do Objeto
	 */
	@Id
	var id: String? = null

	/**
	 * Nome do ponto
	 */
	@Indexed(unique = true)
	var name: String? = null

	/**
	 * Localização [X,Y]
	 */
	@GeoSpatialIndexed(min = 0, max = Int.MAX_VALUE)
	var location: Array<Double?> = arrayOfNulls(2)

	/**
	 * Construtor de Documento Mongo de Ponto de Interesse
	 *
	 * @param dto DTO de Ponto de Interesse
	 */
	constructor(dto: ObjectDTO) : this() {
		val poi = dto as POIDTO
		setLocation(poi.x, poi.y)
		this.name = poi.name
	}

	/**
	 * Construtor de Documento Mongo de Ponto de Interesse
	 *
	 * @param name Nome do ponto
	 * @param x    posição X do ponto
	 * @param y    posição Y do ponto
	 */
	constructor(name: String?, x: Double?, y: Double?) : this() {
		setLocation(x, y)
		this.name = name
	}

	/**
	 * Define o tipo de dado o TypedData possui
	 */
	override val type: DataType
		get() = DataType.POI_TYPE

	/**
	 * Altera a localização do Ponto
	 *
	 * @param x posição X do ponto
	 * @param y posição Y do ponto
	 */
	fun setLocation(x: Double?, y: Double?) {
		location[Cartesian.X.ordinal] = x
		location[Cartesian.Y.ordinal] = y
	}

	/**
	 * Posição X do ponto
	 */
	val x: Double?
		get() = locationValue(Cartesian.X)

	/**
	 * Posição Y do ponto
	 */
	val y: Double?
		get() = locationValue(Cartesian.Y)

	/**
	 * Recupera a posição X ou Y do ponto
	 */
	private fun locationValue(c: Cartesian): Double? = try {
		location[c.ordinal]
	} catch (e: Exception) {
		0.0
	}

	companion object {
		private const val serialVersionUID: Long = 2625585029360206149L
	}
}
