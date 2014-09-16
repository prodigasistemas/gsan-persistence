package br.gov.model.faturamento;

public enum TarifaTipoCalculo {

    CALCULO_PROPORCIONAL    (1),
    CALCULO_SEM_FAIXA_CAER  (2),
    CALCULO_POR_REFERENCIA  (3),
    CALCULO_DIRETO_NA_FAIXA (4);
    
    private int id = 0;

    TarifaTipoCalculo(int id){
    	this.id = id;
    }

	public int getId() {
		return id;
	}
}
