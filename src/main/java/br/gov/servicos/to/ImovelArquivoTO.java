package br.gov.servicos.to;

import java.io.Serializable;

public class ImovelArquivoTO implements Serializable {
	private static final long serialVersionUID = 2115002923332394787L;
	
	private String nomeGerenciaRegional;
	private Integer idLocalidade;
	private String nomeLocalidade;
	private String nomeImovel;
	private String nomeClienteUsuario;
	private Integer codigoSetorComercial;
	private Integer numeroQuadra;
	private Short lote;
	private Short subLote;
	private Integer idClienteResponsavel;
	private String nomeClienteResponsavel;
	private Integer ligacaoAguaSituacao;

}
