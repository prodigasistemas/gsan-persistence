package br.gov.model.faturamento;

public enum IndicadorDebito {
    CONTAS_IMOVEL(1),
    CONTAS_CLIENTE(2),
    CONTAS_CLIENTE_RESPONSAVEL(3),
    TIPO_NAO_IDENTIFICADO(4);
    
    int id;
    
    IndicadorDebito(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
}
