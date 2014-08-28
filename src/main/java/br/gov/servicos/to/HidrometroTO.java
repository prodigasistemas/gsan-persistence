package br.gov.servicos.to;

import java.io.Serializable;
import java.util.Date;


public class HidrometroTO implements Serializable{
	private static final long serialVersionUID = -6553283657678450425L;

	private String numero;
	
	private Short numeroDigitosLeitura;
	
	private Date dataInstalacao;
	
	private Integer numeroLeituraInstalacao;
	
	private Integer idImovel;
	
	private String descricaoLocalInstalacao;

	private Integer rateioTipo;

	public HidrometroTO(String numero, Short numeroDigitosLeitura, Date dataInstalacao, Integer numeroLeituraInstalacao, Integer idImovel,
			String descricaoLocalInstalacao, Integer rateioTipo) {
		this.numero = numero;
		this.numeroDigitosLeitura = numeroDigitosLeitura;
		this.dataInstalacao = dataInstalacao;
		this.numeroLeituraInstalacao = numeroLeituraInstalacao;
		this.idImovel = idImovel;
		this.descricaoLocalInstalacao = descricaoLocalInstalacao;
		this.rateioTipo = rateioTipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Short getNumeroDigitosLeitura() {
		return numeroDigitosLeitura;
	}

	public void setNumeroDigitosLeitura(Short numeroDigitosLeitura) {
		this.numeroDigitosLeitura = numeroDigitosLeitura;
	}

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public Integer getNumeroLeituraInstalacao() {
		return numeroLeituraInstalacao;
	}

	public void setNumeroLeituraInstalacao(Integer numeroLeituraInstalacao) {
		this.numeroLeituraInstalacao = numeroLeituraInstalacao;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public String getDescricaoLocalInstalacao() {
		return descricaoLocalInstalacao;
	}

	public void setDescricaoLocalInstalacao(String descricaoLocalInstalacao) {
		this.descricaoLocalInstalacao = descricaoLocalInstalacao;
	}

	public Integer getRateioTipo() {
		return rateioTipo;
	}

	public void setRateioTipo(Integer rateioTipo) {
		this.rateioTipo = rateioTipo;
	}
}
