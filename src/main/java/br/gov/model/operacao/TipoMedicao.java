package br.gov.model.operacao;

public enum TipoMedicao {
	VAZAO(1), PRESSAO(2), NIVEL(3);

	private Integer id;

	private TipoMedicao(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
