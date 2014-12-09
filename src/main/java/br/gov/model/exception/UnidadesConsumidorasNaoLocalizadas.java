package br.gov.model.exception;

public class UnidadesConsumidorasNaoLocalizadas extends BaseRuntimeException {
    private static final long serialVersionUID = -8661056238218828260L;

    public UnidadesConsumidorasNaoLocalizadas(Object... parametros) {
        super("Unidades consumidoras não localizadas [%s].", parametros);
	}
}
