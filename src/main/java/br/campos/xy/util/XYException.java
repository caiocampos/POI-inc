package br.campos.xy.util;

public class XYException extends Exception {
	private static final long serialVersionUID = 4979492878603725031L;

	public XYException() {
		super();
	}

	public XYException(String msg) {
		super(msg);
	}

	public XYException(Throwable throwable) {
		super(throwable);
	}

	public XYException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
