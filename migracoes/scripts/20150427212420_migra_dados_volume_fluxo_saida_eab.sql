-- // migra dados volume fluxo saida eab
-- Migration SQL that makes the change goes here.
insert into operacao.volume_fluxo
(id, tipofluxo, tipomedicao, volume, volume_id, macromedidor_id)
(select nextval('operacao.sequence_volume_fluxo'), 2, eabs.mmed_tipomedicao, 
  eabs.eabs_volume, volume.id, eabs.mmed_idsaida

from operacao.eeab_volume_saida eabs
inner join operacao.eeab_volume eabv on eabv.eabv_id = eabs.eabv_id
inner join operacao.volume volume on volume.eabv_id = eabv.eabv_id
);

-- //@UNDO
-- SQL to undo the change goes here.
delete from operacao.volume_fluxo where volume_id in
(select volume_id from operacao.volume where tipo_unidade = 1);