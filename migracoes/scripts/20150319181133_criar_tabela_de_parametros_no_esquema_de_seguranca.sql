-- // criar tabela de parametros no esquema de seguranca
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE seguranca.seq_seguranca_parametro
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER SEQUENCE seguranca.seq_seguranca_parametro
  OWNER TO gsan_admin;

CREATE TABLE seguranca.parametro
(
  id integer NOT NULL,
  nome varchar(40),
  valor varchar(150),
  CONSTRAINT seguranca_parametro_pkey PRIMARY KEY (id)
);

ALTER TABLE seguranca.parametro
  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE seguranca.parametro;
DROP SEQUENCE seguranca.seq_seguranca_parametro;