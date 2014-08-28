package br.gov.model.micromedicao;

public enum LeituraSituacao {
	NAO_MEDIDO       (0),
    REALIZADA        (1),
    NAO_REALIZADA    (2),
    CONFIRMADA       (3),
    LEITURA_ALTERADA (4);
	
    private int id = 0;

    LeituraSituacao(int id){
    	this.id = id;
    }

	public int getId() {
		return id;
	}
}
