package br.gov.servicos.operacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.gov.model.operacao.EnergiaEletrica;
import br.gov.model.util.GenericRepository;

@Stateless
public class EnergiaEletricaRepositorio extends GenericRepository<Integer, EnergiaEletrica>{
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

	public EnergiaEletrica obterEnergiaPorData(Date dataReferencia) throws Exception {
		try {
			SimpleDateFormat formataData = new SimpleDateFormat("yyyyMMdd");
			String dataAux = formataData.format(dataReferencia);

			TypedQuery<EnergiaEletrica> query = entity.createQuery("select c1 from EnergiaEletrica c1 where enel_referencia = '" + dataAux + "'",
					EnergiaEletrica.class);
			EnergiaEletrica energiaEletrica = query.getSingleResult();

			for (int j = 0; j < energiaEletrica.getDados().size(); j++) {
				energiaEletrica.getDados().get(j);
			}
			return energiaEletrica;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
}
