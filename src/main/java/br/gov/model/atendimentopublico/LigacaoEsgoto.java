package br.gov.model.atendimentopublico;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="ligacao_esgoto", schema="atendimentopublico")
public class LigacaoEsgoto implements Serializable {
	
	private static final long serialVersionUID = -1962793846504247586L;

	@Id
	@Column(name="lesg_id")
	private Integer id;
	
	@Column(name="lesg_dtligacao")
	@Temporal(TemporalType.DATE)
	private Date dataLigacao;
	
	@Column(name="lesg_nnconsumominimoesgoto")
	private Integer consumoMinimo;
	
	@Column(name="lesg_pcesgoto")
	private BigDecimal percentual;
	
	@Column(name="lesg_pccoleta")
	private BigDecimal percentualAguaConsumidaColetada;
	
	@Column(name="lesg_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date ultimaAlteracao;
	
	@Column(name="lesg_iccaixagordura")
	private Short indicadorCaixaGordura;
	
	@Column(name="lesg_icligacaoesgoto")
	private Short indicadorLigacaoEsgoto;
	
	@Column(name="lesg_pcalternativo")
	private BigDecimal percentualAlternativo;
	
	@Column(name="lesg_nnconsumopcalternativo")
	private Integer numeroConsumoPercentualAlternativo;
	
	@OneToOne
	@JoinColumn(name="lesg_id", referencedColumnName="imov_id")
	private Imovel imovel;
	
	public LigacaoEsgoto(){}

	public Short valorPercentualAguaConsumidaColetada() {
		return percentualAguaConsumidaColetada != null ? percentualAguaConsumidaColetada.shortValue() : 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataLigacao() {
		return dataLigacao;
	}

	public void setDataLigacao(Date dataLigacao) {
		this.dataLigacao = dataLigacao;
	}

	public Integer getConsumoMinimo() {
		return consumoMinimo;
	}

	public void setConsumoMinimo(Integer consumoMinimo) {
		this.consumoMinimo = consumoMinimo;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

	public BigDecimal getPercentualAguaConsumidaColetada() {
		return percentualAguaConsumidaColetada;
	}

	public void setPercentualAguaConsumidaColetada(BigDecimal percentualAguaConsumidaColetada) {
		this.percentualAguaConsumidaColetada = percentualAguaConsumidaColetada;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Short getIndicadorCaixaGordura() {
		return indicadorCaixaGordura;
	}

	public void setIndicadorCaixaGordura(Short indicadorCaixaGordura) {
		this.indicadorCaixaGordura = indicadorCaixaGordura;
	}

	public Short getIndicadorLigacaoEsgoto() {
		return indicadorLigacaoEsgoto;
	}

	public void setIndicadorLigacaoEsgoto(Short indicadorLigacaoEsgoto) {
		this.indicadorLigacaoEsgoto = indicadorLigacaoEsgoto;
	}

	public BigDecimal getPercentualAlternativo() {
		return percentualAlternativo;
	}

	public void setPercentualAlternativo(BigDecimal percentualAlternativo) {
		this.percentualAlternativo = percentualAlternativo;
	}

	public Integer getNumeroConsumoPercentualAlternativo() {
		return numeroConsumoPercentualAlternativo;
	}

	public void setNumeroConsumoPercentualAlternativo(Integer numeroConsumoPercentualAlternativo) {
		this.numeroConsumoPercentualAlternativo = numeroConsumoPercentualAlternativo;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public boolean possuiPercentualAlternativo() {
		return percentualAlternativo != null;
	}
	
	public boolean possuiNumeroConsumoPercentualAlternativo() {
		return numeroConsumoPercentualAlternativo != null;
	}
}
