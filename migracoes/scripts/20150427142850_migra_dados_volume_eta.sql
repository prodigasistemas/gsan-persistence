-- // migra dados volume eta
-- Migration SQL that makes the change goes here.
insert into operacao.volume
(id, tipo_unidade, id_unidade, tmultimaalteracao, tmmedicao, referencia, estimado, volume, observacoes, usur_id, etav_id)	
(select nextval('operacao.sequence_volume'), 
	2, 
	etav.eta_id,
	etav.etav_tmultimaalteracao, 
	etav.etav_tmmedicao,
	cast(to_char(etav.etav_referencia, 'YYYYMM' ) as int),
	etav.etav_estimado,
	etav.etav_volume,
	etav.observacoes,
	etav.usur_id,
	etav.etav_id
from operacao.eta_volume etav);


-- //@UNDO
-- SQL to undo the change goes here.
delete from operacao.volume where tipo_unidade = 2;