-- // Criacao da tabela faturamento.faixaleituraesperadaparametros
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE faturamento.seq_faixaleituraesperadaparametros
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER SEQUENCE faturamento.seq_faixaleituraesperadaparametros
  OWNER TO gsan_admin;

CREATE TABLE faturamento.faixaleituraesperadaparametros
(
  flep_id integer NOT NULL,
  flep_mediainicial integer NOT NULL,
  flep_mediafinal integer NOT NULL,
  flep_fatorfaixainicial numeric(3,1) NOT NULL,
  flep_fatorfaixafinal numeric(3,1) NOT NULL,
  flep_icuso smallint NOT NULL,
  CONSTRAINT faixaleituraesperadaparametros_pkey PRIMARY KEY (flep_id)
);

ALTER TABLE faturamento.faixaleituraesperadaparametros
  OWNER TO gsan_admin;


insert into faturamento.faixaleituraesperadaparametros values (nextval('faturamento.seq_faixaleituraesperadaparametros'), 0, 10, 0, 0, 1);
insert into faturamento.faixaleituraesperadaparametros values (nextval('faturamento.seq_faixaleituraesperadaparametros'), 11, 20, 0.4, 1.6, 1);
insert into faturamento.faixaleituraesperadaparametros values (nextval('faturamento.seq_faixaleituraesperadaparametros'), 21, 45, 0.5, 1.5, 1);
insert into faturamento.faixaleituraesperadaparametros values (nextval('faturamento.seq_faixaleituraesperadaparametros'), 46, 100, 0.6, 1.4, 1);
insert into faturamento.faixaleituraesperadaparametros values (nextval('faturamento.seq_faixaleituraesperadaparametros'), 101, 999, 0.7, 1.3, 1);


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE faturamento.faixaleituraesperadaparametros;
DROP SEQUENCE faturamento.seq_faixaleituraesperadaparametros;
