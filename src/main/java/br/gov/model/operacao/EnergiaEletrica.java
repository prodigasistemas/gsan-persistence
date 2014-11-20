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
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataReferencia;

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

	public Date getDataReferencia() {
		return dataReferencia;
	}

	public void setDataReferencia(Date dataReferencia) {
		this.dataReferencia = dataReferencia;
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

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dados == null) ? 0 : dados.hashCode());
		result = prime * result
				+ ((dataReferencia == null) ? 0 : dataReferencia.hashCode());
		result = prime * result
				+ ((nomeArquivo == null) ? 0 : nomeArquivo.hashCode());
		result = prime * result + ((qtdUC == null) ? 0 : qtdUC.hashCode());
		result = prime * result
				+ ((ultimaAlteracao == null) ? 0 : ultimaAlteracao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result
				+ ((valorTotal == null) ? 0 : valorTotal.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnergiaEletrica other = (EnergiaEletrica) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dados == null) {
			if (other.dados != null)
				return false;
		} else if (!dados.equals(other.dados))
			return false;
		if (dataReferencia == null) {
			if (other.dataReferencia != null)
				return false;
		} else if (!dataReferencia.equals(other.dataReferencia))
			return false;
		if (nomeArquivo == null) {
			if (other.nomeArquivo != null)
				return false;
		} else if (!nomeArquivo.equals(other.nomeArquivo))
			return false;
		if (qtdUC == null) {
			if (other.qtdUC != null)
				return false;
		} else if (!qtdUC.equals(other.qtdUC))
			return false;
		if (ultimaAlteracao == null) {
			if (other.ultimaAlteracao != null)
				return false;
		} else if (!ultimaAlteracao.equals(other.ultimaAlteracao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

}


