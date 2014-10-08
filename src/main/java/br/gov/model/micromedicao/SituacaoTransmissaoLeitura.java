package br.gov.model.micromedicao;

public enum SituacaoTransmissaoLeitura {
    DISPONIVEL                  (1),
    LIBERADO                    (2),
    EM_CAMPO                    (3),
    TRANSMITIDO                 (4),
    FINALIZADO_NAO_TRANSMITIDO  (5),
    FINALIZADO_INCOMPLETO       (6),
    FINALIZADO_USUARIO          (7),
    FINALIZADO_POR_DIGITACAO    (8),
    INFORMAR_MOTIVO_FINALIZACAO (9);
    
    private int id;

	SituacaoTransmissaoLeitura(int id){
    	this.id = id;
    }

	public int getId() {
		return id;
	}
}
