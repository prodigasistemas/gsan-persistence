-- // cria tabela faturamento parametros
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE faturamento.seq_parametro
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER SEQUENCE faturamento.seq_parametro
  OWNER TO gsan_admin;

CREATE TABLE faturamento.parametro
(
  id integer NOT NULL,
  nome varchar(40),
  valor varchar(150),
  CONSTRAINT faturamento_parametro_pkey PRIMARY KEY (id)
);

ALTER TABLE faturamento.parametro
  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE faturamento.parametro;
DROP SEQUENCE faturamento.seq_parametro;