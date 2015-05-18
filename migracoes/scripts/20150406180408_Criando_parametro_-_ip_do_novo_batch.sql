-- // Criando parametro - ip do novo batch
-- Migration SQL that makes the change goes here.

insert into seguranca.parametro values (2, 'IP_NOVO_BATCH', 'localhost:3000');


-- //@UNDO
-- SQL to undo the change goes here.


delete from  seguranca.parametro where id = 2;