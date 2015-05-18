-- // transfere dados de consumo produto para consumo produto sistema abastecimento
-- Migration SQL that makes the change goes here.

insert into operacao.consumo_produto_sistema_abastecimento (select * from operacao.consumo_produto);


-- //@UNDO
-- SQL to undo the change goes here.


delete from operacao.consumo_produto_sistema_abastecimento;