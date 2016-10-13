package br.gov.model.desempenho;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="contrato_medicao_abrangencia_historico", schema="desempenho")
public class ContratoMedicaoAbrangenciaHistorico implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTRATO_MEDICAO_ABRANGENCIA_HISTORICO")
	@SequenceGenerator(name="SEQ_CONTRATO_MEDICAO_ABRANGENCIA_HISTORICO", schema="desempenho", sequenceName="seq_contrato_medicao_abrangencia_historico", allocationSize=1)
	@Column(name="cmah_id")
	private Integer id;
	
	@Column(name="cmab_tmcriacao")
	private Date dataCriacaoAbrangencia;
	
	@Column(name="cmab_remocao")
	private Date dataRemocaoAbrangencia;
	
	@ManyToOne
	@Column(name="cmed_id")
	private ContratoMedicao contratoMedicao;
	
	@ManyToOne
	@Column(name="imov_id")
	private Imovel imovel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCriacaoAbrangencia() {
		return dataCriacaoAbrangencia;
	}

	public void setDataCriacaoAbrangencia(Date dataCriacaoAbrangencia) {
		this.dataCriacaoAbrangencia = dataCriacaoAbrangencia;
	}

	public Date getDataRemocaoAbrangencia() {
		return dataRemocaoAbrangencia;
	}

	public void setDataRemocaoAbrangencia(Date dataRemocaoAbrangencia) {
		this.dataRemocaoAbrangencia = dataRemocaoAbrangencia;
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
	
}
