package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="cadastro", name="area_construida_faixa")
public class AreaConstruidaFaixa implements Serializable{
    private static final long serialVersionUID = 1003672148966426982L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_AREA_CONSTRUIDA_FAIXA")
    @SequenceGenerator(name="SEQ_AREA_CONSTRUIDA_FAIXA", schema="cadastro", sequenceName="seq_area_construida_faixa", allocationSize=1)
    @Column(name="acon_id")
    private Integer id;
    
    @Column(name="acon_nnmenorfaixa")
    private Integer menorFaixa;

    @Column(name="acon_nnmaiorfaixa")
    private Integer maiorFaixa;
    
    public AreaConstruidaFaixa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenorFaixa() {
        return menorFaixa;
    }

    public void setMenorFaixa(Integer menorFaixa) {
        this.menorFaixa = menorFaixa;
    }

    public Integer getMaiorFaixa() {
        return maiorFaixa;
    }

    public void setMaiorFaixa(Integer maiorFaixa) {
        this.maiorFaixa = maiorFaixa;
    }
}
