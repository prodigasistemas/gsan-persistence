package br.gov.servicos.operacao.to;

import java.io.Serializable;

public class ContratoEnergiaListagemTO implements Serializable{
    private static final long serialVersionUID = 2642283448756478868L;
    
    private Integer codigo;
    
    private String numeroContrato;
    
    private Integer uc;
    
    private Integer vigenciaInicial;
    
    private Integer vigenciaFinal;
    
    public ContratoEnergiaListagemTO() {
    }
    
    public ContratoEnergiaListagemTO(Integer codigo, String numeroContrato, Integer uc, Integer vigenciaInicial, Integer vigenciaFinal) {
        super();
        this.codigo = codigo;
        this.numeroContrato = numeroContrato;
        this.uc = uc;
        this.vigenciaInicial = vigenciaInicial;
        this.vigenciaFinal = vigenciaFinal;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Integer getUc() {
        return uc;
    }

    public void setUc(Integer uc) {
        this.uc = uc;
    }

    public Integer getVigenciaInicial() {
        return vigenciaInicial;
    }

    public void setVigenciaInicial(Integer vigenciaInicial) {
        this.vigenciaInicial = vigenciaInicial;
    }

    public Integer getVigenciaFinal() {
        return vigenciaFinal;
    }

    public void setVigenciaFinal(Integer vigenciaFinal) {
        this.vigenciaFinal = vigenciaFinal;
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
        ContratoEnergiaListagemTO other = (ContratoEnergiaListagemTO) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
