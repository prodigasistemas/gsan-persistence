-- // migra dados volume fluxo eta
-- Migration SQL that makes the change goes here.
insert into operacao.volume_fluxo
(id, tipofluxo, tipomedicao, volume, volume_id, macromedidor_id)
(select nextval('operacao.sequence_volume_fluxo'), 1, etae.mmed_tipomedicao, 
  etae.etae_volume, etae.etav_id, etae.mmed_identrada

from operacao.eta_volume_entrada etae
inner join operacao.eta_volume etav on
etav.etav_id = etae.etav_id
);

-- //@UNDO
-- SQL to undo the change goes here.
delete from operacao.volume_fluxo where volume_id in
(select volume_id from operacao.volume where tipo_unidade = 2);