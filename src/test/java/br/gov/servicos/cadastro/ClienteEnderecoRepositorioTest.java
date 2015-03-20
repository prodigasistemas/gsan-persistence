package br.gov.servicos.cadastro;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.model.cadastro.endereco.ClienteEndereco;
import br.gov.persistence.util.SingleDeployment;


@RunWith(Arquillian.class)
public class ClienteEnderecoRepositorioTest extends SingleDeployment{
		
	@Inject
	ClienteEnderecoRepositorio repositorio;
	
	private String logradouroTipoAbreviado   = "AC";
	private String logradouroTipo   = "ACESSO";
	private String logradouroTitulo = "BR";
	private String logradouroNome   = "NAZARE";
	private String cepFormatado     = "68707-000";
	private String numero           = "60";
	private String complemento      = "EM FRENTE AO PLAZA";
	private String bairroNome       = "SAO BRAZ";
	private String municipioNome    = "BELEM";
	private String unidadeFederacao = "PA";
	
	@Test
	@UsingDataSet("cliente_endereco.yml")
	public void clienteEndereco() throws Exception {
		ClienteEndereco clienteEndereco = repositorio.pesquisarEnderecoCliente(1);
		
		StringBuilder endereco = new StringBuilder();
		endereco.append(logradouroTipo)
		.append(" ")
		.append(logradouroTitulo)
		.append(" ")
		.append(logradouroNome)
		.append(" - ")
		.append(municipioNome)
		.append(" ")
		.append("PA")
		.append(" ")
		.append(cepFormatado);

		assertEquals(endereco.toString(), clienteEndereco.getEnderecoFormatadoAbreviado().toString());
	}
	
	@Test
	@UsingDataSet("cliente_endereco.yml")
	public void imovelEndereco02() throws Exception {
		ClienteEndereco clienteEndereco = repositorio.pesquisarEnderecoCliente(2);
		
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
		
		assertEquals(endereco.toString(), clienteEndereco.getEnderecoFormatadoAbreviado().toString());
	}
	
	@Test
	@UsingDataSet("cliente_endereco.yml")
	public void imovelEndereco03() throws Exception {
		ClienteEndereco clienteEndereco = repositorio.pesquisarEnderecoCliente(3);
		
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
		.append(logradouroTipoAbreviado)
		.append(logradouroTitulo)
		.append(logradouroNome)
		
		.append(" E ")
		.append(logradouroTipoAbreviado)
		.append(logradouroTitulo)
		.append(logradouroNome);

		
		assertEquals(endereco.toString(), clienteEndereco.getEnderecoFormatadoAbreviado().toString());
	}	
}
