package br.gov.model.cadastro;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="esfera_poder", schema="cadastro")
public class EsferaPoder implements Serializable{

	private static final long serialVersionUID = -4566136566407546233L;
	
	public final static Integer MUNICIPAL  = Integer.valueOf("1");
    public final static Integer ESTADUAL   = Integer.valueOf("2");
    public final static Integer FEDERAL    = Integer.valueOf("3");
    public final static Integer PARTICULAR = Integer.valueOf("4");

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ESFERA_PODER")
	@SequenceGenerator(name="SEQ_ESFERA_PODER", schema="cadastro", sequenceName="seq_esfera_poder", allocationSize=1)
	@Column(name="epod_id")
	private Integer id;
	
	@Column(name="epod_dsesferapoder")
	private String descricao;
	
	@Column(name="epod_icuso")
	private Short indicadorUso;
	
	@Column(name="epod_icpermitecndparaimovel")
	private Short indicadorPermiteCertidaoNegativaDebitosParaImovel;
	
	@Column(name="epod_icpermitecndparacliente")
	private Short indicadorPermiteCertidaoNegativaDebitosParaCliente;
	
	@Column(name="epod_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	public EsferaPoder(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public Short getIndicadorPermiteCertidaoNegativaDebitosParaImovel() {
		return indicadorPermiteCertidaoNegativaDebitosParaImovel;
	}

	public void setIndicadorPermiteCertidaoNegativaDebitosParaImovel(Short indicadorPermiteCertidaoNegativaDebitosParaImovel) {
		this.indicadorPermiteCertidaoNegativaDebitosParaImovel = indicadorPermiteCertidaoNegativaDebitosParaImovel;
	}

	public Short getIndicadorPermiteCertidaoNegativaDebitosParaCliente() {
		return indicadorPermiteCertidaoNegativaDebitosParaCliente;
	}

	public void setIndicadorPermiteCertidaoNegativaDebitosParaCliente(Short indicadorPermiteCertidaoNegativaDebitosParaCliente) {
		this.indicadorPermiteCertidaoNegativaDebitosParaCliente = indicadorPermiteCertidaoNegativaDebitosParaCliente;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
}
