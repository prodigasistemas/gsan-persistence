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
@Table(name="hidrometro_local_inst", schema="micromedicao")
public class HidrometroLocalInstalacao implements Serializable{
	private static final long serialVersionUID = -3778769642193977114L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_HIDROMETRO_LOCAL_INST")
	@SequenceGenerator(name="SEQ_HIDROMETRO_LOCAL_INST", schema="micromedicao", sequenceName="seq_hidrometro_local_inst", allocationSize=1)
	@Column(name="hili_id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "HidrometroLocalInstalacao [id=" + id + "]";
	}
}
