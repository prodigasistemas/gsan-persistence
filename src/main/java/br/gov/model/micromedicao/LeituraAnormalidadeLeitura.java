package br.gov.model.micromedicao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leitura_anorm_leitura", schema="micromedicao")
public class LeituraAnormalidadeLeitura {

	@Id
	@Column(name="lalt_id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
