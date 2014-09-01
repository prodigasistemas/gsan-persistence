package br.gov.model.micromedicao;

public enum LigacaoTipo {
	AGUA(new Short("1")), ESGOTO(new Short("2"));
	
	private Short id;
	
	LigacaoTipo(Short s){
		this.id = s;
	}
	
	public Short getId(){
		return id;
	}
	
	public static LigacaoTipo parse(Short id) {
		LigacaoTipo ligacaoTipo = null;
        for (LigacaoTipo item : LigacaoTipo.values()) {
            if (item.getId() == id) {
                ligacaoTipo = item;
                break;
            }
        }
        return ligacaoTipo;
    }	
}