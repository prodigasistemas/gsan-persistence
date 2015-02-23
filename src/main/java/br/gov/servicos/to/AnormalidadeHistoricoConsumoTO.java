package br.gov.servicos.to;

import java.io.Serializable;

import br.gov.model.micromedicao.ConsumoAnormalidade;

public class AnormalidadeHistoricoConsumoTO implements Serializable {
	private static final long serialVersionUID = -6865141713743168236L;
	
	private Integer idConsumoHistorico;
	
	private Integer idAnormalidade;

	private Integer ligacaoTipo;

	private Integer referenciaFaturamento;
	
	public AnormalidadeHistoricoConsumoTO() {
    }

	public AnormalidadeHistoricoConsumoTO(Integer idConsumoHistorico, Integer idAnormalidade, Integer ligacaoTipo, Integer referenciaFaturamento) {
		this.idConsumoHistorico = idConsumoHistorico;
		this.idAnormalidade = idAnormalidade;
		this.ligacaoTipo = ligacaoTipo;
		this.referenciaFaturamento = referenciaFaturamento;
	}
	
    public boolean anormalidadeporBaixoAltoOuEstouroConsumo(){
        return idAnormalidade == ConsumoAnormalidade.BAIXO_CONSUMO 
                || idAnormalidade == ConsumoAnormalidade.ALTO_CONSUMO 
                || idAnormalidade == ConsumoAnormalidade.ESTOURO_CONSUMO;
    }
	

	public Integer getIdConsumoHistorico() {
		return idConsumoHistorico;
	}

	public void setIdConsumoHistorico(Integer idConsumoHistorico) {
		this.idConsumoHistorico = idConsumoHistorico;
	}

	public Integer getIdAnormalidade() {
		return idAnormalidade;
	}

	public void setIdAnormalidade(Integer idAnormalidade) {
		this.idAnormalidade = idAnormalidade;
	}

	public Integer getLigacaoTipo() {
		return ligacaoTipo;
	}

	public void setLigacaoTipo(Integer ligacaoTipo) {
		this.ligacaoTipo = ligacaoTipo;
	}

	public Integer getReferenciaFaturamento() {
		return referenciaFaturamento;
	}

	public void setReferenciaFaturamento(Integer referenciaFaturamento) {
		this.referenciaFaturamento = referenciaFaturamento;
	}
}
