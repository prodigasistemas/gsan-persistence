package br.gov.model.cadastro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.servicos.to.ImovelSubcategoriaTO;

@Entity
@Table(name = "categoria", schema = "cadastro")
public class Categoria implements Serializable, ICategoria {
	
	private static final long serialVersionUID = 2892000798308722486L;

	public final static String RESIDENCIAL_DESCRICAO_ABREVIADA = "RES";
	public final static String COMERCIAL_DESCRICAO_ABREVIADA = "COM";
	public final static String INDUSTRIAL_DESCRICAO_ABREVIADA = "IND";
	public final static String PUBLICO_DESCRICAO_ABREVIADA = "PUB";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
	@SequenceGenerator(name = "SEQ_CATEGORIA", schema = "cadastro", sequenceName = "seq_categoria", allocationSize = 1)
	@Column(name = "catg_id")
	private Integer id;

	@Column(name = "catg_dscategoria")
	private String descricao;

	@Column(name = "catg_dsabreviado", columnDefinition = "bpchar(3)")
	private String descricaoAbreviada;

	@Column(name = "catg_nnconsumominimo")
	private Integer consumoMinimo;

	@Column(name = "catg_nnconsumoestouro")
	private Integer consumoEstouro;

	@Column(name = "catg_nnvezesmediaestouro")
	private BigDecimal vezesMediaEstouro;

	@Column(name = "catg_nnmediabaixoconsumo")
	private Integer mediaBaixoConsumo;

	@Column(name = "catg_pcmediabaixoconsumo")
	private BigDecimal porcentagemMediaBaixoConsumo;

	@Column(name = "catg_nnconsumoalto")
	private Integer consumoAlto;

	@Column(name = "catg_nnvezesmediaaltoconsumo")
	private BigDecimal vezesMediaAltoConsumo;

	@Column(name = "catg_icuso")
	private Short indicadorUso;

	@Column(name = "catg_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAlteracao;

	@Column(name = "catg_nnconsumomaximoec")
	private Integer numeroConsumoMaximoEc;

	@Column(name = "catg_iccobrancaacrescimos")
	private Short indicadorCobrancaAcrescimos;

	@Column(name = "catg_nnmaxeconomiasvalidacao")
	private Integer consumoMaximoEconomiasValidacao;

	@Column(name = "catg_nnfatoreconomias")
	private Short fatorEconomias;

	@Column(name = "catg_icpermissaoespecial")
	private Short indicadorPermissaoEspecial;

	@Column(name = "cgtp_id")
	private Integer categoriaTipo;

	private transient Integer quantidadeEconomias;

	public Categoria() {
	}

	public Categoria(Integer id) {
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

	public String getCategoriaDescricao() {
		return getDescricao();
	}

	public String getSubcategoriaDescricao() {
		return "";
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoriaDescricaoAbreviada() {
		return getDescricaoAbreviada();
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public Integer getConsumoMinimo() {
		return consumoMinimo;
	}

	public void setConsumoMinimo(Integer consumoMinimo) {
		this.consumoMinimo = consumoMinimo;
	}

	public Integer getConsumoEstouro() {
		return consumoEstouro;
	}

	public void setConsumoEstouro(Integer consumoEstouro) {
		this.consumoEstouro = consumoEstouro;
	}

	public BigDecimal getVezesMediaEstouro() {
		return vezesMediaEstouro;
	}

	public void setVezesMediaEstouro(BigDecimal vezesMediaEstouro) {
		this.vezesMediaEstouro = vezesMediaEstouro;
	}

	public Integer getMediaBaixoConsumo() {
		return mediaBaixoConsumo;
	}

	public void setMediaBaixoConsumo(Integer mediaBaixoConsumo) {
		this.mediaBaixoConsumo = mediaBaixoConsumo;
	}

	public BigDecimal getPorcentagemMediaBaixoConsumo() {
		return porcentagemMediaBaixoConsumo;
	}

	public void setPorcentagemMediaBaixoConsumo(BigDecimal porcentagemMediaBaixoConsumo) {
		this.porcentagemMediaBaixoConsumo = porcentagemMediaBaixoConsumo;
	}

	public Integer getConsumoAlto() {
		return consumoAlto;
	}

	public void setConsumoAlto(Integer consumoAlto) {
		this.consumoAlto = consumoAlto;
	}

	public BigDecimal getVezesMediaAltoConsumo() {
		return vezesMediaAltoConsumo;
	}

	public void setVezesMediaAltoConsumo(BigDecimal vezesMediaAltoConsumo) {
		this.vezesMediaAltoConsumo = vezesMediaAltoConsumo;
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

	public Integer getNumeroConsumoMaximoEc() {
		return numeroConsumoMaximoEc;
	}

	public void setNumeroConsumoMaximoEc(Integer numeroConsumoMaximoEc) {
		this.numeroConsumoMaximoEc = numeroConsumoMaximoEc;
	}

	public Short getIndicadorCobrancaAcrescimos() {
		return indicadorCobrancaAcrescimos;
	}

	public void setIndicadorCobrancaAcrescimos(Short indicadorCobrancaAcrescimos) {
		this.indicadorCobrancaAcrescimos = indicadorCobrancaAcrescimos;
	}

	public Integer getConsumoMaximoEconomiasValidacao() {
		return consumoMaximoEconomiasValidacao;
	}

	public void setConsumoMaximoEconomiasValidacao(Integer consumoMaximoEconomiasValidacao) {
		this.consumoMaximoEconomiasValidacao = consumoMaximoEconomiasValidacao;
	}

	public Short getFatorEconomias() {
		return fatorEconomias;
	}

	public void setFatorEconomias(Short fatorEconomias) {
		this.fatorEconomias = fatorEconomias;
	}

	public Short getIndicadorPermissaoEspecial() {
		return indicadorPermissaoEspecial;
	}

	public void setIndicadorPermissaoEspecial(Short indicadorPermissaoEspecial) {
		this.indicadorPermissaoEspecial = indicadorPermissaoEspecial;
	}

	public Integer getQuantidadeEconomias() {
		return quantidadeEconomias;
	}

	public void setQuantidadeEconomias(Integer quantidadeEconomias) {
		this.quantidadeEconomias = quantidadeEconomias;
	}

	public Integer getCategoriaTipo() {
		return categoriaTipo;
	}

	public void setCategoriaTipo(Integer categoriaTipo) {
		this.categoriaTipo = categoriaTipo;
	}

	public Categoria getCategoria() {
		return this;
	}

	public Subcategoria getSubcategoria() {
		return Subcategoria.SUBCATEGORIA_ZERO;
	}

	public String getSubcategoriaDescricaoAbreviada() {
		return null;
	}

	public Integer getCodigoSubcategoria() {
		return null;
	}

	public String getCodigoTarifaSocial() {
		return null;
	}

	public Short getNumeroFatorFiscalizacao() {
		return null;
	}

	public Short getIndicadorTarifaConsumo() {
		return null;
	}

	public Short getIndicadorSazonalidade() {
		return null;
	}

	public Categoria newInstance(ImovelSubcategoriaTO to) {
		Categoria categoria = new Categoria();
		categoria.setId(to.getCategoriaId());
		categoria.setDescricao(to.getCategoriaDescricao());
		categoria.setFatorEconomias(to.getFatorEconomias());
		categoria.setCategoriaTipo(to.getCategoriaTipoId());

		return categoria;
	}
}