-- // altera owner sequence eeab
-- Migration SQL that makes the change goes here.

ALTER TABLE operacao.sequence_eeab OWNER TO gsan_admin;


-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE operacao.sequence_eeab OWNER TO postgres;
