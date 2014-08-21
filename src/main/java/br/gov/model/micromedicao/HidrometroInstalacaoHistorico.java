package br.gov.model.micromedicao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.gov.model.atendimentopublico.LigacaoAgua;

@Entity
@Table(name="hidrometro_inst_hist", schema="micromedicao")
public class HidrometroInstalacaoHistorico implements Serializable{
	private static final long serialVersionUID = 3683359932766035603L;

	@Id
	@Column(name = "hidi_id")
	private Long id;
	
	@Column(name="medt_id")
	private Short medicaoTipo;
	
	@OneToMany(mappedBy="hidrometroInstalacaoHistorico")
	private List<LigacaoAgua> ligacoesAgua;
	
	@ManyToOne
	@JoinColumn(name="hili_id")
	private HidrometroLocalInstalacao hidrometroLocalInstalacao;
	
	@ManyToOne
	@JoinColumn(name="hipr_id")
	private HidrometroProtecao hidrometroProtecao;
	
	public HidrometroInstalacaoHistorico() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getMedicaoTipo() {
		return medicaoTipo;
	}

	public void setMedicaoTipo(Short medicaoTipo) {
		this.medicaoTipo = medicaoTipo;
	}

	public List<LigacaoAgua> getLigacoesAgua() {
		return ligacoesAgua;
	}

	public void setLigacoesAgua(List<LigacaoAgua> ligacoesAgua) {
		this.ligacoesAgua = ligacoesAgua;
	}

	public HidrometroLocalInstalacao getHidrometroLocalInstalacao() {
		return hidrometroLocalInstalacao;
	}

	public void setHidrometroLocalInstalacao(HidrometroLocalInstalacao hidrometroLocalInstalacao) {
		this.hidrometroLocalInstalacao = hidrometroLocalInstalacao;
	}

	public HidrometroProtecao getHidrometroProtecao() {
		return hidrometroProtecao;
	}

	public void setHidrometroProtecao(HidrometroProtecao hidrometroProtecao) {
		this.hidrometroProtecao = hidrometroProtecao;
	}

	public String toString() {
		return "HidrometroInstalacaoHistorico [id=" + id + "]";
	}
}