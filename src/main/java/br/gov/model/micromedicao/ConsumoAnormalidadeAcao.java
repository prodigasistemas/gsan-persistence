package br.gov.model.micromedicao;

import java.io.Serializable;
import java.math.BigDecimal;

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
	
	@ManyToOne
	@JoinColumn(name="csan_id")
	private ConsumoAnormalidade consumoAnormalidade;
	
	@ManyToOne
	@JoinColumn(name="catg_id")
	private Categoria categoria; 
	
	@ManyToOne
	@JoinColumn(name="iper_id")
	private ImovelPerfil imovelPerfil; 
	
	@Column(name="csaa_nnfatorconsumomes1")
	private BigDecimal numerofatorConsumoMes1;

	@Column(name="csaa_nnfatorconsumomes2")
    private BigDecimal numerofatorConsumoMes2;

	@Column(name="csaa_nnfatorconsumomes3")
    private BigDecimal numerofatorConsumoMes3;

	@Column(name="csaa_icgeracaocartames1")
    private Short indicadorGeracaoCartaMes1;

	@Column(name="csaa_icgeracaocartames2")
    private Short indicadorGeracaoCartaMes2;

	@Column(name="csaa_icgeracaocartames3")
    private Short indicadorGeracaoCartaMes3;

	@ManyToOne
	@JoinColumn(name="lacs_idmes1")
    private LeituraAnormalidadeConsumo leituraAnormalidadeConsumoMes1;

	@ManyToOne
	@JoinColumn(name="lacs_idmes2")
    private LeituraAnormalidadeConsumo leituraAnormalidadeConsumoMes2;

	@ManyToOne
	@JoinColumn(name="lacs_idmes3")
    private LeituraAnormalidadeConsumo leituraAnormalidadeConsumoMes3;

	@Column(name="csaa_dsmensagemcontames1")
	private String descricaoContaMensagemMes1;
	
	@Column(name="csaa_dsmensagemcontames2")
	private String descricaoContaMensagemMes2;
	
	@Column(name="csaa_dsmensagemcontames3")
	private String descricaoContaMensagemMes3;
	
	@Column(name="csaa_icuso")
	private Short indicadorUso;

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

	public BigDecimal getNumerofatorConsumoMes1() {
		return numerofatorConsumoMes1;
	}

	public void setNumerofatorConsumoMes1(BigDecimal numerofatorConsumoMes1) {
		this.numerofatorConsumoMes1 = numerofatorConsumoMes1;
	}

	public BigDecimal getNumerofatorConsumoMes2() {
		return numerofatorConsumoMes2;
	}

	public void setNumerofatorConsumoMes2(BigDecimal numerofatorConsumoMes2) {
		this.numerofatorConsumoMes2 = numerofatorConsumoMes2;
	}

	public BigDecimal getNumerofatorConsumoMes3() {
		return numerofatorConsumoMes3;
	}

	public void setNumerofatorConsumoMes3(BigDecimal numerofatorConsumoMes3) {
		this.numerofatorConsumoMes3 = numerofatorConsumoMes3;
	}

	public Short getIndicadorGeracaoCartaMes1() {
		return indicadorGeracaoCartaMes1;
	}

	public void setIndicadorGeracaoCartaMes1(Short indicadorGeracaoCartaMes1) {
		this.indicadorGeracaoCartaMes1 = indicadorGeracaoCartaMes1;
	}

	public Short getIndicadorGeracaoCartaMes2() {
		return indicadorGeracaoCartaMes2;
	}

	public void setIndicadorGeracaoCartaMes2(Short indicadorGeracaoCartaMes2) {
		this.indicadorGeracaoCartaMes2 = indicadorGeracaoCartaMes2;
	}

	public Short getIndicadorGeracaoCartaMes3() {
		return indicadorGeracaoCartaMes3;
	}

	public void setIndicadorGeracaoCartaMes3(Short indicadorGeracaoCartaMes3) {
		this.indicadorGeracaoCartaMes3 = indicadorGeracaoCartaMes3;
	}

	public LeituraAnormalidadeConsumo getLeituraAnormalidadeConsumoMes1() {
		return leituraAnormalidadeConsumoMes1;
	}

	public void setLeituraAnormalidadeConsumoMes1(LeituraAnormalidadeConsumo leituraAnormalidadeConsumoMes1) {
		this.leituraAnormalidadeConsumoMes1 = leituraAnormalidadeConsumoMes1;
	}

	public LeituraAnormalidadeConsumo getLeituraAnormalidadeConsumoMes2() {
		return leituraAnormalidadeConsumoMes2;
	}

	public void setLeituraAnormalidadeConsumoMes2(LeituraAnormalidadeConsumo leituraAnormalidadeConsumoMes2) {
		this.leituraAnormalidadeConsumoMes2 = leituraAnormalidadeConsumoMes2;
	}

	public LeituraAnormalidadeConsumo getLeituraAnormalidadeConsumoMes3() {
		return leituraAnormalidadeConsumoMes3;
	}

	public void setLeituraAnormalidadeConsumoMes3(LeituraAnormalidadeConsumo leituraAnormalidadeConsumoMes3) {
		this.leituraAnormalidadeConsumoMes3 = leituraAnormalidadeConsumoMes3;
	}

	public Short getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(Short indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public String toString() {
		return "ConsumoAnormalidadeAcao [id=" + id + "]";
	}
}
