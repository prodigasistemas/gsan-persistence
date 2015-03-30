package br.gov.model.operacao;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="rede_instalada",schema="operacao")
public class RedeInstalada implements Serializable{
	private static final long serialVersionUID = 1273004646142742450L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_rede_instalada")
	@SequenceGenerator(name="sequence_rede_instalada", sequenceName="sequence_rede_instalada", schema="operacao", allocationSize=1)
	@Column(name="rdin_id")
	private Integer codigo;

	@Column(name="rdin_referencia", nullable=false)
	private Integer referencia;

	@ManyToOne
	@JoinColumn(name="greg_id", nullable=false)	
	private RegionalProxy regional = new RegionalProxy();
	
	@ManyToOne
	@JoinColumn(name="uneg_id", nullable=false)
	private UnidadeNegocioProxy unidadeNegocio = new UnidadeNegocioProxy();
	
	@ManyToOne
	@JoinColumn(name="muni_id", nullable=false)
	private MunicipioProxy municipio = new MunicipioProxy();
	
	@ManyToOne
	@JoinColumn(name="loca_id", nullable=false)
	private LocalidadeProxy localidade = new LocalidadeProxy();
	
	@Column(name="rdin_cadastrada", nullable=false)
	private BigDecimal redeCadastrada;

	@Column(name="rdin_existente", nullable=false)
	private BigDecimal redeExistente;
	
    @Column(name="usur_id", nullable=false)
    private Integer usuario;
    
    @Column(name="rdin_tmultimaalteracao", nullable=false, insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;

    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Integer getReferencia() {
        return referencia;
    }
    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }
    public RegionalProxy getRegional() {
        return regional;
    }
    public void setRegional(RegionalProxy regional) {
        this.regional = regional;
    }
    public UnidadeNegocioProxy getUnidadeNegocio() {
        return unidadeNegocio;
    }
    public void setUnidadeNegocio(UnidadeNegocioProxy unidadeNegocio) {
        this.unidadeNegocio = unidadeNegocio;
    }
    public MunicipioProxy getMunicipio() {
        return municipio;
    }
    public void setMunicipio(MunicipioProxy municipio) {
        this.municipio = municipio;
    }
    public LocalidadeProxy getLocalidade() {
        return localidade;
    }
    public void setLocalidade(LocalidadeProxy localidade) {
        this.localidade = localidade;
    }
    public BigDecimal getRedeCadastrada() {
        return redeCadastrada;
    }
    public void setRedeCadastrada(BigDecimal redeCadastrada) {
        this.redeCadastrada = redeCadastrada;
    }
    public BigDecimal getRedeExistente() {
        return redeExistente;
    }
    public void setRedeExistente(BigDecimal redeExistente) {
        this.redeExistente = redeExistente;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RedeInstalada other = (RedeInstalada) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
