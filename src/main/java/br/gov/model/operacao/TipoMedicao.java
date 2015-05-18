package br.gov.model.operacao;

public enum TipoMedicao {
	VAZAO("Vazao",1), PRESSAO("Pressao",2), NIVEL("Nivel", 3);

	private Integer id;
	private String descricao;

	private TipoMedicao(String descricao, Integer id) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}
	
	public static TipoMedicao findById(int id){
	    for (TipoMedicao tipo : TipoMedicao.values()){
	        if (tipo.id == id)
	            return tipo;
	    }
	    
	    return null;
	}

	public String getDescricao() {
		return descricao;
	}
}
