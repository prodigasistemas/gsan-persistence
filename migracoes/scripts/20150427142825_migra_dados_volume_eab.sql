-- // migra dados volume eab
-- Migration SQL that makes the change goes here.
insert into operacao.volume
(id, tipo_unidade, id_unidade, tmultimaalteracao, tmmedicao, referencia, estimado, volume, observacoes, usur_id, eabv_id)	
(select nextval('operacao.sequence_volume'), 
	1,
	eabv.eeab_id, 
	eabv.eabv_tmultimaalteracao, 
	eabv.eabv_tmmedicao,
	cast(to_char(eabv.eabv_referencia, 'YYYYMM' ) as int),
	eabv.eabv_estimado,
	eabv.eabv_volume,
	eabv.observacoes,
	eabv.usur_id,
	eabv.eabv_id
from operacao.eeab_volume eabv);


-- //@UNDO
-- SQL to undo the change goes here.
delete from operacao.volume where tipo_unidade = 1;

