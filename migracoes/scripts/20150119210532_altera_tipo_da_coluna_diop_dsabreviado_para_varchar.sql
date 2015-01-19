-- // altera tipo da coluna diop_dsabreviado para varchar
-- Migration SQL that makes the change goes here.

ALTER TABLE operacional.distrito_operacional
  ALTER COLUMN diop_dsabreviado TYPE character varying(3);


-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE operacional.distrito_operacional
  ALTER COLUMN diop_dsabreviado TYPE character(3);

