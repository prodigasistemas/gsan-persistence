package br.gov.model.exception;

public class ParametroMensagemContaIndefinido extends BaseRuntimeException {
	private static final long serialVersionUID = 1336640570684848328L;

	public ParametroMensagemContaIndefinido() {
		super("Companhia deve definir parametro que divide mensagem da conta em partes.");
	}

}
