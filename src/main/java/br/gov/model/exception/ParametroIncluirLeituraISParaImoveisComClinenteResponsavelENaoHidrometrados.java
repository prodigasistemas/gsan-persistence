package br.gov.model.exception;

public class ParametroIncluirLeituraISParaImoveisComClinenteResponsavelENaoHidrometrados extends BaseRuntimeException{

	private static final long serialVersionUID = 8605087153459193299L;

	public ParametroIncluirLeituraISParaImoveisComClinenteResponsavelENaoHidrometrados() {
		super("Companhia deve definir parametro que define se o sistema de Impressão Simultânea irá incluir leitura para imóveis"
				+ "que possuam cliente responsável e não sejam hidrometrados.");
	}

}
