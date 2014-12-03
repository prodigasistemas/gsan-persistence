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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="energiaeletrica",schema="operacao")
public class EnergiaEletrica  implements Serializable {
	private static final long serialVersionUID = -4344366873212757970L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_energiaeletrica")
	@SequenceGenerator(name="sequence_energiaeletrica", sequenceName="sequence_energiaeletrica", schema="operacao", allocationSize=1)
    @Column(name="enel_id")
    private Integer codigo;

    @Column(name="enel_referencia", nullable=false)
    private Integer referencia;

    @Column(name="enel_qtduc", nullable=false) 
    private Integer qtdUC;

    @Column(name="enel_vlrtotal", nullable=false) 
    private Double valorTotal;

    @Column(name="enel_nmarquivo", nullable=false) 
    private String nomeArquivo;
    
    @OneToMany(mappedBy="energiaEletrica", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<EnergiaEletricaDados> dados = new ArrayList<EnergiaEletricaDados>();    
    
    @Column(name="usur_id", nullable=false)
    private Integer usuario;
    
    @Column(name="enel_tmultimaalteracao", nullable=false, insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;

    public EnergiaEletrica() {

    }

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

    public Integer getQtdUC() {
		return qtdUC;
	}

	public void setQtdUC(Integer qtdUC) {
		this.qtdUC = qtdUC;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public List<EnergiaEletricaDados> getDados() {
		return dados;
	}

	public void setDados(List<EnergiaEletricaDados> dados) {
		this.dados = dados;
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
}
