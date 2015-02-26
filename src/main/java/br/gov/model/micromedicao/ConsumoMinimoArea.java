package br.gov.model.micromedicao;

import java.io.Serializable;
import java.math.BigDecimal;
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

import br.gov.model.cadastro.Categoria;
import br.gov.model.cadastro.Subcategoria;

@Entity
@Table(schema="micromedicao", name="consumo_minimo_area")
public class ConsumoMinimoArea implements Serializable{
    private static final long serialVersionUID = -4592898966870597448L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONSUMO_MINIMO_AREA")
    @SequenceGenerator(name="SEQ_CONSUMO_MINIMO_AREA", schema="micromedicao", sequenceName="seq_consumo_minimo_area", allocationSize=1)
    @Column(name="cmar_id")
    private Integer id;
    
    @Column(name="cmar_amreferencia")
    private Integer anoMesReferencia;
    
    @Column(name="cmar_nnareafinal")
    private BigDecimal numeroAreaFinal;
    
    @Column(name="cmar_nnconsumo")
    private Integer numeroConsumo;
    
    @Column(name="cmar_icuso")
    private Short indicadorUso;
    
    @Column(name="cmar_tmultimaalteracao")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="catg_id", referencedColumnName="catg_id")
    private Categoria categoria;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="scat_id", referencedColumnName="scat_id")
    private Subcategoria subcategoria;
    
    public ConsumoMinimoArea() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getNumeroAreaFinal() {
        return numeroAreaFinal;
    }

    public void setNumeroAreaFinal(BigDecimal numeroAreaFinal) {
        this.numeroAreaFinal = numeroAreaFinal;
    }

    public Integer getNumeroConsumo() {
        return numeroConsumo;
    }

    public void setNumeroConsumo(Integer numeroConsumo) {
        this.numeroConsumo = numeroConsumo;
    }

    public Short getIndicadorUso() {
        return indicadorUso;
    }

    public void setIndicadorUso(Short indicadorUso) {
        this.indicadorUso = indicadorUso;
    }

    public Date getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Date ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public Integer getAnoMesReferencia() {
        return anoMesReferencia;
    }

    public void setAnoMesReferencia(Integer anoMesReferencia) {
        this.anoMesReferencia = anoMesReferencia;
    }
}
