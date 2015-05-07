-- // migra dados volume fluxo de entrada eab
-- Migration SQL that makes the change goes here.
insert into operacao.volume_fluxo
(id, tipofluxo, tipomedicao, volume, volume_id, macromedidor_id)
(select nextval('operacao.sequence_volume_fluxo'), 1, eabe.mmed_tipomedicao, 
  eabe.eabe_volume, eabe.eabv_id, eabe.mmed_identrada

from operacao.eeab_volume_entrada eabe
inner join operacao.eeab_volume eabv on
eabv.eabv_id = eabe.eabv_id
);

-- //@UNDO
-- SQL to undo the change goes here.
delete from operacao.volume_fluxo where volume_id in
(select volume_id from operacao.volume where tipo_unidade = 1);