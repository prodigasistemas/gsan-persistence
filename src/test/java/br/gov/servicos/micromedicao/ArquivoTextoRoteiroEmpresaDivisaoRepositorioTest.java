package br.gov.servicos.micromedicao;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

////@RunWith(Arquillian.class)
public class ArquivoTextoRoteiroEmpresaDivisaoRepositorioTest {

	@Inject
	private ArquivoTextoRoteiroEmpresaDivisaoRepositorio repositorio;
	
	//@Test
	@UsingDataSet("arquivo_texto_roteiro_empresa_divisao.yml")
	@ShouldMatchDataSet("arquivo_texto_roteiro_empresa_divisao_expected.yml")
	public void deletarArquivo() {
		repositorio.deletarPorArquivoTextoRoteiroEmpresa(1);
	}
}
