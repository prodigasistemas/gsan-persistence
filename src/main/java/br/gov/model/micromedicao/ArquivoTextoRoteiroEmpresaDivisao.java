package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="arq_txt_roteiro_emp_div", schema="micromedicao")
public class ArquivoTextoRoteiroEmpresaDivisao implements Serializable{
	private static final long serialVersionUID = -6177934368767605429L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ARQ_TXT_ROTEIRO_EMP_DIV")
	@SequenceGenerator(name="SEQ_ARQ_TXT_ROTEIRO_EMP_DIV", schema="micromedicao", sequenceName="seq_arq_txt_roteiro_emp_div", allocationSize=1)
	@Column(name="tred_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="txre_id")
	private ArquivoTextoRoteiroEmpresa arquivoTextoRoteiroEmpresa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArquivoTextoRoteiroEmpresa getArquivoTextoRoteiroEmpresa() {
		return arquivoTextoRoteiroEmpresa;
	}

	public void setArquivoTextoRoteiroEmpresa(ArquivoTextoRoteiroEmpresa arquivoTextoRoteiroEmpresa) {
		this.arquivoTextoRoteiroEmpresa = arquivoTextoRoteiroEmpresa;
	}
}
