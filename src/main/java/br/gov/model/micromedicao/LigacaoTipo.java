package br.gov.model.micromedicao;

public enum LigacaoTipo {	
    AGUA   (1),
    ESGOTO (2);
    
    private int id = 0;

    LigacaoTipo(int id){
    	this.id = id;
    }

	public int getId() {
		return id;
	}
}
