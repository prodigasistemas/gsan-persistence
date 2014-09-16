package br.gov.servicos.to;

import java.io.Serializable;
import java.util.Date;

public class ConsumoTarifaVigenciaTO implements Serializable {
	private static final long serialVersionUID = -1424011555424705514L;
	
	private Integer idVigencia;
	
	private Date dataVigencia;

	public ConsumoTarifaVigenciaTO(Integer idVigencia, Date dataVigencia) {
		this.idVigencia = idVigencia;
		this.dataVigencia = dataVigencia;
	}

	public Integer getIdVigencia() {
		return idVigencia;
	}

	public void setIdVigencia(Integer idVigencia) {
		this.idVigencia = idVigencia;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}
}
