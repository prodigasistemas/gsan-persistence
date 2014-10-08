-- // adiciona_coluna_prioridade_em_batch_processo_iniciado
-- Migration SQL that makes the change goes here.
ALTER TABLE batch.processo_iniciado ADD COLUMN proi_execution_id bigint default 0;


-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE batch.processo_iniciado DROP COLUMN proi_execution_id;
