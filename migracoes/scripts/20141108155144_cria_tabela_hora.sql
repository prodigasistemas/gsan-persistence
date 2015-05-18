-- // cria tabela hora
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_hora
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER TABLE operacao.sequence_hora OWNER TO gsan_admin;

CREATE TABLE operacao.hora
(
  hora_id integer NOT NULL,
  hora_tipo_unidade integer NOT NULL,
  hora_id_unidade integer NOT NULL,
  hora_ano_mes_referencia integer,
  hora_tmultimaalteracao timestamp without time zone NOT NULL DEFAULT now(),
  usur_id integer NOT NULL,
  eabh_id integer,
  eath_id integer,
  etah_id integer,
  CONSTRAINT hora_pkey PRIMARY KEY (hora_id)
);

ALTER TABLE operacao.hora  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE operacao.hora;

DROP SEQUENCE operacao.sequence_hora;


