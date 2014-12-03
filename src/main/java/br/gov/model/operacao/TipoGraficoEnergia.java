package br.gov.model.operacao;


public enum TipoGraficoEnergia {
    CONSUMO_KWH           (0, "consumo_kwh"), 
    TOTAL_REAIS           (1, "total_reais"),
    AJUSTE_FATOR_POTENCIA (2, "ajuste_fator_potencia"),
    ULTRAPASSAGEM_KWH     (3, "ultrapassagem_kwh"),
    ULTRAPASSAGEM_REAIS   (4, "ultrapassagem_reais");

    private int id;
    
    private String descricao;
    
    TipoGraficoEnergia(int id, String desc){
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
