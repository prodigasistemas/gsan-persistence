package br.gov.model.cobranca;

public enum CobrancaDebitoSituacao {

    PENDENTE    (1),
    PAGO        (2),
    PARCELADO   (3),
    CANCELADO   (4),
    SEM_DEBITOS (5);
	
	private int id;
	
	CobrancaDebitoSituacao(int idSituacao){
		this.id = idSituacao;
	}
	
	public int getId(){
		return id;
	}	
}
