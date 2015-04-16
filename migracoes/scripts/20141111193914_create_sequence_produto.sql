-- // create sequence produto
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_produto
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 26
  CACHE 1;

ALTER TABLE operacao.sequence_produto OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

DROP SEQUENCE operacao.sequence_produto;