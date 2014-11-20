-- // cria view estacoes operacionais
-- Migration SQL that makes the change goes here.

create view operacao.estacao_operacional (id, nome, tipo, quantidade_cmb) as
select eeab_id as id, eeab_nome as nome, 1 as tipo, eeab_cmb as quantidade_cmb
from operacao.eeab
union 
select eeat_id as id, eeat_nome as nome, 3 as tipo, eeat_cmb as quantidade_cmb
from operacao.eeat
union 
select eta_id as id, eta_nome as nome, 2 as tipo, eta_cmb as quantidade_cmb
from operacao.eta;

ALTER view operacao.estacao_operacional OWNER TO gsan_admin;
ALTER TABLE operacao.eeab OWNER TO gsan_admin;
ALTER TABLE operacao.eeat OWNER TO gsan_admin;
ALTER TABLE operacao.eta OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

drop view operacao.estacao_operacional;