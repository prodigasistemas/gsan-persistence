package br.gov.model.cadastro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="imovel_economia", schema="cadastro")
public class ImovelEconomia implements Serializable{
	private static final long serialVersionUID = -5595073207698176858L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_IMOVEL_ECONOMIA")
	@SequenceGenerator(name="SEQ_IMOVEL_ECONOMIA", schema="cadastro", sequenceName="seq_imovel_economia", allocationSize=1)
	@Column(name="imec_id")
	private Integer id;

	@Column(name="imec_dscomplementoendereco")
	private String complementoEndereco;
	
	@Column(name="imec_nnmorador")
	private Short numeroMorador;
	
	@Column(name="imec_nnpontosutilizacao")
	private Short numeroPontosUtilizacao;
	
	@Column(name="imec_nniptu")
	private String numeroIptu;
	
	@Column(name="imec_nncontratoenergia")
	private BigDecimal numeroCelpa;
	
	@Column(name="imec_nnareaconstruida")
	private BigDecimal areaConstruida;
	
	@Column(name="imec_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date ultimaAlteracao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="imov_id", referencedColumnName="imov_id"),
		@JoinColumn(name="scat_id", referencedColumnName="scat_id")
	})
	private ImovelSubcategoria imovelSubcategoria;
	
	public ImovelEconomia(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public Short getNumeroMorador() {
		return numeroMorador;
	}

	public void setNumeroMorador(Short numeroMorador) {
		this.numeroMorador = numeroMorador;
	}

	public Short getNumeroPontosUtilizacao() {
		return numeroPontosUtilizacao;
	}

	public void setNumeroPontosUtilizacao(Short numeroPontosUtilizacao) {
		this.numeroPontosUtilizacao = numeroPontosUtilizacao;
	}

	public String getNumeroIptu() {
		return numeroIptu;
	}

	public void setNumeroIptu(String numeroIptu) {
		this.numeroIptu = numeroIptu;
	}

	public BigDecimal getNumeroCelpa() {
		return numeroCelpa;
	}

	public void setNumeroCelpa(BigDecimal numeroCelpa) {
		this.numeroCelpa = numeroCelpa;
	}

	public BigDecimal getAreaConstruida() {
		return areaConstruida;
	}

	public void setAreaConstruida(BigDecimal areaConstruida) {
		this.areaConstruida = areaConstruida;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public ImovelSubcategoria getImovelSubcategoria() {
		return imovelSubcategoria;
	}

	public void setImovelSubcategoria(ImovelSubcategoria imovelSubcategoria) {
		this.imovelSubcategoria = imovelSubcategoria;
	}
}
