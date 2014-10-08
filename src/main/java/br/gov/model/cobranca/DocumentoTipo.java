package br.gov.model.cobranca;

public enum DocumentoTipo {

	CONTA                                (1),
	ENTRADA_DE_PARCELAMENTO              (2),
	DOCUMENTO_COBRANCA                   (3),
	INCLUIDO                             (4),
	FATURA_CLIENTE                       (5),
	DEBITO_A_COBRAR                      (6),
	GUIA_PAGAMENTO                       (7),
	DEVOLUCAO_VALOR                      (8),
	DEVOLUCAO_CONTA                      (9),
	CREDITO_A_REALIZAR                   (10),
	CORTE_ADMINISTRATIVO                 (11),
	AVISO_CORTE                          (12),
	CORTE_FISICO                         (13),
	EXTRATO_DE_DEBITO                    (14),
	ORDEM_SUPRESSAO                      (15),
	ORDEM_FISCALIZACAO_SUPRIMIDO         (16),
	ORDEM_FISCALIZACAO_CORTADO           (17),
	AVISO_DEBITO                         (18),
	VISITA_COBRANCA                      (19),
	ORDEM_CORTE                          (20),
	CARTA_COBRANCA_SUPRIMIDO             (21),
	CARTA_COBRANCA_CORTADO               (22),
	CARTA_COBRANCA_TARIFA_SOCIAL_LIGADO  (23),
	CARTA_COBRANCA_TARIFA_SOCIAL_CORTADO (24),
	CARTA_COBRANCA_LIGADO                (25),
	ORDEM_FISCALIZACAO_FACTIVEL          (26),
	ORDEM_FISCALIZACAO_POTENCIAL         (27),
	ORDEM_FISCALIZACAO_LIGADO            (28),
	ORDEM_FISCALIZACAO_TOTAL             (29),
	CARTA_SOLIDARIEDADE_DA_CRIANCA       (30),
	INSPECAO_DE_LIGACOES                 (31),
	CARTA_DE_FINAL_DE_ANO_2009           (32),
	EXTRATO_CONTRATO_PARCELAMENTO        (33);
	
	
	private int id;
	
	DocumentoTipo(int idSituacao){
		this.id = idSituacao;
	}
	
	public int getId(){
		return id;
	}	
}
