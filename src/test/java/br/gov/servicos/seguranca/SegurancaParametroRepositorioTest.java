package br.gov.servicos.seguranca;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.seguranca.SegurancaParametro.NOME_PARAMETRO_SEGURANCA;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class SegurancaParametroRepositorioTest extends SingleDeployment {

	@Inject
	private SegurancaParametroRepositorio repositorio;

	@Test
	@UsingDataSet("seguranca_parametro_nao_existe.yml")
	public void naoExisteParametroCaminhoArquivos() {
		try {
			repositorio.recuperaPeloNome(NOME_PARAMETRO_SEGURANCA.CAMINHO_ARQUIVOS);
		} catch (Exception e) {
			assertThat(e.getCause().toString(), containsString("ParametroCaminhoArquivosIndefinido"));
		}
	}

	@Test
	@UsingDataSet("seguranca_parametro_existe.yml")
	public void existeParametroCaminhoArquivos() {
		assertEquals("/tmp/", repositorio.recuperaPeloNome(NOME_PARAMETRO_SEGURANCA.CAMINHO_ARQUIVOS));
	}
}