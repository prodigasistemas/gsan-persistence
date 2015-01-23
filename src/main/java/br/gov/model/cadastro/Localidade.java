package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.endereco.EnderecoReferencia;
import br.gov.model.cadastro.endereco.LogradouroCep;

@Entity
@Table(name="localidade", schema="cadastro")
public class Localidade implements Serializable{
	private static final long serialVersionUID = 8168753906493746420L;

	@Id
	@Column(name="loca_id")
	private Integer id;
	
	@Column(name="loca_nmlocalidade")
	private String descricao;
	
	@Column(name="loca_nnimovel", columnDefinition="bpchar(5)")
	private String numeroImovel;
	
	@Column(name="loca_dscomplementoendereco")
	private String complementoEndereco;

	@Column(name="loca_nnfone")
	private String fone;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="greg_id", nullable=false)
	private GerenciaRegional gerenciaRegional;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lgcp_id")
	private LogradouroCep logradouroCep;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lgbr_id")
	private LogradouroBairro logradouroBairro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="edrf_id")
	private EnderecoReferencia enderecoReferencia;
	
	public Localidade() {}
	
	public Localidade(Integer id) {
		this.id = id;
	}

	public StringBuilder getEnderecoFormatadoTituloAbreviado() {
		StringBuilder endereco = new StringBuilder();

		if (logradouroCep != null && logradouroCep.getLogradouro() != null){
			if (logradouroCep.getLogradouro().getLogradouroTipo() != null){
				endereco.append(logradouroCep.getLogradouro().getLogradouroTipo().getDescricao());
			}
			
			if (logradouroCep.getLogradouro().getLogradouroTitulo() != null){
				endereco.append(logradouroCep.getLogradouro().getLogradouroTitulo().getDescricaoAbreviada());
			}

			endereco.append(logradouroCep.getLogradouro().getNome());

			if (enderecoReferencia != null && enderecoReferencia.getDescricao() != null) {
				endereco.append(enderecoReferencia.getDescricao());
			}

			endereco.append(" - " + numeroImovel != null ? numeroImovel : "");

			if (complementoEndereco != null) {
				endereco.append(" - " + complementoEndereco);
			}

			if (logradouroBairro != null && logradouroBairro.temBairro()) {
				endereco.append(" - ").append(logradouroBairro.getBairro().getNome());

				if (logradouroBairro.temMunicipio()) {
					endereco.append(" ").append(logradouroBairro.getBairro().getMunicipio().getNome());
				}

				if (logradouroBairro.temUnidadeFederacao()) {
					endereco.append(" ").append(logradouroBairro.getBairro().getMunicipio().getUnidadeFederacao().getSigla());
				}
			}

			if (logradouroCep.getCep() != null) {
				endereco.append(" ").append(logradouroCep.getCep().getCepFormatado());
			}
		}

		return endereco;
	}

	/**********************************************
	 ************ GETTERS AND SETTERS ************* 
	 **********************************************/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String nome) {
		this.descricao = nome;
	}

	public GerenciaRegional getGerenciaRegional() {
		return gerenciaRegional;
	}

	public void setGerenciaRegional(GerenciaRegional gerenciaRegional) {
		this.gerenciaRegional = gerenciaRegional;
	}

	public String getNumeroImovel() {
		return numeroImovel;
	}

	public void setNumeroImovel(String numeroImovel) {
		this.numeroImovel = numeroImovel;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public LogradouroCep getLogradouroCep() {
		return logradouroCep;
	}

	public void setLogradouroCep(LogradouroCep logradouroCep) {
		this.logradouroCep = logradouroCep;
	}

	public LogradouroBairro getLogradouroBairro() {
		return logradouroBairro;
	}

	public void setLogradouroBairro(LogradouroBairro logradouroBairro) {
		this.logradouroBairro = logradouroBairro;
	}

	public EnderecoReferencia getEnderecoReferencia() {
		return enderecoReferencia;
	}

	public void setEnderecoReferencia(EnderecoReferencia enderecoReferencia) {
		this.enderecoReferencia = enderecoReferencia;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String toString() {
		return "Localidade [id=" + id + ", nome=" + descricao + "]";
	}
}