package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="cadastro", name="imovel_perfil")
public class ImovelPerfil implements Serializable{
	private static final long serialVersionUID = -3121627671956793452L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_IMOVEL_PERFIL")
	@SequenceGenerator(name="SEQ_IMOVEL_PERFIL", schema="cadastro", sequenceName="seq_imovel_perfil", allocationSize=1)	
	@Column(name="iper_id")
	private Integer id;
	
	@Column(name="iper_icgerardadosleitura")
	private Short indicadorGerarDadosLeitura;
	
	public ImovelPerfil() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getIndicadorGerarDadosLeitura() {
		return indicadorGerarDadosLeitura;
	}

	public void setIndicadorGerarDadosLeitura(Short indicadorGerarDadosLeitura) {
		this.indicadorGerarDadosLeitura = indicadorGerarDadosLeitura;
	}
}
