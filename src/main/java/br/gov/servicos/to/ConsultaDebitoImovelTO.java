package br.gov.servicos.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultaDebitoImovelTO implements Serializable{
	private static final long serialVersionUID = 8462644031332851271L;
	
	private Integer idImovel;
	private List<Integer> situacoes;
	private Integer referenciaInicial;
	private Integer referenciaFinal;
	private Date vencimentoInicial;
	private Date vencimentoFinal;
	private Integer indicadorDebito;
	
	public Integer getIdImovel() {
		return idImovel;
	}
	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}
	public List<Integer> getSituacoes() {
        return situacoes;
    }
    public void setSituacoes(List<Integer> situacoes) {
        this.situacoes = situacoes;
    }
    public Integer getReferenciaInicial() {
		return referenciaInicial;
	}
	public void setReferenciaInicial(Integer referenciaInicial) {
		this.referenciaInicial = referenciaInicial;
	}
	public Integer getReferenciaFinal() {
		return referenciaFinal;
	}
	public void setReferenciaFinal(Integer referenciaFinal) {
		this.referenciaFinal = referenciaFinal;
	}
	public Date getVencimentoInicial() {
		return vencimentoInicial;
	}
	public void setVencimentoInicial(Date vencimentoInicial) {
		this.vencimentoInicial = vencimentoInicial;
	}
	public Date getVencimentoFinal() {
		return vencimentoFinal;
	}
	public void setVencimentoFinal(Date vencimentoFinal) {
		this.vencimentoFinal = vencimentoFinal;
	}
	public Integer getIndicadorDebito() {
		return indicadorDebito;
	}
	public void setIndicadorDebito(Integer indicadorDebito) {
		this.indicadorDebito = indicadorDebito;
	}
    public void addSituacao(Integer situacao){
		if (situacoes == null){
			situacoes = new ArrayList<Integer>();
		}
		situacoes.add(situacao);
	}

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idImovel == null) ? 0 : idImovel.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConsultaDebitoImovelTO other = (ConsultaDebitoImovelTO) obj;
        if (idImovel == null) {
            if (other.idImovel != null)
                return false;
        } else if (!idImovel.equals(other.idImovel))
            return false;
        return true;
    }
}