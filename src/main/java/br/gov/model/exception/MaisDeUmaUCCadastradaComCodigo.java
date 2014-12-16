package br.gov.model.exception;

public class MaisDeUmaUCCadastradaComCodigo extends BaseRuntimeException {
    private static final long serialVersionUID = -8661056238218828260L;

    public MaisDeUmaUCCadastradaComCodigo(Object... parametros) {
        super("Mais de uma UC cadastrada com o código [%s].", parametros);
	}
}
