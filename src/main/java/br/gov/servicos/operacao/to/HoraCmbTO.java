package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class HoraCmbTO implements Serializable {
	private static final long serialVersionUID = -7159627292037705851L;
	
	private Integer codigo;
	
	private Integer cmb;
	
	private BigDecimal medicao;
	
	public HoraCmbTO() {
    }

    public HoraCmbTO(Integer codigo, Integer cmb, BigDecimal medicao) {
        super();
        this.codigo = codigo;
        this.cmb = cmb;
        this.medicao = medicao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCmb() {
        return cmb;
    }

    public void setCmb(Integer cmb) {
        this.cmb = cmb;
    }

    public BigDecimal getMedicao() {
        return medicao;
    }

    public void setMedicao(BigDecimal medicao) {
        this.medicao = medicao;
    }

    public String toString() {
        return "HoraCmbTO [codigo=" + codigo + ", cmb=" + cmb + ", medicao=" + medicao + "]";
    }
}
