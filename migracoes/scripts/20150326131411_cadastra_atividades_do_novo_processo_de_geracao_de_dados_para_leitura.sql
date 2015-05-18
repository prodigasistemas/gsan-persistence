-- // cadastra atividades do novo processo de geracao de dados para leitura
-- Migration SQL that makes the change goes here.

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
  , 'job_processar_rotas_para_leitura'
  , 4
  , 'PROCESSAR ROTAS PARA LEITURA'
  , 2
  , 1
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
  , 'job_processar_rotas_para_gerar_arquivo'
  , 8
  , 'PROCESSAR ROTAS PARA GERAR ARQUIVO'
  , 3
  , 1
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
  , 'job_agrupar_arquivos_microcoletor'
  , 1
  , 'AGRUPAR ARQUIVOS GERADOS PARA MICROCOLETOR'
  , 4
  , 1
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
-- //@UNDO
-- SQL to undo the change goes here.

delete from batch.controle_processo_atividade where proa_id in
  (select proa_id from batch.processo_atividade where proc_id in 
     (select proc_id from batch.processo where proc_dsprocesso = 'NOVO GERAR DADOS PARA LEITURA')
  );

delete from batch.processo_atividade where proc_id in
  (select proc_id from batch.processo where proc_dsprocesso = 'NOVO GERAR DADOS PARA LEITURA');
