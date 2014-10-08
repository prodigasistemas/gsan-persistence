package br.gov.model.micromedicao;

public enum MedicaoTipo {

    LIGACAO_AGUA (1),
    POCO         (2);
    
    private int id = 0;

    MedicaoTipo(int id){
    	this.id = id;
    }

	public int getId() {
		return id;
	}
}
