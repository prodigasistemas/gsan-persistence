package br.gov.servicos.to;

import java.io.Serializable;
import java.math.BigDecimal;

import br.gov.model.cadastro.Categoria;
import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.Subcategoria;

public class ImovelSubcategoriaTO implements Serializable, ICategoria{
	private static final long serialVersionUID = 2664222681959912779L;
	
	private Integer categoriaId;
	private String categoriaDescricao;
	private Integer consumoEstouro;
	private BigDecimal vezesMediaEstouro;
	private Integer subcategoriaQuantidadeEconomias;
	private Integer imovelId;
	private Integer consumoAlto;
	private Integer mediaBaixoConsumo;
	private BigDecimal vezesMediaAltoConsumo;
	private BigDecimal porcentagemMediaBaixoConsumo;
	private String categoriaDescricaoAbreviada;
	private Integer numeroConsumoMaximoEc;
	private Short indicadorCobrancaAcrescimos;
	private Short fatorEconomias;
	private Short categoriaTipoId;
	
	private Integer subcategoriaId;
	private Integer codigo;
	private String subcategoriaDescricao;
	private String subcategoriaDescricaoAbreviada;
	private String codigoTarifaSocial;
	private Short numeroFatorFiscalizacao;
	private Short numeroIndicadorTarifaConsumo;
	private Short indicadorSazonalidade;
	
	private Integer categoriaQuantidadeEconomias;
	
	private String categoriaTipoDescricao;
	
	public ImovelSubcategoriaTO(){}
	
	
	public ImovelSubcategoriaTO(Integer categoriaId, String categoriaDescricao, Integer consumoEstouro, BigDecimal vezesMediaEstouro,
			Integer subcategoriaQuantidadeEconomias, Integer imovelId, Integer consumoAlto, Integer mediaBaixoConsumo, BigDecimal vezesMediaAltoConsumo,
			BigDecimal porcentagemMediaBaixoConsumo, String categoriaDescricaoAbreviada, Integer numeroConsumoMaximoEc, Short indicadorCobrancaAcrescimos,
			Short fatorEconomias, Short categoriaTipoId) {
		this.categoriaId = categoriaId;
		this.categoriaDescricao = categoriaDescricao;
		this.consumoEstouro = consumoEstouro;
		this.vezesMediaEstouro = vezesMediaEstouro;
		this.subcategoriaQuantidadeEconomias = subcategoriaQuantidadeEconomias;
		this.imovelId = imovelId;
		this.consumoAlto = consumoAlto;
		this.mediaBaixoConsumo = mediaBaixoConsumo;
		this.vezesMediaAltoConsumo = vezesMediaAltoConsumo;
		this.porcentagemMediaBaixoConsumo = porcentagemMediaBaixoConsumo;
		this.categoriaDescricaoAbreviada = categoriaDescricaoAbreviada;
		this.numeroConsumoMaximoEc = numeroConsumoMaximoEc;
		this.indicadorCobrancaAcrescimos = indicadorCobrancaAcrescimos;
		this.fatorEconomias = fatorEconomias;
		this.categoriaTipoId = categoriaTipoId;
	}


	public void setId(Integer id){
		setCategoriaId(id);
		setSubcategoriaId(id);
	}
	
	public Integer getId(){
		if (getSubcategoriaId() == null) {
			return getCategoriaId();
		} else {
			return getSubcategoriaId();
		}
	}

	public Integer getSubcategoriaId() {
		return subcategoriaId;
	}

	public void setSubcategoriaId(Integer subcategoriaId) {
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
			return getSubcategoriaQuantidadeEconomias().intValue();
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

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
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
	
	public Short getCategoriaFatorEconomias() {
		return getFatorEconomias();
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

	public Short getCategoriaTipoId() {
		return categoriaTipoId;
	}

	public void setCategoriaTipoId(Short categoriaTipoId) {
		this.categoriaTipoId = categoriaTipoId;
	}

	public String getCategoriaTipoDescricao() {
		return categoriaTipoDescricao;
	}

	public void setCategoriaTipoDescricao(String categoriaTipoDescricao) {
		this.categoriaTipoDescricao = categoriaTipoDescricao;
	}

	public Integer getImovelId() {
		return imovelId;
	}

	public void setImovelId(Integer imovelId) {
		this.imovelId = imovelId;
	}

	public ICategoria getCategoria() {
		return getICategoria();
	}

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
