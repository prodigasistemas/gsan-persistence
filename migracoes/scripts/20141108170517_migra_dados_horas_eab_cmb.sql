-- // migra dados hora eab cmb
-- Migration SQL that makes the change goes here.

insert into operacao.hora_cmb
(hcmb_id, hcmb_qtd, hcmb_medicao, hora_id)
(select nextval('operacao.sequence_hora_cmb'),eabc_qtdcmb, eabc_horacmb, hora.hora_id
from operacao.eeab_horas_cmb eabc
inner join operacao.eeab_horas eabh on
eabh.eabh_id = eabc.eebh_id
inner join operacao.hora hora on
hora.hora_tipo_unidade = 1
and hora.eabh_id = eabh.eabh_id
);

-- //@UNDO
-- SQL to undo the change goes here.

delete from operacao.hora_cmb where hora_id in
(select hora_id from operacao.hora where hora_tipo_unidade = 1)