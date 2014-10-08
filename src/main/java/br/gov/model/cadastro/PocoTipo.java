package br.gov.model.cadastro;

public enum PocoTipo {
    SEM_POCO                (0),
    POCO_ABERTO_AMAZONAS    (1),
    POCO_PROFUNDO_ARTESIANO (2);
    
    private int id = 0;

    PocoTipo(int id){
    	this.id = id;
    }

	public int getId() {
		return id;
	}
}