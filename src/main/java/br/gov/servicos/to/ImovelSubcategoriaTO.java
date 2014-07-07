package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

import br.gov.model.cadastro.Categoria;
import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.Subcategoria;

public class ImovelSubcategoriaTO implements Serializable, ICategoria{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2664222681959912779L;
	
	private Long subcategoriaId;
	private Integer codigo;
	private String subcategoriaDescricao;
	private String subcategoriaDescricaoAbreviada;
	private Integer subcategoriaQuantidadeEconomias;
	private String codigoTarifaSocial;
	private Short numeroFatorFiscalizacao;
	private Short numeroIndicadorTarifaConsumo;
	private Short indicadorSazonalidade;
	
	private Long categoriaId;
	private String categoriaDescricao;
	private String categoriaDescricaoAbreviada;
	private Short fatorEconomias;
	private Integer consumoEstouro;
	private BigDecimal vezesMediaEstouro;
	private Integer categoriaQuantidadeEconomias;
	private Integer consumoAlto;
	private Integer mediaBaixoConsumo;
	private BigDecimal vezesMediaAltoConsumo;
	private BigDecimal porcentagemMediaBaixoConsumo;
	private Integer numeroConsumoMaximoEc;
	private Short indicadorCobrancaAcrescimos;
	
	private Long categoriaTipoId;
	private String categoriaTipoDescricao;
	
	private Long imovelId;
	
	public ImovelSubcategoriaTO(){}
	
	public void setId(Long id){
		setCategoriaId(id);
		setSubcategoriaId(id);
	}
	
	public Long getId(){
		if (getSubcategoriaId() == null) {
			return getCategoriaId();
		} else {
			return getSubcategoriaId();
		}
	}

	public Long getSubcategoriaId() {
		return subcategoriaId;
	}

	public void setSubcategoriaId(Long subcategoriaId) {
		this.subcategoriaId = subcategoriaId;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao(){
		if (getSubcategoriaDescricao() == null) {
			return getCategoriaDescricao();
		} else {
			return getSubcategoriaDescricao();
		}
	}

	public String getSubcategoriaDescricao() {
		return subcategoriaDescricao;
	}

	public void setSubcategoriaDescricao(String subcategoriaDescricao) {
		this.subcategoriaDescricao = subcategoriaDescricao;
	}

	public String getDescricaoAbreviada(){
		if (getSubcategoriaDescricaoAbreviada() == null) {
			return getCategoriaDescricaoAbreviada();
		} else {
			return getSubcategoriaDescricaoAbreviada();
		}
	}
	
	public String getSubcategoriaDescricaoAbreviada() {
		return subcategoriaDescricaoAbreviada;
	}

	public void setSubcategoriaDescricaoAbreviada(String subcategoriaDescricaoAbreviada) {
		this.subcategoriaDescricaoAbreviada = subcategoriaDescricaoAbreviada;
	}
	
	public Integer getQuantidadeEconomias(){
		if (getSubcategoriaQuantidadeEconomias() == null) {
			return getCategoriaQuantidadeEconomias();
		} else {
			return getSubcategoriaQuantidadeEconomias();
		}
	}

	public Integer getSubcategoriaQuantidadeEconomias() {
		return subcategoriaQuantidadeEconomias;
	}

	public void setSubcategoriaQuantidadeEconomias(Integer subcategoriaQuantidadeEconomias) {
		this.subcategoriaQuantidadeEconomias = subcategoriaQuantidadeEconomias;
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

	public Short getNumeroIndicadorTarifaConsumo() {
		return numeroIndicadorTarifaConsumo;
	}

	public void setNumeroIndicadorTarifaConsumo(Short numeroIndicadorTarifaConsumo) {
		this.numeroIndicadorTarifaConsumo = numeroIndicadorTarifaConsumo;
	}

	public Short getIndicadorSazonalidade() {
		return indicadorSazonalidade;
	}

	public void setIndicadorSazonalidade(Short indicadorSazonalidade) {
		this.indicadorSazonalidade = indicadorSazonalidade;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getCategoriaDescricao() {
		return categoriaDescricao;
	}

	public void setCategoriaDescricao(String categoriaDescricao) {
		this.categoriaDescricao = categoriaDescricao;
	}

	public String getCategoriaDescricaoAbreviada() {
		return categoriaDescricaoAbreviada;
	}

	public void setCategoriaDescricaoAbreviada(String categoriaDescricaoAbreviada) {
		this.categoriaDescricaoAbreviada = categoriaDescricaoAbreviada;
	}

	public Short getFatorEconomias() {
		return fatorEconomias;
	}

	public void setFatorEconomias(Short fatorEconomias) {
		this.fatorEconomias = fatorEconomias;
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

	public Integer getCategoriaQuantidadeEconomias() {
		return categoriaQuantidadeEconomias;
	}

	public void setCategoriaQuantidadeEconomias(Integer categoriaQuantidadeEconomias) {
		this.categoriaQuantidadeEconomias = categoriaQuantidadeEconomias;
	}

	public Integer getConsumoAlto() {
		return consumoAlto;
	}

	public void setConsumoAlto(Integer consumoAlto) {
		this.consumoAlto = consumoAlto;
	}

	public Integer getMediaBaixoConsumo() {
		return mediaBaixoConsumo;
	}

	public void setMediaBaixoConsumo(Integer mediaBaixoConsumo) {
		this.mediaBaixoConsumo = mediaBaixoConsumo;
	}

	public BigDecimal getVezesMediaAltoConsumo() {
		return vezesMediaAltoConsumo;
	}

	public void setVezesMediaAltoConsumo(BigDecimal vezesMediaAltoConsumo) {
		this.vezesMediaAltoConsumo = vezesMediaAltoConsumo;
	}

	public BigDecimal getPorcentagemMediaBaixoConsumo() {
		return porcentagemMediaBaixoConsumo;
	}

	public void setPorcentagemMediaBaixoConsumo(BigDecimal porcentagemMediaBaixoConsumo) {
		this.porcentagemMediaBaixoConsumo = porcentagemMediaBaixoConsumo;
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

	public Long getCategoriaTipoId() {
		return categoriaTipoId;
	}

	public void setCategoriaTipoId(Long categoriaTipoId) {
		this.categoriaTipoId = categoriaTipoId;
	}

	public String getCategoriaTipoDescricao() {
		return categoriaTipoDescricao;
	}

	public void setCategoriaTipoDescricao(String categoriaTipoDescricao) {
		this.categoriaTipoDescricao = categoriaTipoDescricao;
	}

	public Long getImovelId() {
		return imovelId;
	}

	public void setImovelId(Long imovelId) {
		this.imovelId = imovelId;
	}

	@Override
	public ICategoria getCategoria() {
		return getICategoria();
	}

	@Override
	public ICategoria getSubcategoria() {
		return getICategoria();
	}
	
	private ICategoria getICategoria(){
		if(subcategoriaId != null){
			ICategoria subcategoria = new Subcategoria();
			subcategoria.setId(subcategoriaId);
			return subcategoria;
		} else {
			ICategoria categoria = new Categoria();
			categoria.setId(categoriaId);
			return categoria;
		}
	}
}
