package br.gov.model.micromedicao;


public enum StatusFaixaFalsa {

	GERAR_FAIXA_FALSA_ATIVO   ( (short) 1),
    GERAR_FAIXA_FALSA_DESATIVO( (short) 2),
    GERAR_FAIXA_FALSA_ROTA    ( (short) 3);
    
    private short id;
    
    StatusFaixaFalsa(short id) {
    	this.id = id;
    }
    
    public short getId() {
    	return id;
    }
    
    public static StatusFaixaFalsa parse(short id) {
    	StatusFaixaFalsa status = null;
        for (StatusFaixaFalsa item : StatusFaixaFalsa.values()) {
            if (item.getId() == id) {
                status = item;
                break;
            }
        }
        return status;
    }
}
