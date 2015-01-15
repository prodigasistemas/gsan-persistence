-- // Criacao da tabela micromedicao.faixa_leitura_esperada_param
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE micromedicao.seq_faixa_leitura_esperada_param
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER SEQUENCE micromedicao.seq_faixa_leitura_esperada_param
  OWNER TO gsan_admin;

CREATE TABLE micromedicao.faixa_leitura_esperada_param
(
  flep_id integer NOT NULL,
  flep_mediainicial integer NOT NULL,
  flep_mediafinal integer NOT NULL,
  flep_fatorfaixainicial numeric(3,1) NOT NULL,
  flep_fatorfaixafinal numeric(3,1) NOT NULL,
  flep_icuso smallint NOT NULL,
  CONSTRAINT faixa_leitura_esperada_param_pkey PRIMARY KEY (flep_id)
);

ALTER TABLE micromedicao.faixa_leitura_esperada_param
  OWNER TO gsan_admin;


insert into micromedicao.faixa_leitura_esperada_param values (nextval('micromedicao.seq_faixa_leitura_esperada_param'), 0, 10, 0, 0, 1);
insert into micromedicao.faixa_leitura_esperada_param values (nextval('micromedicao.seq_faixa_leitura_esperada_param'), 11, 20, 0.4, 1.6, 1);
insert into micromedicao.faixa_leitura_esperada_param values (nextval('micromedicao.seq_faixa_leitura_esperada_param'), 21, 45, 0.5, 1.5, 1);
insert into micromedicao.faixa_leitura_esperada_param values (nextval('micromedicao.seq_faixa_leitura_esperada_param'), 46, 100, 0.6, 1.4, 1);
insert into micromedicao.faixa_leitura_esperada_param values (nextval('micromedicao.seq_faixa_leitura_esperada_param'), 101, 999, 0.7, 1.3, 1);


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE micromedicao.faixa_leitura_esperada_param;
DROP SEQUENCE micromedicao.seq_faixa_leitura_esperada_param;
