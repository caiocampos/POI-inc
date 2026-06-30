package br.campos.poi.model.transfer

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * DTO de busca de Pontos de Interesse próximos
 *
 * @author Caio
 */
data class POINearDTO @JsonCreator constructor(
	/** Posição X do ponto */
	@JsonProperty("x") var x: Double?,
	/** Posição Y do ponto */
	@JsonProperty("y") var y: Double?,
	/** Distancia a procurar */
	@JsonProperty("distance") var distance: Double?
) {
	constructor() : this(null, null, null)
}
