package br.gov.model.cobranca;

public enum CobrancaDebitoSituacao {

    PENDENTE    ((short) 1),
    PAGO        ((short) 2),
    PARCELADO   ((short) 3),
    CANCELADO   ((short) 4),
    SEM_DEBITOS ((short) 5);
	
	private short id;
	
	CobrancaDebitoSituacao(short idSituacao){
		this.id = idSituacao;
	}
	
	public short getId(){
		return id;
	}	
}
