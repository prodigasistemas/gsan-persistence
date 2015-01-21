package br.gov.servicos.faturamento;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class QualidadeAguaRepositorioTest extends SingleDeployment {
	
	@Inject
	private QualidadeAguaRepositorio repositorio;
	
	@Test
	@UsingDataSet("qualidade_agua.yml")
	public void buscarPorAnoMesESistemaAbastecimentoComFonteCaptacaoETipoCaptacaoValido() {
		assertNotNull(repositorio.buscarPorAnoMesESistemaAbastecimentoComFonteCaptacaoETipoCaptacao(201501, 1));
	}
	
	@Test
	@UsingDataSet("qualidade_agua_tipocaptacao.yml")
	public void buscarPorAnoMesELocalidadeESetorComFonteCaptacao() {
		assertNotNull(repositorio.buscarPorAnoMesELocalidadeESetorComFonteCaptacao(201501, 1, 1));
	}
	
	

}
