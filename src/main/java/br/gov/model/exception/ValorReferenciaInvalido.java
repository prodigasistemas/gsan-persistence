package br.gov.model.exception;

public class ValorReferenciaInvalido extends BaseRuntimeException {
	private static final long serialVersionUID = -1064272288311991801L;

	public ValorReferenciaInvalido() {
		super("Valor de referencia é inválido");
	}
}
