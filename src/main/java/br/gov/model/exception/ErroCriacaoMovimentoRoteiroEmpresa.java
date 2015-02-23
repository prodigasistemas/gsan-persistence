package br.gov.model.exception;

public class ErroCriacaoMovimentoRoteiroEmpresa extends BaseRuntimeException{

	private static final long serialVersionUID = 5037958666060828440L;

	public ErroCriacaoMovimentoRoteiroEmpresa(Throwable t, Object... parametros) {
		super("Erro ao persistir movimento com id %s do imovel: %s", t, parametros);
	}


}
