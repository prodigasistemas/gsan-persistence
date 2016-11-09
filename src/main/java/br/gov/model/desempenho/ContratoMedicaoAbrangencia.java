package br.gov.model.desempenho;

import java.io.Serializable;
import java.math.BigDecimal;
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

import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="contrato_medicao_abrangencia", schema="desempenho")
public class ContratoMedicaoAbrangencia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTRATO_MEDICAO_ABRANGENCIA")
	@SequenceGenerator(name="SEQ_CONTRATO_MEDICAO_ABRANGENCIA", schema="desempenho", sequenceName="seq_contrato_medicao_abrangencia", allocationSize=1)
	@Column(name="cmab_id")
	private Integer id;
	
	@Column(name="cmab_tmcriacao")
	private Date dataCriacao;
	
	@Column(name="cmab_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@ManyToOne
	@JoinColumn(name="cmed_id")
	private ContratoMedicao contratoMedicao;
	
	@ManyToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name="last_id")
	private LigacaoAguaSituacao ligacaoAguaSituacao;
	
	@Column(name="cmab_pcesgoto")
	private BigDecimal percentualEsgoto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public ContratoMedicao getContratoMedicao() {
		return contratoMedicao;
	}

	public void setContratoMedicao(ContratoMedicao contratoMedicao) {
		this.contratoMedicao = contratoMedicao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public LigacaoAguaSituacao getLigacaoAguaSituacao() {
		return ligacaoAguaSituacao;
	}

	public void setLigacaoAguaSituacao(LigacaoAguaSituacao ligacaoAguaSituacao) {
		this.ligacaoAguaSituacao = ligacaoAguaSituacao;
	}

	public BigDecimal getPercentualEsgoto() {
		return percentualEsgoto;
	}

	public void setPercentualEsgoto(BigDecimal percentualEsgoto) {
		this.percentualEsgoto = percentualEsgoto;
	}
	
}
