package br.gov.model.exception;

public class ErroCriacaoConta extends BaseRuntimeException{
	private static final long serialVersionUID = -8972705352295997647L;

	public ErroCriacaoConta(Throwable t, Object... parametros) {
		super("Erro ao persistir conta com id %s do imovel: %s", t, parametros);
	}
}