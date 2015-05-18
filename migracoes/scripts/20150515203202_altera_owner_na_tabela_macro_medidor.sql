-- // altera owner na tabela macro medidor
-- Migration SQL that makes the change goes here.
ALTER TABLE operacao.macro_medidor OWNER TO gsan_admin;


-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE operacao.macro_medidor OWNER TO postgres;

