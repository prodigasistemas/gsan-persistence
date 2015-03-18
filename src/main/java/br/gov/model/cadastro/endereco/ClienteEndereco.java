package br.gov.model.cadastro.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.cadastro.Cliente;
import br.gov.model.cadastro.Logradouro;
import br.gov.model.cadastro.LogradouroBairro;

@Entity
@Table(name="cliente_endereco", schema="cadastro")
public class ClienteEndereco implements Serializable {
	private static final long serialVersionUID = -7207289265797274822L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CLIENTE_ENDERECO")
	@SequenceGenerator(name="SEQ_CLIENTE_ENDERECO", schema="cadastro", sequenceName="seq_cliente_endereco", allocationSize=1)
	@Column(name="cled_id")
	private Integer id;
	
	@Column(name="cled_nnimovel", columnDefinition="bpchar(5)")
	private String numero;
	
	@Column(name="cled_dscomplementoendereco")
	private String complemento;
	
	@Column(name="cled_icenderecocorrespondencia")
	private Short indicadorEnderecoCorrespondencia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="edrf_id")
	private EnderecoReferencia enderecoReferencia; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lgcp_id")
	private LogradouroCep logradouroCep; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lgbr_id")
	private LogradouroBairro logradouroBairro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="logr_idinicioperimetro", referencedColumnName="logr_id")
	private Logradouro perimetroInicial;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="logr_idfimperimetro", referencedColumnName="logr_id")
	private Logradouro perimetroFinal;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clie_id")
	private Cliente cliente;
	
	
	public StringBuilder getEnderecoFormatadoAbreviado() {
		StringBuilder endereco = new StringBuilder();

		if (logradouroCep != null && logradouroCep.temLogradouro()) {
			if (logradouroCep.temTipoDescricaoAbreviada()) {
				endereco.append(logradouroCep.getLogradouro().getLogradouroTipo().getDescricao().trim());
			}
			
			if (this.getLogradouroCep().temTitulo() && this.getLogradouroCep().temDescricaoAbreviada()) {
				endereco.append(" ").append(logradouroCep.getLogradouro().getLogradouroTitulo().getDescricaoAbreviada().trim());
			}

			endereco.append(" ").append(this.getLogradouroCep().getLogradouro().getNome().trim());

			if (enderecoReferencia != null && enderecoReferencia.temDescricaoAbreviada()) {
					endereco.append(", ").append(enderecoReferencia.getDescricaoAbreviada().trim());
			}

			if (numero != null) {
				endereco.append(numero.trim());
			}

			if (complemento != null) {
				endereco.append(" - ").append(complemento.trim());
			}

			if (logradouroBairro != null && logradouroBairro.temBairro()) {
				endereco.append(" - ").append(logradouroBairro.getBairro().getNome().trim());

				if (logradouroBairro.temMunicipio()) {
					endereco.append(" ").append(logradouroBairro.getBairro().getMunicipio().getNome().trim());
					
					if (logradouroBairro.temUnidadeFederacao()) {
						endereco.append(" ").append(logradouroBairro.getBairro().getMunicipio().getUnidadeFederacao().getSigla().trim());
					}
				}
			} else if (logradouroCep.temMunicipio()){
				endereco.append(" - ").append(logradouroCep.getLogradouro().getMunicipio().getNome().trim());
				
				if (logradouroCep.temUnidadeFederacao()) {
					endereco.append(" ").append(logradouroCep.getLogradouro().getMunicipio().getUnidadeFederacao().getSigla().trim());
				}
			}

			if (logradouroCep.temCep()) {
				endereco.append(" ").append(logradouroCep.getCep().getCepFormatado().trim());
			}
			
			if (this.getPerimetroInicial() != null && this.getPerimetroFinal() != null) {
				endereco.append(" ENTRE ").append(perimetroInicial.getDescricaoFormatada())
					.append(" E ").append(perimetroFinal.getDescricaoFormatada());
			}
		}

		return endereco;
	}

	/******************************************************************
	 ********************** GETTERS AND SETTERS *********************** 
	 ******************************************************************/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Short getIndicadorEnderecoCorrespondencia() {
		return indicadorEnderecoCorrespondencia;
	}

	public void setIndicadorEnderecoCorrespondencia(Short indicadorEnderecoCorrespondencia) {
		this.indicadorEnderecoCorrespondencia = indicadorEnderecoCorrespondencia;
	}

	public EnderecoReferencia getEnderecoReferencia() {
		return enderecoReferencia;
	}

	public void setEnderecoReferencia(EnderecoReferencia enderecoReferencia) {
		this.enderecoReferencia = enderecoReferencia;
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

	public Logradouro getPerimetroInicial() {
		return perimetroInicial;
	}

	public void setPerimetroInicial(Logradouro perimetroInicial) {
		this.perimetroInicial = perimetroInicial;
	}

	public Logradouro getPerimetroFinal() {
		return perimetroFinal;
	}

	public void setPerimetroFinal(Logradouro perimetroFinal) {
		this.perimetroFinal = perimetroFinal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String toString() {
		return "ClienteEndereco [id=" + id + "]";
	}
}