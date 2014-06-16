package br.gov.model.cadastro;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente_tipo", schema="cadastro")
public class ClienteTipo implements Serializable{

	private static final long serialVersionUID = 6426400277485501128L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CLIENTE_TIPO")
	@SequenceGenerator(name="SEQ_CLIENTE_TIPO", schema="cadastro", sequenceName="seq_cliente_tipo", allocationSize=1)
	@Column(name="cltp_id")
	private Long id;

	@Column(name="cltp_dsclientetipo")
	private String descricao;
	
	@Column(name="cltp_icpessoafisicajuridica")
	private Short indicadorPessoaFisicaJuridica;
	
	@Column(name="cltp_icuso")
	private Short indicadorUso;
	
	@Column(name="cltp_tmultimaalteracao")
	private Date ultimaAlteracao;

	@ManyToOne
	@JoinColumn(name="epod_id")
	private EsferaPoder esferaPoder;
	
	public ClienteTipo(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getIndicadorPessoaFisicaJuridica() {
		return indicadorPessoaFisicaJuridica;
	}

	public void setIndicadorPessoaFisicaJuridica(Short indicadorPessoaFisicaJuridica) {
		this.indicadorPessoaFisicaJuridica = indicadorPessoaFisicaJuridica;
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

	public EsferaPoder getEsferaPoder() {
		return esferaPoder;
	}

	public void setEsferaPoder(EsferaPoder esferaPoder) {
		this.esferaPoder = esferaPoder;
	}
}
