package br.gov.model.operacao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="estacao_operacional",schema="operacao")
public class EstacaoOperacional implements Serializable{
	private static final long serialVersionUID = -8316337367798818315L;

	@EmbeddedId
	private EstacaoOperacionalPK pk;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="quantidade_cmb")
	private Integer quantidadeCmb;
	
	@OneToMany(mappedBy="estacao", fetch=FetchType.LAZY)
	private List<UnidadeConsumidoraOperacional> ucOperacional;
	
	@OneToMany(mappedBy="estacao")
	private List<Consumo> consumos;
	
	public EstacaoOperacional() {
		super();
	}
	public EstacaoOperacional(Integer tipo, Integer id){
	    this.pk = new EstacaoOperacionalPK(tipo, id);
	}
	public EstacaoOperacional(Integer tipo, Integer id, String nome){
	    this.pk = new EstacaoOperacionalPK(tipo, id);
	    this.nome = nome;
	}
	public EstacaoOperacional(Integer tipo, Integer id, String nome, Integer quantidadeCmb){
		this.pk = new EstacaoOperacionalPK(tipo, id);
		this.nome = nome;
		this.quantidadeCmb = quantidadeCmb;
	}
	public EstacaoOperacionalPK getPk() {
		return pk;
	}
	public void setPk(EstacaoOperacionalPK pk) {
		this.pk = pk;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    public Integer getQuantidadeCmb() {
        return quantidadeCmb;
    }
    public void setQuantidadeCmb(Integer quantidadeCmb) {
        this.quantidadeCmb = quantidadeCmb;
    }
    public List<UnidadeConsumidoraOperacional> getUcOperacional() {
        return ucOperacional;
    }
    public void setUcOperacional(List<UnidadeConsumidoraOperacional> ucOperacional) {
        this.ucOperacional = ucOperacional;
    }
    public String toString() {
        return "EstacaoOperacional [pk=" + pk + ", nome=" + nome + "]";
    }
    public List<Consumo> getConsumos() {
        return consumos;
    }
    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EstacaoOperacional other = (EstacaoOperacional) obj;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        return true;
    }
}
