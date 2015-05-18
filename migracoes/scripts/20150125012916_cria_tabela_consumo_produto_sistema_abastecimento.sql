-- // cria tabela consumo produto sistema abastecimento
-- Migration SQL that makes the change goes here.

CREATE TABLE operacao.consumo_produto_sistema_abastecimento
(
  conp_quantidade double precision,
  prod_id integer NOT NULL,
  cons_id integer NOT NULL,
  CONSTRAINT consumo_produto_sistema_abastecimento_pkey PRIMARY KEY (prod_id, cons_id)
);

ALTER TABLE operacao.consumo_produto_sistema_abastecimento
  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE operacao.consumo_produto_sistema_abastecimento;

