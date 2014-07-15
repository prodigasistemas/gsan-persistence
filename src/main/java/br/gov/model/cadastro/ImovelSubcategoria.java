package br.gov.model.cadastro;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="imovel_subcategoria", schema="cadastro")
public class ImovelSubcategoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9097415683142271917L;

	@EmbeddedId
	private ImovelSubcategoriaPK pk;

	@Column(name="imsb_qteconomia")
	private Short quantidadeEconomias;
	
	@Column(name="imsb_qtunidadeprivativa")
	private Short quantidadeUnidadesPrivativas;
	
	@Column(name="imsb_qtunidadecoletiva")
	private Short quantidadeUnidadesColetivas;
	
	@Column(name="imsb_tmultimaalteracao")
	private Date ultimaAlteracao;
	
	@OneToMany
	@JoinColumns({
		@JoinColumn(name="imov_id", referencedColumnName="imov_id"),
		@JoinColumn(name="scat_id", referencedColumnName="scat_id")
	})
    private Set<ImovelEconomia> imovelEconomias;
	
	@ManyToOne
	@JoinColumn(name="scat_id", insertable=false, updatable=false)
	private Subcategoria subcategoria;
	
	public ImovelSubcategoria(){}

	public ImovelSubcategoriaPK getPk() {
		return pk;
	}

	public void setPk(ImovelSubcategoriaPK pk) {
		this.pk = pk;
	}

	public Short getQuantidadeEconomias() {
		return quantidadeEconomias;
	}

	public void setQuantidadeEconomias(Short quantidadeEconomias) {
		this.quantidadeEconomias = quantidadeEconomias;
	}

	public Short getQuantidadeUnidadesPrivativas() {
		return quantidadeUnidadesPrivativas;
	}

	public void setQuantidadeUnidadesPrivativas(Short quantidadeUnidadesPrivativas) {
		this.quantidadeUnidadesPrivativas = quantidadeUnidadesPrivativas;
	}

	public Short getQuantidadeUnidadesColetivas() {
		return quantidadeUnidadesColetivas;
	}

	public void setQuantidadeUnidadesColetivas(Short quantidadeUnidadesColetivas) {
		this.quantidadeUnidadesColetivas = quantidadeUnidadesColetivas;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Set<ImovelEconomia> getImovelEconomias() {
		return imovelEconomias;
	}

	public void setImovelEconomias(Set<ImovelEconomia> imovelEconomias) {
		this.imovelEconomias = imovelEconomias;
	}
}
