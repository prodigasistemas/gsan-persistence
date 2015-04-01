-- // altera tipo da coluna de referencia da tabela de rede instalada
-- Migration SQL that makes the change goes here.

alter table operacao.rede_instalada ADD COLUMN referencia_new integer;

update operacao.rede_instalada 
  set referencia_new = cast(to_char(rdin_referencia, 'YYYYMM') as int);

alter table operacao.rede_instalada DROP COLUMN rdin_referencia;

alter table operacao.rede_instalada RENAME COLUMN referencia_new TO rdin_referencia;

-- //@UNDO
-- SQL to undo the change goes here.

alter table operacao.rede_instalada ADD COLUMN referencia_new date;

update operacao.rede_instalada 
  set referencia_new = cast(
  	  substring(cast(rdin_referencia as text)  for 4) 
      || '-' 
      || substring(cast(rdin_referencia as text)  from 5 for 2)
      || '-01'
    as date);

alter table operacao.rede_instalada DROP COLUMN rdin_referencia;

alter table operacao.rede_instalada RENAME COLUMN referencia_new TO rdin_referencia;

