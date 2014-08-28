package br.gov.model.micromedicao;

public enum RateioTipo {
	SEM_RATEIO                (0),
	RATEIO_POR_IMÓVEL         (1),
	RATEIO_AREA_CONSTRUIDA    (2),
	RATEIO_PELO_NUM_MORADORES (3),
	RATEIO_NAO_MEDIDO_AGUA    (4),
	RATEIO_AREA_COMUM         (5);
    
    private int id = 0;

    RateioTipo(int id){
    	this.id = id;
    }

	public int getId() {
		return id;
	}
}
