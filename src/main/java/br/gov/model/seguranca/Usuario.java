package br.gov.model.seguranca;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuario", schema="seguranca")
public class Usuario implements Serializable{
	private static final long serialVersionUID = -8230938760127248498L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIO")
	@SequenceGenerator(name="SEQ_USUARIO", schema="seguranca", sequenceName="seq_usuario", allocationSize=1)
	@Column(name="usur_id")
	private Integer id;
	
	@Column(name="usur_nmlogin")
	private String login;
	
	@Column(name="usur_nmsenha")
	private String senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + "]";
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
