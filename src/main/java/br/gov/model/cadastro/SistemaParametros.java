package br.gov.model.cadastro;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.model.Status;
import br.gov.model.util.ConstantesSistema;

import java.io.Serializable;

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
	
	@Column(name="parm_icgeracaofaixafalsa")
	private Short indicadorFaixaFalsa;
	
	@Column(name="parm_icusopercentualfaixafalsa")
	private Short indicadorUsoFaixaFalsa;
	
	@Column(name="parm_icnaomedidotarifa")
	private Short indicadorNaoMedidoTarifa;
	
	@Column(name="parm_pcfaixafalsa")
	private BigDecimal percentualFaixaFalsa;
	
	@Column(name="parm_nnmodulodigitoverif")
	private Short numeroModuloDigitoVerificador;
	
	@Column(name="parm_cdempresafebraban")
	private Short codigoEmpresaFebraban;
	
	public static Short INDICADOR_TARIFA_CATEGORIA = new Short("1");
	
	public SistemaParametros() {
	}

	public boolean moduloVerificador11(){
	    return numeroModuloDigitoVerificador != null
                && numeroModuloDigitoVerificador.compareTo(ConstantesSistema.MODULO_VERIFICADOR_11) == 0;
	}
	
	/***********************************************
	 ************* GETTERS AND SETTERS ************* 
	 ************************************************/
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

	public Short getIndicadorFaixaFalsa() {
		return indicadorFaixaFalsa;
	}

	public void setIndicadorFaixaFalsa(Short indicadorFaixaFalsa) {
		this.indicadorFaixaFalsa = indicadorFaixaFalsa;
	}

	public Short getIndicadorUsoFaixaFalsa() {
		return indicadorUsoFaixaFalsa;
	}

	public void setIndicadorUsoFaixaFalsa(Short indicadorUsoFaixaFalsa) {
		this.indicadorUsoFaixaFalsa = indicadorUsoFaixaFalsa;
	}

	public BigDecimal getPercentualFaixaFalsa() {
		return percentualFaixaFalsa;
	}

	public void setPercentualFaixaFalsa(BigDecimal percentualFaixaFalsa) {
		this.percentualFaixaFalsa = percentualFaixaFalsa;
	}

    public Short getIndicadorNaoMedidoTarifa() {
        return indicadorNaoMedidoTarifa;
    }

    public void setIndicadorNaoMedidoTarifa(Short indicadorNaoMedidoTarifa) {
        this.indicadorNaoMedidoTarifa = indicadorNaoMedidoTarifa;
    }

    public Short getNumeroModuloDigitoVerificador() {
        return numeroModuloDigitoVerificador;
    }

    public void setNumeroModuloDigitoVerificador(Short numeroModuloDigitoVerificador) {
        this.numeroModuloDigitoVerificador = numeroModuloDigitoVerificador;
    }

    public Short getCodigoEmpresaFebraban() {
        return codigoEmpresaFebraban;
    }

    public void setCodigoEmpresaFebraban(Short codigoEmpresaFebraban) {
        this.codigoEmpresaFebraban = codigoEmpresaFebraban;
    }

    public boolean parametroAtivo(Short parametro) {
        return parametro != null && parametro == Status.ATIVO.getId();
    }
}