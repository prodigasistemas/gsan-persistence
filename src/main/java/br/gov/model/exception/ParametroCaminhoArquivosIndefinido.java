package br.gov.model.exception;

public class ParametroCaminhoArquivosIndefinido extends BaseRuntimeException {

	private static final long serialVersionUID = 2276194727161683818L;

	public ParametroCaminhoArquivosIndefinido() {
		super("Companhia deve definir parametro do caminho para armazenamento de arquivos");
	}
}
