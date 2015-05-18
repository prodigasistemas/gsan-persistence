-- // cria tabela volume
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_volume
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER TABLE operacao.sequence_volume OWNER TO gsan_admin;

CREATE TABLE operacao.volume
(
  id integer NOT NULL,
  tipo_unidade integer NOT NULL,
  id_unidade integer NOT NULL,
  tmultimaalteracao timestamp without time zone NOT NULL DEFAULT now(),
  tmmedicao timestamp without time zone,
  referencia integer,
  estimado boolean,
  volume numeric(9,2), 
  observacoes varchar(255),
  usur_id integer NOT NULL,
  eabv_id integer,
  eatv_id integer,
  etav_id integer,
  CONSTRAINT volume_pkey PRIMARY KEY (id)
);

ALTER TABLE operacao.volume  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

drop table operacao.volume;

DROP SEQUENCE operacao.sequence_volume;