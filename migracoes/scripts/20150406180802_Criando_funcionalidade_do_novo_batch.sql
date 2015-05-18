-- // Criando funcionalidade do novo batch
-- Migration SQL that makes the change goes here.


insert into seguranca.funcionalidade 
  (fncd_id,  
    modu_id, 
    fncd_dsfuncionalidade, 
    fncd_dscaminhomenu, 
    fncd_dscaminhourl, 
    fncd_icpontoentrada, 
    fncd_dsabreviado, 
    fncd_nnordemmenu, 
    fncd_icnovajanela, 
    fncd_icolap, 
    fncg_id )
values 
  (16026, 
    8, 
    'Novo Batch', 
    'Gsan/Novo Batch', 
    'acessarNovoBatch', 
    1, 
    'NovBat', 
    1, 
    1, 
    2, 
    65);


insert into seguranca.operacao
  (oper_id, fncd_id, oper_dsoperacao, oper_dsabreviado, oper_dscaminhourl,  optp_id)
values (15048, 16026, 'Novo Batch', 'NOVBAT', '', 14);


insert into seguranca.grupo_func_operacao
values (1, 15048, 16026);

-- //@UNDO
-- SQL to undo the change goes here.

delete from seguranca.grupo_func_operacao where fncd_id = 16026;
  delete from seguranca.grupo_func_operacao where oper_id = 15048;
delete from seguranca.operacao where oper_id = 15048;
delete from seguranca.funcionalidade where fncd_id = 16026;
