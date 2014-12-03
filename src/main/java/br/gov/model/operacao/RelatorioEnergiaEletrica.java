package br.gov.model.operacao;

import static br.gov.model.util.Utilitarios.converteAnoMesParaMesAno;

import java.io.Serializable;
import java.util.Date;

public class RelatorioEnergiaEletrica implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigoUC;
	private String nomeUC;
	private Integer referencia;
	private String fatura;
	private Double valorTotal;
	private Double consumoKwh;
	private Double DemandaMedida;
	private Double DemandaFaturada;
	
	private Date dataLeitura;
	private String endereco;
	private String bairro;
	private String cep;
	private String codGrupo;
	private String codTipo;
	private Double consumoKwhCv;
	private Double consumoKwhFs;
	private Double consumoKwhFu;
	private Double consumoKwhPs;
	private Double consumoKwhPu;
	private Double dcv;
	private Double dfs;
	private Double dfu;
	private Double dps;
	private Double dpu;
	private Double demFatCv;
	private Double demFatFp;
	private Double demFatPt;
	private Double demMedCv;
	private Double demMedFp;
	private Double demMedPt;
	private Double demUltCv;
	private Double demUltFp;
	private Double demUltPt;
	private Double fatorCarga;
	private Double fPotFp;
	private Double fPotCv;
	private Double fPotPt;
	private Double valorUltFp;
	private Double valorUltPt;
	private Double valorDemCv;
	private Double valorDemFp;
	private Double valorDemPt;
	private Double valorUltCv;
	private Double valorMultas;
	private Double valorKwhFs;
	private Double valorKwhFu;
	private Double valorKwhCv;
	private Double valorKwhPs;
	private Double valorKwhPu;
	private Double valorICMS;
	private Double valorDreCv;
	private Double valorDrePt;
	private Double valorDreFp;
	private Double valorEreFp;
	private Double valorEreCv;
	private Double valorErePt;
	
	private String municipio;
	private String localidade;
	private Double consumo;
	private Double total;
	private Double ajusteFatorPotencia;
	private Double ultrapassagemR$;
	private Double ultrapassagemKwh;
	
	
    
	
	public RelatorioEnergiaEletrica() {
    }

	public RelatorioEnergiaEletrica(Integer referencia, Integer codigoUC, String nomeUC, 
            Double consumoKwh, Double ajusteFatorPotencia, Double total, Double ultrapassagemKwh, Double ultrapassagemR$){
        this.referencia = referencia;
        this.codigoUC = codigoUC;
        this.nomeUC = nomeUC;
        this.consumoKwh = consumoKwh;
        this.ajusteFatorPotencia = ajusteFatorPotencia;
        this.total = total;
        this.ultrapassagemKwh = ultrapassagemKwh;
        this.ultrapassagemR$ = ultrapassagemR$;
    }
	
	public Integer getCodigoUC() {
		return codigoUC;
	}
	public void setCodigoUC(Integer codigoUC) {
		this.codigoUC = codigoUC;
	}
	public String getNomeUC() {
		return nomeUC;
	}
	public void setNomeUC(String nomeUC) {
		this.nomeUC = nomeUC;
	}
	public Integer getReferencia() {
        return referencia;
    }
    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }
    public String getReferenciaMesAno() {
        return converteAnoMesParaMesAno(referencia);
    }
    public String getFatura() {
		return fatura;
	}
	public void setFatura(String fatura) {
		this.fatura = fatura;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Double getConsumoKwh() {
		return consumoKwh;
	}
	public void setConsumoKwh(Double consumoKwh) {
		this.consumoKwh = consumoKwh;
	}
	public Double getDemandaMedida() {
		return DemandaMedida;
	}
	public void setDemandaMedida(Double demandaMedida) {
		DemandaMedida = demandaMedida;
	}
	public Double getDemandaFaturada() {
		return DemandaFaturada;
	}
	public void setDemandaFaturada(Double demandaFaturada) {
		DemandaFaturada = demandaFaturada;
	}
	public Date getDataLeitura() {
		return dataLeitura;
	}
	public void setDataLeitura(Date dataLeitura) {
		this.dataLeitura = dataLeitura;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCodGrupo() {
		return codGrupo;
	}
	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}
	public String getCodTipo() {
		return codTipo;
	}
	public void setCodTipo(String codTipo) {
		this.codTipo = codTipo;
	}
	public Double getConsumoKwhCv() {
		return consumoKwhCv;
	}
	public void setConsumoKwhCv(Double consumoKwhCv) {
		this.consumoKwhCv = consumoKwhCv;
	}
	public Double getConsumoKwhFs() {
		return consumoKwhFs;
	}
	public void setConsumoKwhFs(Double consumoKwhFs) {
		this.consumoKwhFs = consumoKwhFs;
	}
	public Double getConsumoKwhFu() {
		return consumoKwhFu;
	}
	public void setConsumoKwhFu(Double consumoKwhFu) {
		this.consumoKwhFu = consumoKwhFu;
	}
	public Double getConsumoKwhPs() {
		return consumoKwhPs;
	}
	public void setConsumoKwhPs(Double consumoKwhPs) {
		this.consumoKwhPs = consumoKwhPs;
	}
	public Double getConsumoKwhPu() {
		return consumoKwhPu;
	}
	public void setConsumoKwhPu(Double consumoKwhPu) {
		this.consumoKwhPu = consumoKwhPu;
	}
	public Double getDcv() {
		return dcv;
	}
	public void setDcv(Double dcv) {
		this.dcv = dcv;
	}
	public Double getDfs() {
		return dfs;
	}
	public void setDfs(Double dfs) {
		this.dfs = dfs;
	}
	public Double getDfu() {
		return dfu;
	}
	public void setDfu(Double dfu) {
		this.dfu = dfu;
	}
	public Double getDps() {
		return dps;
	}
	public void setDps(Double dps) {
		this.dps = dps;
	}
	public Double getDpu() {
		return dpu;
	}
	public void setDpu(Double dpu) {
		this.dpu = dpu;
	}
	public Double getDemFatCv() {
		return demFatCv;
	}
	public void setDemFatCv(Double demFatCv) {
		this.demFatCv = demFatCv;
	}
	public Double getDemFatFp() {
		return demFatFp;
	}
	public void setDemFatFp(Double demFatFp) {
		this.demFatFp = demFatFp;
	}
	public Double getDemFatPt() {
		return demFatPt;
	}
	public void setDemFatPt(Double demFatPt) {
		this.demFatPt = demFatPt;
	}
	public Double getDemMedCv() {
		return demMedCv;
	}
	public void setDemMedCv(Double demMedCv) {
		this.demMedCv = demMedCv;
	}
	public Double getDemMedFp() {
		return demMedFp;
	}
	public void setDemMedFp(Double demMedFp) {
		this.demMedFp = demMedFp;
	}
	public Double getDemMedPt() {
		return demMedPt;
	}
	public void setDemMedPt(Double demMedPt) {
		this.demMedPt = demMedPt;
	}
	public Double getDemUltCv() {
		return demUltCv;
	}
	public void setDemUltCv(Double demUltCv) {
		this.demUltCv = demUltCv;
	}
	public Double getDemUltFp() {
		return demUltFp;
	}
	public void setDemUltFp(Double demUltFp) {
		this.demUltFp = demUltFp;
	}
	public Double getDemUltPt() {
		return demUltPt;
	}
	public void setDemUltPt(Double demUltPt) {
		this.demUltPt = demUltPt;
	}
	public Double getFatorCarga() {
		return fatorCarga;
	}
	public void setFatorCarga(Double fatorCarga) {
		this.fatorCarga = fatorCarga;
	}
	public Double getfPotFp() {
		return fPotFp;
	}
	public void setfPotFp(Double fPotFp) {
		this.fPotFp = fPotFp;
	}
	public Double getfPotCv() {
		return fPotCv;
	}
	public void setfPotCv(Double fPotCv) {
		this.fPotCv = fPotCv;
	}
	public Double getfPotPt() {
		return fPotPt;
	}
	public void setfPotPt(Double fPotPt) {
		this.fPotPt = fPotPt;
	}
	public Double getValorUltFp() {
		return valorUltFp;
	}
	public void setValorUltFp(Double valorUltFp) {
		this.valorUltFp = valorUltFp;
	}
	public Double getValorUltPt() {
		return valorUltPt;
	}
	public void setValorUltPt(Double valorUltPt) {
		this.valorUltPt = valorUltPt;
	}
	public Double getValorDemCv() {
		return valorDemCv;
	}
	public void setValorDemCv(Double valorDemCv) {
		this.valorDemCv = valorDemCv;
	}
	public Double getValorDemFp() {
		return valorDemFp;
	}
	public void setValorDemFp(Double valorDemFp) {
		this.valorDemFp = valorDemFp;
	}
	public Double getValorDemPt() {
		return valorDemPt;
	}
	public void setValorDemPt(Double valorDemPt) {
		this.valorDemPt = valorDemPt;
	}
	public Double getValorUltCv() {
		return valorUltCv;
	}
	public void setValorUltCv(Double valorUltCv) {
		this.valorUltCv = valorUltCv;
	}
	public Double getValorMultas() {
		return valorMultas;
	}
	public void setValorMultas(Double valorMultas) {
		this.valorMultas = valorMultas;
	}
	public Double getValorKwhFs() {
		return valorKwhFs;
	}
	public void setValorKwhFs(Double valorKwhFs) {
		this.valorKwhFs = valorKwhFs;
	}
	public Double getValorKwhFu() {
		return valorKwhFu;
	}
	public void setValorKwhFu(Double valorKwhFu) {
		this.valorKwhFu = valorKwhFu;
	}
	public Double getValorKwhCv() {
		return valorKwhCv;
	}
	public void setValorKwhCv(Double valorKwhCv) {
		this.valorKwhCv = valorKwhCv;
	}
	public Double getValorKwhPs() {
		return valorKwhPs;
	}
	public void setValorKwhPs(Double valorKwhPs) {
		this.valorKwhPs = valorKwhPs;
	}
	public Double getValorKwhPu() {
		return valorKwhPu;
	}
	public void setValorKwhPu(Double valorKwhPu) {
		this.valorKwhPu = valorKwhPu;
	}
	public Double getValorICMS() {
		return valorICMS;
	}
	public void setValorICMS(Double valorICMS) {
		this.valorICMS = valorICMS;
	}
	public Double getValorDreCv() {
		return valorDreCv;
	}
	public void setValorDreCv(Double valorDreCv) {
		this.valorDreCv = valorDreCv;
	}
	public Double getValorDrePt() {
		return valorDrePt;
	}
	public void setValorDrePt(Double valorDrePt) {
		this.valorDrePt = valorDrePt;
	}
	public Double getValorDreFp() {
		return valorDreFp;
	}
	public void setValorDreFp(Double valorDreFp) {
		this.valorDreFp = valorDreFp;
	}
	public Double getValorEreFp() {
		return valorEreFp;
	}
	public void setValorEreFp(Double valorEreFp) {
		this.valorEreFp = valorEreFp;
	}
	public Double getValorEreCv() {
		return valorEreCv;
	}
	public void setValorEreCv(Double valorEreCv) {
		this.valorEreCv = valorEreCv;
	}
	public Double getValorErePt() {
		return valorErePt;
	}
	public void setValorErePt(Double valorErePt) {
		this.valorErePt = valorErePt;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public Double getConsumo() {
		return consumo;
	}
	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getAjusteFatorPotencia() {
		return ajusteFatorPotencia;
	}
	public void setAjusteFatorPotencia(Double ajusteFatorPotencia) {
		this.ajusteFatorPotencia = ajusteFatorPotencia;
	}
	public Double getUltrapassagemR$() {
		return ultrapassagemR$;
	}
	public void setUltrapassagemR$(Double ultrapassagemR$) {
		this.ultrapassagemR$ = ultrapassagemR$;
	}
	public Double getUltrapassagemKwh() {
		return ultrapassagemKwh;
	}
	public void setUltrapassagemKwh(Double ultrapassagemKwh) {
		this.ultrapassagemKwh = ultrapassagemKwh;
	}
	
	public String toString() {
		return "RelatorioEnergiaEletrica [codigoUC=" + codigoUC + ", referencia=" + referencia + "]";
	}
}
