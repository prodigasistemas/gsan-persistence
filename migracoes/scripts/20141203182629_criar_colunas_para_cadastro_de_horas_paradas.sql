-- // criar colunas para cadastro de horas paradas
-- Migration SQL that makes the change goes here.

ALTER TABLE operacao.hora ADD COLUMN hora_parada_energia numeric(6,2) default 0;

UPDATE operacao.hora SET hora_parada_energia = 0;


ALTER TABLE operacao.hora ADD COLUMN hora_parada_manutencao numeric(6,2) default 0;

UPDATE operacao.hora SET hora_parada_manutencao = 0;


ALTER TABLE operacao.hora ADD COLUMN hora_parada_controle numeric(6,2) default 0;

UPDATE operacao.hora SET hora_parada_controle = 0;

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE operacao.hora DROP COLUMN hora_parada_energia;

ALTER TABLE operacao.hora DROP COLUMN hora_parada_manutencao;

ALTER TABLE operacao.hora DROP COLUMN hora_parada_controle;

