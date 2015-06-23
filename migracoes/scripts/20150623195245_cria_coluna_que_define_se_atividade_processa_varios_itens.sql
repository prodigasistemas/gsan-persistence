-- // cria coluna que define se atividade processa varios itens
-- Migration SQL that makes the change goes here.

alter table batch.processo_atividade add column processa_varios_itens boolean default true;

update batch.processo_atividade set processa_varios_itens = true;

-- //@UNDO
-- SQL to undo the change goes here.

alter table batch.processo_atividade drop column processa_varios_itens;

