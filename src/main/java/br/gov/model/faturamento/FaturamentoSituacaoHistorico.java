package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(name="ftsh_nnconsumoaguamedido")
	private Integer consumoAguaMedido;
	
	@Column(name="ftsh_nnconsumoaguanaomedido")
	private Integer consumoAguaNaoMedido;
	
	
	@Column(name="ftsh_nnvolumeesgotomedido")
	private Integer volumeEsgotoMedido;
	
	
	@Column(name="ftsh_nnvolumeesgotonaomedido")
	private Integer volumeEsgotoNaoMedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
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

	public Integer getConsumoAguaMedido() {
		return consumoAguaMedido;
	}

	public void setConsumoAguaMedido(Integer consumoAguaMedido) {
		this.consumoAguaMedido = consumoAguaMedido;
	}

	public Integer getConsumoAguaNaoMedido() {
		return consumoAguaNaoMedido;
	}

	public void setConsumoAguaNaoMedido(Integer consumoAguaNaoMedido) {
		this.consumoAguaNaoMedido = consumoAguaNaoMedido;
	}

	public Integer getVolumeEsgotoMedido() {
		return volumeEsgotoMedido;
	}

	public void setVolumeEsgotoMedido(Integer volumeEsgotoMedido) {
		this.volumeEsgotoMedido = volumeEsgotoMedido;
	}

	public Integer getVolumeEsgotoNaoMedido() {
		return volumeEsgotoNaoMedido;
	}

	public void setVolumeEsgotoNaoMedido(Integer volumeEsgotoNaoMedido) {
		this.volumeEsgotoNaoMedido = volumeEsgotoNaoMedido;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	
	public String toString() {
		return "FaturamentoSituacaoHistorico [id=" + id + ", anoMesFaturamentoSituacaoInicio=" + anoMesFaturamentoSituacaoInicio
				+ ", anoMesFaturamentoSituacaoFim=" + anoMesFaturamentoSituacaoFim + ", anoMesFaturamentoRetirada=" + anoMesFaturamentoRetirada + "]";
	}
}
