package br.gov.servicos.operacao.to;

import static br.gov.model.util.Utilitarios.formatarBigDecimalComVirgula;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import br.gov.model.operacao.TipoUnidadeOperacional;

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
	
	private BigDecimal horasMes = BigDecimal.ZERO;
	private BigDecimal horasParadasPorEnergia = BigDecimal.ZERO;
	private BigDecimal horasParadasParaManutencao = BigDecimal.ZERO;
	private BigDecimal horasParadasParaControle = BigDecimal.ZERO;
	private Integer    totalCmb = 0;
	private BigDecimal horasTrabalhadas = BigDecimal.ZERO;
	
	private List<CmbRelatorio> cmbs = new LinkedList<CmbRelatorio>();
	
	class CmbRelatorio{
	    private Integer    cmb = 0;
	    private BigDecimal horasCmb = BigDecimal.ZERO;
	    
	    public CmbRelatorio(Integer cmb, BigDecimal horasCmb) {
            this.cmb = cmb;
            this.horasCmb = horasCmb;
        }
	    
        public void setCmb(Integer cmb) {
            this.cmb = cmb;
        }
        public void setHorasCmb(BigDecimal horasCmb) {
            this.horasCmb = horasCmb;
        }

        public Integer getCmb() {
            return cmb;
        }

        public BigDecimal getHorasCmb() {
            return horasCmb;
        }
	}
	
	public HorasRelatorioTO() {
	}
	
	public void addHoraCmb(Integer qtdCmb, BigDecimal horas){
	    this.cmbs.add(new CmbRelatorio(qtdCmb, horas));
	}
	
	public void addHorasTrabalhadas(BigDecimal horaTrabalhada){
	    horasTrabalhadas = horasTrabalhadas.add(horaTrabalhada);
	}

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }


    public void setCdRegional(Integer cdRegional) {
        this.cdRegional = cdRegional;
    }


    public void setNomeRegional(String nomeRegional) {
        this.nomeRegional = nomeRegional;
    }


    public void setCdUnidadeNegocio(Integer cdUnidadeNegocio) {
        this.cdUnidadeNegocio = cdUnidadeNegocio;
    }


    public void setNomeUnidadeNegocio(String nomeUnidadeNegocio) {
        this.nomeUnidadeNegocio = nomeUnidadeNegocio;
    }


    public void setCdMunicipio(Integer cdMunicipio) {
        this.cdMunicipio = cdMunicipio;
    }


    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }


    public void setCdLocalidade(Integer cdLocalidade) {
        this.cdLocalidade = cdLocalidade;
    }


    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }


    public void setTipoUnidadeOperacional(Integer tipoUnidadeOperacional) {
        this.tipoUnidadeOperacional = tipoUnidadeOperacional;
    }


    public void setCdUnidadeOperacional(Integer cdUnidadeOperacional) {
        this.cdUnidadeOperacional = cdUnidadeOperacional;
    }


    public void setDescricaoUnidadeOperacional(String descricaoUnidadeOperacional) {
        this.descricaoUnidadeOperacional = descricaoUnidadeOperacional;
    }


    public void setHorasMes(BigDecimal horasMes) {
        this.horasMes = horasMes;
    }


    public void setHorasParadasPorEnergia(BigDecimal horasParadasPorEnergia) {
        this.horasParadasPorEnergia = horasParadasPorEnergia;
    }


    public void setHorasParadasParaManutencao(BigDecimal horasParadasParaManutencao) {
        this.horasParadasParaManutencao = horasParadasParaManutencao;
    }


    public void setHorasParadasParaControle(BigDecimal horasParadasParaControle) {
        this.horasParadasParaControle = horasParadasParaControle;
    }


    public void setTotalCmb(Integer totalCmb) {
        this.totalCmb = totalCmb;
    }


    public void setCmbs(List<CmbRelatorio> cmbs) {
        this.cmbs = cmbs;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public Integer getCdRegional() {
        return cdRegional;
    }

    public String getNomeRegional() {
        return nomeRegional;
    }

    public Integer getCdUnidadeNegocio() {
        return cdUnidadeNegocio;
    }

    public String getNomeUnidadeNegocio() {
        return nomeUnidadeNegocio;
    }

    public Integer getCdMunicipio() {
        return cdMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public Integer getCdLocalidade() {
        return cdLocalidade;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    public Integer getTipoUnidadeOperacional() {
        return tipoUnidadeOperacional;
    }

    public Integer getCdUnidadeOperacional() {
        return cdUnidadeOperacional;
    }

    public String getDescricaoUnidadeOperacional() {
        return descricaoUnidadeOperacional;
    }

    public BigDecimal getHorasMes() {
        return horasMes;
    }

    public BigDecimal getHorasParadasPorEnergia() {
        return horasParadasPorEnergia;
    }

    public BigDecimal getHorasParadasParaManutencao() {
        return horasParadasParaManutencao;
    }

    public BigDecimal getHorasParadasParaControle() {
        return horasParadasParaControle;
    }

    public Integer getTotalCmb() {
        return totalCmb;
    }

    public BigDecimal getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public List<CmbRelatorio> getCmbs() {
        return cmbs;
    }

    public List<String> toArray(){
        final List<String> s = new LinkedList<String>();
        s.add(nomeRegional);
        s.add(nomeUnidadeNegocio);
        s.add(nomeMunicipio);
        s.add(nomeLocalidade);
        s.add(TipoUnidadeOperacional.findById(tipoUnidadeOperacional).toString());
        s.add(String.valueOf(cdUnidadeOperacional));
        s.add(descricaoUnidadeOperacional);
        s.add(String.valueOf(referencia));
        s.add(formatarBigDecimalComVirgula(horasMes));
        s.add(String.valueOf(totalCmb));
        s.add(formatarBigDecimalComVirgula(horasParadasPorEnergia));
        s.add(formatarBigDecimalComVirgula(horasParadasParaManutencao));
        s.add(formatarBigDecimalComVirgula(horasParadasParaControle));
        s.add(formatarBigDecimalComVirgula(horasTrabalhadas));
        cmbs.forEach(cmb -> {
            s.add(formatarBigDecimalComVirgula(cmb.getHorasCmb()));
        });
        return s;
    }
}
