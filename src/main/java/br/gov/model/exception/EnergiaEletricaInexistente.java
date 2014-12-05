package br.gov.model.exception;

public class EnergiaEletricaInexistente extends BaseRuntimeException {
	private static final long serialVersionUID = -1064272288311991801L;

	public EnergiaEletricaInexistente() {
		super("erro_dados_energia_inexistentes_para_referencia");
	}
}
