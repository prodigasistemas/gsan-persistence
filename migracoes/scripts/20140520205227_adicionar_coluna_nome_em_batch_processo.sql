-- // adicionar_coluna_nome_em_batch_processo
-- Migration SQL that makes the change goes here.
ALTER TABLE batch.processo ADD COLUMN proc_nmarquivobatch character varying(40);
ALTER TABLE batch.processo ADD UNIQUE (proc_nmarquivobatch)

-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE batch.processo DROP COLUMN proc_nmarquivobatch;
