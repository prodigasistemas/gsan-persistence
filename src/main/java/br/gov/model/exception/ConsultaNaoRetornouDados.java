package br.gov.model.exception;

public class ConsultaNaoRetornouDados extends BaseRuntimeException {
	private static final long serialVersionUID = -1064272288311991801L;

	public ConsultaNaoRetornouDados() {
		super("erro_consulta_nao_retornou_dados");
	}
}
