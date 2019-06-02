package br.campos.xy.model.abst;

import br.campos.xy.util.DataType;

/**
 * Abstração de Objetos que podem ser convertidos pela AbstractDataFactory
 * 
 * @author Caio
 */
public abstract class TypedData {

	/**
	 * Define o tipo de dado o TypedData possui
	 * 
	 * @return Enum com o tipo de dado
	 */
	public DataType getType() {
		return DataType.NO_TYPE;
	}
}
