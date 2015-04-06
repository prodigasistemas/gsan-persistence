package br.gov.model.micromedicao;

public enum ServicoTipoCelular {

	LEITURA					(1),
	IMPRESSAO_SIMULTANEA	(2);

	private int id;

	ServicoTipoCelular(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
