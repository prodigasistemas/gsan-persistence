package br.gov.model.cobranca;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.Status;
import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="parcelamento", schema="cobranca")
public class Parcelamento {
	
	@Id
	@Column(name="parc_id")
	private Integer id;
	
	@Column(name="parc_amreferenciafaturamento")
	private Integer anoMesReferenciaFaturamento;
	
	@Column(name="pcst_id")
	private Integer situacao;
	
	@Column(name="parc_vlentrada")
	private BigDecimal valorEntrada;
	
	@Column(name="parc_icconfirmacao")
	private Short indicadorConfirmacaoParcelamento;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	public Parcelamento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesReferenciaFaturamento() {
		return anoMesReferenciaFaturamento;
	}

	public void setAnoMesReferenciaFaturamento(Integer anoMesReferenciaFaturamento) {
		this.anoMesReferenciaFaturamento = anoMesReferenciaFaturamento;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Short getIndicadorConfirmacaoParcelamento() {
		return indicadorConfirmacaoParcelamento;
	}

	public void setIndicadorConfirmacaoParcelamento(Short indicadorConfirmacaoParcelamento) {
		this.indicadorConfirmacaoParcelamento = indicadorConfirmacaoParcelamento;
	}

	public String toString() {
		return "Parcelamento [anoMesReferenciaFaturamento=" + anoMesReferenciaFaturamento + "]";
	}

	public boolean semEntrada() {
		return valorEntrada == null || valorEntrada.equals(BigDecimal.ZERO);
	}

	public boolean confirmado() {
		return indicadorConfirmacaoParcelamento != null && indicadorConfirmacaoParcelamento.shortValue() == Status.ATIVO.getId();
	}
}
