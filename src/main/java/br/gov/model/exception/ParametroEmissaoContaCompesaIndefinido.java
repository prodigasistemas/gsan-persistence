package br.gov.model.exception;

public class ParametroEmissaoContaCompesaIndefinido extends BaseRuntimeException{
	private static final long serialVersionUID = 2471014788477723048L;

	public ParametroEmissaoContaCompesaIndefinido() {
		super("Companhia deve definir parametro de emissao de conta pelo Compesa.");
	}
}
