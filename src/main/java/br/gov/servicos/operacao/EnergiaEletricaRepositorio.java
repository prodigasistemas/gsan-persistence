package br.gov.servicos.operacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.EnergiaEletrica;
import br.gov.model.util.GenericRepository;

@Stateless
public class EnergiaEletricaRepositorio extends GenericRepository<Integer, EnergiaEletrica>{
    
    public boolean existeEnergiaEletricaNaReferencia(Integer referencia) throws Exception {
        String query = "SELECT count(e) FROM EnergiaEletrica e WHERE referencia = :referencia";

        long count = entity.createQuery(query, Long.class)
                .setParameter("referencia", referencia)
                .getSingleResult();

        return (count > 0) ? true : false;
    }

    public List<EnergiaEletrica> listaEnergiaEletrica() throws Exception {
        String query = "SELECT e FROM EnergiaEletrica e ORDER BY referencia DESC";
        
        return entity.createQuery(query, EnergiaEletrica.class).getResultList();
    }
    
	public List<EnergiaEletrica> obterLista() {
		TypedQuery<EnergiaEletrica> query = entity.createQuery("select c1 from EnergiaEletrica c1 order by enel_referencia desc", EnergiaEletrica.class);
		List<EnergiaEletrica> lista = query.getResultList();
		return lista;
	}

	public EnergiaEletrica obterEnergia(Integer codigo) throws Exception {
		TypedQuery<EnergiaEletrica> query = entity.createQuery("select c1 from EnergiaEletrica c1 where enel_id = " + codigo, EnergiaEletrica.class);
		EnergiaEletrica energiaEletrica = query.getSingleResult();

		for (int j = 0; j < energiaEletrica.getDados().size(); j++) {
			energiaEletrica.getDados().get(j);
		}
		return energiaEletrica;
	}

	public EnergiaEletrica obterEnergiaPorReferencia(Integer referencia) throws Exception {
		return entity.createQuery("select c1 from EnergiaEletrica c1 where referencia = " + referencia,
                EnergiaEletrica.class).getSingleResult();
	}
}
