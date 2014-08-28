package br.gov.model.atendimentopublico;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.Imovel;
import br.gov.model.micromedicao.HidrometroInstalacaoHistorico;

@Entity
@Table(name = "ligacao_agua", schema = "atendimentopublico")
public class LigacaoAgua implements Serializable{
	private static final long serialVersionUID = -5223172999613411911L;

	@Id
	@Column(name="lagu_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@OneToMany(mappedBy="ligacaoAgua")
	private Set<HidrometroInstalacaoHistorico> hidrometroInstalacoesHistorico;
	
	public LigacaoAgua() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Set<HidrometroInstalacaoHistorico> getHidrometroInstalacoesHistorico() {
		return hidrometroInstalacoesHistorico;
	}

	public void setHidrometroInstalacoesHistorico(Set<HidrometroInstalacaoHistorico> hidrometroInstalacoesHistorico) {
		this.hidrometroInstalacoesHistorico = hidrometroInstalacoesHistorico;
	}

	public String toString() {
		return "LigacaoAgua [id=" + id + ", imovel=" + imovel + "]";
	}
}