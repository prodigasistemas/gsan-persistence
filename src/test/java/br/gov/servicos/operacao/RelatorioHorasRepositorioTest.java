package br.gov.servicos.operacao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.persistence.util.SingleDeployment;
import br.gov.servicos.operacao.to.ConsultaHorasTO;
import br.gov.servicos.operacao.to.HorasRelatorioTO;

@RunWith(Arquillian.class)
public class RelatorioHorasRepositorioTest extends SingleDeployment{

	@Inject
	private RelatorioHorasRepositorio repositorio;
	
	@Test
	@UsingDataSet("horas.yml")
	public void apenasHorasParadasPorEnergia() throws Exception{
	    
	    ConsultaHorasTO consulta = new ConsultaHorasTO();
	    consulta.setReferenciaInicial(201402);
	    consulta.setReferenciaFinal(201406);
		List<HorasRelatorioTO> lista = repositorio.consultaHoras(consulta);
		
		HorasRelatorioTO item = lista.get(0);
		
		assertEquals(40, item.getHorasParadasPorEnergia().intValue());
	}
	
	@Test
	@UsingDataSet("horas.yml")
	public void calculaHorasCMB() throws Exception{
	    
	    ConsultaHorasTO consulta = new ConsultaHorasTO();
	    consulta.setReferenciaInicial(201402);
	    consulta.setReferenciaFinal(201406);
	    List<HorasRelatorioTO> lista = repositorio.consultaHoras(consulta);
	    
	    HorasRelatorioTO item = lista.get(1);
	    
	    assertEquals(500.60, item.getHorasCmb().doubleValue(), 1);
	    assertEquals(744, item.getHorasMes().intValue());
	    assertEquals(20, item.getHorasParadasParaControle().intValue());
	    assertEquals(20, item.getHorasParadasParaManutencao().intValue());
	    assertEquals(50, item.getHorasParadasPorEnergia().intValue());
	}
	
	@Test
	@UsingDataSet("horas.yml")
	public void filtraPorLocalidade() throws Exception{
	    
	    ConsultaHorasTO consulta = new ConsultaHorasTO();
	    consulta.setReferenciaInicial(201402);
	    consulta.setReferenciaFinal(201406);
	    consulta.setCodigoLocalidade(2);
	    List<HorasRelatorioTO> lista = repositorio.consultaHoras(consulta);
	    
	    HorasRelatorioTO item = lista.get(0);
	    
	    assertEquals(150, item.getHorasParadasPorEnergia().intValue());
	}	
}
