package br.gov.model.cobranca;

public enum DocumentoTipo {

	CONTA                                ((short) 1),
	ENTRADA_DE_PARCELAMENTO              ((short) 2),
	DOCUMENTO_COBRANCA                   ((short) 3),
	INCLUIDO                             ((short) 4),
	FATURA_CLIENTE                       ((short) 5),
	DEBITO_A_COBRAR                      ((short) 6),
	GUIA_PAGAMENTO                       ((short) 7),
	DEVOLUCAO_VALOR                      ((short) 8),
	DEVOLUCAO_CONTA                      ((short) 9),
	CREDITO_A_REALIZAR                   ((short) 10),
	CORTE_ADMINISTRATIVO                 ((short) 11),
	AVISO_CORTE                          ((short) 12),
	CORTE_FISICO                         ((short) 13),
	EXTRATO_DE_DEBITO                    ((short) 14),
	ORDEM_SUPRESSAO                      ((short) 15),
	ORDEM_FISCALIZACAO_SUPRIMIDO         ((short) 16),
	ORDEM_FISCALIZACAO_CORTADO           ((short) 17),
	AVISO_DEBITO                         ((short) 18),
	VISITA_COBRANCA                      ((short) 19),
	ORDEM_CORTE                          ((short) 20),
	CARTA_COBRANCA_SUPRIMIDO             ((short) 21),
	CARTA_COBRANCA_CORTADO               ((short) 22),
	CARTA_COBRANCA_TARIFA_SOCIAL_LIGADO  ((short) 23),
	CARTA_COBRANCA_TARIFA_SOCIAL_CORTADO ((short) 24),
	CARTA_COBRANCA_LIGADO                ((short) 25),
	ORDEM_FISCALIZACAO_FACTIVEL          ((short) 26),
	ORDEM_FISCALIZACAO_POTENCIAL         ((short) 27),
	ORDEM_FISCALIZACAO_LIGADO            ((short) 28),
	ORDEM_FISCALIZACAO_TOTAL             ((short) 29),
	CARTA_SOLIDARIEDADE_DA_CRIANCA       ((short) 30),
	INSPECAO_DE_LIGACOES                 ((short) 31),
	CARTA_DE_FINAL_DE_ANO_2009           ((short) 32),
	EXTRATO_CONTRATO_PARCELAMENTO        ((short) 33);
	
	
	private short id;
	
	DocumentoTipo(short idSituacao){
		this.id = idSituacao;
	}
	
	public short getId(){
		return id;
	}	
}
