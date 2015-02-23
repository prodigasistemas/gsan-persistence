package br.gov.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="imovel_conta_envio", schema="cadastro")
public class ImovelContaEnvio {
	
	@Id
	@Column(name="icte_id")
	private Integer id;
	
	@Column(name="icte_icuso")
	private Short indicadorUso;

	public static Integer ENVIAR_CLIENTE_RESPONSAVEL 				= Integer.valueOf(1);
	public static Integer ENVIAR_IMOVEL 							= Integer.valueOf(2);
	public static Integer NAO_PAGAVEL_IMOVEL_PAGAVEL_RESPONSAVEL 	= Integer.valueOf(3);
	public static Integer ENVIAR_PARA_EMAIL 						= Integer.valueOf(4);
	public static Integer ENVIAR_PARA_IMOVEL_E_PARA_EMAIL 			= Integer.valueOf(5);
	public static Integer ENVIAR_CONTA_BRAILLE 						= Integer.valueOf(6);
	public static Integer ENVIAR_CONTA_BRAILLE_RESPONSAVEL 			= Integer.valueOf(7);
	public static Integer ENVIAR_CLIENTE_RESPONSAVEL_FINAL_GRUPO 	= Integer.valueOf(9);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}
	
	
	
	
}
