package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hidrometro_capacidade" , schema="micromedicao")
public class HidrometroCapacidade implements Serializable {

	private static final long serialVersionUID = -1648065378072951473L;
	
	@Id
	@Column(name="hicp_id")
	private Integer id;
	
	@Column(name="hicp_dshidrometrocapacidade")
	private String descricao;
	
	@Column(name="hicp_dsabreviadahidrcapacidade")
	private String descricaoAbreviada;
	
	@Column(name="hicp_nndigitosleituraminimo")
	private Short leituraMinimo;
	
	@Column(name="hicp_nndigitosleituramaximo")
	private Short leituraMaximo;
	
	@Column(name="hicp_icuso")
	private Short indicadorUso;
	
	@Column(name="hicp_nnordem")
	private Short numeroOrdem;
	
	@Column(name="hicp_cdhidrometrocapacidade")
	private String codigoHidrometroCapacidade;

	public HidrometroCapacidade() {}

	public HidrometroCapacidade(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public Short getLeituraMinimo() {
		return leituraMinimo;
	}

	public void setLeituraMinimo(Short leituraMinimo) {
		this.leituraMinimo = leituraMinimo;
	}

	public Short getLeituraMaximo() {
		return leituraMaximo;
	}

	public void setLeituraMaximo(Short leituraMaximo) {
		this.leituraMaximo = leituraMaximo;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public Short getNumeroOrdem() {
		return numeroOrdem;
	}

	public void setNumeroOrdem(Short numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}

	public String getCodigoHidrometroCapacidade() {
		return codigoHidrometroCapacidade;
	}

	public void setCodigoHidrometroCapacidade(String codigoHidrometroCapacidade) {
		this.codigoHidrometroCapacidade = codigoHidrometroCapacidade;
	}
}
