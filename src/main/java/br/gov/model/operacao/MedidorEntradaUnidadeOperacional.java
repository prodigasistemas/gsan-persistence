package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="medidor_entrada_unidade_operacional", schema="operacao")
public class MedidorEntradaUnidadeOperacional implements Serializable{
	private static final long serialVersionUID = 3848963424071649125L;

	@EmbeddedId
	private MedidorUnidadeOperacionalPK pk;
	
	@Column(name="id_unidade_operacional")
	private Integer idUnidadeOperacional;
	
	@Column(name="tipo_medicao")
	private Integer tipoMedicao;
	
	@Column(name="identificador_leitura")
	private String identificadorLeitura;
	
	public MedidorEntradaUnidadeOperacional() {
	}
	
	public MedidorEntradaUnidadeOperacional(Integer idMedidor, Integer tipoUnidade,
			Integer idUnidadeOperacional, Integer tipo_medicao,
			String identificadorLeitura) {
		this.pk = new MedidorUnidadeOperacionalPK(tipoUnidade, idMedidor);
		this.idUnidadeOperacional = idUnidadeOperacional;
		this.tipoMedicao = tipo_medicao;
		this.identificadorLeitura = identificadorLeitura;
	}

	public MedidorUnidadeOperacionalPK getPk() {
		return pk;
	}

	public void setPk(MedidorUnidadeOperacionalPK pk) {
		this.pk = pk;
	}

	public Integer getIdUnidadeOperacional() {
		return idUnidadeOperacional;
	}

	public void setIdUnidadeOperacional(Integer idUnidadeOperacional) {
		this.idUnidadeOperacional = idUnidadeOperacional;
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
	
	public String getTipoDescricao() {
		return TipoMedicao.findById(tipoMedicao).getDescricao();
	}
}
