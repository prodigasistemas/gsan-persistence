package br.gov.servicos.batch;

import javax.ejb.Stateless;

import br.gov.model.batch.ControleProcessoAtividade;
import br.gov.model.util.GenericRepository;

@Stateless
public class ControleProcessoAtividadeRepositorio extends GenericRepository<Integer, ControleProcessoAtividade>{
}
