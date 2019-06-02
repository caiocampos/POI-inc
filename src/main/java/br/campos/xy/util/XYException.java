package br.campos.xy.util;

/**
 * Exceção personalizada para melhor tratativa
 * 
 * @author caio
 */
public class XYException extends Exception {
	private static final long serialVersionUID = 4979492878603725031L;

	/**
	 * Construtor de Exceção
	 */
	public XYException() {
		super();
	}

	/**
	 * Construtor de Exceção
	 * 
	 * @param msg mensagem de erro
	 */
	public XYException(String msg) {
		super(msg);
	}

	/**
	 * Construtor de Exceção
	 * 
	 * @param throwable origem da Exceção
	 */
	public XYException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Construtor de Exceção
	 * 
	 * @param msg       mensagem de erro
	 * @param throwable origem da Exceção
	 */
	public XYException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
