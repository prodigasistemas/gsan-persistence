-- // altera tipo da coluna de nome de arquivo da tabela roteiro empresa divisao
-- Migration SQL that makes the change goes here.

ALTER TABLE  micromedicao.arq_txt_roteiro_emp_div
  ALTER COLUMN tred_nmarquivo TYPE character varying(40);


-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE  micromedicao.arq_txt_roteiro_emp_div
  ALTER COLUMN tred_nmarquivo TYPE character(40);

