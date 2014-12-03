package br.gov.model.operacao;

public enum TipoRelatorioEnergia {
    UCS_NAO_CADASTRADAS      (0, "ucs_nao_cadastradas"), 
    UCS_NAO_FATURADAS        (1, "ucs_nao_faturadas"),
    FATURAMENTO_MENSAL       (2, "faturamento_mensal"),
    ANALISE_ENERGIA_ELETRICA (3, "analise_energia_eletrica");
    
    private int id;
    
    private String descricao;
    
    TipoRelatorioEnergia(int id, String desc){
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
