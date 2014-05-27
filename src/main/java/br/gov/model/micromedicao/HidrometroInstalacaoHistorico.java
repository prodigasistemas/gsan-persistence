package br.gov.model.micromedicao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.gov.model.atendimentopublico.LigacaoAgua;

@Entity
@Table(name="hidrometro_inst_hist", schema="micromedicao")
public class HidrometroInstalacaoHistorico {
	@Id
	@Column(name = "hidi_id")
	private Long id;
	
	@OneToMany(mappedBy="hidrometroInstalacaoHistorico")
	private List<LigacaoAgua> ligacoesAgua;
	
	public HidrometroInstalacaoHistorico() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<LigacaoAgua> getLigacoesAgua() {
		return ligacoesAgua;
	}

	public void setLigacoesAgua(List<LigacaoAgua> ligacoesAgua) {
		this.ligacoesAgua = ligacoesAgua;
	}
}