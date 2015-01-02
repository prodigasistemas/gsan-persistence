-- // cadastra processo acao cobranca
-- Migration SQL that makes the change goes here.

INSERT INTO batch.processo(
            proc_id, proc_dsprocesso, proc_dsabreviado, proc_icuso, proc_tmultimaalteracao, 
            prtp_id, proc_dsorientacao, proc_icautorizacao, proc_limite, 
            proc_nmarquivobatch, proc_prioridade)
    VALUES (nextval('batch.seq_processo'), 'NOVO GERAR ATIVIDADE ACAO COBRANCA' , 'NVGAC', 2, now(), 
            4, null, 2, 0, 
            'job_gerar_atividade_acao_cobranca', 0);

-- //@UNDO
-- SQL to undo the change goes here.

delete from batch.processo where proc_nmarquivobatch = 'job_gerar_atividade_acao_cobranca';
