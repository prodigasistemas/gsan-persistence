package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.model.Status;

@Entity
@Table(name="debito_tipo", schema="faturamento")
public class DebitoTipo {
	@Id
	@Column(name="dbtp_id")
	private Integer id;
	
	@Column(name="dbtp_icgeracaoconta")
	private short indicadorGeracaoConta;
	
	@Column(name="dbtp_dsdebitotipo")
	private String descricao;
	
	@Column(name="dbtp_nncodigoconstante")
	private Integer codigoConstante;
	
	public DebitoTipo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getIndicadorGeracaoConta() {
		return Status.parse(indicadorGeracaoConta);
	}

	public void setIndicadorGeracaoConta(Status ativo) {
		this.indicadorGeracaoConta = ativo.getId();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getCodigoConstante() {
		return codigoConstante;
	}

	public void setCodigoConstante(Integer codigoConstante) {
		this.codigoConstante = codigoConstante;
	}

	public int hashCode() {
		return this.getId().intValue();
	}
}
