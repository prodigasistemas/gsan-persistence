package br.gov.model.exception;

public class TarifaConsumoInexistente extends BaseRuntimeException {
	private static final long serialVersionUID = -1064272288311991801L;

	public TarifaConsumoInexistente(Object... params) {
		super("Nao existe tarifa com id [%s] para esta vigencia [%s]", params[0], params[1]);
	}
}
