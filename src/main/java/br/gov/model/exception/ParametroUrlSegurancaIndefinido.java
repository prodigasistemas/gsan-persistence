package br.gov.model.exception;

public class ParametroUrlSegurancaIndefinido extends BaseRuntimeException {

	private static final long serialVersionUID = 2276194727161683818L;

	public ParametroUrlSegurancaIndefinido() {
		super("Definir url de acesso ao sistema de seguranca");
	}
}
