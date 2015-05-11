-- // migra dados volume fluxo saida eat
-- Migration SQL that makes the change goes here.
insert into operacao.volume_fluxo
(id, tipofluxo, tipomedicao, volume, volume_id, macromedidor_id)
(select nextval('operacao.sequence_volume_fluxo'), 2, eats.mmed_tipomedicao, 
  eats.eats_volume, volume.id, eats.mmed_idsaida

from operacao.eeat_volume_saida eats
inner join operacao.eeat_volume eatv on eatv.eatv_id = eats.eatv_id
inner join operacao.volume volume on volume.eatv_id = eatv.eatv_id
);

-- //@UNDO
-- SQL to undo the change goes here.
delete from operacao.volume_fluxo where volume_id in
(select volume_id from operacao.volume where tipo_unidade = 3);