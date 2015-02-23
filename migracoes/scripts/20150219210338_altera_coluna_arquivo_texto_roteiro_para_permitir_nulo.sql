-- // altera coluna arquivo texto roteiro para permitir nulo
-- Migration SQL that makes the change goes here.

ALTER TABLE micromedicao.arquivo_texto_rot_empr ALTER COLUMN txre_artexto DROP NOT NULL ;


-- //@UNDO
-- SQL to undo the change goes here.
