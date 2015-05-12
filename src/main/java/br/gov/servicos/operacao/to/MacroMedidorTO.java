package br.gov.servicos.operacao.to;

import java.io.Serializable;

import br.gov.model.operacao.TipoMedicao;

public class MacroMedidorTO implements Serializable{

	private static final long serialVersionUID = 2121508999382660307L;

	private Integer id;
	
	private Integer tipoMedicao;
	
	private String identificadorLeitura;

	public MacroMedidorTO(Integer id, Integer tipoMedicao,
			String identificadorLeitura) {
		this.id = id;
		this.tipoMedicao = tipoMedicao;
		this.identificadorLeitura = identificadorLeitura;
	}

	public MacroMedidorTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipoMedicao() {
		return tipoMedicao;
	}

	public void setTipoMedicao(Integer tipoMedicao) {
		this.tipoMedicao = tipoMedicao;
	}

	public String getIdentificadorLeitura() {
		return identificadorLeitura;
	}

	public void setIdentificadorLeitura(String identificadorLeitura) {
		this.identificadorLeitura = identificadorLeitura;
	}

	public String getDescricaoTipoMedicao() {
		return TipoMedicao.findById(this.tipoMedicao).getDescricao();
	}
}
