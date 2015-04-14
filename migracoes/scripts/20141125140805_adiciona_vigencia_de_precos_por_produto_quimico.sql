-- // adiciona vigencia de precos por produto quimico
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE operacao.sequence_preco_produto
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER TABLE operacao.sequence_preco_produto OWNER TO gsan_admin;

CREATE TABLE operacao.preco_produto
(
  id integer NOT NULL,
  preco numeric(9,6),
  prod_id integer NOT NULL,
  vigencia date NOT NULL,
  tmultimaalteracao timestamp without time zone NOT NULL DEFAULT now(),
  usur_id integer NOT NULL,
  CONSTRAINT preco_produto_pkey PRIMARY KEY (id),
  CONSTRAINT fk1_preco_produto FOREIGN KEY (prod_id)
      REFERENCES operacao.produto (prod_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT  
);

ALTER TABLE operacao.preco_produto  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE operacao.preco_produto;

DROP SEQUENCE operacao.sequence_preco_produto;