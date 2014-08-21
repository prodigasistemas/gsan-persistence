package br.gov.model.cadastro;

public enum PocoTipo {
    SEM_POCO                ((short) 0),
    POCO_ABERTO_AMAZONAS    ((short) 1),
    POCO_PROFUNDO_ARTESIANO ((short) 2);
    
    private short id = 0;

    PocoTipo(short id){
    	this.id = id;
    }

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}
}