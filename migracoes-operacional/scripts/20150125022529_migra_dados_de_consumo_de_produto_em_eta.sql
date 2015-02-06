-- // migra dados de consumo de produto em eta
-- Migration SQL that makes the change goes here.

insert into operacao.consumo_produto
(id, quantidade, prod_id, cons_id)
(select nextval('operacao.sequence_consumo_produto'), conp_quantidade, cp.prod_id, consumo.id
from operacao.consumoeta_produto cp
inner join operacao.consumoeta ceta on
ceta.cons_id = cp.cons_id
inner join operacao.consumo consumo on
consumo.tipo_unidade = 2
and consumo.etac_id = ceta.cons_id
);

-- //@UNDO
-- SQL to undo the change goes here.

delete from operacao.consumo_produto where cons_id in
(select id from operacao.consumo where tipo_unidade = 2)