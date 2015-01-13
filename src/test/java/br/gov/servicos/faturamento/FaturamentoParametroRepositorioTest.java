package br.gov.servicos.faturamento;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.faturamento.FaturamentoParametro.NOME_PARAMETRO_FATURAMENTO;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class FaturamentoParametroRepositorioTest extends SingleDeployment{

	@Inject
	private FaturamentoParametroRepositorio repositorio;
	
	@Test
	@UsingDataSet("faturamento_parametro_01.yml")
	public void naoExisteParametroFebraban(){
	    try {
	        repositorio.recuperaPeloNome(NOME_PARAMETRO_FATURAMENTO.EMITIR_CONTA_CODIGO_FEBRABAN);
        } catch (Exception e) {
            assertThat(e.getCause().toString(), containsString("ParametroEmissaoContaFebrabanIndefinido"));
        }
	}
	
	@Test
	@UsingDataSet("faturamento_parametro_02.yml")
	public void existeParametroFebraban(){
        String valor = repositorio.recuperaPeloNome(NOME_PARAMETRO_FATURAMENTO.EMITIR_CONTA_CODIGO_FEBRABAN);
        assertTrue(Boolean.valueOf(valor));
	}
}
