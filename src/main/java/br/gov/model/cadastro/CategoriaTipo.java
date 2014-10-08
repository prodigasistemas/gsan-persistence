package br.gov.model.cadastro;

public enum CategoriaTipo {
    PARTICULAR (1),
    PUBLICO    (2);
    
    private int id;
    
    CategoriaTipo(int id){
    	this.id = id;
    }

	public int getId() {
		return id;
	}
}