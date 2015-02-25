package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.micromedicao.ArquivoTextoRoteiroEmpresa;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ArquivoTextoRoteiroEmpresaRepositorioTest extends SingleDeployment {

	@Inject
	private ArquivoTextoRoteiroEmpresaRepositorio repositorio;
	
	@Test
	@UsingDataSet("arquivo_texto_roteiro_empresa.yml")
	public void pesquisarPorRotaEReferencia() {
		ArquivoTextoRoteiroEmpresa arquivo = repositorio.pesquisarPorRotaEReferencia(1, 201502);

		assertEquals(3, arquivo.getId().intValue());
		assertEquals(2, arquivo.getSituacaoTransmissaoLeitura().intValue());
	}
	
	@Test
	@UsingDataSet("arquivo_texto_roteiro_empresa.yml")
	@ShouldMatchDataSet("arquivo_texto_roteiro_empresa_expected.yml")
	public void deletarArquivo() {
		repositorio.excluir(3);
		repositorio.excluir(4);
	}
	
	@Test
	@UsingDataSet("arquivo_texto_roteiro_empresa.yml")
	public void pesquisarPorGrupoEReferencia() {
		List<ArquivoTextoRoteiroEmpresa> arquivos = repositorio.pesquisarPorGrupoEReferencia(1, 201502);

		ArquivoTextoRoteiroEmpresa arquivo = arquivos.get(0);
		
		assertEquals(3, arquivo.getId().intValue());
		assertEquals(2, arquivo.getSituacaoTransmissaoLeitura().intValue());
	}
}
