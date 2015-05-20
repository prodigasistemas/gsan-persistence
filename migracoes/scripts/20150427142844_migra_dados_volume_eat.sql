-- // migra dados volume eat
-- Migration SQL that makes the change goes here.
insert into operacao.volume
(id, tipo_unidade, id_unidade, tmultimaalteracao, tmmedicao, referencia, estimado, volume, observacoes, usur_id, eatv_id)	
(select nextval('operacao.sequence_volume'), 
	3, 
	eatv.eeat_id,
	eatv.eatv_tmultimaalteracao, 
	eatv.eatv_tmmedicao,
	cast(to_char(eatv.eatv_referencia, 'YYYYMM' ) as int),
	eatv.eatv_estimado,
	eatv.eatv_volume,
	eatv.observacoes,
	eatv.usur_id,
	eatv.eatv_id
from operacao.eeat_volume eatv);


-- //@UNDO
-- SQL to undo the change goes here.
delete from operacao.volume where tipo_unidade = 3;

