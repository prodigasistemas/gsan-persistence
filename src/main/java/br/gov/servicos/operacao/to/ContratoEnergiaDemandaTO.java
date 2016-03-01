package br.gov.servicos.operacao.to;

import java.io.Serializable;

public class ContratoEnergiaDemandaTO implements  Serializable{
    private static final long serialVersionUID = -3963057724157167142L;

    private Integer codigo;
	
	private Integer periodoInicial;

	private Integer periodoFinal;
	
	private Integer demandaSecoPonta;
	
	private Integer demandaSecoForaPonta;

	private Integer demandaUmidoPonta;

	private Integer demandaUmidoForaPonta;

	private Integer convencionalVerde;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(Integer periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public Integer getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(Integer periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public Integer getDemandaSecoPonta() {
        return demandaSecoPonta;
    }

    public void setDemandaSecoPonta(Integer demandaSecoPonta) {
        this.demandaSecoPonta = demandaSecoPonta;
    }

    public Integer getDemandaSecoForaPonta() {
        return demandaSecoForaPonta;
    }

    public void setDemandaSecoForaPonta(Integer demandaSecoForaPonta) {
        this.demandaSecoForaPonta = demandaSecoForaPonta;
    }

    public Integer getDemandaUmidoPonta() {
        return demandaUmidoPonta;
    }

    public void setDemandaUmidoPonta(Integer demandaUmidoPonta) {
        this.demandaUmidoPonta = demandaUmidoPonta;
    }

    public Integer getDemandaUmidoForaPonta() {
        return demandaUmidoForaPonta;
    }

    public void setDemandaUmidoForaPonta(Integer demandaUmidoForaPonta) {
        this.demandaUmidoForaPonta = demandaUmidoForaPonta;
    }

    public Integer getConvencionalVerde() {
        return convencionalVerde;
    }

    public void setConvencionalVerde(Integer convencionalVerde) {
        this.convencionalVerde = convencionalVerde;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContratoEnergiaDemandaTO other = (ContratoEnergiaDemandaTO) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
