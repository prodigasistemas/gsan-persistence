-- // create sequence registro consumo sistema abastecimento
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_registro_consumo_sistema_abastecimento
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 221
  CACHE 1;

ALTER TABLE operacao.sequence_registro_consumo_sistema_abastecimento OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

DROP SEQUENCE operacao.sequence_registro_consumo_sistema_abastecimento;