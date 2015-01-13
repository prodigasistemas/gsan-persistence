package br.gov.model.exception;

public class ParametroEmissaoContaFebrabanIndefinido extends BaseRuntimeException {
	private static final long serialVersionUID = 1336640570684848328L;

	public ParametroEmissaoContaFebrabanIndefinido() {
		super("Companhia deve definir parametro de emissao de conta pelo Febraban.");
	}

}
