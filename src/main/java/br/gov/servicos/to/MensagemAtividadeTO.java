package br.gov.servicos.to;

import java.io.Serializable;

import br.gov.model.batch.ControleProcessoAtividade;

public class MensagemAtividadeTO implements Serializable{
    private static final long serialVersionUID = 2925502070381234863L;

    private String nomeProcesso;
    
    private String nomeAtividade;
    
    private String nomeArquivo;
    
    private Integer idControleAtividade;
    
    private Integer idProcessoIniciado;
    
    public MensagemAtividadeTO build(ControleProcessoAtividade controle){
        MensagemAtividadeTO obj = new MensagemAtividadeTO();
        obj.nomeProcesso  = controle.getProcessoIniciado().getProcesso().getDescricao();
        obj.nomeAtividade = controle.getAtividade().getDescricao();
        obj.nomeArquivo   = controle.getAtividade().getNomeArquivoBatch();
        obj.idControleAtividade = controle.getId();
        obj.idProcessoIniciado  = controle.getProcessoIniciado().getId();
        
        return obj;
    }
    public String getNomeProcesso() {
        return nomeProcesso;
    }
    public String getNomeAtividade() {
        return nomeAtividade;
    }
    public String getNomeArquivo() {
        return nomeArquivo;
    }
    public Integer getIdControleAtividade() {
        return idControleAtividade;
    }
    public Integer getIdProcessoIniciado() {
        return idProcessoIniciado;
    }
}
