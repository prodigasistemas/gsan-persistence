package br.gov.model.micromedicao;

public enum LeituraTipo {
    CONVENCIONAL                (1),
    MICROCOLETOR                (2),
    LEITURA_E_ENTRADA_SIMULTANEA(3),
    CELULAR_MOBILE              (4);
    
    private int id = 0;

    LeituraTipo(int id){
    	this.id = id;
    }

	public int getId() {
		return id;
	}
	
    public static LeituraTipo findById(int id){
        for (LeituraTipo tipo : LeituraTipo.values()){
            if (tipo.id == id)
                return tipo;
        }
        
        return null;
    }	
}
