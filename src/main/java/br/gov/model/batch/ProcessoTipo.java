package br.gov.model.batch;


public enum ProcessoTipo {

	COMANDADO_FATURAMENTO(1), 
	COMANDADO_COBRANCA(2), 
	MENSAL(3), 
	EVENTUAL(4), 
	RELATORIO(5), 
	SEMANAL(6), 
	DIARIO(7); 
	
	private int id;
	
	ProcessoTipo(int idTipo){
		this.id = idTipo;
	}
	
	public int getId(){
		return id;
	}
}
