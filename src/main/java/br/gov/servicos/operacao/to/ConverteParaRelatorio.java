package br.gov.servicos.operacao.to;

import java.util.List;

@FunctionalInterface
public interface ConverteParaRelatorio {
    public List<String> toArray();
}
