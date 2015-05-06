-- // exlui a coluna de proxima atividade da tabela de controle de execucao de atividade
-- Migration SQL that makes the change goes here.

ALTER TABLE batch.controle_processo_atividade DROP COLUMN proximativ_id;

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE batch.controle_processo_atividade ADD COLUMN proximativ_id integer;