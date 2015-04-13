-- // altera texto do campo formula
-- Migration SQL that makes the change goes here.
UPDATE operacao.indicador
SET indc_form = 'Despesa Total por Ultrapassagem da Demanda Contratada (R$) / Despesa Total com Energia Elétrica (R$)'
WHERE indc_nome = 'Conformidade da demanda de potência elétrica contratada'

UPDATE operacao.indicador
SET indc_form = 'Fórmula" modificar o texto do denominador para: "Despesa Total com Energia Elétrica (R$)'
WHERE indc_nome = 'Despesa decorrente do Fator de Potência Elétrica'
-- //@UNDO
-- SQL to undo the change goes here.
UPDATE operacao.indicador
SET indc_form = 'Despesa Total por Ultrapassagem da Demanda Contratada (R$) / Despesa Total com Energia Elétrica (R$)'
WHERE indc_nome = 'Conformidade da demanda de potência elétrica contratada'

UPDATE operacao.indicador
SET indc_form = 'Fórmula" modificar o texto do denominador para: "Despesa Total com Energia Elétrica (R$)'
WHERE indc_nome = 'Despesa decorrente do Fator de Potência Elétrica'

