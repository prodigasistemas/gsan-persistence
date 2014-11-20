-- // migra dados hora eat cmb
-- Migration SQL that makes the change goes here.

insert into operacao.hora_cmb
(hcmb_id, hcmb_qtd, hcmb_medicao, hora_id)
(select nextval('operacao.sequence_hora_cmb'), eatc_qtdcmb, eatc_horacmb, hora.hora_id
from operacao.eeat_horas_cmb cmb
inner join operacao.eeat_horas eh on
eh.eath_id = cmb.eath_id
inner join operacao.hora hora on
hora.hora_tipo_unidade = 3
and hora.eath_id = eh.eath_id
);

-- //@UNDO
-- SQL to undo the change goes here.

delete from operacao.hora_cmb where hora_id in
(select hora_id from operacao.hora where hora_tipo_unidade = 3)