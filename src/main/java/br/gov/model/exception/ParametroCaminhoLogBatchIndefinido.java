package br.gov.model.exception;

public class ParametroCaminhoLogBatchIndefinido extends BaseRuntimeException {

	private static final long serialVersionUID = 2276194727161683818L;

	public ParametroCaminhoLogBatchIndefinido() {
		super("Companhia deve definir parametro do caminho para leitura e escrita de log do batch");
	}
}
