package br.gov.servicos.operacao.to;

import java.io.Serializable;

public class DadosRelatorioEnergiaEletrica implements Serializable{
	private static final long serialVersionUID = -3571976936845251980L;
	
    private Integer idMunicipio;
    private String  nomeMunicipio;
    private Integer idLocalidade;
    private String  nomeLocalidade;
    private Integer uc;
    private Integer referencia;
	private Double consumo;
	private Double ultrapassagemKwh;
	private Double ultrapassagemValor;
	private Double totalFatorPotencia;
	private Double valorTotal;
	

    public DadosRelatorioEnergiaEletrica(Integer idMunicipio, String nomeMunicipio, Integer idLocalidade, String nomeLocalidade, Integer uc,
            Integer referencia, Double consumo, Double ultrapassagemKwh, Double ultrapassagemValor, Double totalFatorPotencia, Double valorTotal) {
        super();
        this.idMunicipio = idMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.idLocalidade = idLocalidade;
        this.nomeLocalidade = nomeLocalidade;
        this.uc = uc;
        this.referencia = referencia;
        this.consumo = consumo;
        this.ultrapassagemKwh = ultrapassagemKwh;
        this.ultrapassagemValor = ultrapassagemValor;
        this.totalFatorPotencia = totalFatorPotencia;
        this.valorTotal = valorTotal;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Integer idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }

    public Integer getUc() {
        return uc;
    }

    public void setUc(Integer uc) {
        this.uc = uc;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Double getUltrapassagemKwh() {
        return ultrapassagemKwh;
    }

    public void setUltrapassagemKwh(Double ultrapassagemKwh) {
        this.ultrapassagemKwh = ultrapassagemKwh;
    }

    public Double getUltrapassagemValor() {
        return ultrapassagemValor;
    }

    public void setUltrapassagemValor(Double ultrapassagemValor) {
        this.ultrapassagemValor = ultrapassagemValor;
    }

    public Double getTotalFatorPotencia() {
        return totalFatorPotencia;
    }

    public void setTotalFatorPotencia(Double totalFatorPotencia) {
        this.totalFatorPotencia = totalFatorPotencia;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String toString() {
		return "DadosRelatorioEnergiaEletrica [nomeMunicipio=" + nomeMunicipio
				+ ", nomeLocalidade=" + nomeLocalidade + ", consumo=" + consumo
				+ ", ultrapassagemKwh=" + ultrapassagemKwh
				+ ", ultrapassagemValor=" + ultrapassagemValor
				+ ", totalFatorPotencia=" + totalFatorPotencia
				+ ", valorTotal=" + valorTotal + "]";
	}
}
