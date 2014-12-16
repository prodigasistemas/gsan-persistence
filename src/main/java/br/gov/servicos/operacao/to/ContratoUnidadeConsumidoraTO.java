package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.util.Date;

public class ContratoUnidadeConsumidoraTO implements Serializable{
    private static final long serialVersionUID = 5803870237314626125L;

    private Integer codigoUC;
    
    private Date dataFimContrato;
    
    public ContratoUnidadeConsumidoraTO(Integer codigoUC, Date dataFimContrato) {
        this.codigoUC = codigoUC;
        this.dataFimContrato = dataFimContrato;
    }

    public Integer getCodigoUC() {
        return codigoUC;
    }

    public void setCodigoUC(Integer codigoUC) {
        this.codigoUC = codigoUC;
    }

    public Date getDataFimContrato() {
        return dataFimContrato;
    }

    public void setDataFimContrato(Date dataFimContrato) {
        this.dataFimContrato = dataFimContrato;
    }
}
