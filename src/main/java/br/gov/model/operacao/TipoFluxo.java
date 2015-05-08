package br.gov.model.operacao;

public enum TipoFluxo {
	ENTRADA(1), SAIDA(2);
	
	private Integer id;

	private TipoFluxo(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
