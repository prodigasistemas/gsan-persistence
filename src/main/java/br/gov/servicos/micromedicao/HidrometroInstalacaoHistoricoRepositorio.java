package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.model.micromedicao.Hidrometro;
import br.gov.model.micromedicao.HidrometroInstalacaoHistorico;
import br.gov.servicos.to.HidrometroTO;

@Stateless
public class HidrometroInstalacaoHistoricoRepositorio {
	@PersistenceContext
	private EntityManager entity;
	
	public List<HidrometroTO> dadosInstalacaoHidrometro(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.HidrometroTO(")
		   .append(" hidr.numero")
		   .append(", hidr.numeroDigitosLeitura")
		   .append(", hidi.dataInstalacao")
		   .append(", hidi.numeroLeituraInstalacao")
		   .append(", coalesce(lagu.imovel.id, imovel.id) ")
		   .append(", hli.descricao")
		   .append(", hidi.rateioTipo")
		   .append(", hidi.medicaoTipo")
		   .append(" ) ")
		   .append(" FROM HidrometroInstalacaoHistorico hidi")
		   .append(" LEFT JOIN hidi.hidrometro hidr ")
		   .append(" LEFT JOIN hidi.ligacaoAgua lagu ")
		   .append(" LEFT JOIN hidi.hidrometroLocalInstalacao hli ")
		   .append(" LEFT JOIN hidi.imovel imovel ")
		   .append(" WHERE (lagu.imovel.id = :idImovel OR imovel.id = :idImovel) ")
		   .append(" AND hidi.dataRetirada is null ");

		return entity.createQuery(sql.toString(), HidrometroTO.class)
		        .setParameter("idImovel", idImovel)
		        .getResultList();
	}
	
	public HidrometroTO dadosInstalacaoHidrometroAgua(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.HidrometroTO(")
		   .append(" hidr.numero")
		   .append(", hidr.numeroDigitosLeitura")
		   .append(", hidi.dataInstalacao")
		   .append(", hidi.numeroLeituraInstalacao")
		   .append(", coalesce(lagu.imovel.id, imovel.id) ")
		   .append(", hli.descricao")
		   .append(", hidi.rateioTipo")
		   .append(", hidi.medicaoTipo")
		   .append(" ) ")
		   .append(" FROM HidrometroInstalacaoHistorico hidi")
		   .append(" LEFT JOIN hidi.hidrometro hidr ")
		   .append(" LEFT JOIN hidi.ligacaoAgua lagu ")
		   .append(" LEFT JOIN hidi.hidrometroLocalInstalacao hli ")
		   .append(" LEFT JOIN hidi.imovel imovel ")
		   .append(" WHERE lagu.imovel.id = :idImovel ")
		   .append(" AND hidi.dataRetirada is null ");

		return entity.createQuery(sql.toString(), HidrometroTO.class).setParameter("idImovel", idImovel).getSingleResult();
	}
	
	public HidrometroTO dadosInstalacaoHidrometroPoco(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.HidrometroTO(")
		   .append(" hidr.numero")
		   .append(", hidr.numeroDigitosLeitura")
		   .append(", hidi.dataInstalacao")
		   .append(", hidi.numeroLeituraInstalacao")
		   .append(", coalesce(lagu.imovel.id, imovel.id) ")
		   .append(", hli.descricao")
		   .append(", hidi.rateioTipo")
		   .append(", hidi.medicaoTipo")
		   .append(" ) ")
		   .append(" FROM HidrometroInstalacaoHistorico hidi")
		   .append(" LEFT JOIN hidi.hidrometro hidr ")
		   .append(" LEFT JOIN hidi.ligacaoAgua lagu ")
		   .append(" LEFT JOIN hidi.hidrometroLocalInstalacao hli ")
		   .append(" LEFT JOIN hidi.imovel imovel ")
		   .append(" WHERE imovel.id = :idImovel ")
		   .append(" AND hidi.dataRetirada is null ");

		return entity.createQuery(sql.toString(), HidrometroTO.class).setParameter("idImovel", idImovel).getSingleResult();
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

		return entity.createQuery(sql.toString(), Hidrometro.class).setParameter("idImovel", idImovel).getSingleResult();
	}
	
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

		return entity.createQuery(sql.toString(), Hidrometro.class).setParameter("idImovel", idImovel).getSingleResult();
	}

	//TODO: Metodo semelhante ao dadosHidrometroInstaladoAgua
	public HidrometroInstalacaoHistorico hidrometroInstalacaoHistoricoAtualAgua(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT hidi ")
		   .append(" FROM HidrometroInstalacaoHistorico hidi")
		   .append(" LEFT JOIN hidi.hidrometro hidr ")
		   .append(" LEFT JOIN hidi.ligacaoAgua lagu ")
		   .append(" LEFT JOIN hidi.hidrometroLocalInstalacao hli ")
		   .append(" LEFT JOIN hidi.imovel imovel ")
		   .append(" WHERE lagu.imovel.id = :idImovel")
		   .append(" AND hidi.dataRetirada is null ");

		return entity.createQuery(sql.toString(), HidrometroInstalacaoHistorico.class).setParameter("idImovel", idImovel).getSingleResult();
	}
}
