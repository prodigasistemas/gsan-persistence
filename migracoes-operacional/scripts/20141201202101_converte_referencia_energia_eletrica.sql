-- // converte referencia energia eletrica
-- Migration SQL that makes the change goes here.

ALTER TABLE operacao.energiaeletrica ADD COLUMN enel_referencia_temp integer;

update  operacao.energiaeletrica
set enel_referencia_temp = cast(to_char(enel_referencia, 'YYYYMM') as int);


ALTER TABLE operacao.energiaeletrica DROP COLUMN enel_referencia;

ALTER TABLE operacao.energiaeletrica ADD COLUMN enel_referencia integer;

update  operacao.energiaeletrica
set enel_referencia = enel_referencia_temp;

ALTER TABLE operacao.energiaeletrica DROP COLUMN enel_referencia_temp;

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE operacao.energiaeletrica ADD COLUMN enel_referencia_temp date;

update  operacao.energiaeletrica
set enel_referencia_temp = cast(
    substring(cast(enel_referencia as text)  for 4) 
    || '-' || substring(cast(enel_referencia as text)  from 5 for 2)
    || '-01'
    as date);

ALTER TABLE operacao.energiaeletrica DROP COLUMN enel_referencia;

ALTER TABLE operacao.energiaeletrica ADD COLUMN enel_referencia date;

update  operacao.energiaeletrica
set enel_referencia = enel_referencia_temp;

ALTER TABLE operacao.energiaeletrica DROP COLUMN enel_referencia_temp;
