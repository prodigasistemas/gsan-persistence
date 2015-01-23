package br.gov.model.faturamento;

import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.Quadra;
import br.gov.model.financeiro.LancamentoItemContabil;

public interface IDebito {

	DebitoTipo getDebitoTipo();
	
	LancamentoItemContabil getLancamentoItemContabil();
	
	Localidade getLocalidade();
	
	Quadra getQuadra();
	
	Integer getCodigoSetorComercial();
	
	Integer getNumeroQuadra();
	
	Short getNumeroLote();
	
	Short getNumeroSubLote();
	
	Integer getAnoMesReferenciaDebito();
	
	Integer getAnoMesCobrancaDebito();
	
	Integer getTipoFinanciamento();
}