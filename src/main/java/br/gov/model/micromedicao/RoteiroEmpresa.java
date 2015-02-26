package br.gov.model.micromedicao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.cadastro.Empresa;

@Entity
@Table(name="roteiro_empresa" ,schema="micromedicao")
public class RoteiroEmpresa implements Serializable {

	private static final long serialVersionUID = -2334037080440511991L;
	
	@Id
	@Column(name="roem_id")
	private Integer id;
	
	@Column(name="roem_icuso")
	private Short indicadorUso;

	@Column(name="roem_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAlteracao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="empr_id")
	private Empresa empresa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="leit_id")
	private Leiturista leiturista;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Leiturista getLeiturista() {
		return leiturista;
	}

	public void setLeiturista(Leiturista leiturista) {
		this.leiturista = leiturista;
	}
}
