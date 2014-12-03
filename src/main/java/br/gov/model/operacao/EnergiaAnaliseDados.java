package br.gov.model.operacao;

import java.io.Serializable;

public class EnergiaAnaliseDados implements Serializable {
    private static final long serialVersionUID = 8345738607632980748L;

    private Integer referencia;

    private double valor;

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
