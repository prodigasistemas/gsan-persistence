-- // adiciona_coluna_limite_em_batch_processo
-- Migration SQL that makes the change goes here.
ALTER TABLE batch.processo ADD COLUMN proc_limite int default 0;

UPDATE batch.processo
SET proc_limite = 0;

-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE batch.processo DROP COLUMN proc_limite;
