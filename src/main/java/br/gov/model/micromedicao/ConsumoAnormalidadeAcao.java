package br.gov.model.micromedicao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.model.cadastro.Categoria;
import br.gov.model.cadastro.ImovelPerfil;

@Entity
@Table(name="consumo_anorm_acao", schema="micromedicao")
public class ConsumoAnormalidadeAcao implements Serializable{
	private static final long serialVersionUID = -7973132886930969791L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONSUMO_ANORM_ACAO")
	@SequenceGenerator(name="SEQ_CONSUMO_ANORM_ACAO", schema="micromedicao", sequenceName="seq_consumo_anorm_acao", allocationSize=1)
	@Column(name="csaa_id")
	private Integer id;
	
	@Column(name="csaa_dsmensagemcontames1")
	private String descricaoContaMensagemMes1;
	
	@Column(name="csaa_dsmensagemcontames2")
	private String descricaoContaMensagemMes2;
	
	@Column(name="csaa_dsmensagemcontames3")
	private String descricaoContaMensagemMes3;
	
	@ManyToOne
	@JoinColumn(name="catg_id")
	private Categoria categoria; 
	
	@ManyToOne
	@JoinColumn(name="csan_id")
	private ConsumoAnormalidade consumoAnormalidade; 
	
	@ManyToOne
	@JoinColumn(name="iper_id")
	private ImovelPerfil imovelPerfil; 
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoContaMensagemMes1() {
		return descricaoContaMensagemMes1;
	}

	public void setDescricaoContaMensagemMes1(String descricaoContaMensagemMes1) {
		this.descricaoContaMensagemMes1 = descricaoContaMensagemMes1;
	}

	public String getDescricaoContaMensagemMes2() {
		return descricaoContaMensagemMes2;
	}

	public void setDescricaoContaMensagemMes2(String descricaoContaMensagemMes2) {
		this.descricaoContaMensagemMes2 = descricaoContaMensagemMes2;
	}

	public String getDescricaoContaMensagemMes3() {
		return descricaoContaMensagemMes3;
	}

	public void setDescricaoContaMensagemMes3(String descricaoContaMensagemMes3) {
		this.descricaoContaMensagemMes3 = descricaoContaMensagemMes3;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ConsumoAnormalidade getConsumoAnormalidade() {
		return consumoAnormalidade;
	}

	public void setConsumoAnormalidade(ConsumoAnormalidade consumoAnormalidade) {
		this.consumoAnormalidade = consumoAnormalidade;
	}

	public ImovelPerfil getImovelPerfil() {
		return imovelPerfil;
	}

	public void setImovelPerfil(ImovelPerfil imovelPerfil) {
		this.imovelPerfil = imovelPerfil;
	}

	public String toString() {
		return "ConsumoAnormalidadeAcao [id=" + id + "]";
	}
}
