-- // cria view para medidores de unidades operacionais
-- Migration SQL that makes the change goes here.
create view operacao.medidor_unidade_operacional
  (id, tipo_unidade_operacional, id_unidade_operacional, tipo_medicao, identificador_leitura) as
select eebm_id as id, 1 as tipo, eeab_id as id_unidade_operacional, 
medidor.mmed_tipomedicao as tipo_medicao, medidor.mmed_idleitura as identificador_leitura
from operacao.eeab_medidor eab
inner join operacao.macro_medidor medidor on
  medidor.mmed_id = eab.mmed_idsaida

union 
select eetm_id as id, 3 as tipo, eeat_id as id_unidade_operacional, 
medidor.mmed_tipomedicao as tipo_medicao, medidor.mmed_idleitura as identificador_leitura
from operacao.eeat_medidor eat
inner join operacao.macro_medidor medidor on
  medidor.mmed_id = eat.mmed_idsaida

union 
select etam_id as id, 2 as tipo, eta_id as id_unidade_operacional, 
medidor.mmed_tipomedicao as tipo_medicao, medidor.mmed_idleitura as identificador_leitura
from operacao.eta_medidor eta
inner join operacao.macro_medidor medidor on
  medidor.mmed_id = eta.mmed_idsaida

ALTER view operacao.medidor_unidade_operacional OWNER TO gsan_admin;
ALTER TABLE operacao.eeab_medidor OWNER TO gsan_admin;
ALTER TABLE operacao.eeat_medidor OWNER TO gsan_admin;
ALTER TABLE operacao.eta_medidor OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

drop view operacao.medidor_unidade_operacional;