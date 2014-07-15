package br.gov.model.cadastro;

public enum ImovelContaEnvio {
	ENVIAR_CLIENTE_RESPONSAVEL             ((short) 1),
	ENVIAR_IMOVEL                          ((short) 2),
	NAO_PAGAVEL_IMOVEL_PAGAVEL_RESPONSAVEL ((short) 3),
	ENVIAR_PARA_EMAIL                      ((short) 4),
	ENVIAR_PARA_IMOVEL_E_PARA_EMAIL        ((short) 5),
	ENVIAR_CONTA_BRAILLE                   ((short) 6),
	ENVIAR_CONTA_BRAILLE_RESPONSAVEL       ((short) 7),
	ENVIAR_CLIENTE_RESPONSAVEL_FINAL_GRUPO ((short) 9);
	
	short id;
	
	ImovelContaEnvio(short id){
		this.id = id;
	}
	
	public short getId(){
		return id;
	}
}
