package br.gov.model.cadastro.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cep", schema="cadastro")
public class Cep implements Serializable {
	private static final long serialVersionUID = 8525933517290089222L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CEP")
	@SequenceGenerator(name="SEQ_CEP", schema="cadastro", sequenceName="seq_cep", allocationSize=1)
	@Column(name="cep_id")
	private Integer id;
	
	@Column(name="cep_cdcep")
	private Integer codigo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCepFormatado() {
        String strCod = codigo != null ? String.valueOf(codigo) : " ";
        
        if (strCod.length() == 8){
        	strCod = strCod.substring(0, 5) + "-" + strCod.substring(5, 8);
        }
        
        return strCod;
    }

	public String toString() {
		return "Cep [id=" + id + "]";
	}
}