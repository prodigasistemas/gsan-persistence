-- // tornar campo codigo de UC unico
-- Migration SQL that makes the change goes here.

ALTER TABLE operacao.unidade_consumidora ADD CONSTRAINT CONSTRAINT_OPERACAO_UNIDADE_CONSUMIDORA_UCON_UC UNIQUE (ucon_uc);

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE operacao.unidade_consumidora
  DROP CONSTRAINT CONSTRAINT_OPERACAO_UNIDADE_CONSUMIDORA_UCON_UC;

