package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.cadastro.Categoria;
import br.gov.model.cadastro.Subcategoria;

@Entity
@Table(name="conta_catg_cons_fx", schema="faturamento")
public class ContaCategoriaConsumoFaixa implements Serializable{
	private static final long serialVersionUID = -2287635202479403837L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTA_CATEGORIA_CONSUMO_FAIXA")
	@SequenceGenerator(name="SEQ_CONTA_CATEGORIA_CONSUMO_FAIXA", schema="faturamento", sequenceName="seq_conta_catg_cons_fx", allocationSize=1)
	@Column(name="cccf_id")
	private Integer id;
	
	@Column(name="cccf_vlagua")
	private BigDecimal valorAgua;
	
	@Column(name="cccf_nnconsumoagua")
	private Integer consumoAgua;

	@Column(name="cccf_vlesgoto")
	private BigDecimal valorEsgoto;
	
	@Column(name="cccf_nnconsumoesgoto")
	private Integer consumoEsgoto;
	
	@Column(name="cccf_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="cccf_nnconsumofaixainicio")
	private Integer consumoFaixaInicio;
	
	@Column(name="cccf_nnconsumofaixafim")
	private Integer consumoFaixaFim;
	
	@Column(name="cccf_vltarifafaixa")
	private BigDecimal valorTarifaFaixa;
	
	@ManyToOne
	@JoinColumn(name="catg_id", insertable=false, updatable=false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="scat_id", insertable=false, updatable=false)
	private Subcategoria subcategoria;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cnta_id", referencedColumnName="cnta_id"),
		@JoinColumn(name="catg_id", referencedColumnName="catg_id"),
		@JoinColumn(name="scat_id", referencedColumnName="scat_id")
	})
	private ContaCategoria contaCategoria;
	
	public ContaCategoriaConsumoFaixa(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Integer getConsumoFaixaInicio() {
		return consumoFaixaInicio;
	}

	public void setConsumoFaixaInicio(Integer consumoFaixaInicio) {
		this.consumoFaixaInicio = consumoFaixaInicio;
	}

	public Integer getConsumoFaixaFim() {
		return consumoFaixaFim;
	}

	public void setConsumoFaixaFim(Integer consumoFaixaFim) {
		this.consumoFaixaFim = consumoFaixaFim;
	}

	public BigDecimal getValorTarifaFaixa() {
		return valorTarifaFaixa;
	}

	public void setValorTarifaFaixa(BigDecimal valorTarifaFaixa) {
		this.valorTarifaFaixa = valorTarifaFaixa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public ContaCategoria getContaCategoria() {
		return contaCategoria;
	}

	public void setContaCategoria(ContaCategoria contaCategoria) {
		this.contaCategoria = contaCategoria;
	}
}
