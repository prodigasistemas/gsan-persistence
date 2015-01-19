package br.gov.model.faturamento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="qualidade_agua_padrao", schema="faturamento")
public class QualidadeAguaPadrao implements Serializable{
	private static final long serialVersionUID = -5113872734895310271L;
	
	@Id
	@Column(name="qlap_id")
	private Integer id;
	
	@Column(name="qlap_dspadraoturbidez")
	private String descricaoPadraoTurbidez;
	
	@Column(name="qlap_dspadraoph")
	private String descricaoPadraoPh;
	
	@Column(name="qlap_dspadraocor")
	private String descricaoPadraoCor;
	
	@Column(name="qlap_dspadraocloro")
	private String descricaoPadraoCloro;
	
	@Column(name="qlap_dspadraofluor")
	private String descricaoPadraoFluor;
	
	@Column(name="qlap_dspadraoferro")
	private String descricaoPadraoFerro;
	
	@Column(name="qlap_dspadraocoliformestotais")
	private String descricaoPadraoColiformesTotais;
	
	@Column(name="qlap_dspadraocoliformesfecais")
	private String descricaoPadraoColiformesFecais;
	
	@Column(name="qlap_tmultimaalteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAlteracao;
	
	@Column(name="qlap_dspadraonitrato")
	private String descricaoNitrato;
	
	@Column(name="qlap_dspadraocoliftermo")
	private String descricaoPadraoColiformesTermotolerantes;
	
	@Column(name="qlap_dspadraoalcalinidade")
	private String descricaoPadraoAlcalinidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoPadraoTurbidez() {
		return descricaoPadraoTurbidez;
	}

	public void setDescricaoPadraoTurbidez(String descricaoPadraoTurbidez) {
		this.descricaoPadraoTurbidez = descricaoPadraoTurbidez;
	}

	public String getDescricaoPadraoPh() {
		return descricaoPadraoPh;
	}

	public void setDescricaoPadraoPh(String descricaoPadraoPh) {
		this.descricaoPadraoPh = descricaoPadraoPh;
	}

	public String getDescricaoPadraoCor() {
		return descricaoPadraoCor;
	}

	public void setDescricaoPadraoCor(String descricaoPadraoCor) {
		this.descricaoPadraoCor = descricaoPadraoCor;
	}

	public String getDescricaoPadraoCloro() {
		return descricaoPadraoCloro;
	}

	public void setDescricaoPadraoCloro(String descricaoPadraoCloro) {
		this.descricaoPadraoCloro = descricaoPadraoCloro;
	}

	public String getDescricaoPadraoFluor() {
		return descricaoPadraoFluor;
	}

	public void setDescricaoPadraoFluor(String descricaoPadraoFluor) {
		this.descricaoPadraoFluor = descricaoPadraoFluor;
	}

	public String getDescricaoPadraoFerro() {
		return descricaoPadraoFerro;
	}

	public void setDescricaoPadraoFerro(String descricaoPadraoFerro) {
		this.descricaoPadraoFerro = descricaoPadraoFerro;
	}

	public String getDescricaoPadraoColiformesTotais() {
		return descricaoPadraoColiformesTotais;
	}

	public void setDescricaoPadraoColiformesTotais(
			String descricaoPadraoColiformesTotais) {
		this.descricaoPadraoColiformesTotais = descricaoPadraoColiformesTotais;
	}

	public String getDescricaoPadraoColiformesFecais() {
		return descricaoPadraoColiformesFecais;
	}

	public void setDescricaoPadraoColiformesFecais(
			String descricaoPadraoColiformesFecais) {
		this.descricaoPadraoColiformesFecais = descricaoPadraoColiformesFecais;
	}

	public Date getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Date ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public String getDescricaoNitrato() {
		return descricaoNitrato;
	}

	public void setDescricaoNitrato(String descricaoNitrato) {
		this.descricaoNitrato = descricaoNitrato;
	}

	public String getDescricaoPadraoColiformesTermotolerantes() {
		return descricaoPadraoColiformesTermotolerantes;
	}

	public void setDescricaoPadraoColiformesTermotolerantes(
			String descricaoPadraoColiformesTermotolerantes) {
		this.descricaoPadraoColiformesTermotolerantes = descricaoPadraoColiformesTermotolerantes;
	}

	public String getDescricaoPadraoAlcalinidade() {
		return descricaoPadraoAlcalinidade;
	}

	public void setDescricaoPadraoAlcalinidade(String descricaoPadraoAlcalinidade) {
		this.descricaoPadraoAlcalinidade = descricaoPadraoAlcalinidade;
	}
	
}
