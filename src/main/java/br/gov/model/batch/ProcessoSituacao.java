package br.gov.model.batch;

public enum ProcessoSituacao {

	EM_PROCESSAMENTO(1), CONCLUIDO(2), EM_ESPERA(3), AGENDADO(4), CONCLUIDO_COM_ERRO(6), CANCELADO(7);
	
	private int id;
	
	ProcessoSituacao(int idSituacao){
		this.id = idSituacao;
	}
	
	public int getId(){
		return id;
	}
}
