package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="fatur_situacao_hist", schema="faturamento")
public class FaturamentoSituacaoHistorico {
	
	@Id
	@Column(name="ftsh_id")
	private Integer id;
	
	@Column(name="ftsh_amfatmtsitinicio")
    private Integer anoMesFaturamentoSituacaoInicio;

	@Column(name="ftsh_amfaturamentosituacaofim")
    private Integer anoMesFaturamentoSituacaoFim;

	@Column(name="ftsh_amfaturamentoretirada")
    private Integer anoMesFaturamentoRetirada;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	public FaturamentoSituacaoHistorico() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesFaturamentoSituacaoInicio() {
		return anoMesFaturamentoSituacaoInicio;
	}

	public void setAnoMesFaturamentoSituacaoInicio(Integer anoMesFaturamentoSituacaoInicio) {
		this.anoMesFaturamentoSituacaoInicio = anoMesFaturamentoSituacaoInicio;
	}

	public Integer getAnoMesFaturamentoSituacaoFim() {
		return anoMesFaturamentoSituacaoFim;
	}

	public void setAnoMesFaturamentoSituacaoFim(Integer anoMesFaturamentoSituacaoFim) {
		this.anoMesFaturamentoSituacaoFim = anoMesFaturamentoSituacaoFim;
	}

	public Integer getAnoMesFaturamentoRetirada() {
		return anoMesFaturamentoRetirada;
	}

	public void setAnoMesFaturamentoRetirada(Integer anoMesFaturamentoRetirada) {
		this.anoMesFaturamentoRetirada = anoMesFaturamentoRetirada;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	@Override
	public String toString() {
		return "FaturamentoSituacaoHistorico [id=" + id + ", anoMesFaturamentoSituacaoInicio=" + anoMesFaturamentoSituacaoInicio
				+ ", anoMesFaturamentoSituacaoFim=" + anoMesFaturamentoSituacaoFim + ", anoMesFaturamentoRetirada=" + anoMesFaturamentoRetirada + "]";
	}
}
