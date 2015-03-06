package br.gov.servicos.micromedicao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.micromedicao.LeituraTipo;
import br.gov.model.micromedicao.Rota;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class RotaRepositorioTest extends SingleDeployment{

	@Inject
	private RotaRepositorio repositorio;
	
	@Test
	@UsingDataSet("rotas.yml")
	public void instalacaoHidrometroLigacaoAgua(){
	    List<Rota> rotas = repositorio.obterPeloGrupoETipoLeitura(1, LeituraTipo.MICROCOLETOR);
	    
	    assertEquals(2, rotas.size());
	}
}