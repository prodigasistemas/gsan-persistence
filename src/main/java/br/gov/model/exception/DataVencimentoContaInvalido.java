package br.gov.model.exception;

public class DataVencimentoContaInvalido extends BaseRuntimeException {
	private static final long serialVersionUID = 1336640570684848328L;

	public DataVencimentoContaInvalido() {
		super("Data de vencimento de conta invalido.");
	}

}
