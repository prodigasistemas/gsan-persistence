-- // cria tabela consumo
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_consumo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER TABLE operacao.sequence_consumo OWNER TO gsan_admin;

CREATE TABLE operacao.consumo
(
  id integer NOT NULL,
  tipo_unidade integer NOT NULL,
  id_unidade integer NOT NULL,
  data date,
  tmultimaalteracao timestamp without time zone NOT NULL DEFAULT now(),
  usur_id integer NOT NULL,
  eatc_id integer,
  etac_id integer,
  CONSTRAINT consumo_pkey PRIMARY KEY (id)
);

ALTER TABLE operacao.consumo  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE operacao.consumo;

DROP SEQUENCE operacao.sequence_consumo;