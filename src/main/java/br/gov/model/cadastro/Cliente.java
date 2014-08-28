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
@Table(name="cliente",schema="cadastro")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 2827727025294779399L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CLIENTE")
	@SequenceGenerator(name="SEQ_CLIENTE", schema="cadastro", sequenceName="seq_cliente", allocationSize=1)
	@Column(name="clie_id")
	private Long id;
	
	@Column(name="clie_nmcliente")
	private String nome;
	
	@Column(name="clie_nmabreviado")
	private String nomeAbreviado;
	
	@Column(name="clie_nncpf")
	private String cpf;
	
	@Column(name="clie_nnrg")
	private String rg;
	
	@Column(name="clie_dtrgemissao")
	private Date dataEmissaoRg;
	
	@Column(name="clie_ddvencimento")
	private Short diaVencimento;
	
	@Column(name="clie_dtnascimento")
	private Date dataNascimento;

	@Column(name="clie_nncnpj")
	private String cnpj;
	
	@Column(name="clie_dsemail")
	private String email;
	
	@Column(name="clie_icuso")
	private Short indicadorUso;
	
	@Column(name="tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@Column(name="clie_icacaocobranca")
	private Short indicadorAcaoCobranca;
	
	@Column(name="clie_nnmae")
	private String nomeMae;
	
	@Column(name="clie_iccobrancaacrescimos")
	private Short indicadorAcrescimos;
	
	@Column(name="clie_icgeraarquivotexto")
	private Short indicadorGeraArquivoTexto;
	
	@Column(name="clie_icgerafaturaantecipada")
	private Short indicadorGeraFaturaAntecipada;
	
	@Column(name="clie_icvencimentomesseguinte")
	private Short indicadorVencimentoMesSeguinte;
	
	@Column(name="clie_icusonomefantasiaconta")
	private Short indicadorUsoNomeFantasiaConta;
	
	@Column(name="clie_icpermitenegativacao")
	private Short indicadorPermiteNegativacao;
	
	@ManyToOne
	@JoinColumn(name="cltp_id")
	private ClienteTipo clienteTipo;
	
	public Cliente(){}
	
	public Cliente(Long id){
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataEmissaoRg() {
		return dataEmissaoRg;
	}

	public void setDataEmissaoRg(Date dataEmissaoRg) {
		this.dataEmissaoRg = dataEmissaoRg;
	}

	public Short getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Short dia) {
		this.diaVencimento = dia;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Short getIndicadorAcaoCobranca() {
		return indicadorAcaoCobranca;
	}

	public void setIndicadorAcaoCobranca(Short indicadorAcaoCobranca) {
		this.indicadorAcaoCobranca = indicadorAcaoCobranca;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Short getIndicadorAcrescimos() {
		return indicadorAcrescimos;
	}

	public void setIndicadorAcrescimos(Short indicadorAcrescimos) {
		this.indicadorAcrescimos = indicadorAcrescimos;
	}

	public Short getIndicadorGeraArquivoTexto() {
		return indicadorGeraArquivoTexto;
	}

	public void setIndicadorGeraArquivoTexto(Short indicadorGeraArquivoTexto) {
		this.indicadorGeraArquivoTexto = indicadorGeraArquivoTexto;
	}

	public Short getIndicadorGeraFaturaAntecipada() {
		return indicadorGeraFaturaAntecipada;
	}

	public void setIndicadorGeraFaturaAntecipada(Short indicadorGeraFaturaAntecipada) {
		this.indicadorGeraFaturaAntecipada = indicadorGeraFaturaAntecipada;
	}

	public Short getIndicadorVencimentoMesSeguinte() {
		return indicadorVencimentoMesSeguinte;
	}

	public void setIndicadorVencimentoMesSeguinte(Short indicadorVencimentoMesSeguinte) {
		this.indicadorVencimentoMesSeguinte = indicadorVencimentoMesSeguinte;
	}

	public Short getIndicadorUsoNomeFantasiaConta() {
		return indicadorUsoNomeFantasiaConta;
	}

	public void setIndicadorUsoNomeFantasiaConta(Short indicadorUsoNomeFantasiaConta) {
		this.indicadorUsoNomeFantasiaConta = indicadorUsoNomeFantasiaConta;
	}

	public Short getIndicadorPermiteNegativacao() {
		return indicadorPermiteNegativacao;
	}

	public void setIndicadorPermiteNegativacao(Short indicadorPermiteNegativacao) {
		this.indicadorPermiteNegativacao = indicadorPermiteNegativacao;
	}

	public ClienteTipo getClienteTipo() {
		return clienteTipo;
	}

	public void setClienteTipo(ClienteTipo clienteTipo) {
		this.clienteTipo = clienteTipo;
	}

	public boolean existeDiaVencimento() {
		return diaVencimento != null && diaVencimento.intValue() != 0;
	}
}