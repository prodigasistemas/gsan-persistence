package br.gov.model.financeiro;


public enum TipoFinanciamento {
	SERVICO_NORMAL       (1),
	PARCELAMENTO_AGUA    (2),
	PARCELAMENTO_ESGOTO  (3),
	PARCELAMENTO_SERVICO (4);
	
	int id;
	TipoFinanciamento(int id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}
