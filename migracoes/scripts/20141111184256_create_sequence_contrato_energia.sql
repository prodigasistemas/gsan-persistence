-- // create sequence contrato energia
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_contrato_energia
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 4255
  CACHE 1;

ALTER TABLE operacao.sequence_contrato_energia OWNER TO gsan_admin;



-- //@UNDO
-- SQL to undo the change goes here.

DROP SEQUENCE operacao.sequence_contrato_energia;