package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estacao_operacional",schema="operacao")
public class EstacaoOperacional implements Serializable{
	private static final long serialVersionUID = -8316337367798818315L;

	@EmbeddedId
	private EstacaoOperacionalPK pk;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="quantidade_cmb")
	private Integer quantidadeCmb;
	
	public EstacaoOperacional() {
		super();
	}
	
	public EstacaoOperacional(Integer tipo, Integer id){
	    this.pk = new EstacaoOperacionalPK(tipo, id);
	}
	
	public EstacaoOperacional(Integer tipo, Integer id, String nome){
	    this.pk = new EstacaoOperacionalPK(tipo, id);
	    this.nome = nome;
	}
	
	public EstacaoOperacional(Integer tipo, Integer id, String nome, Integer quantidadeCmb){
		this.pk = new EstacaoOperacionalPK(tipo, id);
		this.nome = nome;
		this.quantidadeCmb = quantidadeCmb;
	}

	public EstacaoOperacionalPK getPk() {
		return pk;
	}

	public void setPk(EstacaoOperacionalPK pk) {
		this.pk = pk;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public Integer getQuantidadeCmb() {
        return quantidadeCmb;
    }

    public void setQuantidadeCmb(Integer quantidadeCmb) {
        this.quantidadeCmb = quantidadeCmb;
    }
}
