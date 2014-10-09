INSERT INTO batch.processo_situacao(
            prst_id, prst_dsprocessosituacao, prst_dsabreviado, prst_icuso, 
            prst_tmultimaalteracao)
    VALUES (nextval('batch.seq_processo_situacao'), 'REINICIADO', 'RNCD', 2, 
            now());
