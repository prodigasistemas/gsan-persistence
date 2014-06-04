package br.gov.model.atendimentopublico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.Imovel;
import br.gov.model.micromedicao.HidrometroInstalacaoHistorico;

@Entity
@Table(name = "ligacao_agua", schema = "atendimentopublico")
public class LigacaoAgua {
	@Id
	@Column(name="lagu_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="imov_id")
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name="hidi_id")
	private HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico;
	
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

	public HidrometroInstalacaoHistorico getHidrometroInstalacaoHistorico() {
		return hidrometroInstalacaoHistorico;
	}

	public void setHidrometroInstalacaoHistorico(HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico) {
		this.hidrometroInstalacaoHistorico = hidrometroInstalacaoHistorico;
	}

	public String toString() {
		return "LigacaoAgua [id=" + id + ", imovel=" + imovel + "]";
	}
}