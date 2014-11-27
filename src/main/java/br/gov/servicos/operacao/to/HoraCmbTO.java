package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;

import br.gov.model.operacao.TipoRegistroHoras;

public class HoraCmbTO implements Serializable {
	private static final long serialVersionUID = -7159627292037705851L;
	
	private Integer codigo;
	
	private Integer cmb;
	
	private BigDecimal medicao;
	
	private TipoRegistroHoras tipoRegistro;
	
	public HoraCmbTO() {
    }

    public HoraCmbTO(Integer codigo, Integer cmb, BigDecimal medicao, TipoRegistroHoras tipo) {
        super();
        this.codigo = codigo;
        this.cmb = cmb;
        this.medicao = medicao;
        this.tipoRegistro = tipo;
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

    public TipoRegistroHoras getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistroHoras tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String toString() {
        return "HoraCmbTO [codigo=" + codigo + ", cmb=" + cmb + ", medicao=" + medicao + "]";
    }
}
