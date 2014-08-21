package br.gov.model.micromedicao;

public enum SituacaoTransmissaoLeitura {
    DISPONIVEL                  ((short) 1),
    LIBERADO                    ((short) 2),
    EM_CAMPO                    ((short) 3),
    TRANSMITIDO                 ((short) 4),
    FINALIZADO_NAO_TRANSMITIDO  ((short) 5),
    FINALIZADO_INCOMPLETO       ((short) 6),
    FINALIZADO_USUARIO          ((short) 7),
    FINALIZADO_POR_DIGITACAO    ((short) 8),
    INFORMAR_MOTIVO_FINALIZACAO ((short) 9);
    
    private short id;

	SituacaoTransmissaoLeitura(short id){
    	this.id = id;
    }

	public short getId() {
		return id;
	}
}
