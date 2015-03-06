-- // altera tabela arquivo texto roteiro empresa para permitir nulos
-- Migration SQL that makes the change goes here.

ALTER TABLE micromedicao.arquivo_texto_rot_empr ALTER COLUMN loca_id DROP NOT NULL ;
ALTER TABLE micromedicao.arquivo_texto_rot_empr ALTER COLUMN txre_cdsetorcomercial1 DROP NOT NULL ;
ALTER TABLE micromedicao.arquivo_texto_rot_empr ALTER COLUMN txre_nnquadrainicial1 DROP NOT NULL ;
ALTER TABLE micromedicao.arquivo_texto_rot_empr ALTER COLUMN txre_nnquadrafinal1 DROP NOT NULL ;

-- //@UNDO
-- SQL to undo the change goes here.


