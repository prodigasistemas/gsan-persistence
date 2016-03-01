package br.gov.servicos.operacao.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.gov.model.operacao.ContratoEnergiaDemanda;

public class ContratoEnergiaCadastroTO implements Serializable{
    private static final long serialVersionUID = -4019679697344071537L;

    private String numeroContrato;

    private Integer unidadeConsumidora;
    
    private Double tensaoNominal;

    private Double tensaoContratada;

    private String subGrupoTarifario;

    private Double frequencia;

    private Double perdasTransformacao;

    private Double potenciaInstalada;

    private Date horarioPontaInicial;

    private Date horarioPontaFinal;
    
    private Date horarioReservadoInicial;

    private Date horarioReservadoFinal;
    
    private Date dataAssinatura;

    private String periodoTeste;

    private String periodoAjuste;
    
    private String opcaoFaturamento;

    private String modalidadeTarifaria;

    private String agrupadorFatura;

    private List<ContratoEnergiaDemanda> demanda = new ArrayList<ContratoEnergiaDemanda>();    
    
    private Integer vigenciaInicial;

    private Integer vigenciaFinal;
    
    private String convencionalVerde;
    
    private String demandaSecoPonta;
    
    private String demandaSecoForaPonta;
    
    private String demandaUmidoPonta;
    
    private String demandaUmidoForaPonta;

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Integer getUnidadeConsumidora() {
        return unidadeConsumidora;
    }

    public void setUnidadeConsumidora(Integer unidadeConsumidora) {
        this.unidadeConsumidora = unidadeConsumidora;
    }

    public Double getTensaoNominal() {
        return tensaoNominal;
    }

    public void setTensaoNominal(Double tensaoNominal) {
        this.tensaoNominal = tensaoNominal;
    }

    public Double getTensaoContratada() {
        return tensaoContratada;
    }

    public void setTensaoContratada(Double tensaoContratada) {
        this.tensaoContratada = tensaoContratada;
    }

    public String getSubGrupoTarifario() {
        return subGrupoTarifario;
    }

    public void setSubGrupoTarifario(String subGrupoTarifario) {
        this.subGrupoTarifario = subGrupoTarifario;
    }

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
        this.frequencia = frequencia;
    }

    public Double getPerdasTransformacao() {
        return perdasTransformacao;
    }

    public void setPerdasTransformacao(Double perdasTransformacao) {
        this.perdasTransformacao = perdasTransformacao;
    }

    public Double getPotenciaInstalada() {
        return potenciaInstalada;
    }

    public void setPotenciaInstalada(Double potenciaInstalada) {
        this.potenciaInstalada = potenciaInstalada;
    }

    public Date getHorarioPontaInicial() {
        return horarioPontaInicial;
    }

    public void setHorarioPontaInicial(Date horarioPontaInicial) {
        this.horarioPontaInicial = horarioPontaInicial;
    }

    public Date getHorarioPontaFinal() {
        return horarioPontaFinal;
    }

    public void setHorarioPontaFinal(Date horarioPontaFinal) {
        this.horarioPontaFinal = horarioPontaFinal;
    }

    public Date getHorarioReservadoInicial() {
        return horarioReservadoInicial;
    }

    public void setHorarioReservadoInicial(Date horarioReservadoInicial) {
        this.horarioReservadoInicial = horarioReservadoInicial;
    }

    public Date getHorarioReservadoFinal() {
        return horarioReservadoFinal;
    }

    public void setHorarioReservadoFinal(Date horarioReservadoFinal) {
        this.horarioReservadoFinal = horarioReservadoFinal;
    }

    public Date getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(Date dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public String getPeriodoTeste() {
        return periodoTeste;
    }

    public void setPeriodoTeste(String periodoTeste) {
        this.periodoTeste = periodoTeste;
    }

    public String getPeriodoAjuste() {
        return periodoAjuste;
    }

    public void setPeriodoAjuste(String periodoAjuste) {
        this.periodoAjuste = periodoAjuste;
    }

    public String getOpcaoFaturamento() {
        return opcaoFaturamento;
    }

    public void setOpcaoFaturamento(String opcaoFaturamento) {
        this.opcaoFaturamento = opcaoFaturamento;
    }

    public String getModalidadeTarifaria() {
        return modalidadeTarifaria;
    }

    public void setModalidadeTarifaria(String modalidadeTarifaria) {
        this.modalidadeTarifaria = modalidadeTarifaria;
    }

    public String getAgrupadorFatura() {
        return agrupadorFatura;
    }

    public void setAgrupadorFatura(String agrupadorFatura) {
        this.agrupadorFatura = agrupadorFatura;
    }

    public List<ContratoEnergiaDemanda> getDemanda() {
        return demanda;
    }

    public void setDemanda(List<ContratoEnergiaDemanda> demanda) {
        this.demanda = demanda;
    }

    public Integer getVigenciaInicial() {
        return vigenciaInicial;
    }

    public void setVigenciaInicial(Integer vigenciaInicial) {
        this.vigenciaInicial = vigenciaInicial;
    }

    public Integer getVigenciaFinal() {
        return vigenciaFinal;
    }

    public void setVigenciaFinal(Integer vigenciaFinal) {
        this.vigenciaFinal = vigenciaFinal;
    }

    public String getConvencionalVerde() {
        return convencionalVerde;
    }

    public void setConvencionalVerde(String convencionalVerde) {
        this.convencionalVerde = convencionalVerde;
    }

    public String getDemandaSecoPonta() {
        return demandaSecoPonta;
    }

    public void setDemandaSecoPonta(String demandaSecoPonta) {
        this.demandaSecoPonta = demandaSecoPonta;
    }

    public String getDemandaSecoForaPonta() {
        return demandaSecoForaPonta;
    }

    public void setDemandaSecoForaPonta(String demandaSecoForaPonta) {
        this.demandaSecoForaPonta = demandaSecoForaPonta;
    }

    public String getDemandaUmidoPonta() {
        return demandaUmidoPonta;
    }

    public void setDemandaUmidoPonta(String demandaUmidoPonta) {
        this.demandaUmidoPonta = demandaUmidoPonta;
    }

    public String getDemandaUmidoForaPonta() {
        return demandaUmidoForaPonta;
    }

    public void setDemandaUmidoForaPonta(String demandaUmidoForaPonta) {
        this.demandaUmidoForaPonta = demandaUmidoForaPonta;
    }
}
