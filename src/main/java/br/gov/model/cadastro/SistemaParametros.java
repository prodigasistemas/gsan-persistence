package br.gov.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sistema_parametros", schema="cadastro")
public class SistemaParametros {
	
	@Id
	@Column(name="parm_id")
	private Integer id;
	
	@Column(name="parm_amreferenciafaturamento")
	private Integer anoMesFaturamento;
	
	@Column(name="parm_nnmindiasemsvcmto")
	private Short numeroMinimoDiasEmissaoVencimento;
	
	@Column(name="parm_nndiasadicionaiscorreios")
	private Short numeroDiasAdicionaisCorreios;
	
	@Column(name="parm_nnmesesvalidadeconta")
	private Short numeroMesesValidadeConta;
	
	public SistemaParametros() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesFaturamento() {
		return anoMesFaturamento;
	}

	public void setAnoMesFaturamento(Integer anoMesFaturamento) {
		this.anoMesFaturamento = anoMesFaturamento;
	}

	public Short getNumeroMinimoDiasEmissaoVencimento() {
		return numeroMinimoDiasEmissaoVencimento;
	}

	public void setNumeroMinimoDiasEmissaoVencimento(Short numeroMinimoDiasEmissaoVencimento) {
		this.numeroMinimoDiasEmissaoVencimento = numeroMinimoDiasEmissaoVencimento;
	}

	public Short getNumeroDiasAdicionaisCorreios() {
		return numeroDiasAdicionaisCorreios;
	}

	public void setNumeroDiasAdicionaisCorreios(Short numeroDiasAdicionaisCorreios) {
		this.numeroDiasAdicionaisCorreios = numeroDiasAdicionaisCorreios;
	}

	public Short getNumeroMesesValidadeConta() {
		return numeroMesesValidadeConta;
	}

	public void setNumeroMesesValidadeConta(Short numeroMesesValidadeConta) {
		this.numeroMesesValidadeConta = numeroMesesValidadeConta;
	}
}