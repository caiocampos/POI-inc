package br.campos.poi.util

/**
 * Exceção personalizada para melhor tratativa
 *
 * @author caio
 */
class POIException : Exception {

	constructor() : super()

	constructor(msg: String) : super(msg)

	constructor(throwable: Throwable) : super(throwable)

	constructor(msg: String, throwable: Throwable) : super(msg, throwable)

	companion object {
		private const val serialVersionUID: Long = 4979492878603725031L
	}
}
