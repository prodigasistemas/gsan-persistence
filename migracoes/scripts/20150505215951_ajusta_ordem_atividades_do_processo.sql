-- // ajusta ordem atividades do processo
-- Migration SQL that makes the change goes here.

UPDATE batch.processo_atividade
SET ordemexecucao = 1
where nmarquivobatch = 'job_processar_rotas_para_leitura';

UPDATE batch.processo_atividade
SET ordemexecucao = 2
where nmarquivobatch = 'job_processar_rotas_para_gerar_arquivo';

UPDATE batch.processo_atividade
SET ordemexecucao = 3
where nmarquivobatch = 'job_agrupar_arquivos_microcoletor';

-- //@UNDO
-- SQL to undo the change goes here.
