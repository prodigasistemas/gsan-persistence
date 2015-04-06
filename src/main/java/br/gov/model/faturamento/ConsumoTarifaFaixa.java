package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consumo_tarifa_faixa", schema = "faturamento")
public class ConsumoTarifaFaixa implements Serializable {

	private static final long serialVersionUID = -348872108434297880L;

	@Id
	@Column(name = "ctfx_id")
	private Integer id;

	@Column(name = "ctfx_nncosumofaixainicio")
	private Integer numeroConsumoFaixaInicio;

	@Column(name = "ctfx_nnconsumofaixafim")
    private Integer numeroConsumoFaixaFim;

	@Column(name = "ctfx_vlconsumotarifa")
    private BigDecimal valorConsumoTarifa;

	@Column(name = "ctfx_tmultimaalteracao")
    private Date ultimaAlteracao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cstc_id")
	private ConsumoTarifaCategoria consumoTarifaCategoria;
	
	public ConsumoTarifaFaixa() {}
	
	public ConsumoTarifaFaixa(
			Integer id,
			Integer numeroConsumoFaixaInicio,
			Integer numeroConsumoFaixaFim,
			BigDecimal valorConsumoTarifa,
			Date ultimaAlteracao,
			ConsumoTarifaCategoria consumoTarifaCategoria) {
		super();
		this.id = id;
		this.numeroConsumoFaixaInicio = numeroConsumoFaixaInicio;
		this.numeroConsumoFaixaFim = numeroConsumoFaixaFim;
		this.valorConsumoTarifa = valorConsumoTarifa;
		this.ultimaAlteracao = ultimaAlteracao;
		this.consumoTarifaCategoria = consumoTarifaCategoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroConsumoFaixaInicio() {
		return numeroConsumoFaixaInicio;
	}

	public void setNumeroConsumoFaixaInicio(Integer numeroConsumoFaixaInicio) {
		this.numeroConsumoFaixaInicio = numeroConsumoFaixaInicio;
	}

	public Integer getNumeroConsumoFaixaFim() {
		return numeroConsumoFaixaFim;
	}

	public void setNumeroConsumoFaixaFim(Integer numeroConsumoFaixaFim) {
		this.numeroConsumoFaixaFim = numeroConsumoFaixaFim;
	}

	public BigDecimal getValorConsumoTarifa() {
		return valorConsumoTarifa;
	}

	public void setValorConsumoTarifa(BigDecimal valorConsumoTarifa) {
		this.valorConsumoTarifa = valorConsumoTarifa;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
}
