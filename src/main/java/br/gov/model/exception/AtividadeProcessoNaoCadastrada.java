package br.gov.model.exception;

public class AtividadeProcessoNaoCadastrada extends BaseRuntimeException {
	private static final long serialVersionUID = -1064272288311991801L;

	public AtividadeProcessoNaoCadastrada(Object... params) {
		super("Nao existe atividade cadastrada para o processo com este nome [%s]", params[0]);
	}
}
