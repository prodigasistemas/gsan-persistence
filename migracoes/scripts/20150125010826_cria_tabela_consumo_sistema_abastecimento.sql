-- // cria tabela consumo sistema abastecimento
-- Migration SQL that makes the change goes here.

CREATE TABLE operacao.consumo_sistema_abastecimento
(
  cons_id integer NOT NULL,
  cons_data timestamp without time zone,
  loca_id integer NOT NULL,
  muni_id integer NOT NULL,
  greg_id integer NOT NULL,
  sabs_id integer NOT NULL,
  cons_tmultimaalteracao timestamp without time zone NOT NULL DEFAULT now(),
  uneg_id integer NOT NULL,
  usur_id integer NOT NULL,
  CONSTRAINT consumo_sistema_abastecimento_pkey PRIMARY KEY (cons_id)
);

ALTER TABLE operacao.consumo_sistema_abastecimento
  OWNER TO gsan_admin;
-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE operacao.consumo_sistema_abastecimento;
