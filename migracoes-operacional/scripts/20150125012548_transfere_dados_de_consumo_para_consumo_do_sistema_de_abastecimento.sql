-- // transfere dados de consumo para consumo do sistema de abastecimento
-- Migration SQL that makes the change goes here.

insert into operacao.consumo_sistema_abastecimento (select * from operacao.consumo);


-- //@UNDO
-- SQL to undo the change goes here.


delete from operacao.consumo_sistema_abastecimento;