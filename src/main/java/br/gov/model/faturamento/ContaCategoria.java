package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conta_categoria", schema="faturamento")
public class ContaCategoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6419566037598200012L;

	@EmbeddedId
	private ContaCategoriaPK pk;

	@Column(name="ctcg_qteconomia")
	private Short quantidadeEconomia;
	
	@Column(name="ctcg_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="ctcg_vlagua")
	private BigDecimal valorAgua;
	
	@Column(name="ctcg_nnconsumoagua")
	private Integer consumoAgua;
	
	@Column(name="ctcg_vlesgoto")
	private BigDecimal valorEsgoto;
	
	@Column(name="ctcg_nnconsumoesgoto")
	private Integer consumoEsgoto;
	
	@Column(name="ctcg_vltarifaminimaagua")
	private BigDecimal valorTarifaMinimaAgua;
	
	@Column(name="ctcg_nnconsumominimoagua")
	private Integer consumoMinimoAgua;
	
	@Column(name="ctcg_vltarifaminimaesgoto")
	private BigDecimal valorTarifaMinimaEsgoto;
	
	@Column(name="ctcg_nnconsumominimoesgoto")
	private Integer consumoMinimoEsgoto;
	
	@OneToMany
	@JoinColumns({
		@JoinColumn(name="cnta_id", referencedColumnName="cnta_id"),
		@JoinColumn(name="catg_id", referencedColumnName="catg_id"),
		@JoinColumn(name="scat_id", referencedColumnName="scat_id")
	})
    private Set<ContaCategoriaConsumoFaixa> contaCategoriaConsumoFaixas;
	
	public ContaCategoria(){}

	public ContaCategoriaPK getPk() {
		return pk;
	}

	public void setPk(ContaCategoriaPK id) {
		this.pk = id;
	}

	public Short getQuantidadeEconomia() {
		return quantidadeEconomia;
	}

	public void setQuantidadeEconomia(Short quantidadeEconomia) {
		this.quantidadeEconomia = quantidadeEconomia;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public BigDecimal getValorAgua() {
		return valorAgua;
	}

	public void setValorAgua(BigDecimal valorAgua) {
		this.valorAgua = valorAgua;
	}

	public Integer getConsumoAgua() {
		return consumoAgua;
	}

	public void setConsumoAgua(Integer consumoAgua) {
		this.consumoAgua = consumoAgua;
	}

	public BigDecimal getValorEsgoto() {
		return valorEsgoto;
	}

	public void setValorEsgoto(BigDecimal valorEsgoto) {
		this.valorEsgoto = valorEsgoto;
	}

	public Integer getConsumoEsgoto() {
		return consumoEsgoto;
	}

	public void setConsumoEsgoto(Integer consumoEsgoto) {
		this.consumoEsgoto = consumoEsgoto;
	}

	public BigDecimal getValorTarifaMinimaAgua() {
		return valorTarifaMinimaAgua;
	}

	public void setValorTarifaMinimaAgua(BigDecimal valorTarifaMinimaAgua) {
		this.valorTarifaMinimaAgua = valorTarifaMinimaAgua;
	}

	public Integer getConsumoMinimoAgua() {
		return consumoMinimoAgua;
	}

	public void setConsumoMinimoAgua(Integer consumoMinimoAgua) {
		this.consumoMinimoAgua = consumoMinimoAgua;
	}

	public BigDecimal getValorTarifaMinimaEsgoto() {
		return valorTarifaMinimaEsgoto;
	}

	public void setValorTarifaMinimaEsgoto(BigDecimal valorTarifaMinimaEsgoto) {
		this.valorTarifaMinimaEsgoto = valorTarifaMinimaEsgoto;
	}

	public Integer getConsumoMinimoEsgoto() {
		return consumoMinimoEsgoto;
	}

	public void setConsumoMinimoEsgoto(Integer consumoMinimoEsgoto) {
		this.consumoMinimoEsgoto = consumoMinimoEsgoto;
	}

	public Set<ContaCategoriaConsumoFaixa> getContaCategoriaConsumoFaixas() {
		return contaCategoriaConsumoFaixas;
	}

	public void setContaCategoriaConsumoFaixas(Set<ContaCategoriaConsumoFaixa> contaCategoriaConsumoFaixas) {
		this.contaCategoriaConsumoFaixas = contaCategoriaConsumoFaixas;
	}
}
