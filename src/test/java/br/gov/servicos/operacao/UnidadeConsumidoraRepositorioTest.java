package br.gov.servicos.operacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.gov.servicos.operacao.to.UnidadeConsumidoraSemContratoTO;

//@RunWith(Arquillian.class)
public class UnidadeConsumidoraRepositorioTest {

	@Inject
	private UnidadeConsumidoraRepositorio repositorio;
	
	//@Test
	@UsingDataSet("contratosUnidadeConsumidora.yml")
	public void unidadeConsumidoraSemContrato() throws Exception{
		List<UnidadeConsumidoraSemContratoTO> lista = repositorio.unidadesConsumidorasAtivasSemContrato();
		
		int ucs = 0;
		
		for (UnidadeConsumidoraSemContratoTO uc : lista) {
            ucs += uc.getCodigoUC();
        }
		
		assertEquals(3, lista.size());
		assertEquals(1300, ucs);
	}
	
    //@Test
    @UsingDataSet("contratosUnidadeConsumidora.yml")
    public void existeUnidadeConsumidoraComCodigo100() throws Exception{
        assertTrue(repositorio.existeUnidadeConsumidora(100));
    }
	
    //@Test
    @UsingDataSet("contratosUnidadeConsumidora.yml")
    public void naoExisteUnidadeConsumidoraComCodigo234() throws Exception{
        assertFalse(repositorio.existeUnidadeConsumidora(234));
    }
    
	
}
