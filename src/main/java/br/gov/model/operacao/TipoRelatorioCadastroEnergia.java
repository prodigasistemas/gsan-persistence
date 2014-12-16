package br.gov.model.operacao;

public enum TipoRelatorioCadastroEnergia {
    UNIDADE_CONSUMIDORA      (0, "unidade_consumidora"), 
    CONTRATO_ENERGIA         (1, "contrato_energia_eletrica");
    
    private int id;
    
    private String descricao;
    
    TipoRelatorioCadastroEnergia(int id, String desc){
        this.id = id;
        this.descricao = desc;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
