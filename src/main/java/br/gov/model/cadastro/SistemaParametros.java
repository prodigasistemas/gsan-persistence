package br.gov.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sistema_parametros", schema="cadastro")
public class SistemaParametros {
	
	@Id
	@Column(name="parm_id")
	private Integer id;
	
	@Column(name="parm_amreferenciafaturamento")
	private Integer anoMesFaturamento;
	
	public SistemaParametros() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesFaturamento() {
		return anoMesFaturamento;
	}

	public void setAnoMesFaturamento(Integer anoMesFaturamento) {
		this.anoMesFaturamento = anoMesFaturamento;
	}
}
