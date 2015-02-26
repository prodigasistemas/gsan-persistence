package br.gov.servicos.cadastro;

import javax.ejb.Stateless;

import br.gov.model.cadastro.Quadra;
import br.gov.model.util.GenericRepository;

@Stateless
public class QuadraRepositorio extends GenericRepository<Integer, Quadra> {

	public int[] obterIntervaloQuadrasPorRota(Integer idRota) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT coalesce(MIN(qdra.numeroQuadra), 0) , coalesce(MAX(qdra.numeroQuadra), 0) ")
		   .append(" FROM Quadra qdra ")
		   .append(" INNER JOIN qdra.rota rota ")
		   .append(" WHERE rota.id = :idRota ");

		Object[] result = (Object[]) entity.createQuery(sql.toString()).setParameter("idRota", idRota).setMaxResults(1).getSingleResult();

		return new int[] { Integer.valueOf(result[0].toString()), Integer.valueOf(result[1].toString()) };
	}
}
