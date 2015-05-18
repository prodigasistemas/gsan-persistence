-- // altera parametro de bloqueio de data retroativa
-- Migration SQL that makes the change goes here.

UPDATE operacao.parametro
SET parm_nmparametro = 'BLOQUEIA_DATA_RETROATIVA'
WHERE parm_nmparametro = 'BLOQUEIA DATA RETROATIVA'

-- //@UNDO
-- SQL to undo the change goes here.

UPDATE operacao.parametro
SET parm_nmparametro = 'BLOQUEIA DATA RETROATIVA'
WHERE parm_nmparametro = 'BLOQUEIA_DATA_RETROATIVA'

