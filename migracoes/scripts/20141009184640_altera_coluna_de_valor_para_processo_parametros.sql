-- // altera coluna de valor para processo parametros
-- Migration SQL that makes the change goes here.

ALTER TABLE batch.processo_parametros ALTER COLUMN prpr_valorparametro TYPE text;


-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE batch.processo_parametros ALTER COLUMN prpr_valorparametro TYPE character varying(255);
