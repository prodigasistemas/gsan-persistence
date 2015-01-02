package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.math.BigDecimal;

import br.gov.model.operacao.TipoUnidadeOperacional;

import static br.gov.model.util.Utilitarios.formatarBigDecimalComPonto;

public class HorasRelatorioTO implements Serializable, ConverteParaRelatorio{
	private static final long serialVersionUID = -2619735608273425353L;
	
	private Integer referencia;

	private Integer cdRegional;
	private String nomeRegional;
	private Integer cdUnidadeNegocio;
	private String nomeUnidadeNegocio;
	private Integer cdMunicipio;
	private String nomeMunicipio;
	private Integer cdLocalidade;
	private String nomeLocalidade;
	private Integer tipoUnidadeOperacional;
	private Integer cdUnidadeOperacional;
	private String descricaoUnidadeOperacional;
	
	private Integer qtdCmb = 0;
	private BigDecimal horasMes = BigDecimal.ZERO;
	private BigDecimal horasCmb = BigDecimal.ZERO;
	private BigDecimal horasParadasPorEnergia = BigDecimal.ZERO;
	private BigDecimal horasParadasParaManutencao = BigDecimal.ZERO;
	private BigDecimal horasParadasParaControle = BigDecimal.ZERO;
	
	public HorasRelatorioTO() {
	}

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public Integer getCdRegional() {
        return cdRegional;
    }

    public void setCdRegional(Integer cdRegional) {
        this.cdRegional = cdRegional;
    }

    public String getNomeRegional() {
        return nomeRegional;
    }

    public void setNomeRegional(String nomeRegional) {
        this.nomeRegional = nomeRegional;
    }

    public Integer getCdUnidadeNegocio() {
        return cdUnidadeNegocio;
    }

    public void setCdUnidadeNegocio(Integer cdUnidadeNegocio) {
        this.cdUnidadeNegocio = cdUnidadeNegocio;
    }

    public String getNomeUnidadeNegocio() {
        return nomeUnidadeNegocio;
    }

    public void setNomeUnidadeNegocio(String nomeUnidadeNegocio) {
        this.nomeUnidadeNegocio = nomeUnidadeNegocio;
    }

    public Integer getCdMunicipio() {
        return cdMunicipio;
    }

    public void setCdMunicipio(Integer cdMunicipio) {
        this.cdMunicipio = cdMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Integer getCdLocalidade() {
        return cdLocalidade;
    }

    public void setCdLocalidade(Integer cdLocalidade) {
        this.cdLocalidade = cdLocalidade;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }

    public Integer getTipoUnidadeOperacional() {
        return tipoUnidadeOperacional;
    }

    public void setTipoUnidadeOperacional(Integer tipoUnidadeOperacional) {
        this.tipoUnidadeOperacional = tipoUnidadeOperacional;
    }

    public Integer getCdUnidadeOperacional() {
        return cdUnidadeOperacional;
    }

    public void setCdUnidadeOperacional(Integer cdUnidadeOperacional) {
        this.cdUnidadeOperacional = cdUnidadeOperacional;
    }

    public String getDescricaoUnidadeOperacional() {
        return descricaoUnidadeOperacional;
    }

    public void setDescricaoUnidadeOperacional(String descricaoUnidadeOperacional) {
        this.descricaoUnidadeOperacional = descricaoUnidadeOperacional;
    }

    public BigDecimal getHorasMes() {
        return horasMes;
    }

    public void setHorasMes(BigDecimal horasMes) {
        this.horasMes = horasMes;
    }

    public BigDecimal getHorasCmb() {
        return horasCmb;
    }

    public void setHorasCmb(BigDecimal horasCmb) {
        this.horasCmb = horasCmb;
    }

    public BigDecimal getHorasParadasPorEnergia() {
        return horasParadasPorEnergia;
    }

    public void setHorasParadasPorEnergia(BigDecimal horasParadasPorEnergia) {
        this.horasParadasPorEnergia = horasParadasPorEnergia;
    }

    public BigDecimal getHorasParadasParaManutencao() {
        return horasParadasParaManutencao;
    }

    public void setHorasParadasParaManutencao(BigDecimal horasParadasParaManutencao) {
        this.horasParadasParaManutencao = horasParadasParaManutencao;
    }

    public BigDecimal getHorasParadasParaControle() {
        return horasParadasParaControle;
    }

    public void setHorasParadasParaControle(BigDecimal horasParadasParaControle) {
        this.horasParadasParaControle = horasParadasParaControle;
    }

    public Integer getQtdCmb() {
        return qtdCmb;
    }

    public void setQtdCmb(Integer qtdCmb) {
        this.qtdCmb = qtdCmb;
    }
    
    public String[] toArray(){
        return new String[]{
                  nomeRegional
                , nomeUnidadeNegocio
                , nomeMunicipio
                , nomeLocalidade
                , TipoUnidadeOperacional.findById(tipoUnidadeOperacional).toString()
                , String.valueOf(cdUnidadeOperacional)
                , descricaoUnidadeOperacional
                , String.valueOf(referencia)
                , String.valueOf(qtdCmb)
                , formatarBigDecimalComPonto(horasMes)
                , formatarBigDecimalComPonto(horasCmb)
                , formatarBigDecimalComPonto(horasParadasPorEnergia)
                , formatarBigDecimalComPonto(horasParadasParaManutencao)
                , formatarBigDecimalComPonto(horasParadasParaControle)
                };
    }
}
