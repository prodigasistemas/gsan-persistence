package br.gov.model.cadastro;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ClienteTest {
    
    @Test
    public void possuiCpf(){
        Cliente cliente = new Cliente();
        cliente.setCpf("67873164888");
        assertTrue(cliente.possuiCpf());
    }
    
    @Test
    public void possuiCnpj(){
        Cliente cliente = new Cliente();
        cliente.setCnpj("32625575000196");
        assertTrue(cliente.possuiCnpj());
    }
    
    @Test
    public void getCnpj(){
        Cliente cliente = new Cliente();
        cliente.setCnpj("32625575000196");
        assertEquals("32625575000196", cliente.getCpfOuCnpj());
    }
    
    @Test
    public void getCpf(){
        Cliente cliente = new Cliente();
        cliente.setCpf("67873164888");
        assertEquals("67873164888", cliente.getCpfOuCnpj());
    }
}
