-- // excluir colunas de referencia para eab eta eat da tabela hora
-- Migration SQL that makes the change goes here.

ALTER TABLE operacao.hora DROP COLUMN eabh_id;
ALTER TABLE operacao.hora DROP COLUMN eath_id;
ALTER TABLE operacao.hora DROP COLUMN etah_id;


-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE operacao.hora ADD COLUMN eabh_id integer;
ALTER TABLE operacao.hora ADD COLUMN eath_id integer;
ALTER TABLE operacao.hora ADD COLUMN etah_id integer;