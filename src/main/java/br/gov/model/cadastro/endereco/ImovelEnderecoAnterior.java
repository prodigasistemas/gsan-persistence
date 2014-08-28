package br.gov.model.cadastro.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.Imovel;

@Entity
@Table(name="imovel_endereco_anterior", schema="cadastro")
public class ImovelEnderecoAnterior implements Serializable {
	private static final long serialVersionUID = -182709054906707815L;

	@Id
	@Column(name="imov_id")
	private Integer id;
	
	@Column(name="ieda_dsenderecoanterior")
	private String enderecoAnterior;
	
	@OneToOne
	@JoinColumn(name="imov_id", insertable=false, updatable=false)
	private Imovel imovel; 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnderecoAnterior() {
		return enderecoAnterior;
	}

	public void setEnderecoAnterior(String enderecoAnterior) {
		this.enderecoAnterior = enderecoAnterior;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public String toString() {
		return "ImovelEnderecoAnterior [id=" + id + "]";
	}
}