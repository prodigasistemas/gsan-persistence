package br.gov.servicos.cadastro.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class AreaConstruidaTO implements Serializable{
    private static final long serialVersionUID = -1692415698817749618L;

    private BigDecimal areaConstruida;
    
    private Integer menorFaixa;

    public AreaConstruidaTO(BigDecimal areaConstruida, Integer maiorFaixa) {
        super();
        this.areaConstruida = areaConstruida;
        this.menorFaixa = maiorFaixa;
    }

    public BigDecimal getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(BigDecimal areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public Integer getMenorFaixa() {
        return menorFaixa;
    }

    public void setMenorFaixa(Integer faixa) {
        this.menorFaixa = faixa;
    }
}
