package br.gov.model.operacao;

public enum TipoRelatorioCadastroUnidadeOperacional {
    EAB  (0, "eab"), 
    ETA  (1, "eta"),
    EAT  (2, "eat"),
    ETE  (3, "ete");
    
    private int id;
    
    private String descricao;
    
    TipoRelatorioCadastroUnidadeOperacional(int id, String desc){
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
