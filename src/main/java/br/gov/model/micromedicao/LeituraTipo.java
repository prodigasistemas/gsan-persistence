package br.gov.model.micromedicao;

public enum LeituraTipo {
    CONVENCIONAL                ((short) 1),
    MICROCOLETOR                ((short) 2),
    LEITURA_E_ENTRADA_SIMULTANEA((short) 3),
    CELULAR_MOBILE              ((short) 4);
    
    private short id = 0;

    LeituraTipo(short id){
    	this.id = id;
    }

	public short getId() {
		return id;
	}
}
