package br.gov.model.micromedicao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="consumo_anormalidade", schema="micromedicao")
public class ConsumoAnormalidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2969850794854621162L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONSUMO_ANORMALIDADE")
	@SequenceGenerator(name="SEQ_CONSUMO_ANORMALIDADE", schema="micromedicao", sequenceName="seq_consumo_anormalidade", allocationSize=1)
	@Column(name="csan_id")
	private Long id;
	
	@Column(name="csan_dsconsumoanormalidade")
	private String descricao;
	
	@Column(name="csan_dsabrvconsanormalidade")
	private String descricaoAbreviada;
	
	@Column(name="csan_dsmensagemconta")
	private String mensagemConta;
	
	@Column(name="csan_icuso")
	private Short indicadorUso;
	
	@Column(name="csan_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="csan_icrevcompermissaoespecial")
	private Short indicadorRevisaoPermissaoEspecial;
	
	@Column(name="csan_iccalcularmedia")
	private Short indicadorCalcularMedia;
	
	public ConsumoAnormalidade() {}

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

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public String getMensagemConta() {
		return mensagemConta;
	}

	public void setMensagemConta(String mensagemConta) {
		this.mensagemConta = mensagemConta;
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

	public Short getIndicadorRevisaoPermissaoEspecial() {
		return indicadorRevisaoPermissaoEspecial;
	}

	public void setIndicadorRevisaoPermissaoEspecial(Short indicadorRevisaoPermissaoEspecial) {
		this.indicadorRevisaoPermissaoEspecial = indicadorRevisaoPermissaoEspecial;
	}

	public Short getIndicadorCalcularMedia() {
		return indicadorCalcularMedia;
	}

	public void setIndicadorCalcularMedia(Short indicadorCalcularMedia) {
		this.indicadorCalcularMedia = indicadorCalcularMedia;
	}
}
