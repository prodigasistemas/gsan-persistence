-- // adiciona_situacao_em_fila_em_batch_processo_situacao
-- Migration SQL that makes the change goes here.
INSERT INTO batch.processo_situacao(prst_id, prst_dsprocessosituacao,
            prst_dsabreviado, prst_icuso, prst_tmultimaalteracao)
            VALUES (nextval('batch.seq_processo_situacao'), 'EM FILA', 'EFL', 2, now());


-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM batch.processo_situacao WHERE prst_dsprocessosituacao = 'EM FILA';
