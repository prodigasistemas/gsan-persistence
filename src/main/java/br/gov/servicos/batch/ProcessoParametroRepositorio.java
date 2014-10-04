package br.gov.servicos.batch;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.batch.ProcessoIniciado;
import br.gov.model.batch.ProcessoParametro;

@Stateless
public class ProcessoParametroRepositorio {

	@PersistenceContext
	private EntityManager entity;
	
	public Properties buscarParametrosPorProcessoIniciado(ProcessoIniciado processoIniciado){
		List<ProcessoParametro> processoParametros = this.buscarProcessoParametros(processoIniciado);
		
		Properties parametros = new Properties();
		
		for (ProcessoParametro processoParametro : processoParametros) {
			parametros.setProperty(processoParametro.getNomeParametro(), processoParametro.getValor());
		}
		
		return parametros;
	}
	
	public List<ProcessoParametro> buscarProcessoParametros(ProcessoIniciado processoIniciado){
		return entity.createQuery("from ProcessoParametro where processoIniciado.id = :processoIniciadoId", ProcessoParametro.class)
				.setParameter("processoIniciadoId", processoIniciado.getId())
				.getResultList();
	}
	
	public List<ProcessoParametro> inserirParametrosDefault(ProcessoIniciado processoIniciado){
		Properties parametros = new Properties();
		
		parametros.setProperty("idProcessoIniciado", String.valueOf(processoIniciado.getId()));
		parametros.setProperty("percentualProcessado", "0");
		if (processoIniciado.getProcesso().getNomeArquivoBatch() != null){
			parametros.setProperty("nomeArquivoBatch", processoIniciado.getProcesso().getNomeArquivoBatch());
		}
		
		return this.inserirParametros(processoIniciado, parametros);
	}
	
	public List<ProcessoParametro> inserirParametros(ProcessoIniciado processoIniciado, Properties parametros){
		
		List<ProcessoParametro> parametrosInseridos = new ArrayList<ProcessoParametro>();
		Enumeration<Object> chaves = parametros.keys();
		
		while (chaves.hasMoreElements()) {
			String chave = (String) chaves.nextElement();
			
			ProcessoParametro parametro = new ProcessoParametro(processoIniciado, chave, parametros.getProperty(chave));
			entity.persist(parametro);
			
//			parametrosInseridos.add(parametro);
		}
		
		return parametrosInseridos;
	}
}
