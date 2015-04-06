-- // adiciona constraint para coluna ltan_id da tabela movimento_roteiro_empr
-- Migration SQL that makes the change goes here.

-- ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN ltan_id TYPE integer;

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE  micromedicao.movimento_roteiro_empr ALTER COLUMN ltan_id TYPE smallint;
