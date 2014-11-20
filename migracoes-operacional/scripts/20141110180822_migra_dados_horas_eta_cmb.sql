-- // migra dados hora eta cmb
-- Migration SQL that makes the change goes here.

insert into operacao.hora_cmb
(hcmb_id, hcmb_qtd, hcmb_medicao, hora_id)
(select nextval('operacao.sequence_hora_cmb'), etac_qtdcmb, etac_horacmb, hora.hora_id
from operacao.eta_horas_cmb cmb
inner join operacao.eta_horas eh on
eh.etah_id = cmb.etah_id
inner join operacao.hora hora on
hora.hora_tipo_unidade = 2
and hora.etah_id = eh.etah_id
);

-- //@UNDO
-- SQL to undo the change goes here.

delete from operacao.hora_cmb where hora_id in
(select hora_id from operacao.hora where hora_tipo_unidade = 2)