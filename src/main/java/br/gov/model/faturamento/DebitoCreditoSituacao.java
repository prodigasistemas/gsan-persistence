package br.gov.model.faturamento;


public enum DebitoCreditoSituacao {
	NORMAL( (short) 0),
	RETIFICADA( (short) 1),
	INCLUIDA( (short) 2),
	CANCELADA( (short) 3),
	CANCELADA_POR_RETIFICACAO( (short) 4),
	PARCELADA( (short) 5),
	ARRASTADA( (short) 6),
	ENTRADA_DE_PARCELAMENTO( (short) 7),
	PAGA_OU_PRESCRITO( (short) 8),
	PRE_FATURADA( (short) 9),
	CARTAO_CREDITO( (short) 10),
	ERRO_PROCESSAMENTO( (short) 11),
	DEBITO_PRESCRITO_CONTAS_INCLUIDAS( (short) 12);
	
	private short id;
	private DebitoCreditoSituacao(short id) {
		this.id = id;
	}
	
	public short getId(){
		return id;
	}
	
	public static DebitoCreditoSituacao parse(short id) {
        DebitoCreditoSituacao DebitoCreditoSituacao = null;
        for (DebitoCreditoSituacao item : DebitoCreditoSituacao.values()) {
            if (item.getId() == id) {
                DebitoCreditoSituacao = item;
                break;
            }
        }
        return DebitoCreditoSituacao;
    }	
	

}
