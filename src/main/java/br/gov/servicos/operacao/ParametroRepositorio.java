package br.gov.servicos.operacao;

import javax.ejb.Stateless;

import br.gov.model.operacao.Parametro;
import br.gov.model.util.GenericRepository;

@Stateless
public class ParametroRepositorio extends GenericRepository<Integer, Parametro>{
	
    public Parametro obterPeloNome(Parametro.Nome nome){
	    return entity.createQuery("select p from Parametro p where p.descricao = :nome", Parametro.class)
	            .setParameter("nome", nome.toString())
	            .getSingleResult();
	}
}
