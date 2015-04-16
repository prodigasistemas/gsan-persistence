-- // altera texto do campo responsaveis
-- Migration SQL that makes the change goes here.
UPDATE operacao.indicador
SET indc_resp = 'UEAT / USRP'
WHERE indc_nome = 'Rede Instalada'

-- //@UNDO
-- SQL to undo the change goes here.
UPDATE operacao.indicador
SET indc_resp = 'UEPM / USRP'
WHERE indc_nome = 'Rede Instalada'