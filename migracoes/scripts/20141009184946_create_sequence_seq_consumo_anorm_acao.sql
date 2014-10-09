-- // create sequence seq_consumo_anorm_acao
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE micromedicao.seq_consumo_anorm_acao
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

-- //@UNDO
-- SQL to undo the change goes here.

DROP SEQUENCE micromedicao.seq_consumo_anorm_acao;
  