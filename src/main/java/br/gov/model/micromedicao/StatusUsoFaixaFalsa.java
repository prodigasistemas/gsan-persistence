package br.gov.model.micromedicao;

public enum StatusUsoFaixaFalsa {

	SISTEMA_PARAMETRO   ( (short) 1),
	ROTA( (short) 2),;
    
    private short id;
    
    StatusUsoFaixaFalsa(short id) {
    	this.id = id;
    }
    
    public short getId() {
    	return id;
    }
    
    public static StatusUsoFaixaFalsa parse(short id) {
    	StatusUsoFaixaFalsa status = null;
        for (StatusUsoFaixaFalsa item : StatusUsoFaixaFalsa.values()) {
            if (item.getId() == id) {
                status = item;
                break;
            }
        }
        return status;
    }
}
