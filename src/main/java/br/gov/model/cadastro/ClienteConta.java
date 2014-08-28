package br.gov.model.cadastro;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.faturamento.Conta;

@Entity
@Table(schema="cadastro", name="cliente_conta")
public class ClienteConta implements Serializable{
	private static final long serialVersionUID = 5913851228303603265L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CLIENTE_CONTA")
	@SequenceGenerator(name="SEQ_CLIENTE_CONTA", schema="cadastro", sequenceName="seq_cliente_conta", allocationSize=1)
	@Column(name="clct_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="clie_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="crtp_id")
	private ClienteRelacaoTipo clienteRelacaoTipo;

	@ManyToOne
	@JoinColumn(name="cnta_id")
	private Conta conta;
	
	@Column(name="clct_icnomeconta")
	private Short indicadorNomeConta;
	
	@Column(name="clct_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	public ClienteConta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteRelacaoTipo getClienteRelacaoTipo() {
		return clienteRelacaoTipo;
	}

	public void setClienteRelacaoTipo(ClienteRelacaoTipo clienteRelacaoTipo) {
		this.clienteRelacaoTipo = clienteRelacaoTipo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public Short getIndicadorNomeConta() {
		return indicadorNomeConta;
	}

	public void setIndicadorNomeConta(Short indicadorNomeConta) {
		this.indicadorNomeConta = indicadorNomeConta;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String toString() {
		return "ClienteConta [id=" + id + ", cliente=" + cliente + ", clienteRelacaoTipo=" + clienteRelacaoTipo + ", conta=" + conta + "]";
	}
}
