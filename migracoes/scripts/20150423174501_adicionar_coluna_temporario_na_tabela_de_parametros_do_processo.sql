-- // adicionar coluna temporario na tabela de parametros do processo
-- Migration SQL that makes the change goes here.


ALTER TABLE batch.processo_parametros ADD COLUMN prpr_temporario smallint default 0;

UPDATE batch.processo_parametros
SET prpr_temporario = 0;


-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE batch.processo_parametros DROP COLUMN prpr_temporario;