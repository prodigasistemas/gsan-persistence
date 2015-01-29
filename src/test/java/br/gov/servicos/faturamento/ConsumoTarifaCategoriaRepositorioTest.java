package br.gov.servicos.faturamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.util.Utilitarios;
import br.gov.persistence.util.SingleDeployment;

@RunWith(Arquillian.class)
public class ConsumoTarifaCategoriaRepositorioTest extends SingleDeployment {

	@Inject
	private ConsumoTarifaCategoriaRepositorio repositorio;

	@Test
	@UsingDataSet("consumo_tarifa_categoria_subcategoria.yml")
	public void pesquisarConsumoTarifaCategoria() {
		Integer consumo = repositorio.consumoMinimoTarifaCategoria(1, 1);
		assertEquals(10, consumo.intValue());
	}
	
	@Test
	@UsingDataSet("consumo_tarifa_categoria_subcategoria.yml")
	public void pesquisarConsumoTarifaSubcategoria() {
		Integer consumo = repositorio.consumoMinimoTarifaSubCategoria(2, 2);
		assertEquals(20, consumo.intValue());
	}
	
	@Test
	@UsingDataSet("consumo_tarifa_categoria_vigente.yml")
	public void pesquisarConsumoTarifaCategoriaVigente() {
		Date dataFaturamento = Utilitarios.criarData(1, 1, 2015);
		
		assertNotNull(repositorio.buscarConsumoTarifaCategoriaVigente(dataFaturamento, 1, 1, 1));
	}
	
	@Test
	@UsingDataSet("consumo_tarifa_categoria_data_leitura.yml")
	public void pesquisarConsumoTarifaCategoriaVigentePelaDataLeitura() {
		Date dataLeitura = Utilitarios.criarData(1, 1, 2015);
		
		assertNotNull(repositorio.buscarConsumoTarifaCategoriaVigentePelaDataLeitura(dataLeitura, 1, 1, 1));
	}
}
