package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.Status;
import br.gov.model.micromedicao.LeituraAnormalidadeConsumo;
import br.gov.model.micromedicao.LeituraAnormalidadeLeitura;

@Entity
@Table(name="fatur_situacao_tipo", schema="faturamento")
public class FaturamentoSituacaoTipo {
	
	@Id
	@Column(name="ftst_id")
	private Integer id;
	
    @Column(name="ftst_icfaturamentoparalisacao")
	private Short paralisacaoFaturamento;

    @Column(name="ftst_icleituraparalisacao")
	private Short paralisacaoLeitura;
    
    @Column(name="ftst_icvalidoagua")
    private Short validoAgua;
    
    @Column(name="ftst_icvalidoesgoto")
    private Short validoEsgoto;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lacs_idconsacobrarcomleit")
	private LeituraAnormalidadeConsumo leituraAnormalidadeConsumoComLeitura;
	
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lacs_idconsacobrarsemleit")
	private LeituraAnormalidadeConsumo leituraAnormalidadeConsumoSemLeitura;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lalt_idleitafaturarcomleit")
	private LeituraAnormalidadeLeitura leituraAnormalidadeLeituraComLeitura;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lalt_idleitafaturarsemleit")
	private LeituraAnormalidadeLeitura leituraAnormalidadeLeituraSemLeitura;
    
    public FaturamentoSituacaoTipo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getParalisacaoFaturamento() {
		return paralisacaoFaturamento;
	}

	public void setParalisacaoFaturamento(Short paralisacaoFaturamento) {
		this.paralisacaoFaturamento = paralisacaoFaturamento;
	}
	
	public Short getParalisacaoLeitura() {
		return paralisacaoLeitura;
	}

	public void setParalisacaoLeitura(Short paralisacaoLeitura) {
		this.paralisacaoLeitura = paralisacaoLeitura;
	}

	public Short getValidoAgua() {
		return validoAgua;
	}

	public void setValidoAgua(Short validoAgua) {
		this.validoAgua = validoAgua;
	}

	public Short getValidoEsgoto() {
		return validoEsgoto;
	}

	public void setValidoEsgoto(Short validoEsgoto) {
		this.validoEsgoto= validoEsgoto;
	}
	
	public LeituraAnormalidadeConsumo getLeituraAnormalidadeConsumoComLeitura() {
		return leituraAnormalidadeConsumoComLeitura;
	}

	public void setLeituraAnormalidadeConsumoComLeitura(LeituraAnormalidadeConsumo leituraAnormalidadeConsumoComLeitura) {
		this.leituraAnormalidadeConsumoComLeitura = leituraAnormalidadeConsumoComLeitura;
	}

	public LeituraAnormalidadeConsumo getLeituraAnormalidadeConsumoSemLeitura() {
		return leituraAnormalidadeConsumoSemLeitura;
	}

	public void setLeituraAnormalidadeConsumoSemLeitura(LeituraAnormalidadeConsumo leituraAnormalidadeConsumoSemLeitura) {
		this.leituraAnormalidadeConsumoSemLeitura = leituraAnormalidadeConsumoSemLeitura;
	}

	public LeituraAnormalidadeLeitura getLeituraAnormalidadeLeituraComLeitura() {
		return leituraAnormalidadeLeituraComLeitura;
	}

	public void setLeituraAnormalidadeLeituraComLeitura(LeituraAnormalidadeLeitura leituraAnormalidadeLeituraComLeitura) {
		this.leituraAnormalidadeLeituraComLeitura = leituraAnormalidadeLeituraComLeitura;
	}

	public LeituraAnormalidadeLeitura getLeituraAnormalidadeLeituraSemLeitura() {
		return leituraAnormalidadeLeituraSemLeitura;
	}

	public void setLeituraAnormalidadeLeituraSemLeitura(LeituraAnormalidadeLeitura leituraAnormalidadeLeituraSemLeitura) {
		this.leituraAnormalidadeLeituraSemLeitura = leituraAnormalidadeLeituraSemLeitura;
	}

	public String toString() {
		return "FaturamentoSituacaoTipo [id=" + id + ", paralisacaoFaturamento=" + paralisacaoFaturamento + ", validoAgua="	+ validoAgua + "]";
	}
	
	public boolean paralisacaoFaturamentoAtivo() {
		return paralisacaoFaturamento != null  && paralisacaoFaturamento == Status.ATIVO.getId();
	}
	
	public boolean paralisacaoFaturamentoAgua() {
		return paralisacaoFaturamentoAtivo() && validoAgua == Status.ATIVO.getId();
	}
	
	public boolean paralisacaoFaturamentoEsgoto() {
		return paralisacaoFaturamentoAtivo() && validoEsgoto == Status.ATIVO.getId();
	}
}
