-- // cria coluna que aponta para a atividade principal
-- Migration SQL that makes the change goes here.

ALTER TABLE batch.processo_atividade ADD COLUMN principal_id integer;

-- //@UNDO
-- SQL to undo the change goes here.


ALTER TABLE batch.processo_atividade DROP COLUMN principal_id;
