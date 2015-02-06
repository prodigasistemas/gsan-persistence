package br.gov.servicos.operacao.to;

public enum TipoRelatorioProdutoQuimico {
	FISICO(1, "fisico"), FINANCEIRO(2, "financeiro");
	
	private int tipo;
	
	private String descricao; 
	
	TipoRelatorioProdutoQuimico(int cod, String desc){
		this.tipo = cod;
		this.descricao = desc;
	}

	public int getTipo() {
		return tipo;
	}
	
	public String getDescricao(){
		return descricao;
	}
}