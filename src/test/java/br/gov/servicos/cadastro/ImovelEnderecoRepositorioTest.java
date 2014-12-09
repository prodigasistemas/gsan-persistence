package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.Imovel;
import br.gov.persistence.util.SingleDeployment;


@RunWith(Arquillian.class)
public class ImovelEnderecoRepositorioTest extends SingleDeployment{
		
	@Inject
	ImovelRepositorio repositorio;
	
	private String logradouroTipo   = "AC";
	private String logradouroTitulo = "BR";
	private String logradouroNome   = "NAZARE";
	private String cepFormatado     = "68707-000";
	private String numero           = "60";
	private String complemento      = "EM FRENTE AO PLAZA";
	private String bairroNome       = "SAO BRAZ";
	private String municipioNome    = "BELEM";
	private String unidadeFederacao = "PA";
	
	private String enderecoAnterior = "BR KM 50";
	
	@Test
	@UsingDataSet("imovel_endereco.yml")
	public void imovelEnderecoAnterior() throws Exception {
		String endereco = repositorio.recuperaEnderecoAnterior(1);
		
		assertEquals(enderecoAnterior, endereco);
	}
	
	@Test
	@UsingDataSet("imovel_endereco.yml")
	public void imovelEndereco() throws Exception {
		Imovel imovel = repositorio.pesquisaComEndereco(1);
		
		StringBuilder endereco = new StringBuilder();
		endereco.append(logradouroTipo)
		.append(" ")
		.append(logradouroTitulo)
		.append(" ")
		.append(logradouroNome)
		.append(" ")
		.append(cepFormatado);
		assertEquals(endereco.toString(), imovel.getEnderecoFormatadoAbreviado().toString());
	}
	
	@Test
	@UsingDataSet("imovel_endereco.yml")
	public void imovelEndereco02() throws Exception {
		Imovel imovel = repositorio.pesquisaComEndereco(2);
		
		StringBuilder endereco = new StringBuilder();
		endereco.append(logradouroTipo)
		.append(" ")
		.append(logradouroTitulo)
		.append(" ")
		.append(logradouroNome)
		.append(numero)
		.append(" - ")
		.append(complemento)
		.append(" - ")
		.append(bairroNome)
		.append(" ")
		.append(municipioNome)
		.append(" ")
		.append(unidadeFederacao)
		.append(" ")
		.append(cepFormatado);
		
		assertEquals(endereco.toString(), imovel.getEnderecoFormatadoAbreviado().toString());
	}
	
	@Test
	@UsingDataSet("imovel_endereco.yml")
	public void imovelEndereco03() throws Exception {
		Imovel imovel = repositorio.pesquisaComEndereco(3);
		
		StringBuilder endereco = new StringBuilder();
		endereco.append(logradouroTipo)
		.append(" ")
		.append(logradouroTitulo)
		.append(" ")
		.append(logradouroNome)
		.append(numero)
		.append(" - ")
		.append(complemento)
		.append(" - ")
		.append(bairroNome)
		.append(" ")
		.append(municipioNome)
		.append(" ")
		.append(unidadeFederacao)
		.append(" ")
		.append(cepFormatado)
		
		.append(" ENTRE ")
		.append(logradouroTipo)
		.append(logradouroTitulo)
		.append(logradouroNome)
		
		.append(" E ")
		.append(logradouroTipo)
		.append(logradouroTitulo)
		.append(logradouroNome);

		
		assertEquals(endereco.toString(), imovel.getEnderecoFormatadoAbreviado().toString());
	}	
}
