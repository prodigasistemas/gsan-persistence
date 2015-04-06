-- // cria tabela para controle de atividade de processo
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE batch.seq_controle_processo_atividade
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER SEQUENCE batch.seq_controle_processo_atividade
  OWNER TO gsan_admin;

CREATE TABLE batch.controle_processo_atividade
(
  id integer NOT NULL,
  inicio timestamp without time zone NOT NULL DEFAULT now(),
  termino timestamp,
  situacao smallint,
  proximativ_id integer,
  totalitens integer,
  itensprocessados integer,
  proa_id integer,
  proi_id integer,
  tmultimaalteracao timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT controle_processo_atividade_pkey PRIMARY KEY (id),
  CONSTRAINT fk1_controle_processo_atividade FOREIGN KEY (proa_id)
      REFERENCES batch.processo_atividade (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk2_controle_processo_atividade FOREIGN KEY (proi_id)
      REFERENCES batch.processo_iniciado (proi_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk3_controle_processo_atividade FOREIGN KEY (proximativ_id)
      REFERENCES batch.processo_atividade (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT      
);

ALTER TABLE batch.controle_processo_atividade
  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE batch.controle_processo_atividade;
DROP SEQUENCE batch.seq_controle_processo_atividade;