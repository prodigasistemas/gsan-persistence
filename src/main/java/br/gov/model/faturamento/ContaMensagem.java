package br.gov.model.faturamento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.GerenciaRegional;
import br.gov.model.cadastro.Localidade;
import br.gov.model.cadastro.SetorComercial;

@Entity
@Table(schema="faturamento", name="conta_mensagem")
public class ContaMensagem implements Serializable{
	private static final long serialVersionUID = -954995399472396601L;
	
	@Id
	@Column(name = "ctms_id")
	private Integer id;
	
	@Column(name = "ctms_amreferenciafaturamento")
	private Integer anoMesRreferenciaFaturamento;
	
	@Column(name = "ctms_dscontamensagem01")
	private String descricaoContaMensagem01;
	
	@Column(name = "ctms_dscontamensagem02")
	private String descricaoContaMensagem02;
	
	@Column(name = "ctms_dscontamensagem03")
	private String descricaoContaMensagem03;
	
	@ManyToOne
	@JoinColumn(name="ftgr_id")
	private FaturamentoGrupo faturamentoGrupo;
	
	@ManyToOne
	@JoinColumn(name="greg_id")
	private GerenciaRegional gerenciaRegional;
	
	@ManyToOne
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="stcm_id")
	private SetorComercial setorComercial;
	
	public ContaMensagem() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesRreferenciaFaturamento() {
		return anoMesRreferenciaFaturamento;
	}

	public void setAnoMesRreferenciaFaturamento(Integer anoMesRreferenciaFaturamento) {
		this.anoMesRreferenciaFaturamento = anoMesRreferenciaFaturamento;
	}

	public String getDescricaoContaMensagem01() {
		return descricaoContaMensagem01;
	}

	public void setDescricaoContaMensagem01(String descricaoContaMensagem01) {
		this.descricaoContaMensagem01 = descricaoContaMensagem01;
	}

	public String getDescricaoContaMensagem02() {
		return descricaoContaMensagem02;
	}

	public void setDescricaoContaMensagem02(String descricaoContaMensagem02) {
		this.descricaoContaMensagem02 = descricaoContaMensagem02;
	}

	public String getDescricaoContaMensagem03() {
		return descricaoContaMensagem03;
	}

	public void setDescricaoContaMensagem03(String descricaoContaMensagem03) {
		this.descricaoContaMensagem03 = descricaoContaMensagem03;
	}

	public FaturamentoGrupo getFaturamentoGrupo() {
		return faturamentoGrupo;
	}

	public void setFaturamentoGrupo(FaturamentoGrupo faturamentoGrupo) {
		this.faturamentoGrupo = faturamentoGrupo;
	}

	public GerenciaRegional getGerenciaRegional() {
		return gerenciaRegional;
	}

	public void setGerenciaRegional(GerenciaRegional gerenciaRegional) {
		this.gerenciaRegional = gerenciaRegional;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public SetorComercial getSetorComercial() {
		return setorComercial;
	}

	public void setSetorComercial(SetorComercial setorComercial) {
		this.setorComercial = setorComercial;
	}
}