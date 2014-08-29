package br.gov.model.cadastro;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="subcategoria", schema="cadastro")
public class Subcategoria implements Serializable, ICategoria {
	private static final long serialVersionUID = -8583209465706655041L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SUBCATEGORIA")
	@SequenceGenerator(name="SEQ_SUBCATEGORIA", schema="cadastro", sequenceName="seq_subcategoria", allocationSize=1)
	@Column(name="scat_id")
	private Long id;
	
	@Column(name="scat_cdsubcategoria")
	private Integer codigo;
	
	@Column(name="scat_dssubcategoria")
	private String descricao;
	
	@Column(name="scat_icuso")
	private Short indicadorUso;
	
	@Column(name="scat_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="scat_cdtarifasocial")
	private String codigoTarifaSocial;
	
	@Column(name="scat_nnfatorfiscalizacao")
	private Short numeroFatorFiscalizacao;
	
	@Column(name="scat_ictarifaconsumo")
	private Short indicadorTarifaConsumo;
	
	@Column(name="scat_dsabreviada")
	private String descricaoAbreviada;
	
	@Column(name="scat_cdgruposubcategoria")
	private Integer codigoGrupoSubcategoria;
	
	@Column(name="scat_icsazonalidade")
	private Short indicadorSazonalidade;

	@ManyToOne
	@JoinColumn(name="catg_id")
	private Categoria categoria;
	
	private Integer quantidadeEconomias;
	
	public static final Subcategoria SUBCATEGORIA_ZERO;
	
	static {
    	SUBCATEGORIA_ZERO = new Subcategoria();
    	SUBCATEGORIA_ZERO.setId(0L);
    }
	
	public Subcategoria(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public String getSubcategoriaDescricao() {
		return getDescricao();
	}
	
	public String getCategoriaDescricao() {
		return this.categoria.getDescricao();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getCodigoTarifaSocial() {
		return codigoTarifaSocial;
	}

	public void setCodigoTarifaSocial(String codigoTarifaSocial) {
		this.codigoTarifaSocial = codigoTarifaSocial;
	}

	public Short getNumeroFatorFiscalizacao() {
		return numeroFatorFiscalizacao;
	}

	public void setNumeroFatorFiscalizacao(Short numeroFatorFiscalizacao) {
		this.numeroFatorFiscalizacao = numeroFatorFiscalizacao;
	}

	public Short getIndicadorTarifaConsumo() {
		return indicadorTarifaConsumo;
	}

	public void setIndicadorTarifaConsumo(Short indicadorTarifaConsumo) {
		this.indicadorTarifaConsumo = indicadorTarifaConsumo;
	}
	
	public String getCategoriaDescricaoAbreviada() {
		return categoria.getDescricaoAbreviada();
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public Integer getCodigoGrupoSubcategoria() {
		return codigoGrupoSubcategoria;
	}

	public void setCodigoGrupoSubcategoria(Integer codigoGrupoSubcategoria) {
		this.codigoGrupoSubcategoria = codigoGrupoSubcategoria;
	}

	public Short getIndicadorSazonalidade() {
		return indicadorSazonalidade;
	}

	public void setIndicadorSazonalidade(Short indicadorSazonalidade) {
		this.indicadorSazonalidade = indicadorSazonalidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public Integer getQuantidadeEconomias() {
		return quantidadeEconomias;
	}

	public void setQuantidadeEconomias(Integer quantidadeEconomias) {
		this.quantidadeEconomias = quantidadeEconomias;
	}
	
	@Override
	public Short getCategoriaFatorEconomias() {
		return this.categoria.getFatorEconomias();
	}
	
	@Override
	public ICategoria getSubcategoria(){
		return this;
	}
}
