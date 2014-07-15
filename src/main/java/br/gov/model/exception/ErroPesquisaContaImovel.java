package br.gov.model.exception;

public class ErroPesquisaContaImovel extends BaseRuntimeException {
	private static final long serialVersionUID = -1064272288311991801L;

	public ErroPesquisaContaImovel(Throwable e, Object... parametros) {
		super("Erro ao verficar se imovel %s possui conta.", e, parametros);
	}
}
