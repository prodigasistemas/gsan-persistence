package br.gov.model.exception;

public class CategoriasTarifaInexistente extends BaseRuntimeException {
	private static final long serialVersionUID = -1064272288311991801L;

	public CategoriasTarifaInexistente(Object... params) {
		super("Categorias de tarifa inexistente para o imovel [%s]", params[0]);
	}
}
