package br.gov.model.operacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="contrato_energia",schema="operacao")
public class ContratoEnergia implements Serializable{
	private static final long serialVersionUID = -6165114382431368154L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_contrato_energia")
	@SequenceGenerator(name="sequence_contrato_energia", sequenceName="sequence_contrato_energia", schema="operacao", allocationSize=1)
    @Column(name="cene_id")
	private Integer codigo;
	
	@Column(name="cene_nmcontrato", nullable=false, length=50)
	private String numeroContrato;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ucon_id", nullable=false)
	private UnidadeConsumidora unidadeConsumidora = new UnidadeConsumidora();
	
	@Column(name="cene_tensaonominal")
	private Double tensaoNominal;

	@Column(name="cene_tensaocontratada")
	private Double tensaoContratada;

	@Column(name="cene_subgrupotarifario", length=20)
	private String subGrupoTarifario;

	@Column(name="cene_frequencia")
	private Double frequencia;

	@Column(name="cene_perdastransformacao")
	private Double perdasTransformacao;

	@Column(name="cene_potenciainstalada")
	private Double potenciaInstalada;

	@Column(name="cene_horariopontaini")
	@Temporal(TemporalType.TIME)
	private Date horarioPontaInicial;

	@Column(name="cene_horariopontafim")
	@Temporal(TemporalType.TIME)
	private Date horarioPontaFinal;
	
	@Column(name="cene_horarioreservadoini")
	@Temporal(TemporalType.TIME)
	private Date horarioReservadoInicial;

	@Column(name="cene_horarioreservadofim")
	@Temporal(TemporalType.TIME)
	private Date horarioReservadoFinal;
	
	@Column(name="cene_dataassinatura")
	private Date dataAssinatura;

	@Column(name="cene_periodoteste")
	private String periodoTeste;

	@Column(name="cene_periodoajuste")
	private String periodoAjuste;
	
	@Column(name="cene_opcaofaturamento", length=20)
	private String opcaoFaturamento;

	@Column(name="cene_modalidadetarifaria", length=20)
	private String modalidadeTarifaria;

	@Column(name="cene_agrupadorfatura", length=20)
	private String agrupadorFatura;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="cene_id", referencedColumnName="cene_id")
	private List<ContratoEnergiaDemanda> demandas = new ArrayList<ContratoEnergiaDemanda>();    
	
    @Column(name="usur_id", nullable=false)
    private Integer usuario;
    
    @Column(name="cene_tmultimaalteracao", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;
    
    @Column(name="cene_vigenciainicial")
    private Integer vigenciaInicial;

    @Column(name="cene_vigenciafinal")
    private Integer vigenciaFinal;
    
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public UnidadeConsumidora getUnidadeConsumidora() {
		return unidadeConsumidora;
	}

	public void setUnidadeConsumidora(UnidadeConsumidora unidadeConsumidora) {
		this.unidadeConsumidora = unidadeConsumidora;
	}

	public Double getTensaoNominal() {
		return tensaoNominal;
	}

	public void setTensaoNominal(Double tensaoNominal) {
		this.tensaoNominal = tensaoNominal;
	}

	public Double getTensaoContratada() {
		return tensaoContratada;
	}

	public void setTensaoContratada(Double tensaoContratada) {
		this.tensaoContratada = tensaoContratada;
	}

	public String getSubGrupoTarifario() {
		return subGrupoTarifario;
	}

	public void setSubGrupoTarifario(String subGrupoTarifario) {
		this.subGrupoTarifario = subGrupoTarifario;
	}

	public Double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Double frequencia) {
		this.frequencia = frequencia;
	}

	public Double getPerdasTransformacao() {
		return perdasTransformacao;
	}

	public void setPerdasTransformacao(Double perdasTransformacao) {
		this.perdasTransformacao = perdasTransformacao;
	}

	public Double getPotenciaInstalada() {
		return potenciaInstalada;
	}

	public void setPotenciaInstalada(Double potenciaInstalada) {
		this.potenciaInstalada = potenciaInstalada;
	}

	public Date getHorarioPontaInicial() {
		return horarioPontaInicial;
	}

	public void setHorarioPontaInicial(Date horarioPontaInicial) {
		this.horarioPontaInicial = horarioPontaInicial;
	}

	public Date getHorarioPontaFinal() {
		return horarioPontaFinal;
	}

	public void setHorarioPontaFinal(Date horarioPontaFinal) {
		this.horarioPontaFinal = horarioPontaFinal;
	}

	public Date getHorarioReservadoInicial() {
		return horarioReservadoInicial;
	}

	public void setHorarioReservadoInicial(Date horarioReservadoInicial) {
		this.horarioReservadoInicial = horarioReservadoInicial;
	}

	public Date getHorarioReservadoFinal() {
		return horarioReservadoFinal;
	}

	public void setHorarioReservadoFinal(Date horarioReservadoFinal) {
		this.horarioReservadoFinal = horarioReservadoFinal;
	}

	public Date getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public String getPeriodoTeste() {
		return periodoTeste;
	}

	public void setPeriodoTeste(String periodoTeste) {
		this.periodoTeste = periodoTeste;
	}

	public String getPeriodoAjuste() {
		return periodoAjuste;
	}

	public void setPeriodoAjuste(String periodoAjuste) {
		this.periodoAjuste = periodoAjuste;
	}

	public String getOpcaoFaturamento() {
		return opcaoFaturamento;
	}

	public void setOpcaoFaturamento(String opcaoFaturamento) {
		this.opcaoFaturamento = opcaoFaturamento;
	}

	public String getModalidadeTarifaria() {
		return modalidadeTarifaria;
	}

	public void setModalidadeTarifaria(String modalidadeTarifaria) {
		this.modalidadeTarifaria = modalidadeTarifaria;
	}

	public String getAgrupadorFatura() {
		return agrupadorFatura;
	}

	public void setAgrupadorFatura(String agrupadorFatura) {
		this.agrupadorFatura = agrupadorFatura;
	}

	public List<ContratoEnergiaDemanda> getDemandas() {
		return demandas;
	}

	public void setDemandas(List<ContratoEnergiaDemanda> demandas) {
		this.demandas = demandas;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

    public Integer getVigenciaInicial() {
        return vigenciaInicial;
    }

    public void setVigenciaInicial(Integer vigenciaInicial) {
        this.vigenciaInicial = vigenciaInicial;
    }

    public Integer getVigenciaFinal() {
        return vigenciaFinal;
    }

    public void setVigenciaFinal(Integer vigenciaFinal) {
        this.vigenciaFinal = vigenciaFinal;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroContrato == null) ? 0 : numeroContrato.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContratoEnergia other = (ContratoEnergia) obj;
        if (numeroContrato == null) {
            if (other.numeroContrato != null)
                return false;
        } else if (!numeroContrato.equals(other.numeroContrato))
            return false;
        return true;
    }
}
