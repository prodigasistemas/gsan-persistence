package br.gov.model.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.model.atendimentopublico.LigacaoAgua;
import br.gov.model.atendimentopublico.LigacaoAguaSituacao;
import br.gov.model.atendimentopublico.LigacaoEsgotoSituacao;

@Entity
@Table(name="imovel", schema="cadastro")
@NamedQueries({
	@NamedQuery(name="imovel.totalImoveisParaPreFaturamento"
			,query="select count(im) from Imovel im "
					+ " inner join im.quadra qua "
					+ " inner join qua.rota rot "
					+ " WHERE rot.id = :rotaId ")
	,
	@NamedQuery(name="imovel.pesquisarImovelParaPreFaturamento"
		,query="select im from Imovel im "
				+ " inner join im.quadra qua "
				+ " inner join qua.rota rot "
				+ " WHERE rot.id = :rotaId ")
}
)
public class Imovel implements Serializable{
	private static final long serialVersionUID = 8944311080432329009L;

	@Id
	@Column(name="imov_id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="loca_id")
	private Localidade localidade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stcm_id")
	private SetorComercial setorComercial;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="qdra_id")
	private Quadra quadra;
	
	@Column(name="imov_nnimovel")
	private String numeroImovel;
	
	@OneToOne(mappedBy="imovel")
	private LigacaoAgua ligacaoAgua;
	
	@ManyToOne
	@JoinColumn(name="last_id")
	private LigacaoAguaSituacao ligacaoAguaSituacao;
	
	@ManyToOne
	@JoinColumn(name="lest_id")
	private LigacaoEsgotoSituacao ligacaoEsgotoSituacao;
	
	public Imovel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Quadra getQuadra() {
		return quadra;
	}

	public void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	public String getNumeroImovel() {
		return numeroImovel;
	}

	public void setNumeroImovel(String numeroImovel) {
		this.numeroImovel = numeroImovel;
	}

	public LigacaoAgua getLigacaoAgua() {
		return ligacaoAgua;
	}

	public void setLigacaoAgua(LigacaoAgua ligacaoAgua) {
		this.ligacaoAgua = ligacaoAgua;
	}
	
	public LigacaoAguaSituacao getLigacaoAguaSituacao() {
		return ligacaoAguaSituacao;
	}

	public void setLigacaoAguaSituacao(LigacaoAguaSituacao ligacaoAguaSituacao) {
		this.ligacaoAguaSituacao = ligacaoAguaSituacao;
	}

	public LigacaoEsgotoSituacao getLigacaoEsgotoSituacao() {
		return ligacaoEsgotoSituacao;
	}

	public void setLigacaoEsgotoSituacao(LigacaoEsgotoSituacao ligacaoEsgotoSituacao) {
		this.ligacaoEsgotoSituacao = ligacaoEsgotoSituacao;
	}

	public String toString() {
		return "Imovel [id=" + id + ", numeroImovel=" + numeroImovel + "]";
	}
}
