package br.gov.model.micromedicao;

public enum TipoServicoCelular {
    LEITURA              (1),
    IMPRESSAO_SIMULTANEA (2);

    private int id = 0;

    TipoServicoCelular(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
