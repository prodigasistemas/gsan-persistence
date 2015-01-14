package br.gov.model.faturamento;

public enum TipoConta {
    CONTA_RETIDA_POR_EC(1),
    CONTA_RETIDA_POR_BC(2),
    CONTA_CLIENTE_RESPONSAVEL(3),
    CONTA_DEBITO_AUTOMATICO(4),
    CONTA_NORMAL(5),
    CONTA_DEBITO_AUTO_COM_CLIENTE_RESP(6);
    
    int id;
    
    TipoConta(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
}
