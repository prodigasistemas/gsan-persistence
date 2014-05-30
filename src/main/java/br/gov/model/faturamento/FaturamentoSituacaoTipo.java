package br.gov.model.faturamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.model.Status;

@Entity
@Table(name="fatur_situacao_tipo", schema="faturamento")
public class FaturamentoSituacaoTipo {
	
	@Id
	@Column(name="ftst_id")
	private Long id;
	
    @Column(name="ftst_icfaturamentoparalisacao")
	private short paralisacaoFaturamento;

    @Column(name="ftst_icvalidoagua")
    private short validoAgua;
    
    public FaturamentoSituacaoTipo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getParalisacaoFaturamento() {
		return Status.parse(paralisacaoFaturamento);
	}

	public void setParalisacaoFaturamento(Status paralisacaoFaturamento) {
		this.paralisacaoFaturamento = paralisacaoFaturamento.getId();
	}
	
	public Status getValidoAgua() {
		return Status.parse(validoAgua);
	}

	public void setvalidoAgua(Status validoAgua) {
		this.validoAgua = validoAgua.getId();
	}

	public String toString() {
		return "FaturamentoSituacaoTipo [id=" + id + ", paralisacaoFaturamento=" + paralisacaoFaturamento + ", validoAgua="	+ validoAgua + "]";
	}
}
