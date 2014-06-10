package br.gov.model.faturamento;

public enum ContaMotivoRevisao {
	REVISAO_AUTOMATICA_ESTOURO_CONSUMO       (91),
	REVISAO_POR_PAGAMENTO_COMPROVADO         (98),
	REVISAO_AUTOMATICA_BAIXO_CONSUMO         (100),
	REVISAO_ENTRADA_DE_PARCELAMENTO          (101),
	REVISAO_POR_ANTIGUIDADE                  (102),
	CONTA_EM_CONTRATO_PARCELAMENTO           (105),
	DEBITO_A_COBRAR_EM_CONTRATO_PARCELAMENTO (106);
	
	private int id;
	
	ContaMotivoRevisao(int id) {
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public static ContaMotivoRevisao parse(int id) {
		ContaMotivoRevisao key = null;
        for (ContaMotivoRevisao item : ContaMotivoRevisao.values()) {
            if (item.getId() == id) {
                key = item;
                break;
            }
        }
        return key;
    }	

}
