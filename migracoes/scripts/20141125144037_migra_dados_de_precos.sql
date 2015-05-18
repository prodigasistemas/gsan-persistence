-- // migra dados de precos
-- Migration SQL that makes the change goes here.

insert into operacao.preco_produto
(id, preco, vigencia, usur_id, prod_id)
(select nextval('operacao.sequence_preco_produto'), tbpp_preco, cast(tabp_vigencia as date), usur_id, prod_id
from operacao.tabelapreco t
inner join operacao.tabelapreco_produto p on
p.tabp_id = t.tabp_id
);

-- //@UNDO
-- SQL to undo the change goes here.

delete from operacao.preco_produto;