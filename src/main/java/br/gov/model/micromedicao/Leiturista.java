package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.seguranca.Usuario;

@Entity
@Table(name="leiturista", schema="micromedicao")
public class Leiturista implements Serializable {
	private static final long serialVersionUID = -2566021566597302550L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LEITURISTA")
	@SequenceGenerator(name="SEQ_LEITURISTA", schema="micromedicao", sequenceName="seq_leiturista", allocationSize=1)	
	@Column(name = "leit_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="usur_id")
	private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String toString() {
		return "Leiturista [id=" + id + "]";
	}
}