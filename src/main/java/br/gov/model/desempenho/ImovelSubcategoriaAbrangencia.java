package br.gov.model.desempenho;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.cadastro.ICategoria;
import br.gov.model.cadastro.Imovel;
import br.gov.model.cadastro.Subcategoria;

@Entity
@Table(name="imovel_subcategoria_abrangencia", schema="desempenho")
public class ImovelSubcategoriaAbrangencia implements Serializable, ICategoria {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_IMOVEL_SUBCATEGORIA_ABRANGENCIA")
	@SequenceGenerator(name="SEQ_IMOVEL_SUBCATEGORIA_ABRANGENCIA", schema="desempenho", sequenceName="seq_imovel_subcategoria_abrangencia", allocationSize=1)
	@Column(name="imsa_id")
	private Integer id;
	
	@Column(name="imsa_tmcriacao")
	private Date dataCriacao;
	
	@Column(name="imsa_tmultimaalteracao")
	private Date dataUltimaAlteracao;
	
	@Column(name="imsa_qteconomias")
	private Integer quantidadeEconomias;
	
	@ManyToOne
	@JoinColumn(name="scat_id")
	private Subcategoria subcategoria;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name="cmed_id")
	private ContratoMedicao contratoMedicao;
	
	public ImovelSubcategoriaAbrangencia(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	@Override
	public Integer getQuantidadeEconomias() {
		return quantidadeEconomias;
	}

	public void setQuantidadeEconomias(Integer quantidadeEconomias) {
		this.quantidadeEconomias = quantidadeEconomias;
	}

	@Override
	public ICategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public ContratoMedicao getContratoMedicao() {
		return contratoMedicao;
	}

	public void setContratoMedicao(ContratoMedicao contratoMedicao) {
		this.contratoMedicao = contratoMedicao;
	}

	@Override
	public ICategoria getCategoria() {
		return subcategoria.getCategoria();
	}

	@Override
	public String getCategoriaDescricao() {
		return subcategoria.getCategoriaDescricao();
	}

	@Override
	public String getCategoriaDescricaoAbreviada() {
		return subcategoria.getCategoriaDescricaoAbreviada();
	}

	@Override
	public String getSubcategoriaDescricao() {
		return subcategoria.getSubcategoriaDescricao();
	}

	@Override
	public String getSubcategoriaDescricaoAbreviada() {
		return subcategoria.getSubcategoriaDescricaoAbreviada();
	}

	@Override
	public Integer getCodigoSubcategoria() {
		return subcategoria.getCodigoSubcategoria();
	}

	@Override
	public Short getFatorEconomias() {
		return subcategoria.getFatorEconomias();
	}

	@Override
	public Integer getConsumoEstouro() {
		return subcategoria.getConsumoEstouro();
	}

	@Override
	public Integer getConsumoAlto() {
		return subcategoria.getConsumoAlto();
	}

	@Override
	public Integer getNumeroConsumoMaximoEc() {
		return subcategoria.getNumeroConsumoMaximoEc();
	}

	@Override
	public Integer getMediaBaixoConsumo() {
		return subcategoria.getMediaBaixoConsumo();
	}

	@Override
	public BigDecimal getVezesMediaAltoConsumo() {
		return subcategoria.getVezesMediaAltoConsumo();
	}

	@Override
	public BigDecimal getVezesMediaEstouro() {
		return subcategoria.getVezesMediaEstouro();
	}

	@Override
	public BigDecimal getPorcentagemMediaBaixoConsumo() {
		return subcategoria.getPorcentagemMediaBaixoConsumo();
	}

	@Override
	public Short getIndicadorCobrancaAcrescimos() {
		return subcategoria.getIndicadorCobrancaAcrescimos();
	}

	@Override
	public Integer getCategoriaTipo() {
		return subcategoria.getCategoriaTipo();
	}

	@Override
	public String getCodigoTarifaSocial() {
		return subcategoria.getCodigoTarifaSocial();
	}

	@Override
	public Short getNumeroFatorFiscalizacao() {
		return subcategoria.getNumeroFatorFiscalizacao();
	}

	@Override
	public Short getIndicadorTarifaConsumo() {
		return subcategoria.getIndicadorTarifaConsumo();
	}

	@Override
	public Short getIndicadorSazonalidade() {
		return subcategoria.getIndicadorSazonalidade();
	}
}
