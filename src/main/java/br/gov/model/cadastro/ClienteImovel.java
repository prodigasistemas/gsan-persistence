package br.gov.model.cadastro;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.Status;

@Entity
@Table(name="cliente_imovel", schema="cadastro")
public class ClienteImovel implements Serializable{

	private static final long serialVersionUID = 6195549110465807421L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CLIENTE_IMOVEL")
	@SequenceGenerator(name="SEQ_CLIENTE_IMOVEL", schema="cadastro", sequenceName="seq_cliente_imovel", allocationSize=1)
	@Column(name="clim_id")
	private Integer id;
	
	@Column(name="clim_dtrelacaoinicio")
	@Temporal(TemporalType.DATE)
	private Date dataInicioRelacao;
	
	@Column(name="clim_dtrelacaofim")
	@Temporal(TemporalType.DATE)
	private Date dataFimRelacao;
	
	@Column(name="clim_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date ultimaAlteracao;
	
	@Column(name="clim_icnomeconta")
	private Short indicadorNomeConta;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clie_id")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="crtp_id")
	private ClienteRelacaoTipo clienteRelacaoTipo;
	
	public ClienteImovel(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInicioRelacao() {
		return dataInicioRelacao;
	}

	public void setDataInicioRelacao(Date dataInicioRelacao) {
		this.dataInicioRelacao = dataInicioRelacao;
	}

	public Date getDataFimRelacao() {
		return dataFimRelacao;
	}

	public void setDataFimRelacao(Date dataFimRelacao) {
		this.dataFimRelacao = dataFimRelacao;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Short getIndicadorNomeConta() {
		return indicadorNomeConta;
	}

	public void setIndicadorNomeConta(Short indicadorNomeConta) {
		this.indicadorNomeConta = indicadorNomeConta;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
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

	public boolean nomeParaConta() {
		return indicadorNomeConta != null && indicadorNomeConta == Status.ATIVO.getId();
	}
}
