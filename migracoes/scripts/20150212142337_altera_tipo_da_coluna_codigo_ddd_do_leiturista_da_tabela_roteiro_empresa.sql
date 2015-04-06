-- // altera tipo da coluna codigo ddd do leiturista da tabela roteiro empresa
-- Migration SQL that makes the change goes here.

ALTER TABLE  micromedicao.arquivo_texto_rot_empr
  ALTER COLUMN txre_cddddleiturista TYPE character varying(2);

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE  micromedicao.arquivo_texto_rot_empr
  ALTER COLUMN txre_cddddleiturista TYPE character(2);
