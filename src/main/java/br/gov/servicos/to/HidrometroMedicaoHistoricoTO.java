package br.gov.servicos.to;

import java.io.Serializable;
import java.util.Date;

import br.gov.model.micromedicao.HidrometroInstalacaoHistorico;
import br.gov.model.micromedicao.MedicaoHistorico;

public class HidrometroMedicaoHistoricoTO implements Serializable {
	
	private static final long serialVersionUID = -6553283657678450425L;

	private String numero;
	
	private Short numeroDigitosLeitura;
	
	private Date dataInstalacao;
	
	private Integer numeroLeituraInstalacao;
	
	private Integer idImovel;
	
	private String descricaoLocalInstalacao;

	private Integer rateioTipo;
	
	private Integer medicaoTipo;
	
	private Integer leituraAtualFaturamento;
	
	private Date dataLeituraAtualFaturamento;
	
	private Integer leituraSituacaoAtual;
	
	private Integer consumoMedioHidrometro;
	
	private Date dataLeituraAtualInformada;
	
	private Integer leituraAtualInformada;

	public HidrometroMedicaoHistoricoTO(HidrometroTO hidrometroTO) {
		super();
		this.numero = hidrometroTO.getNumero();
		this.numeroDigitosLeitura = hidrometroTO.getNumeroDigitosLeitura();
		this.dataInstalacao = hidrometroTO.getDataInstalacao();
		this.numeroLeituraInstalacao = hidrometroTO.getNumeroLeituraInstalacao();
		this.idImovel = hidrometroTO.getIdImovel();
		this.descricaoLocalInstalacao = hidrometroTO.getDescricaoLocalInstalacao();
		this.rateioTipo = hidrometroTO.getRateioTipo();
		this.medicaoTipo = hidrometroTO.getMedicaoTipo();
		this.leituraAtualFaturamento = hidrometroTO.getNumeroLeituraInstalacao();
		this.dataLeituraAtualFaturamento = null;
		this.leituraSituacaoAtual = new Integer(2);
		this.consumoMedioHidrometro = new Integer(0);
		this.dataLeituraAtualInformada = null;
		this.leituraAtualInformada = null;
	}
	
	public HidrometroMedicaoHistoricoTO(HidrometroInstalacaoHistorico hidrometro) {
        super();
        this.numero = hidrometro.getHidrometro().getNumero();
        this.numeroDigitosLeitura = hidrometro.getHidrometro().getNumeroDigitosLeitura();
        this.dataInstalacao = hidrometro.getDataInstalacao();
        this.numeroLeituraInstalacao = hidrometro.getNumeroLeituraInstalacao();
        
        if (hidrometro.getImovel() != null) {
            this.idImovel = hidrometro.getImovel().getId();
        } else {
            this.idImovel = hidrometro.getLigacaoAgua().getId();
        }
        this.descricaoLocalInstalacao = hidrometro.getHidrometroLocalInstalacao().getDescricao();
        this.rateioTipo = hidrometro.getRateioTipo();
        this.medicaoTipo = hidrometro.getMedicaoTipo();
        this.leituraAtualFaturamento = hidrometro.getNumeroLeituraInstalacao();
        this.dataLeituraAtualFaturamento = null;
        this.leituraSituacaoAtual = new Integer(2);
        this.consumoMedioHidrometro = new Integer(0);
        this.dataLeituraAtualInformada = null;
        this.leituraAtualInformada = null;
    }

	public HidrometroMedicaoHistoricoTO() {
		
	}
	public void setMedicaoHistorico(MedicaoHistorico medicaoHistorico) {
	    if (medicaoHistorico != null){
	        this.numeroLeituraInstalacao = medicaoHistorico.getLeituraAtualFaturamento();
	        this.leituraAtualFaturamento = medicaoHistorico.getLeituraAtualFaturamento();
	        this.dataLeituraAtualFaturamento = medicaoHistorico.getDataLeituraAtualFaturamento();
	        this.leituraSituacaoAtual = medicaoHistorico.getLeituraSituacaoAtual();
	        this.consumoMedioHidrometro = medicaoHistorico.getConsumoMedioHidrometro();
	        this.dataLeituraAtualInformada = medicaoHistorico.getDataLeituraAtualInformada();
	        this.leituraAtualInformada = medicaoHistorico.getLeituraAtualInformada();
	    }
	}
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Short getNumeroDigitosLeitura() {
		return numeroDigitosLeitura;
	}

	public void setNumeroDigitosLeitura(Short numeroDigitosLeitura) {
		this.numeroDigitosLeitura = numeroDigitosLeitura;
	}

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public Integer getNumeroLeituraInstalacao() {
		return numeroLeituraInstalacao;
	}

	public void setNumeroLeituraInstalacao(Integer numeroLeituraInstalacao) {
		this.numeroLeituraInstalacao = numeroLeituraInstalacao;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public String getDescricaoLocalInstalacao() {
		return descricaoLocalInstalacao;
	}

	public void setDescricaoLocalInstalacao(String descricaoLocalInstalacao) {
		this.descricaoLocalInstalacao = descricaoLocalInstalacao;
	}

	public Integer getRateioTipo() {
		return rateioTipo;
	}

	public void setRateioTipo(Integer rateioTipo) {
		this.rateioTipo = rateioTipo;
	}

	public Integer getMedicaoTipo() {
		return medicaoTipo;
	}

	public void setMedicaoTipo(Integer medicaoTipo) {
		this.medicaoTipo = medicaoTipo;
	}

	public Integer getLeituraAtualFaturamento() {
		return leituraAtualFaturamento;
	}

	public void setLeituraAtualFaturamento(Integer leituraAtualFaturamento) {
		this.leituraAtualFaturamento = leituraAtualFaturamento;
	}

	public Date getDataLeituraAtualFaturamento() {
		return dataLeituraAtualFaturamento;
	}

	public void setDataLeituraAtualFaturamento(Date dataLeituraAtualFaturamento) {
		this.dataLeituraAtualFaturamento = dataLeituraAtualFaturamento;
	}

	public Integer getLeituraSituacaoAtual() {
		return leituraSituacaoAtual;
	}

	public void setLeituraSituacaoAtual(Integer leituraSituacaoAtual) {
		this.leituraSituacaoAtual = leituraSituacaoAtual;
	}

	public Integer getConsumoMedioHidrometro() {
		return consumoMedioHidrometro;
	}

	public void setConsumoMedioHidrometro(Integer consumoMedioHidrometro) {
		this.consumoMedioHidrometro = consumoMedioHidrometro;
	}

	public Date getDataLeituraAtualInformada() {
		return dataLeituraAtualInformada;
	}

	public void setDataLeituraAtualInformada(Date dataLeituraAtualInformada) {
		this.dataLeituraAtualInformada = dataLeituraAtualInformada;
	}

	public Integer getLeituraAtualInformada() {
		return leituraAtualInformada;
	}

	public void setLeituraAtualInformada(Integer leituraAtualInformada) {
		this.leituraAtualInformada = leituraAtualInformada;
	}
}
