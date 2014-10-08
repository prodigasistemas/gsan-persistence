package br.gov.model.micromedicao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leitura_anormalidade", schema="micromedicao")
public class LeituraAnormalidade implements Serializable{
	private static final long serialVersionUID = 3799289934892490486L;

	@Id
	@Column(name="ltan_id")
	private Integer id;
	
	@Column(name="ltan_dsleituraanormalidade")
	private String descricao;
	
	@Column(name="ltan_dsabrevleituraanormalidad")
	private String descricaoAbreviada;
	
	@Column(name="ltan_icrelativohidrometro")
	private Short indicadorRelativoHidrometro;
	
	@Column(name="ltan_icimovelsemhidrometro")
	private Short indicadorImovelSemHidrometro;
	
	@Column(name="ltan_icusosistema")
	private Short indicadorSistema;
	
	@Column(name="ltan_icemissaoordemservico")
	private Short indicadorEmissaoOrdemServico;
	
	@Column(name="ltan_icuso")
	private Short indicadorUso;
	
	@Column(name="ltan_nnfatorsemleitura")
	private BigDecimal numeroFatorSemLeitura;
	
	@Column(name="ltan_nnfatorcomleitura")
	private BigDecimal numeroFatorComLeitura;
	
	@Column(name="ltan_icleitura")
	private Short indicadorLeitura;
	
	@Column(name="ltan_nnmesesleiturasuspensa")
	private Integer numeroMesesLeituraSuspensa;
	
	@Column(name="ltan_nnvezessuspendeleitura")
	private Integer numeroVezesSuspendeLeitura;
	
	public LeituraAnormalidade(){}

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

	public Short getIndicadorRelativoHidrometro() {
		return indicadorRelativoHidrometro;
	}

	public void setIndicadorRelativoHidrometro(Short indicadorRelativoHidrometro) {
		this.indicadorRelativoHidrometro = indicadorRelativoHidrometro;
	}

	public Short getIndicadorImovelSemHidrometro() {
		return indicadorImovelSemHidrometro;
	}

	public void setIndicadorImovelSemHidrometro(Short indicadorImovelSemHidrometro) {
		this.indicadorImovelSemHidrometro = indicadorImovelSemHidrometro;
	}

	public Short getIndicadorSistema() {
		return indicadorSistema;
	}

	public void setIndicadorSistema(Short indicadorSistema) {
		this.indicadorSistema = indicadorSistema;
	}

	public Short getIndicadorEmissaoOrdemServico() {
		return indicadorEmissaoOrdemServico;
	}

	public void setIndicadorEmissaoOrdemServico(Short indicadorEmissaoOrdemServico) {
		this.indicadorEmissaoOrdemServico = indicadorEmissaoOrdemServico;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public BigDecimal getNumeroFatorSemLeitura() {
		return numeroFatorSemLeitura;
	}

	public void setNumeroFatorSemLeitura(BigDecimal numeroFatorSemLeitura) {
		this.numeroFatorSemLeitura = numeroFatorSemLeitura;
	}

	public BigDecimal getNumeroFatorComLeitura() {
		return numeroFatorComLeitura;
	}

	public void setNumeroFatorComLeitura(BigDecimal numeroFatorComLeitura) {
		this.numeroFatorComLeitura = numeroFatorComLeitura;
	}

	public Short getIndicadorLeitura() {
		return indicadorLeitura;
	}

	public void setIndicadorLeitura(Short indicadorLeitura) {
		this.indicadorLeitura = indicadorLeitura;
	}

	public Integer getNumeroMesesLeituraSuspensa() {
		return numeroMesesLeituraSuspensa;
	}

	public void setNumeroMesesLeituraSuspensa(Integer numeroMesesLeituraSuspensa) {
		this.numeroMesesLeituraSuspensa = numeroMesesLeituraSuspensa;
	}

	public Integer getNumeroVezesSuspendeLeitura() {
		return numeroVezesSuspendeLeitura;
	}

	public void setNumeroVezesSuspendeLeitura(Integer numeroVezesSuspendeLeitura) {
		this.numeroVezesSuspendeLeitura = numeroVezesSuspendeLeitura;
	}
}
