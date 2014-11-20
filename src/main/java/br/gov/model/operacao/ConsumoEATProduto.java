package br.gov.model.operacao;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="consumoeat_produto",schema="operacao")
public class ConsumoEATProduto implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides( {
	      @AttributeOverride(name = "idConsumo", column = @Column(name = "cons_id")),
	      @AttributeOverride(name = "idProduto", column = @Column(name = "prod_id")) 
	})
	private ConsumoProdutoPK id;

	@Column(name="conp_quantidade")
	private Double qtdConsumo;
	
    @ManyToOne
    @JoinColumn(name="cons_id", insertable=false, updatable=false)
    private ConsumoEAT consumo;
	
    @ManyToOne
    @JoinColumn(name="prod_id", insertable=false, updatable=false)
	private Produto produto;
	
	public ConsumoEATProduto(){
	}

	public ConsumoProdutoPK getId() {
		return id;
	}

	public void setId(ConsumoProdutoPK id) {
		this.id = id;
	}

	public Double getQtdConsumo() {
		return qtdConsumo;
	}

	public void setQtdConsumo(Double qtdConsumo) {
		this.qtdConsumo = qtdConsumo;
	}

	public ConsumoEAT getConsumo() {
		return consumo;
	}

	public void setConsumo(ConsumoEAT consumo) {
		this.consumo = consumo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
