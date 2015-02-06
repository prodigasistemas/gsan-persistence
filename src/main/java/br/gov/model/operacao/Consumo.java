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
@Table(name="consumo",schema="operacao")
public class Consumo implements Serializable {
    private static final long serialVersionUID = -4788755307586932304L;

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_consumo")
	@SequenceGenerator(name="sequence_consumo", sequenceName="sequence_consumo", schema="operacao", allocationSize=1)
	@Column(name="id")
	private Integer id;
	
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	private Date data;

    @Column(name="usur_id", nullable=false)
    private Integer usuario;
    
    @Column(name="tmultimaalteracao", nullable=false, insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;

    @OneToMany(mappedBy="consumo", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<ConsumoProduto> consumosProduto = new ArrayList<ConsumoProduto>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="tipo_unidade", referencedColumnName="tipo", insertable=false, updatable=false), 
        @JoinColumn(name="id_unidade", referencedColumnName="id", insertable=false, updatable=false)
    })
    private EstacaoOperacional estacao;
        
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="tipo_unidade", referencedColumnName="ucop_tipooperacional", insertable=false, updatable=false), 
        @JoinColumn(name="id_unidade", referencedColumnName="ucop_idoperacional", insertable=false, updatable=false)
    })
    private UnidadeConsumidoraOperacional unidadeConsumidoraOperacional;
    
    @Column(name="tipo_unidade", nullable=false)
    private Integer tipoEstacao;
    
    @Column(name="id_unidade", nullable=false)
    private Integer idEstacao;
    
	public Consumo() {
	}
	public void addConsumoProduto(ConsumoProduto cp){
	    if (consumosProduto == null){
	        consumosProduto = new ArrayList<ConsumoProduto>();
	    }
	    consumosProduto.add(cp);
	    
	}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public EstacaoOperacional getEstacao() {
        return estacao;
    }
    public void setEstacao(EstacaoOperacional estacao) {
        this.estacao = estacao;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public List<ConsumoProduto> getConsumosProduto() {
        return consumosProduto;
    }
    public void setConsumosProduto(List<ConsumoProduto> consumoProduto) {
        this.consumosProduto = consumoProduto;
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
    public UnidadeConsumidoraOperacional getUnidadeConsumidoraOperacional() {
        return unidadeConsumidoraOperacional;
    }
    public void setUnidadeConsumidoraOperacional(UnidadeConsumidoraOperacional unidadeConsumidoraOperacional) {
        this.unidadeConsumidoraOperacional = unidadeConsumidoraOperacional;
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
    public String toString() {
        return "Consumo [id=" + id + ", data=" + data + "]";
    }
}
