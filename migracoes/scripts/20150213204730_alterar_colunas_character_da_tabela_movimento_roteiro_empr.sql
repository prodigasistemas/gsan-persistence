-- // alterar colunas character da tabela movimento_roteiro_empr
-- Migration SQL that makes the change goes here.

ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_nnloteimovel TYPE character varying(4);
ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_nnsubloteimovel TYPE character varying(3);
ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_nnhidrometro TYPE character varying(10);
ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_dsabrevlogradourotitulo TYPE character varying(5);
ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_dsabrevlogradourotipo TYPE character varying(5);

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_nnloteimovel TYPE character(4);
ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_nnsubloteimovel TYPE character(3);
ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_nnhidrometro TYPE character(10);
ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_dsabrevlogradourotitulo TYPE character(5);
ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN mrem_dsabrevlogradourotipo TYPE character(5);
