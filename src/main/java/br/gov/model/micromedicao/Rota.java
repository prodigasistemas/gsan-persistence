package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.Status;
import br.gov.model.cadastro.Empresa;
import br.gov.model.faturamento.FaturamentoGrupo;


@Entity
@Table(name="rota", schema="micromedicao")
public class Rota implements Serializable {
	private static final long serialVersionUID = 3490871292616360289L;
	
	@Id
	@Column(name="rota_id")
	private Integer id;
	
	@Column(name="lttp_id")
	private Short leituraTipo;
	
	@Column(name="rota_icalternativa")
	private Short indicadorRotaAlternativa;
	
	@ManyToOne
	@JoinColumn(name="ftgr_id")
	private FaturamentoGrupo faturamentoGrupo;
	
	@ManyToOne
	@JoinColumn(name="leit_id")
	private Leiturista leiturista;
	
	@ManyToOne
	@JoinColumn(name="empr_id")
	private Empresa empresa;
	
	public Rota() {
	}

	public boolean alternativa() {
		return indicadorRotaAlternativa != null && indicadorRotaAlternativa == Status.ATIVO.getId();
	}

/**********************************************
 ************ GETTERS AND SETTERS ************* 
 **********************************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getLeituraTipo() {
		return leituraTipo;
	}

	public void setLeituraTipo(Short leituraTipo) {
		this.leituraTipo = leituraTipo;
	}
	
	public Short getIndicadorRotaAlternativa() {
		return indicadorRotaAlternativa;
	}

	public void setIndicadorRotaAlternativa(Short indicadorRotaAlternativa) {
		this.indicadorRotaAlternativa = indicadorRotaAlternativa;
	}
	
	public boolean isAlternativa(){
		return indicadorRotaAlternativa != null && indicadorRotaAlternativa == (short) 1;
	}

	public FaturamentoGrupo getFaturamentoGrupo() {
		return faturamentoGrupo;
	}

	public void setFaturamentoGrupo(FaturamentoGrupo faturamentoGrupo) {
		this.faturamentoGrupo = faturamentoGrupo;
	}

	public Leiturista getLeiturista() {
		return leiturista;
	}

	public void setLeiturista(Leiturista leiturista) {
		this.leiturista = leiturista;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String toString() {
		return "Rota [id=" + id + "]";
	}
}