-- // create sequence unidade medida
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_unidade_medida
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 17
  CACHE 1;

ALTER TABLE operacao.sequence_unidade_medida OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

DROP SEQUENCE operacao.sequence_unidade_medida;