package br.gov.model.cobranca.parcelamento;

public enum ParcelamentoSituacao {

    NORMAL    (1),
    DESFEITO  (2),
    CANCELADO (4),
    CONCLUIDO (5);
    
	private int id;
	
	ParcelamentoSituacao(int idSituacao){
		this.id = idSituacao;
	}
	
	public int getId(){
		return id;
	}	
}
