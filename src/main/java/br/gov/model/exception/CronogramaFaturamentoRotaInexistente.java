package br.gov.model.exception;

public class CronogramaFaturamentoRotaInexistente extends BaseRuntimeException {
	private static final long serialVersionUID = -1064272288311991801L;

	public CronogramaFaturamentoRotaInexistente(Throwable e, Object... parametros) {
		super("Cronograma de faturamento inexistente para [rota = %s; grupoFaturamento = %s, referencia = %s].", e, parametros);
	}
}
