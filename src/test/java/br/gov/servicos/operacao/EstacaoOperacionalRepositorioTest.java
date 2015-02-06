package br.gov.servicos.operacao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.operacao.EstacaoOperacional;
import br.gov.model.operacao.LocalidadeProxy;
import br.gov.model.operacao.PerfilBeanEnum;
import br.gov.model.operacao.RegionalProxy;
import br.gov.model.operacao.TipoUnidadeOperacional;
import br.gov.model.operacao.UsuarioProxy;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class EstacaoOperacionalRepositorioTest extends SingleDeployment{

	@Inject
	private EstacaoOperacionalRepositorio repositorio;
	
	private UsuarioProxy usuario;
	
	@Before
	public void init(){
	    usuario = new UsuarioProxy();
	    usuario.setPerfil(PerfilBeanEnum.ADMIN);
	}
	
	@Test
	@UsingDataSet("estacoes.yml")
	public void buscarEATs() throws Exception{
		List<EstacaoOperacional> estacoes = repositorio.listarPeloTipoEUsuario(usuario, TipoUnidadeOperacional.EAT);
		assertEquals(2, estacoes.size());
	}
	
	@Test
	@UsingDataSet("estacoes.yml")
	public void buscarETAs() throws Exception{
	    List<EstacaoOperacional> estacoes = repositorio.listarPeloTipoEUsuario(usuario, TipoUnidadeOperacional.ETA);
	    assertEquals(1, estacoes.size());
	}
	
	@Test
	@UsingDataSet("estacoes.yml")
	public void buscarEABs() throws Exception{
	    List<EstacaoOperacional> estacoes = repositorio.listarPeloTipoEUsuario(usuario, TipoUnidadeOperacional.EAB);
	    assertEquals(3, estacoes.size());
	}
	
	@Test
	@UsingDataSet("estacoes.yml")
	public void buscarEABsPorLocalidadeComoSupervisor() throws Exception{
	    usuario.setPerfil(PerfilBeanEnum.SUPERVISOR);
	    LocalidadeProxy localidade = new LocalidadeProxy();
	    localidade.setCodigo(2);
	    usuario.addLocalidade(localidade);
	    List<EstacaoOperacional> estacoes = repositorio.listarPeloTipoEUsuario(usuario, TipoUnidadeOperacional.EAB);
	    assertEquals(1, estacoes.size());
	    assertEquals("EAB C" , estacoes.get(0).getNome());
	}
	
    @Test
    @UsingDataSet("estacoes.yml")
    public void buscarEABsPorRegionalComoGerente() throws Exception{
        usuario.setPerfil(PerfilBeanEnum.GERENTE);
        RegionalProxy regional = new RegionalProxy();
        regional.setCodigo(2);
        usuario.setRegionalProxy(regional);
        List<EstacaoOperacional> estacoes = repositorio.listarPeloTipoEUsuario(usuario, TipoUnidadeOperacional.EAB);
        assertEquals(1, estacoes.size());
        assertEquals("EAB B" , estacoes.get(0).getNome());
    }
    
    @Test
    @UsingDataSet("estacoes.yml")
    public void buscarEstacoesSemConsumo() throws Exception{
        Calendar c = Calendar.getInstance();
        c.set(2015, 0, 20);
        List<EstacaoOperacional> estacoes = repositorio.listarEstacoesComConsumoPendente(c.getTime(), TipoUnidadeOperacional.EAB);
        assertEquals(2, estacoes.size());
    }	
}