package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FaturamentoAtividadeCronogramaRotaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6787932542572455810L;

	@Column(name="ftac_id")
	private Long faturamentoAtividadeCronogramaId;
	
	@Column(name="rota_id")
	private Long rotaId;
	
	public FaturamentoAtividadeCronogramaRotaPK(){}

	public Long getFaturamentoAtividadeCronogramaId() {
		return faturamentoAtividadeCronogramaId;
	}

	public void setFaturamentoAtividadeCronogramaId(Long faturamentoAtividadeCronogramaId) {
		this.faturamentoAtividadeCronogramaId = faturamentoAtividadeCronogramaId;
	}

	public Long getRotaId() {
		return rotaId;
	}

	public void setRotaId(Long rotaId) {
		this.rotaId = rotaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faturamentoAtividadeCronogramaId == null) ? 0 : faturamentoAtividadeCronogramaId.hashCode());
		result = prime * result + ((rotaId == null) ? 0 : rotaId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaturamentoAtividadeCronogramaRotaPK other = (FaturamentoAtividadeCronogramaRotaPK) obj;
		if (faturamentoAtividadeCronogramaId == null) {
			if (other.faturamentoAtividadeCronogramaId != null)
				return false;
		} else if (!faturamentoAtividadeCronogramaId.equals(other.faturamentoAtividadeCronogramaId))
			return false;
		if (rotaId == null) {
			if (other.rotaId != null)
				return false;
		} else if (!rotaId.equals(other.rotaId))
			return false;
		return true;
	}
}
