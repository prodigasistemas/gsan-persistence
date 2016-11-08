package br.gov.servicos.to;

import java.io.Serializable;

import br.gov.model.cadastro.Imovel;
import br.gov.model.desempenho.ContratoMedicao;

public class MedicaoPerformanceParametrosTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3334552164216211040L;
	private Integer referencia;
	private ContratoMedicao contratoMedicao;
	private Imovel imovel;
	
	public MedicaoPerformanceParametrosTO(){}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public ContratoMedicao getContratoMedicao() {
		return contratoMedicao;
	}

	public void setContratoMedicao(ContratoMedicao contratoMedicao) {
		this.contratoMedicao = contratoMedicao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
}
