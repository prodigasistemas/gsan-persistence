-- // migra dados hora eab
-- Migration SQL that makes the change goes here.

insert into operacao.hora
(hora_id, hora_tipo_unidade, hora_id_unidade, hora_ano_mes_referencia, usur_id, eabh_id)
(select nextval('operacao.sequence_hora'), 1, eeab_id, cast(to_char(eabh_referencia, 'YYYYMM' ) as int), eabh.usur_id, eabh_id
from operacao.eeab_horas eabh);

-- //@UNDO
-- SQL to undo the change goes here.

delete from operacao.hora where hora_tipo_unidade = 1;
