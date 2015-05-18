-- // cria tabela consumo produto
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_consumo_produto
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER TABLE operacao.sequence_consumo_produto OWNER TO gsan_admin;

CREATE TABLE operacao.consumo_produto
(
  id integer NOT NULL,
  quantidade numeric(11,2),
  prod_id integer NOT NULL,
  cons_id integer NOT NULL,
  CONSTRAINT consumo_produto_pkey PRIMARY KEY (id),
  CONSTRAINT consumo_produto_fk_prod FOREIGN KEY (prod_id)
      REFERENCES operacao.produto (prod_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT consumo_produto_fk_cons FOREIGN KEY (cons_id)
      REFERENCES operacao.consumo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE operacao.consumo_produto OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE operacao.consumo_produto;

DROP SEQUENCE operacao.sequence_consumo_produto;