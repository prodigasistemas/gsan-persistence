package br.gov.servicos.micromedicao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.servicos.to.HidrometroTO;

@Stateless
public class HidrometroInstalacaoHistoricoRepositorio {
	@PersistenceContext
	private EntityManager entity;
	
	public List<HidrometroTO> dadosInstalacaoHidrometro(Integer idImovel){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT new br.gov.servicos.to.HidrometroTO(")
		.append(" hidr.numero")
		.append(", hidr.numeroDigitosLeitura")
		.append(", hidi.dataInstalacao")
		.append(", hidi.numeroLeituraInstalacao")
		.append(", coalesce(lagu.imovel.id, imovel.id) ")
		.append(", hli.descricao")
		.append(", hidi.rateioTipo")
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
}
