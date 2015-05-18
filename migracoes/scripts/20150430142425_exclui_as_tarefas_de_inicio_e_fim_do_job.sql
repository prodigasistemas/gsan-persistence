-- // exclui as tarefas de inicio e fim do job
-- Migration SQL that makes the change goes here.

DELETE FROM batch.controle_processo_atividade
where proa_id in (
  select id 
  from batch.processo_atividade 
  WHERE nmarquivobatch = 'job_iniciar_processamento' or
        nmarquivobatch = 'job_finalizar_processamento'
);

DELETE FROM batch.processo_atividade
WHERE nmarquivobatch = 'job_iniciar_processamento' or 
      nmarquivobatch = 'job_finalizar_processamento';

-- //@UNDO
-- SQL to undo the change goes here.


INSERT INTO batch.processo_atividade(
  id
  , nmarquivobatch
  , limiteexecucao
  , descricao
  , ordemexecucao
  , exibiremtela
  , proc_id
)
VALUES(
  nextval('batch.seq_processo_atividade')
  , 'job_iniciar_processamento'
  , 1
  , 'INICIA PROCESSAMENTO'
  , 1
  , 0
  , (select proc_id from batch.processo where proc_dsprocesso = 'NOVO GERAR DADOS PARA LEITURA')
);

INSERT INTO batch.processo_atividade(
  id
  , nmarquivobatch
  , limiteexecucao
  , descricao
  , ordemexecucao
  , exibiremtela
  , proc_id
)
VALUES(
  nextval('batch.seq_processo_atividade')
  , 'job_finalizar_processamento'
  , 1
  , 'FINALIZA PROCESSAMENTO'
  , 5
  , 0
  , (select proc_id from batch.processo where proc_dsprocesso = 'NOVO GERAR DADOS PARA LEITURA')
);
