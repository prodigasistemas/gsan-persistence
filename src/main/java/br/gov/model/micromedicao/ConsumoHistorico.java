package br.gov.model.micromedicao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="consumo_historico", schema="micromedicao")
public class ConsumoHistorico implements Serializable, Comparable<ConsumoHistorico>{
	private static final long serialVersionUID = 6182290473352810480L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONSUMO_HISTORICO")
	@SequenceGenerator(name="SEQ_CONSUMO_HISTORICO", schema="micromedicao", sequenceName="seq_consumo_historico", allocationSize=1)
	@Column(name="cshi_id")
	private Integer id;

	@Column(name="cshi_amfaturamento")
	private Integer referenciaFaturamento;
	
	@Column(name="cshi_nnconsumocalculomedia")
	private Integer numeroConsumoCalculoMedia;
	
	@Column(name="lgti_id")
	private Integer ligacaoTipo;
	
	@Column(name="cshi_icaltultimosconss")
	private Short indicadorAlteracaoUltimosConsumos;
	
	@Column(name="cshi_icajuste")
	private Short indicadorAjuste;
	
	@Column(name="cshi_nnconsumofaturadomes")
	private Integer numeroConsumoFaturadoMes;
	
	@Column(name="cshi_nnconsumorateio")
	private Integer consumoRateio;
	
	@Column(name="cshi_icimovelcondominio")
	private Short indicadorImovelCondominio;
	
	@Column(name="cshi_nnconsumomedio")
	private Integer consumoMedio;
	
	@Column(name="cshi_nnconsumominimo")
	private Integer consumoMinimo;
	
	@Column(name="cshi_icfaturamento")
	private Short indicadorFaturamento;
	
	@Column(name="cshi_pccoleta")
	private BigDecimal percentualColeta;
	
	@Column(name="cshi_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="cshi_idconsumoimovelcondominio")
	private Integer consumoImovelCondominio;
	
	@Column(name="cshi_nnconsimoveisvinculados")
	private Integer consumoImovelVinculadosCondominio;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="csan_id")
	private ConsumoAnormalidade consumoAnormalidade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cstp_id")
	private ConsumoTipo consumoTipo;
	
	public ConsumoHistorico(){}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReferenciaFaturamento() {
		return referenciaFaturamento;
	}

	public void setReferenciaFaturamento(Integer referenciaFaturamento) {
		this.referenciaFaturamento = referenciaFaturamento;
	}

	public Integer getNumeroConsumoCalculoMedia() {
		return numeroConsumoCalculoMedia;
	}

	public void setNumeroConsumoCalculoMedia(Integer numeroConsumoCalculoMedia) {
		this.numeroConsumoCalculoMedia = numeroConsumoCalculoMedia;
	}

	public Integer getLigacaoTipo() {
		return ligacaoTipo;
	}

	public void setLigacaoTipo(Integer ligacaoTipo) {
		this.ligacaoTipo = ligacaoTipo;
	}

	public Short getIndicadorAlteracaoUltimosConsumos() {
		return indicadorAlteracaoUltimosConsumos;
	}

	public void setIndicadorAlteracaoUltimosConsumos(Short indicadorAlteracaoUltimosConsumos) {
		this.indicadorAlteracaoUltimosConsumos = indicadorAlteracaoUltimosConsumos;
	}

	public Short getIndicadorAjuste() {
		return indicadorAjuste;
	}

	public void setIndicadorAjuste(Short indicadorAjuste) {
		this.indicadorAjuste = indicadorAjuste;
	}

	public Integer getNumeroConsumoFaturadoMes() {
		return numeroConsumoFaturadoMes;
	}

	public void setNumeroConsumoFaturadoMes(Integer numeroConsumoFaturadoMes) {
		this.numeroConsumoFaturadoMes = numeroConsumoFaturadoMes;
	}

	public Integer getConsumoRateio() {
		return consumoRateio;
	}

	public void setConsumoRateio(Integer consumoRateio) {
		this.consumoRateio = consumoRateio;
	}

	public Short getIndicadorImovelCondominio() {
		return indicadorImovelCondominio;
	}

	public void setIndicadorImovelCondominio(Short indicadorImovelCondominio) {
		this.indicadorImovelCondominio = indicadorImovelCondominio;
	}

	public Integer getConsumoMedio() {
		return consumoMedio;
	}

	public void setConsumoMedio(Integer consumoMedio) {
		this.consumoMedio = consumoMedio;
	}

	public Integer getConsumoMinimo() {
		return consumoMinimo;
	}

	public void setConsumoMinimo(Integer consumoMinimo) {
		this.consumoMinimo = consumoMinimo;
	}

	public Short getIndicadorFaturamento() {
		return indicadorFaturamento;
	}

	public void setIndicadorFaturamento(Short indicadorFaturamento) {
		this.indicadorFaturamento = indicadorFaturamento;
	}

	public BigDecimal getPercentualColeta() {
		return percentualColeta;
	}

	public void setPercentualColeta(BigDecimal percentualColeta) {
		this.percentualColeta = percentualColeta;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Integer getConsumoImovelCondominio() {
		return consumoImovelCondominio;
	}

	public void setConsumoImovelCondominio(Integer consumoImovelCondominio) {
		this.consumoImovelCondominio = consumoImovelCondominio;
	}

	public Integer getConsumoImovelVinculadosCondominio() {
		return consumoImovelVinculadosCondominio;
	}

	public void setConsumoImovelVinculadosCondominio(Integer consumoImovelVinculadosCondominio) {
		this.consumoImovelVinculadosCondominio = consumoImovelVinculadosCondominio;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public ConsumoAnormalidade getConsumoAnormalidade() {
		return consumoAnormalidade;
	}

	public void setConsumoAnormalidade(ConsumoAnormalidade consumoAnormalidade) {
		this.consumoAnormalidade = consumoAnormalidade;
	}

	public ConsumoTipo getConsumoTipo() {
		return consumoTipo;
	}

	public void setConsumoTipo(ConsumoTipo consumoTipo) {
		this.consumoTipo = consumoTipo;
	}

	public int compareTo(ConsumoHistorico o) {
		if (this.getReferenciaFaturamento() != null && o.getReferenciaFaturamento() != null){
			return - referenciaFaturamento.compareTo(o.getReferenciaFaturamento());
		}
		return 0;
	}

	public String toString() {
		return "ConsumoHistorico [id=" + id + ", referenciaFaturamento=" + referenciaFaturamento + "]";
	}
}
