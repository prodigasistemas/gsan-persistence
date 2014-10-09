-- // altera_coluna_de_valor_para_processo_parametros.sql
-- Migration SQL that makes the change goes here.
ALTER TABLE batch.processo_parametros ALTER COLUMN prpr_valorparametro TYPE text;


-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE batch.processo_parametros MODIFY COLUMN prpr_valorparametro TYPE character varying(255);


