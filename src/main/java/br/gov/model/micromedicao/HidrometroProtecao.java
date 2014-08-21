package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="hidrometro_protecao", schema="micromedicao")
public class HidrometroProtecao implements Serializable{
	private static final long serialVersionUID = -3778769642193977114L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_HIDROMETRO_PROTECAO")
	@SequenceGenerator(name="SEQ_HIDROMETRO_PROTECAO", schema="micromedicao", sequenceName="seq_hidrometro_protecao", allocationSize=1)
	@Column(name="hipr_id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "HidrometroProtecao [id=" + id + "]";
	}
}
