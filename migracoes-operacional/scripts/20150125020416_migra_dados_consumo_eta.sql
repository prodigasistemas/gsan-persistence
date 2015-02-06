-- // migra dados consumo eta
-- Migration SQL that makes the change goes here.

insert into operacao.consumo
(id, tipo_unidade, id_unidade, data, usur_id, etac_id)
(select nextval('operacao.sequence_consumo'), 2, eta_id, cast(cons_data as date), c.usur_id, cons_id
from operacao.consumoeta c );

-- //@UNDO
-- SQL to undo the change goes here.

delete from operacao.consumo where tipo_unidade = 2;
