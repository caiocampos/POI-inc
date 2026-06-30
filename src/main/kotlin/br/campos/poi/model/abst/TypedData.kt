package br.campos.poi.model.abst

import br.campos.poi.util.DataType

/**
 * Abstração de Objetos que podem ser convertidos pela AbstractDataFactory
 *
 * @author Caio
 */
abstract class TypedData {

	/**
	 * Define o tipo de dado que o TypedData possui
	 */
	open val type: DataType
		get() = DataType.NO_TYPE
}
