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
@Table(name="cliente_relacao_tipo", schema="cadastro")
public class ClienteRelacaoTipo implements Serializable{
	
	private static final long serialVersionUID = -5421164882053548649L;
	
	public final static Short PROPRIETARIO = new Short("1");
    public final static Short USUARIO = new Short("2");
    public final static Short RESPONSAVEL = new Short("3");

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CLIENTE_RELACAO_TIPO")
	@SequenceGenerator(name="SEQ_CLIENTE_RELACAO_TIPO", schema="cadastro", sequenceName="seq_cliente_relacao_tipo", allocationSize=1)
	@Column(name="crtp_id")
	private Long id;
	
	@Column(name="crtp_dsclienterelacaotipo")
	private String descricao;
	
	@Column(name="crtp_icuso")
	private Short indicadorUso;
	
	@Column(name="crtp_tmultimaalteracao")
	private Date ultimaAlteracao;

	public ClienteRelacaoTipo(){}

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
}
