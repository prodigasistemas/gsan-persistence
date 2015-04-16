-- // exclui tabelas de consumo de produto
-- Migration SQL that makes the change goes here.

drop table operacao.consumo_produto;

drop table operacao.consumo;

-- //@UNDO
-- SQL to undo the change goes here.

CREATE TABLE operacao.consumo
(
  cons_id integer NOT NULL,
  cons_data timestamp without time zone,
  loca_id integer NOT NULL,
  muni_id integer NOT NULL,
  greg_id integer NOT NULL,
  sabs_id integer NOT NULL,
  cons_tmultimaalteracao timestamp without time zone NOT NULL DEFAULT now(),
  uneg_id integer NOT NULL,
  usur_id integer NOT NULL,
  CONSTRAINT consumo_pkey PRIMARY KEY (cons_id),
  CONSTRAINT fk38b6fc062b17a1bf FOREIGN KEY (sabs_id)
      REFERENCES operacional.sistema_abastecimento (sabs_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk38b6fc068f83f6d7 FOREIGN KEY (greg_id)
      REFERENCES cadastro.gerencia_regional (greg_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk38b6fc06af0e0fdd FOREIGN KEY (muni_id)
      REFERENCES cadastro.municipio (muni_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk38b6fc06cbe39cec FOREIGN KEY (uneg_id)
      REFERENCES cadastro.unidade_negocio (uneg_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk38b6fc06e0bf3866 FOREIGN KEY (loca_id)
      REFERENCES cadastro.localidade (loca_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE operacao.consumo
  OWNER TO gsan_admin;

CREATE TABLE operacao.consumo_produto
(
  conp_quantidade double precision,
  prod_id integer NOT NULL,
  cons_id integer NOT NULL,
  CONSTRAINT consumo_produto_pkey PRIMARY KEY (prod_id, cons_id),
  CONSTRAINT fk73b30bc078e4d1b7 FOREIGN KEY (prod_id)
      REFERENCES operacao.produto (prod_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk73b30bc0f372caa FOREIGN KEY (cons_id)
      REFERENCES operacao.consumo (cons_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE operacao.consumo_produto
  OWNER TO gsan_admin;