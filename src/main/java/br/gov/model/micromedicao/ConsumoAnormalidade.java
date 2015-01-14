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
	private static final long serialVersionUID = 6442442436348921707L;

	public final static int CONSUMO_ALTERADO                 = 1;
    public final static int CONSUMO_INFORMADO                = 2;
    public final static int CONSUMO_RETIFICADO               = 3;
    public final static int BAIXO_CONSUMO                    = 4;
    public final static int ESTOURO_CONSUMO                  = 5;
    public final static int ALTO_CONSUMO                     = 6;
    public final static int LEITURA_ATUAL_MENOR_PROJETADA    = 7;
    public final static int LEITURA_ATUAL_MENOR_ANTERIOR     = 8;
    public final static int HIDROMETRO_SUBSTITUIDO_INFORMADO = 9;
    public final static int LEITURA_NAO_INFORMADA            = 10;
    public final static int ESTOURO_MEDIA                    = 11;
    public final static int CONSUMO_MINIMO_FIXADO            = 12;
    public final static int CONSUMO_FORA_FAIXA                   = 13;
    public final static int HIDROMETRO_SUBSTITUIDO_NAO_INFORMADO = 14;
    public final static int FATURAMENTO_ANTECIPADO               = 15;
    public final static int VIRADA_HIDROMETRO                    = 16;
    public final static int ANORMALIDADE_DE_LEITURA              = 17;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONSUMO_ANORMALIDADE")
	@SequenceGenerator(name="SEQ_CONSUMO_ANORMALIDADE", schema="micromedicao", sequenceName="seq_consumo_anormalidade", allocationSize=1)
	@Column(name="csan_id")
	private Integer id;
	
	@Column(name="csan_dsconsumoanormalidade")
	private String descricao;
	
	@Column(name="csan_dsabrvconsanormalidade", columnDefinition="bpchar(5)")
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
	
	/*********************************************
	 ************ GETTERS AND SETTERS ************ 
	 *********************************************/
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

	public String toString() {
		return "ConsumoAnormalidade [id=" + id + "]";
	}
}
