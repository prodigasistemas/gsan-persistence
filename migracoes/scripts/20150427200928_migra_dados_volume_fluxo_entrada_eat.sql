-- // migra dados volume fluxo eat
-- Migration SQL that makes the change goes here.
insert into operacao.volume_fluxo
(id, tipofluxo, tipomedicao, volume, volume_id, macromedidor_id)
(select nextval('operacao.sequence_volume_fluxo'), 1, eate.mmed_tipomedicao, 
  eate.eate_volume, eate.eatv_id, eate.mmed_identrada

from operacao.eeat_volume_entrada eate
inner join operacao.eeat_volume eatv on
eatv.eatv_id = eate.eatv_id
);

-- //@UNDO
-- SQL to undo the change goes here.
delete from operacao.volume_fluxo where volume_id in
(select volume_id from operacao.volume where tipo_unidade = 3);