package br.gov.model.operacao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="contrato_energia_demanda",schema="operacao")
public class ContratoEnergiaDemanda implements BaseEntidade, Serializable{
	private static final long serialVersionUID = 1436728198289444401L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_contrato_energia_demanda")
	@SequenceGenerator(name="sequence_contrato_energia_demanda", sequenceName="sequence_contrato_energia_demanda", schema="operacao", allocationSize=1)
    @Column(name="cend_id")
	private Integer codigo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cene_id")
    private ContratoEnergia contrato;

	@Column(name="cend_dataini")
	@Temporal(TemporalType.DATE)
	private Date dataInicial; 

	@Column(name="cend_datafim")
	@Temporal(TemporalType.DATE)
	private Date dataFinal; 
	
	@Column(name="cend_demandasecoponta")
	private Integer demandaSecoPonta;
	
	@Column(name="cend_demandasecoforaponta")
	private Integer demandaSecoForaPonta;

	@Column(name="cend_demandaumidoponta")
	private Integer demandaUmidoPonta;

	@Column(name="cend_demandaumidoforaponta")
	private Integer demandaUmidoForaPonta;

	@Column(name="cend_convencionalverde")
	private Integer convencionalVerde;
	
	@Column(name="cend_periodoinicial")
	private Integer periodoInicial;
	
	@Column(name="cend_periodofinal")
	private Integer periodoFinal;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public ContratoEnergia getContrato() {
		return contrato;
	}

	public void setContrato(ContratoEnergia contrato) {
		this.contrato = contrato;
	}

	public Integer getDemandaSecoPonta() {
		return demandaSecoPonta;
	}

	public void setDemandaSecoPonta(Integer demandaSecoPonta) {
		this.demandaSecoPonta = demandaSecoPonta;
	}

	public Integer getDemandaSecoForaPonta() {
		return demandaSecoForaPonta;
	}

	public void setDemandaSecoForaPonta(Integer demandaSecoForaPonta) {
		this.demandaSecoForaPonta = demandaSecoForaPonta;
	}

	public Integer getDemandaUmidoPonta() {
		return demandaUmidoPonta;
	}

	public void setDemandaUmidoPonta(Integer demandaUmidoPonta) {
		this.demandaUmidoPonta = demandaUmidoPonta;
	}

	public Integer getDemandaUmidoForaPonta() {
		return demandaUmidoForaPonta;
	}

	public void setDemandaUmidoForaPonta(Integer demandaUmidoForaPonta) {
		this.demandaUmidoForaPonta = demandaUmidoForaPonta;
	}
	
	public Integer getConvencionalVerde() {
		return convencionalVerde;
	}

	public void setConvencionalVerde(Integer convencionalVerde) {
		this.convencionalVerde = convencionalVerde;
	}

    public Integer getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(Integer periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public Integer getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(Integer periodoFinal) {
        this.periodoFinal = periodoFinal;
    }
}
