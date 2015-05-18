-- // migra dados volume fluxo saida eta
-- Migration SQL that makes the change goes here.
insert into operacao.volume_fluxo
(id, tipofluxo, tipomedicao, volume, volume_id, macromedidor_id)
(select nextval('operacao.sequence_volume_fluxo'), 2, etas.mmed_tipomedicao, 
  etas.etas_volume, volume.id, etas.mmed_idsaida

from operacao.eta_volume_saida etas
inner join operacao.eta_volume etav on etav.etav_id = etas.etav_id
inner join operacao.volume volume on volume.etav_id = etav.etav_id
);

-- //@UNDO
-- SQL to undo the change goes here.
delete from operacao.volume_fluxo where volume_id in
(select volume_id from operacao.volume where tipo_unidade = 2);