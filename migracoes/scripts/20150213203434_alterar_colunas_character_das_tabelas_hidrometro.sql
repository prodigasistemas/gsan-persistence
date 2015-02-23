-- // alterar colunas character das tabelas hidrometro
-- Migration SQL that makes the change goes here.

ALTER TABLE  micromedicao.hidrometro_capacidade ALTER COLUMN hicp_dsabreviadahidrcapacidade TYPE character varying(6);
ALTER TABLE  micromedicao.hidrometro_capacidade ALTER COLUMN hicp_cdhidrometrocapacidade TYPE character varying(1);
ALTER TABLE  micromedicao.hidrometro_marca ALTER COLUMN himc_dsabreviadahidrmarca TYPE character varying(3);
ALTER TABLE  micromedicao.hidrometro_marca ALTER COLUMN himc_cdhidrometromarca TYPE character varying(1);
ALTER TABLE  micromedicao.hidrometro_tipo ALTER COLUMN hitp_dcabreviadahidrometrotipo TYPE character varying(5);

-- //@UNDO
-- SQL to undo the change goes here.

ALTER TABLE  micromedicao.hidrometro_capacidade ALTER COLUMN hicp_dsabreviadahidrcapacidade TYPE character(6);
ALTER TABLE  micromedicao.hidrometro_capacidade ALTER COLUMN hicp_cdhidrometrocapacidade TYPE character(1);
ALTER TABLE  micromedicao.hidrometro_marca ALTER COLUMN himc_dsabreviadahidrmarca TYPE character(3);
ALTER TABLE  micromedicao.hidrometro_marca ALTER COLUMN himc_cdhidrometromarca TYPE character(1);
ALTER TABLE  micromedicao.hidrometro_tipo ALTER COLUMN hitp_dcabreviadahidrometrotipo TYPE character(5);