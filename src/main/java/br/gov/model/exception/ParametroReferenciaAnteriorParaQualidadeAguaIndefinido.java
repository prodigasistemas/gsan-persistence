package br.gov.model.exception;

public class ParametroReferenciaAnteriorParaQualidadeAguaIndefinido extends BaseRuntimeException{
	private static final long serialVersionUID = 2471014788477723048L;

	public ParametroReferenciaAnteriorParaQualidadeAguaIndefinido() {
		super("Companhia deve definir parametro que define se deseja utilizar referencia anterior para gerar texto sobre qualidade da agua.");
	}
}
