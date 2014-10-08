-- // criar_tabela_processo_parametros
-- Migration SQL that makes the change goes here.
CREATE SEQUENCE batch.seq_processo_parametros
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER TABLE batch.seq_processo_parametros
  OWNER TO gsan_admin;

CREATE TABLE batch.processo_parametros
(
  prpr_id integer NOT NULL, -- id do processo parametro
  proi_id integer NOT NULL, -- descricao da situacao do processo
  prpr_nmparametro character varying(40), -- descricao abreviada da situacao do processo
  prpr_valorparametro character varying(40), -- indicador de uso (1-ativo 2-inativo)
  CONSTRAINT processo_parametros_pkey PRIMARY KEY (prpr_id),
  CONSTRAINT fk1_processo_iniciado FOREIGN KEY (proi_id)
      REFERENCES batch.processo_iniciado (proi_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

ALTER TABLE batch.processo_parametros
  OWNER TO gsan_admin;

CREATE INDEX xfk1_processo_parametros
  ON batch.processo_parametros
  USING btree
  (proi_id)
TABLESPACE indices;

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE batch.processo_parametros;
DROP INDEX batch.xfk1_processo_parametros;
DROP SEQUENCE batch.seq_processo_parametros;
