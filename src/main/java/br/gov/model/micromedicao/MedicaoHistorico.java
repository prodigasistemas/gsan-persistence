package br.gov.model.micromedicao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.atendimentopublico.LigacaoAgua;
import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="medicao_historico", schema="micromedicao")
public class MedicaoHistorico implements Serializable{
	private static final long serialVersionUID = -4896352165985579067L;

	@Id
	@Column(name = "mdhi_id")
	private Integer id;
	
	@Column(name = "mdhi_amleitura")
	private Integer anoMesReferencia;
	
	@Column(name = "mdhi_nnleitantfatmt")
	private Integer leituraAnteriorFaturamento;

	@Column(name = "mdhi_nnleitantinformada")
	private Integer leituraAnteriorInformada;
	
	@Column(name = "mdhi_nnleituraatualfaturamento")
	private Integer leituraAtualFaturamento;
	
	@Column(name = "mdhi_nnleituraatualinformada")
	private Integer leituraAtualInformada;
	
	@Column(name = "ltst_idleiturasituacaoatual")
	private Integer leituraSituacaoAtual;
	
	@Column(name = "mdhi_nnconsumomediohidrometro")
	private Integer consumoMedioHidrometro;
	
	@Column(name="mdhi_dtleitantfatmt")
	@Temporal(TemporalType.DATE)
	private Date dataLeituraAnteriorFaturamento;
	
	@Column(name="mdhi_dtleituraatualfaturamento")
	@Temporal(TemporalType.DATE)
	private Date dataLeituraAtualFaturamento;
	
	@Column(name="mdhi_dtleituraatualinformada")
	@Temporal(TemporalType.DATE)
	private Date dataLeituraAtualInformada;
	
	@ManyToOne
	@JoinColumn(name="lagu_id")
	private LigacaoAgua ligacaoAgua;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name="ltan_idleitanormfatmt")
	private LeituraAnormalidade leituraAnormalidadeFaturamento;
	
	public MedicaoHistorico() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesReferencia() {
		return anoMesReferencia;
	}

	public void setAnoMesReferencia(Integer anoMesReferencia) {
		this.anoMesReferencia = anoMesReferencia;
	}

	public Integer getLeituraAnteriorFaturamento() {
		return leituraAnteriorFaturamento;
	}

	public void setLeituraAnteriorFaturamento(Integer leituraAnteriorFaturamento) {
		this.leituraAnteriorFaturamento = leituraAnteriorFaturamento;
	}

	public Integer getLeituraAnteriorInformada() {
		return leituraAnteriorInformada;
	}

	public void setLeituraAnteriorInformada(Integer leituraAnteriorInformada) {
		this.leituraAnteriorInformada = leituraAnteriorInformada;
	}
	
	public Integer getLeituraAtualFaturamento() {
		return leituraAtualFaturamento;
	}

	public void setLeituraAtualFaturamento(Integer leituraAtualFaturamento) {
		this.leituraAtualFaturamento = leituraAtualFaturamento;
	}

	public Integer getLeituraAtualInformada() {
		return leituraAtualInformada;
	}

	public void setLeituraAtualInformada(Integer leituraAtualInformada) {
		this.leituraAtualInformada = leituraAtualInformada;
	}

	public Integer getLeituraSituacaoAtual() {
		return leituraSituacaoAtual;
	}

	public void setLeituraSituacaoAtual(Integer leituraSituacaoAtual) {
		this.leituraSituacaoAtual = leituraSituacaoAtual;
	}

	public Integer getConsumoMedioHidrometro() {
		return consumoMedioHidrometro;
	}

	public void setConsumoMedioHidrometro(Integer consumoMedioHidrometro) {
		this.consumoMedioHidrometro = consumoMedioHidrometro;
	}

	public Date getDataLeituraAnteriorFaturamento() {
		return dataLeituraAnteriorFaturamento;
	}

	public void setDataLeituraAnteriorFaturamento(Date dataLeituraAnteriorFaturamento) {
		this.dataLeituraAnteriorFaturamento = dataLeituraAnteriorFaturamento;
	}

	public Date getDataLeituraAtualFaturamento() {
		return dataLeituraAtualFaturamento;
	}

	public void setDataLeituraAtualFaturamento(Date dataLeituraAtualFaturamento) {
		this.dataLeituraAtualFaturamento = dataLeituraAtualFaturamento;
	}

	public Date getDataLeituraAtualInformada() {
		return dataLeituraAtualInformada;
	}

	public void setDataLeituraAtualInformada(Date dataLeituraAtualInformada) {
		this.dataLeituraAtualInformada = dataLeituraAtualInformada;
	}

	public LigacaoAgua getLigacaoAgua() {
		return ligacaoAgua;
	}

	public void setLigacaoAgua(LigacaoAgua ligacaoAgua) {
		this.ligacaoAgua = ligacaoAgua;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public LeituraAnormalidade getLeituraAnormalidadeFaturamento() {
		return leituraAnormalidadeFaturamento;
	}

	public void setLeituraAnormalidadeFaturamento(LeituraAnormalidade leituraAnormalidadeFaturamento) {
		this.leituraAnormalidadeFaturamento = leituraAnormalidadeFaturamento;
	}

	public String toString() {
		return "MedicaoHistorico [id=" + id + "]";
	}

}