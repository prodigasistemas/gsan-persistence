-- // altera texto do campo formula
-- Migration SQL that makes the change goes here.
UPDATE operacao.indicador
SET indc_form = 'Despesa Total por Ultrapassagem da Demanda Contratada (R$) / Despesa Total com Energia Elétrica (R$)'
WHERE indc_nome = 'Conformidade da demanda de potência elétrica contratada';

UPDATE operacao.indicador
SET indc_form = 'Despesa pelo Fator de Potência Elétrica em R$ / Despesa Total com Energia Elétrica (R$)'
WHERE indc_nome = 'Despesa decorrente do Fator de Potência Elétrica';
-- //@UNDO
-- SQL to undo the change goes here.
UPDATE operacao.indicador
SET indc_form = 'demanda de potência elétrica medida em Kw / demanda de potência elétrica contratada em Kw'
WHERE indc_nome = 'Conformidade da demanda de potência elétrica contratada';

UPDATE operacao.indicador
SET indc_form = 'despesa pelo Fator de Potência Elétrica em R$ / despesa total com demanda e consumo de energia elétrica em R$'
WHERE indc_nome = 'Despesa decorrente do Fator de Potência Elétrica';