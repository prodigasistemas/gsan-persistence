-- // altera tipo das colunas character da tabela leiturista
-- Migration SQL that makes the change goes here.

ALTER TABLE  micromedicao.leiturista
  ALTER COLUMN leit_cdddd TYPE character varying(2);
  
ALTER TABLE  micromedicao.leiturista
  ALTER COLUMN leit_nnfone TYPE character varying(8);

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE  micromedicao.leiturista
  ALTER COLUMN leit_cdddd TYPE character(2);
  
ALTER TABLE  micromedicao.leiturista
  ALTER COLUMN leit_nnfone TYPE character(8);