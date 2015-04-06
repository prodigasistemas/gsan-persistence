-- // cria tabela para atividade de processo
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE batch.seq_processo_atividade
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER SEQUENCE batch.seq_processo_atividade
  OWNER TO gsan_admin;

CREATE TABLE batch.processo_atividade
(
  id integer NOT NULL,
  nmarquivobatch varchar(60),
  limiteexecucao smallint,
  descricao varchar(60),
  ordemexecucao smallint,
  exibiremtela smallint,
  proc_id integer,
  tmultimaalteracao timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT processo_atividade_pkey PRIMARY KEY (id),
  CONSTRAINT fk1_processo_atividade FOREIGN KEY (proc_id)
      REFERENCES batch.processo (proc_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT  
);

ALTER TABLE batch.processo_atividade
  OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE batch.processo_atividade;
DROP SEQUENCE batch.seq_processo_atividade;