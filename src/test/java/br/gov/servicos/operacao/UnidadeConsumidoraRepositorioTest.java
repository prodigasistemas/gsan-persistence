package br.gov.servicos.operacao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.operacao.to.ContratoUnidadeConsumidoraTO;

@RunWith(Arquillian.class)
public class UnidadeConsumidoraRepositorioTest extends SingleDeployment{

	@Inject
	private UnidadeConsumidoraRepositorio repositorio;
	
	@Test
	@UsingDataSet("contratosUnidadeConsumidora.yml")
	public void unidadeConsumidoraSemContratoVigente() throws Exception{
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 10);
	    cal.set(Calendar.DAY_OF_MONTH, 10);
	    
		List<ContratoUnidadeConsumidoraTO> lista = repositorio.unidadesConsumidorasSemVigenciaContratual(cal.getTime());
		
		int ucs = 0;
		
		for (ContratoUnidadeConsumidoraTO uc : lista) {
            ucs += uc.getCodigoUC();
        }
		assertEquals(2, lista.size());
		assertEquals(9999, ucs);
	}	
}
