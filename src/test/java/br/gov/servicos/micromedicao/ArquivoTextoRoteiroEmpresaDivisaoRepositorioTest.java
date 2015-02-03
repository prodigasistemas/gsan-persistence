package br.gov.servicos.micromedicao;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ArquivoTextoRoteiroEmpresaDivisaoRepositorioTest extends SingleDeployment {

	@Inject
	private ArquivoTextoRoteiroEmpresaDivisaoRepositorio repositorio;
	
	@Test
	@UsingDataSet("arquivo_texto_roteiro_empresa_divisao.yml")
	@ShouldMatchDataSet("arquivo_texto_roteiro_empresa_divisao_expected.yml")
	public void deletarArquivo() {
		repositorio.deletarPorArquivoTextoRoteiroEmpresa(1);
	}
}
