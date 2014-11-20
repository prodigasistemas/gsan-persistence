package br.gov.model.exception;

public class ErroConsultaSistemaExterno extends BaseRuntimeException {
	private static final long serialVersionUID = 5063625968006329888L;
	
	public ErroConsultaSistemaExterno() {
		super("erro_consulta_sistema_externo");
	}
	
	public ErroConsultaSistemaExterno(Throwable e) {
		super("erro_consulta_sistema_externo", e);
	}
}
