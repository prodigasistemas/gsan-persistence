-- // adicionar coluna prioridade em batch processo
-- Migration SQL that makes the change goes here.
ALTER TABLE batch.processo ADD COLUMN proc_prioridade int default 0;

UPDATE batch.processo
SET proc_prioridade = 0;



-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE batch.processo DROP COLUMN proc_prioridade;
