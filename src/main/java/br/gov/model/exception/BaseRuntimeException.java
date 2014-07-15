package br.gov.model.exception;


public class BaseRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -5334054081788545824L;
	
	public BaseRuntimeException(String msg){
		super(msg);
	}
	
	public BaseRuntimeException(String msg, Object... parametros){
		super(String.format(msg, parametros));
	}
	
	public BaseRuntimeException(String msg, Throwable e, Object... parametros){
		super(String.format(msg, parametros), e);
	}
}