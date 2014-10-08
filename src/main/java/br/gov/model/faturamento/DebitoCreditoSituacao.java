package br.gov.model.faturamento;


public enum DebitoCreditoSituacao {
	NORMAL                      (0),
	RETIFICADA                  (1),
	INCLUIDA                    (2),
	CANCELADA                   (3),
	CANCELADA_POR_RETIFICACAO   (4),
	PARCELADA                   (5),
	ARRASTADA                   (6),
	ENTRADA_DE_PARCELAMENTO     (7),
	PAGA_OU_PRESCRITO           (8),
	PRE_FATURADA                (9),
	CARTAO_CREDITO              (10),
	ERRO_PROCESSAMENTO          (11),
	DEBITO_PRESCRITO_CONTAS_INCLUIDAS(12);
	
	private int id;
	
	private DebitoCreditoSituacao(int id) {
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
}
