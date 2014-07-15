package br.gov.model.cadastro;

public enum CategoriaTipo {
    PARTICULAR ((short) 1),
    PUBLICO    ((short) 2);
    
    private short id;
    
    CategoriaTipo(short id){
    	this.id = id;
    }

	public short getId() {
		return id;
	}
}