-- // cria coluna tipo para registro de horas
-- Migration SQL that makes the change goes here.

ALTER TABLE operacao.hora_cmb ADD COLUMN hcmb_tipo_registro integer default 0;

UPDATE operacao.hora_cmb SET hcmb_tipo_registro = 0;

-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE operacao.hora_cmb DROP COLUMN hcmb_tipo_registro;
