package br.gov.model.atendimentopublico;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.model.cadastro.Imovel;
import br.gov.model.micromedicao.HidrometroInstalacaoHistorico;

@Entity
@Table(name = "ligacao_agua", schema = "atendimentopublico")
public class LigacaoAgua implements Serializable{
	private static final long serialVersionUID = -5223172999613411911L;

	@Id
	@Column(name="lagu_id")
	private Integer id;
	
	@Column(name="lagu_dtligacaoagua")
	@Temporal(TemporalType.DATE)
	private Date dataLigacao;
	
	@Column(name="lagu_nnconsumominimoagua")
	private Integer consumoMinimoAgua;
	
	@Column(name="lagu_nnlacre")
	private String numeroLacre;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lagu_id", referencedColumnName="imov_id")
	private Imovel imovel;
	
	@OneToMany(mappedBy="ligacaoAgua", fetch=FetchType.LAZY)
	private Set<HidrometroInstalacaoHistorico> hidrometroInstalacoesHistorico;
	
	public LigacaoAgua() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataLigacao() {
		return dataLigacao;
	}

	public void setDataLigacao(Date dataLigacao) {
		this.dataLigacao = dataLigacao;
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

	public Integer getConsumoMinimoAgua() {
		return consumoMinimoAgua;
	}

	public void setConsumoMinimoAgua(Integer consumoMinimoAgua) {
		this.consumoMinimoAgua = consumoMinimoAgua;
	}

	public String getNumeroLacre() {
		return numeroLacre;
	}

	public void setNumeroLacre(String numeroLacre) {
		this.numeroLacre = numeroLacre;
	}

	public String toString() {
		return "LigacaoAgua [id=" + id + ", imovel=" + imovel + "]";
	}
	
	public boolean existeHidrometrosInstalado() {
		boolean existe = false;
		if (!hidrometroInstalacoesHistorico.isEmpty()) {
			existe = (!hidrometroInstalacoesHistorico.stream().filter(h -> h.getDataRetirada() == null).collect(Collectors.toList()).isEmpty());
		}
		return existe;
	}
}