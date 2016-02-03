package br.gov.servicos.to;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.gov.model.faturamento.CreditoTipo;

public class CreditosContaTOTest {
    
    CreditosContaTO to;
    
    CreditoTipo tipoDescontoAcrescimosImpontualidade;
    CreditoTipo tipoDescontoAntiguidadeDebito;
    
    String DESCONTO_ACRESCIMOS_IMPONTUALIDADE = "DESCONTO_ACRESCIMOS_IMPONTUALIDADE";
    String DESCONTO_ANTIGUIDADE_DEBITO        = "DESCONTO_ANTIGUIDADE_DEBITO"; 
    
    @Before
    public void setUp(){
        to = new CreditosContaTO();
        
        tipoDescontoAcrescimosImpontualidade = new CreditoTipo();
        tipoDescontoAcrescimosImpontualidade.setId(1);
        tipoDescontoAcrescimosImpontualidade.setDescricao(DESCONTO_ACRESCIMOS_IMPONTUALIDADE);
        
        tipoDescontoAntiguidadeDebito = new CreditoTipo();
        tipoDescontoAntiguidadeDebito.setId(1);
        tipoDescontoAntiguidadeDebito.setDescricao(DESCONTO_ANTIGUIDADE_DEBITO);
        
        to.putValoresPorCreditoTipo(tipoDescontoAcrescimosImpontualidade, new BigDecimal(400));
        to.putValoresPorCreditoTipo(tipoDescontoAntiguidadeDebito, new BigDecimal(200));
    }
    
    @Test
    public void atualizarValorCredito(){
        to.atualizarValorCredito(tipoDescontoAcrescimosImpontualidade, BigDecimal.TEN);
        
        assertEquals(410, to.getValorCreditoTipo(tipoDescontoAcrescimosImpontualidade).doubleValue(), 0.1);
    }

    @Test
    public void somaValorCreditoTipoEValorCreditoParcelaMes(){
        assertEquals(550, to.somaValorCreditoTipoEValorCreditoParcelaMes(tipoDescontoAcrescimosImpontualidade, new BigDecimal(150)).doubleValue(), 0.1);
    }
}
