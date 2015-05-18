-- // cria view para medidores de entrada de unidades operacionais
-- Migration SQL that makes the change goes here.
create view operacao.medidor_entrada_unidade_operacional
  (id, tipo_unidade_operacional, id_unidade_operacional, tipo_medicao, identificador_leitura) as
select eab.mmed_identrada as id, 1 as tipo, eeab_id as id_unidade_operacional, 
medidor.mmed_tipomedicao as tipo_medicao, medidor.mmed_idleitura as identificador_leitura
from operacao.eeab_fontecaptacao eab
inner join operacao.macro_medidor medidor on
  medidor.mmed_id = eab.mmed_identrada

union 
select eat.mmed_identrada as id, 3 as tipo, eeat_id as id_unidade_operacional, 
medidor.mmed_tipomedicao as tipo_medicao, medidor.mmed_idleitura as identificador_leitura
from operacao.eeat_fontecaptacao eat
inner join operacao.macro_medidor medidor on
  medidor.mmed_id = eat.mmed_identrada

union 
select eta.mmed_identrada as id, 2 as tipo, eta_id as id_unidade_operacional, 
medidor.mmed_tipomedicao as tipo_medicao, medidor.mmed_idleitura as identificador_leitura
from operacao.eta_fontecaptacao eta
inner join operacao.macro_medidor medidor on
  medidor.mmed_id = eta.mmed_identrada;

ALTER view operacao.medidor_entrada_unidade_operacional OWNER TO gsan_admin;
ALTER TABLE operacao.eeab_fontecaptacao OWNER TO gsan_admin;
ALTER TABLE operacao.eeat_fontecaptacao OWNER TO gsan_admin;
ALTER TABLE operacao.eta_fontecaptacao OWNER TO gsan_admin;

-- //@UNDO
-- SQL to undo the change goes here.

drop view operacao.medidor_entrada_unidade_operacional;