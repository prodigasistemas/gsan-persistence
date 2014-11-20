-- // migra dados hora eat
-- Migration SQL that makes the change goes here.

insert into operacao.hora
(hora_id, hora_tipo_unidade, hora_id_unidade, hora_ano_mes_referencia, usur_id, eath_id)
(select nextval('operacao.sequence_hora'), 3, eeat_id, cast(to_char(eath_referencia, 'YYYYMM' ) as int), usur_id, eath_id
from operacao.eeat_horas);

-- //@UNDO
-- SQL to undo the change goes here.

delete from operacao.hora where hora_tipo_unidade = 3;
