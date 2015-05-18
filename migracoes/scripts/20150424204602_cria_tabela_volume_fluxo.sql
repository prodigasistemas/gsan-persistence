-- // cria tabela volume fluxo
-- Migration SQL that makes the change goes here.
CREATE SEQUENCE operacao.sequence_volume_fluxo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER TABLE operacao.sequence_volume_fluxo OWNER TO gsan_admin;

CREATE TABLE operacao.volume_fluxo
(
  id integer NOT NULL,
  tipofluxo integer NOT NULL,
  tipomedicao integer NOT  NULL,
  volume numeric(9,2),
  volume_id integer NOT NULL,
  macromedidor_id integer NOT NULL,

  CONSTRAINT volume_fluxo_pkey PRIMARY KEY (id),
  CONSTRAINT fk1_volume_fluxo FOREIGN KEY (volume_id)
      REFERENCES operacao.volume (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk2_volume_fluxo FOREIGN KEY (macromedidor_id)
      REFERENCES operacao.macro_medidor (mmed_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE operacao.volume_fluxo  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.
drop table operacao.volume_fluxo;

DROP SEQUENCE operacao.sequence_volume_fluxo;