-- // cria tabela hora cmb
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_hora_cmb
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER TABLE operacao.sequence_hora_cmb OWNER TO gsan_admin;

CREATE TABLE operacao.hora_cmb
(
  hcmb_id integer NOT NULL,
  hcmb_qtd integer NOT NULL,
  hcmb_medicao numeric(5,2),
  hcmb_tmultimaalteracao timestamp without time zone NOT NULL DEFAULT now(),
  hora_id integer not null,
  CONSTRAINT hora_cmb_pkey PRIMARY KEY (hcmb_id),
  CONSTRAINT fk1_hora_cmb FOREIGN KEY (hora_id)
      REFERENCES operacao.hora (hora_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE operacao.hora_cmb OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

drop table operacao.hora_cmb;

drop sequence operacao.sequence_hora_cmb;
