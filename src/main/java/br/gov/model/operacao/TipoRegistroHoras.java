package br.gov.model.operacao;

public enum TipoRegistroHoras {
    TRABALHADAS                      (0, "horas_trabalhadas"), 
    PARADAS_POR_ENERGIA              (1, "horas_paradas_energia"),
    PARADAS_POR_MANUTENCAO           (2, "horas_paradas_manutencao"),
    PARADAS_POR_CONTROLE_OPERACIONAL (3, "horas_paradas_controle");
    
    private int id;
    
    private String descricao;
    
    TipoRegistroHoras(int id, String desc){
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
