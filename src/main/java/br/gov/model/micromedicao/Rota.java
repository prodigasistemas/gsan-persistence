package br.gov.model.micromedicao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javassist.expr.Instanceof;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.Status;
import br.gov.model.cadastro.Empresa;
import br.gov.model.faturamento.FaturamentoGrupo;


@Entity
@Table(name="rota", schema="micromedicao")
public class Rota implements Serializable {
	private static final long serialVersionUID = 3490871292616360289L;
	
	@Id
	@Column(name="rota_id")
	private Integer id;
	
	@Column(name="rota_cdrota")
	private Short codigo;
	
	@Column(name="lttp_id")
	private Integer leituraTipo;
	
	@Column(name="rota_icalternativa")
	private Short indicadorRotaAlternativa;
	
	@Column(name="rota_icfaixafalsageracao")
	private Short indicadorGerarFalsaFaixa;

	@ManyToOne
	@JoinColumn(name="ftgr_id")
	private FaturamentoGrupo faturamentoGrupo;
	
	@ManyToOne
	@JoinColumn(name="leit_id")
	private Leiturista leiturista;
	
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;
	
	@Column(name="rota_pcfaixafalsageracao")
	private BigDecimal percentualGeracaoFaixaFalsa;
	
	@Column(name="rota_nndiasconsumoajuste")
	private Integer numeroDiasConsumoAjuste;
	
	@Column(name="rota_dtleituraajuste")
	private Date dataAjusteLeitura;
	
	@Column(name="rota_icconsumoajuste")
	private Short indicadorAjusteConsumo;

	@Column(name="rota_ictransmissaooffline")
	private Short indicadorTransmissaoOffline;
	
	@Column(name="rota_icseqleitura")
	private Integer indicadorSequencialLeitura;

	public Rota() {
	}

	public boolean alternativa() {
		return indicadorRotaAlternativa != null && indicadorRotaAlternativa == Status.ATIVO.getId();
	}

/**********************************************
 ************ GETTERS AND SETTERS ************* 
 **********************************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLeituraTipo() {
		return leituraTipo;
	}

	public void setLeituraTipo(Integer leituraTipo) {
		this.leituraTipo = leituraTipo;
	}
	
	public Short getIndicadorRotaAlternativa() {
		return indicadorRotaAlternativa;
	}

	public void setIndicadorRotaAlternativa(Short indicadorRotaAlternativa) {
		this.indicadorRotaAlternativa = indicadorRotaAlternativa;
	}
	
	public boolean isAlternativa(){
		return indicadorRotaAlternativa != null && indicadorRotaAlternativa == (short) 1;
	}

	public Short getIndicadorGerarFalsaFaixa() {
		return indicadorGerarFalsaFaixa;
	}

	public void setIndicadorGerarFalsaFaixa(Short indicadorGerarFalsaFaixa) {
		this.indicadorGerarFalsaFaixa = indicadorGerarFalsaFaixa;
	}

	public FaturamentoGrupo getFaturamentoGrupo() {
		return faturamentoGrupo;
	}

	public void setFaturamentoGrupo(FaturamentoGrupo faturamentoGrupo) {
		this.faturamentoGrupo = faturamentoGrupo;
	}

	public Leiturista getLeiturista() {
		return leiturista;
	}

	public void setLeiturista(Leiturista leiturista) {
		this.leiturista = leiturista;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Short getCodigo() {
		return codigo;
	}

	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}
	
	public BigDecimal getPercentualGeracaoFaixaFalsa() {
		return percentualGeracaoFaixaFalsa;
	}

	public void setPercentualGeracaoFaixaFalsa(BigDecimal percentualGeracaoFaixaFalsa) {
		this.percentualGeracaoFaixaFalsa = percentualGeracaoFaixaFalsa;
	}

	public String toString() {
		return "Rota [id=" + id + "]";
	}
	
	public boolean possuiPercentualFaixaFalsa() {
		return percentualGeracaoFaixaFalsa != null && !percentualGeracaoFaixaFalsa.equals(new BigDecimal(0.0));
	}

	public Integer getNumeroDiasConsumoAjuste() {
		return numeroDiasConsumoAjuste;
	}

	public void setNumeroDiasConsumoAjuste(Integer numeroDiasConsumoAjuste) {
		this.numeroDiasConsumoAjuste = numeroDiasConsumoAjuste;
	}

	public Date getDataAjusteLeitura() {
		return dataAjusteLeitura;
	}

	public void setDataAjusteLeitura(Date dataAjusteLeitura) {
		this.dataAjusteLeitura = dataAjusteLeitura;
	}

	public Short getIndicadorAjusteConsumo() {
		return indicadorAjusteConsumo;
	}

	public void setIndicadorAjusteConsumo(Short indicadorAjusteConsumo) {
		this.indicadorAjusteConsumo = indicadorAjusteConsumo;
	}

	public Short getIndicadorTransmissaoOffline() {
		return indicadorTransmissaoOffline;
	}

	public void setIndicadorTransmissaoOffline(Short indicadorTransmissaoOffline) {
		this.indicadorTransmissaoOffline = indicadorTransmissaoOffline;
	}

	public Integer getIndicadorSequencialLeitura() {
		return indicadorSequencialLeitura;
	}

	public void setIndicadorSequencialLeitura(Integer indicadorSequencialLeitura) {
		this.indicadorSequencialLeitura = indicadorSequencialLeitura;
	}
}