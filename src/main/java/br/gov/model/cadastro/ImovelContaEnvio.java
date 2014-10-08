package br.gov.model.cadastro;

public enum ImovelContaEnvio {
	ENVIAR_CLIENTE_RESPONSAVEL             (1),
	ENVIAR_IMOVEL                          (2),
	NAO_PAGAVEL_IMOVEL_PAGAVEL_RESPONSAVEL (3),
	ENVIAR_PARA_EMAIL                      (4),
	ENVIAR_PARA_IMOVEL_E_PARA_EMAIL        (5),
	ENVIAR_CONTA_BRAILLE                   (6),
	ENVIAR_CONTA_BRAILLE_RESPONSAVEL       (7),
	ENVIAR_CLIENTE_RESPONSAVEL_FINAL_GRUPO (9);
	
	int id;
	
	ImovelContaEnvio(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
}
