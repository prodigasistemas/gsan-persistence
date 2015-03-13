package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.Hidrometro;
import br.gov.servicos.to.HidrometroTO;

@Stateless
public class HidrometroInstalacaoHistoricoRepositorio {
	@PersistenceContext
	private EntityManager entity;
	
	//TODO: Trocar a chamada deste metodo pelos outros dois: dadosInstalacaoHidrometroAgua e dadosInstalacaoHidrometroPoco
	public List<HidrometroTO> dadosInstalacaoHidrometro(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.HidrometroTO(")
		   .append(" hidr.numero")
		   .append(", hidr.numeroDigitosLeitura")
		   .append(", hidi.dataInstalacao")
		   .append(", hidi.numeroLeituraInstalacao")
		   .append(", coalesce(lagu.id, imovel.id) ")
		   .append(", hli.descricao")
		   .append(", hidi.rateioTipo")
		   .append(", hidi.medicaoTipo")
		   .append(" ) ")
		   .append(" FROM HidrometroInstalacaoHistorico hidi")
		   .append(" LEFT JOIN hidi.hidrometro hidr ")
		   .append(" LEFT JOIN hidi.ligacaoAgua lagu ")
		   .append(" LEFT JOIN hidi.hidrometroLocalInstalacao hli ")
		   .append(" LEFT JOIN hidi.imovel imovel ")
		   .append(" WHERE (lagu.id = :id OR imovel.id = :id) ")
		   .append(" AND hidi.dataRetirada is null ");

		return entity.createQuery(sql.toString(), HidrometroTO.class)
		        .setParameter("id", idImovel)
		        .getResultList();
	}
	
	// TODO: Método não está mais sendo utilizado?
	public HidrometroTO dadosInstalacaoHidrometroAgua(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.HidrometroTO(")
		   .append(" hidr.numero")
		   .append(", hidr.numeroDigitosLeitura")
		   .append(", hidi.dataInstalacao")
		   .append(", hidi.numeroLeituraInstalacao")
		   .append(", lagu.imovel.id ")
		   .append(", hli.descricao")
		   .append(", hidi.rateioTipo")
		   .append(", hidi.medicaoTipo")
		   .append(" ) ")
		   .append(" FROM HidrometroInstalacaoHistorico hidi")
		   .append(" LEFT JOIN hidi.hidrometro hidr ")
		   .append(" LEFT JOIN hidi.ligacaoAgua lagu ")
		   .append(" LEFT JOIN hidi.hidrometroLocalInstalacao hli ")
		   .append(" WHERE lagu.imovel.id = :idImovel ")
		   .append(" AND hidi.dataRetirada is null ");
		
		try {
		    return entity.createQuery(sql.toString(), HidrometroTO.class)
		            .setParameter("idImovel", idImovel)
		            .setMaxResults(1)
		            .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}
	
	// TODO: Método não está mais sendo utilizado?
	public HidrometroTO dadosInstalacaoHidrometroPoco(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.HidrometroTO(")
		   .append(" hidr.numero")
		   .append(", hidr.numeroDigitosLeitura")
		   .append(", hidi.dataInstalacao")
		   .append(", hidi.numeroLeituraInstalacao")
		   .append(", imovel.id")
		   .append(", hli.descricao")
		   .append(", hidi.rateioTipo")
		   .append(", hidi.medicaoTipo")
		   .append(" ) ")
		   .append(" FROM HidrometroInstalacaoHistorico hidi")
		   .append(" LEFT JOIN hidi.hidrometro hidr ")
		   .append(" LEFT JOIN hidi.hidrometroLocalInstalacao hli ")
		   .append(" LEFT JOIN hidi.imovel imovel ")
		   .append(" WHERE imovel.id = :idImovel ")
		   .append(" AND hidi.dataRetirada is null ");

      try {
          return entity.createQuery(sql.toString(), HidrometroTO.class)
                  .setParameter("idImovel", idImovel)
                  .setMaxResults(1)
                  .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}
	
	public Hidrometro dadosHidrometroInstaladoAgua(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT hidr ")
		   .append(" FROM HidrometroInstalacaoHistorico hidi")
		   .append(" LEFT JOIN hidi.hidrometro hidr ")
		   .append(" LEFT JOIN hidi.ligacaoAgua lagu ")
		   .append(" LEFT JOIN hidi.hidrometroLocalInstalacao hli ")
		   .append(" LEFT JOIN hidi.imovel imovel ")
		   .append(" WHERE lagu.id = :idImovel ")
		   .append(" AND hidi.dataRetirada is null ");

		try {
			return entity.createQuery(sql.toString(), Hidrometro.class).setParameter("idImovel", idImovel).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	// TODO: Método não está mais sendo utilizado?
	public Hidrometro dadosHidrometroInstaladoPoco(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT hidr ")
		   .append(" FROM HidrometroInstalacaoHistorico hidi")
		   .append(" LEFT JOIN hidi.hidrometro hidr ")
		   .append(" LEFT JOIN hidi.ligacaoAgua lagu ")
		   .append(" LEFT JOIN hidi.hidrometroLocalInstalacao hli ")
		   .append(" LEFT JOIN hidi.imovel imovel ")
		   .append(" WHERE imovel.id = :idImovel ")
		   .append(" AND hidi.dataRetirada is null ");

		return entity.createQuery(sql.toString(), Hidrometro.class).setParameter("idImovel", idImovel).setMaxResults(1).getSingleResult();
	}
}
