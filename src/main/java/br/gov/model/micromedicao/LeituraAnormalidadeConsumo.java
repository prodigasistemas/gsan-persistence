package br.gov.model.micromedicao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leitura_anorm_consumo", schema="micromedicao")
public class LeituraAnormalidadeConsumo {
	
	@Id
	@Column(name="lacs_id")
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
