package br.gov.model.cadastro;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sistema_parametros", schema="cadastro")
public class SistemaParametros implements Serializable {
	private static final long serialVersionUID = 2506057341225497998L;

	@Id
	@Column(name="parm_id")
	private Integer id;
	
	@Column(name="parm_amreferenciafaturamento")
	private Integer anoMesFaturamento;
	
	@Column(name="parm_nnmindiasemsvcmto")
	private Short numeroMinimoDiasEmissaoVencimento;
	
	@Column(name="parm_nndiasadicionaiscorreios")
	private Short numeroDiasAdicionaisCorreios;
	
	@Column(name="parm_nnmesesvalidadeconta")
	private Short numeroMesesValidadeConta;
	
	@Column(name="parm_ictarifacategoria")
	private Short indicadorTarifaCategoria;
	
	@Column(name="parm_vlcontafichacomp")
	private BigDecimal valorContaFichaComp;
	
	@Column(name="parm_nnmesescalcmediacons")
	private Short mesesMediaConsumo;
	
	@Column(name="parm_nnmesesmaximocalculomedia")
	private Short numeroMesesMaximoCalculoMedia;
	
	@Column(name="parm_amreferenciaarrecadacao")
	private Integer anoMesArrecadacao;
	
	@Column(name="parm_icbloqctasctrparceldebito")
	private Short indicadorBloqueioContasContratoParcelDebitos;
	
	@Column(name="parm_icbloqguiactrparceldebito")
	private Short indicadorBloqueioGuiasOuAcresContratoParcelDebito;
	
	@Column(name="parm_nmabreviadoempresa")
	private String nomeAbreviadoEmpresa;
	
	public static Short INDICADOR_TARIFA_CATEGORIA = new Short("1");
	
	public SistemaParametros() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoMesFaturamento() {
		return anoMesFaturamento;
	}

	public void setAnoMesFaturamento(Integer anoMesFaturamento) {
		this.anoMesFaturamento = anoMesFaturamento;
	}

	public Short getNumeroMinimoDiasEmissaoVencimento() {
		return numeroMinimoDiasEmissaoVencimento;
	}

	public void setNumeroMinimoDiasEmissaoVencimento(Short numeroMinimoDiasEmissaoVencimento) {
		this.numeroMinimoDiasEmissaoVencimento = numeroMinimoDiasEmissaoVencimento;
	}

	public Short getNumeroDiasAdicionaisCorreios() {
		return numeroDiasAdicionaisCorreios;
	}

	public void setNumeroDiasAdicionaisCorreios(Short numeroDiasAdicionaisCorreios) {
		this.numeroDiasAdicionaisCorreios = numeroDiasAdicionaisCorreios;
	}

	public Short getNumeroMesesValidadeConta() {
		return numeroMesesValidadeConta;
	}

	public void setNumeroMesesValidadeConta(Short numeroMesesValidadeConta) {
		this.numeroMesesValidadeConta = numeroMesesValidadeConta;
	}
	
	public boolean indicadorTarifaCategoria() {
		return getIndicadorTarifaCategoria() == INDICADOR_TARIFA_CATEGORIA;
	}

	public Short getIndicadorTarifaCategoria() {
		return indicadorTarifaCategoria;
	}

	public void setIndicadorTarifaCategoria(Short indicadorTarifaCategoria) {
		this.indicadorTarifaCategoria = indicadorTarifaCategoria;
	}

	public BigDecimal getValorContaFichaComp() {
		return valorContaFichaComp;
	}

	public void setValorContaFichaComp(BigDecimal valorContaFichaComp) {
		this.valorContaFichaComp = valorContaFichaComp;
	}

	public Short getMesesMediaConsumo() {
		return mesesMediaConsumo;
	}

	public void setMesesMediaConsumo(Short mesesMediaConsumo) {
		this.mesesMediaConsumo = mesesMediaConsumo;
	}

	public Short getNumeroMesesMaximoCalculoMedia() {
		return numeroMesesMaximoCalculoMedia;
	}

	public void setNumeroMesesMaximoCalculoMedia(Short numeroMesesMaximoCalculoMedia) {
		this.numeroMesesMaximoCalculoMedia = numeroMesesMaximoCalculoMedia;
	}

	public Integer getAnoMesArrecadacao() {
		return anoMesArrecadacao;
	}

	public void setAnoMesArrecadacao(Integer anoMesArrecadacao) {
		this.anoMesArrecadacao = anoMesArrecadacao;
	}

	public Short getIndicadorBloqueioContasContratoParcelDebitos() {
		return indicadorBloqueioContasContratoParcelDebitos;
	}

	public void setIndicadorBloqueioContasContratoParcelDebitos(Short indicadorBloqueioContasContratoParcelDebitos) {
		this.indicadorBloqueioContasContratoParcelDebitos = indicadorBloqueioContasContratoParcelDebitos;
	}

	public Short getIndicadorBloqueioGuiasOuAcresContratoParcelDebito() {
		return indicadorBloqueioGuiasOuAcresContratoParcelDebito;
	}

	public void setIndicadorBloqueioGuiasOuAcresContratoParcelDebito(Short indicadorBloqueioGuiasOuAcresContratoParcelDebito) {
		this.indicadorBloqueioGuiasOuAcresContratoParcelDebito = indicadorBloqueioGuiasOuAcresContratoParcelDebito;
	}

	public String getNomeAbreviadoEmpresa() {
		return nomeAbreviadoEmpresa;
	}

	public void setNomeAbreviadoEmpresa(String nomeAbreviadoEmpresa) {
		this.nomeAbreviadoEmpresa = nomeAbreviadoEmpresa;
	}
}