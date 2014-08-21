package br.gov.model.micromedicao;

public enum MedicaoTipo {

    LIGACAO_AGUA ((short) 1),
    POCO         ((short) 2);
    
    private short id = 0;

    MedicaoTipo(short id){
    	this.id = id;
    }

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}
}
