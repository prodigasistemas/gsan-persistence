package br.gov.model.operacao;

public enum TipoUnidadeOperacional {
	EAB(1), ETA(2), EAT(3);
	
	private int id;
	
	TipoUnidadeOperacional(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public static TipoUnidadeOperacional findById(int id){
	    for (TipoUnidadeOperacional tipo : TipoUnidadeOperacional.values()){
	        if (tipo.id == id)
	            return tipo;
	    }
	    
	    return null;
	}
}