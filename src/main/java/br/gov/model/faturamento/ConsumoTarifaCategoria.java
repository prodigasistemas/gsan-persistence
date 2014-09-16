package br.gov.model.faturamento;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.model.cadastro.Categoria;
import br.gov.model.cadastro.Subcategoria;

@Entity
@Table(name="consumo_tarifa_categoria", schema="faturamento")
public class ConsumoTarifaCategoria implements Serializable {
	private static final long serialVersionUID = -348872108434297880L;
	
	@Id
	@Column(name="cstc_id")
	private Integer id;
	
	@Column(name="cstc_nnconsumominimo")
	private Integer numeroConsumoMinimo;
	
	@Column(name="cstc_vltarifaminima")
	private BigDecimal valorTarifaMinima;
	
	@ManyToOne
	@JoinColumn(name="catg_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="scat_id")
	private Subcategoria subCategoria;

	@ManyToOne
	@JoinColumn(name="cstv_id")
	private ConsumoTarifaVigencia consumoTarifaVigencia;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroConsumoMinimo() {
		return numeroConsumoMinimo;
	}

	public void setNumeroConsumoMinimo(Integer numeroConsumoMinimo) {
		this.numeroConsumoMinimo = numeroConsumoMinimo;
	}

	public BigDecimal getValorTarifaMinima() {
		return valorTarifaMinima;
	}

	public void setValorTarifaMinima(BigDecimal valorTarifaMinima) {
		this.valorTarifaMinima = valorTarifaMinima;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Subcategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(Subcategoria subcategoria) {
		this.subCategoria = subcategoria;
	}

	public ConsumoTarifaVigencia getConsumoTarifaVigencia() {
		return consumoTarifaVigencia;
	}

	public void setConsumoTarifaVigencia(ConsumoTarifaVigencia consumoTarifaVigencia) {
		this.consumoTarifaVigencia = consumoTarifaVigencia;
	}
}
