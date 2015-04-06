package br.gov.servicos.batch;

import javax.ejb.Stateless;

import br.gov.model.batch.ProcessoIniciado;
import br.gov.model.util.GenericRepository;

@Stateless
public class ProcessoIniciadoRepositorio extends GenericRepository<Integer, ProcessoIniciado>{
}