-- // adiciona situacao processo reiniciado
-- Migration SQL that makes the change goes here.

INSERT INTO batch.processo_situacao(
            prst_id, prst_dsprocessosituacao, prst_dsabreviado, prst_icuso, 
            prst_tmultimaalteracao)
    VALUES (nextval('batch.seq_processo_situacao'), 'REINICIADO', 'RNCD', 2, 
            now());


-- //@UNDO
-- SQL to undo the change goes here.

DELETE FROM batch.processo_situacao
WHERE prst_dsprocessosituacao = 'REINICIADO';

select setval('batch.seq_processo_situacao',  (select last_value - 1 from batch.seq_processo_situacao));
