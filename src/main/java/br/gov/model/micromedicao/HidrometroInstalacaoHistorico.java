package br.gov.model.micromedicao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.atendimentopublico.LigacaoAgua;
import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="hidrometro_inst_hist", schema="micromedicao")
public class HidrometroInstalacaoHistorico implements Serializable{
	private static final long serialVersionUID = 3683359932766035603L;

	@Id
	@Column(name = "hidi_id")
	private Integer id;
	
	@Column(name="medt_id")
	private Integer medicaoTipo;
	
	@Column(name="hidi_dtinstalacaohidrometro")
	@Temporal(TemporalType.DATE)
	private Date dataInstalacao;
	
	@Column(name="hidi_dtretiradahidrometro")
	@Temporal(TemporalType.DATE)
	private Date dataRetirada;
	
	@Column(name="hidi_nnleitinstalacaohidmt")
	private Integer numeroLeituraInstalacao;
	
	@Column(name="rttp_id")
	private Integer rateioTipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lagu_id")
	private LigacaoAgua ligacaoAgua;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hili_id")
	private HidrometroLocalInstalacao hidrometroLocalInstalacao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hipr_id")
	private HidrometroProtecao hidrometroProtecao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hidr_id")
	private Hidrometro hidrometro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	public HidrometroInstalacaoHistorico() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMedicaoTipo() {
		return medicaoTipo;
	}

	public void setMedicaoTipo(Integer medicaoTipo) {
		this.medicaoTipo = medicaoTipo;
	}

	public Integer getRateioTipo() {
		return rateioTipo;
	}

	public void setRateioTipo(Integer rateioTipo) {
		this.rateioTipo = rateioTipo;
	}

	public LigacaoAgua getLigacaoAgua() {
		return ligacaoAgua;
	}

	public void setLigacaoAgua(LigacaoAgua ligacaoAgua) {
		this.ligacaoAgua = ligacaoAgua;
	}

	public HidrometroLocalInstalacao getHidrometroLocalInstalacao() {
		return hidrometroLocalInstalacao;
	}

	public void setHidrometroLocalInstalacao(HidrometroLocalInstalacao hidrometroLocalInstalacao) {
		this.hidrometroLocalInstalacao = hidrometroLocalInstalacao;
	}

	public HidrometroProtecao getHidrometroProtecao() {
		return hidrometroProtecao;
	}

	public void setHidrometroProtecao(HidrometroProtecao hidrometroProtecao) {
		this.hidrometroProtecao = hidrometroProtecao;
	}

	public Hidrometro getHidrometro() {
		return hidrometro;
	}

	public void setHidrometro(Hidrometro hidrometro) {
		this.hidrometro = hidrometro;
	}

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Integer getNumeroLeituraInstalacao() {
		return numeroLeituraInstalacao;
	}

	public void setNumeroLeituraInstalacao(Integer numeroLeituraInstalacao) {
		this.numeroLeituraInstalacao = numeroLeituraInstalacao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public String toString() {
		return "HidrometroInstalacaoHistorico [id=" + id + "]";
	}
}