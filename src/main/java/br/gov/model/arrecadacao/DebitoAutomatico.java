package br.gov.model.arrecadacao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="debito_automatico", schema="arrecadacao")
public class DebitoAutomatico implements Serializable {

	private static final long serialVersionUID = -621518526399682948L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DEBITO_AUTOMATICO")
	@SequenceGenerator(name="SEQ_DEBITO_AUTOMATICO", schema="arrecadacao", sequenceName="seq_debito_automatico", allocationSize=1)		
	@Column(name="deba_id")
	private Long id;
	
	@Column(name="deba_dsidentificacaoclientebco")
	private String identificacaoClienteBanco;
	
	@Column(name="deba_dtopcao")
	private Date opcaoDebitoContaCorrente;
	
	@Column(name="deba_dtinclusao")
	private Date inclusaoNovoDebitoAutomatico;
	
	@Column(name="deba_dtexclusao")
	private Date dataExclusao;
	
	@Column(name="deba_tmultimaalteracao")
	private Date ultimaAlteracao;

	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;

	@ManyToOne
	@JoinColumn(name="agen_id")
	private Agencia agencia;
	
	public DebitoAutomatico(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacaoClienteBanco() {
		return identificacaoClienteBanco;
	}

	public void setIdentificacaoClienteBanco(String identificacaoClienteBanco) {
		this.identificacaoClienteBanco = identificacaoClienteBanco;
	}

	public Date getOpcaoDebitoContaCorrente() {
		return opcaoDebitoContaCorrente;
	}

	public void setOpcaoDebitoContaCorrente(Date opcaoDebitoContaCorrente) {
		this.opcaoDebitoContaCorrente = opcaoDebitoContaCorrente;
	}

	public Date getInclusaoNovoDebitoAutomatico() {
		return inclusaoNovoDebitoAutomatico;
	}

	public void setInclusaoNovoDebitoAutomatico(Date inclusaoNovoDebitoAutomatico) {
		this.inclusaoNovoDebitoAutomatico = inclusaoNovoDebitoAutomatico;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date exclusao) {
		this.dataExclusao = exclusao;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
}
