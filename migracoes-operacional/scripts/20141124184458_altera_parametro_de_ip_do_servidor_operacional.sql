-- // altera parametro de ip do servidor operacional
-- Migration SQL that makes the change goes here.

update cadastro.sistema_parametros
set parm_ipservidormodulooperacional = '200.178.173.135:9080'

-- //@UNDO
-- SQL to undo the change goes here.

update cadastro.sistema_parametros
set parm_ipservidormodulooperacional = '200.178.173.135:8084'