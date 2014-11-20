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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hora",schema="operacao")
public class Hora implements Serializable{
	private static final long serialVersionUID = -8809784528136646357L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence_hora")
	@SequenceGenerator(name = "sequence_hora", sequenceName = "sequence_hora", schema="operacao", allocationSize=1)
	@Column(name="hora_id")		
	private Integer codigo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="hora_tipo_unidade", referencedColumnName="tipo", insertable=false, updatable=false), 
		@JoinColumn(name="hora_id_unidade", referencedColumnName="id", insertable=false, updatable=false)
	})
	private EstacaoOperacional estacao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="hora_tipo_unidade", referencedColumnName="ucop_tipooperacional", insertable=false, updatable=false), 
		@JoinColumn(name="hora_id_unidade", referencedColumnName="ucop_idoperacional", insertable=false, updatable=false)
	})
	private UnidadeConsumidoraOperacional unidadeConsumidoraOperacional;
	
	@Column(name="hora_ano_mes_referencia")
	private Integer referencia;

	@Column(name="hora_tipo_unidade")
	private Integer tipoEstacao;
	
	@Column(name="hora_id_unidade")
	private Integer idEstacao;
	
	@Column(name="usur_id", nullable=false)
    private Integer usuario;

	@Column(name="hora_tmultimaalteracao", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;
    
	@OneToMany(mappedBy="hora", cascade=CascadeType.ALL)
	private List<HoraCMB> cmbs = new ArrayList<HoraCMB>();
	
	public Hora() {
	}
	
	public void addCmb(HoraCMB cmb){
	    if (cmbs == null){
	        cmbs = new ArrayList<HoraCMB>();
	    }
	    cmbs.add(cmb);
	}

	public Integer getTipoEstacao() {
        return tipoEstacao;
    }

    public void setTipoEstacao(Integer tipoEstacao) {
        this.tipoEstacao = tipoEstacao;
    }

    public Integer getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(Integer idEstacao) {
        this.idEstacao = idEstacao;
    }

    public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public EstacaoOperacional getEstacao() {
		return estacao;
	}

	public void setEstacao(EstacaoOperacional estacao) {
		this.estacao = estacao;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
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

	public List<HoraCMB> getCmbs() {
		return cmbs;
	}

	public void setCmbs(List<HoraCMB> cmb) {
		this.cmbs = cmb;
	}

	public UnidadeConsumidoraOperacional getUnidadeConsumidoraOperacional() {
		return unidadeConsumidoraOperacional;
	}

	public void setUnidadeConsumidoraOperacional(UnidadeConsumidoraOperacional unidadeConsumidoraOperacional) {
		this.unidadeConsumidoraOperacional = unidadeConsumidoraOperacional;
	}

    public String toString() {
        return "Hora [codigo=" + codigo + ", referencia=" + referencia + "]";
    }
}
