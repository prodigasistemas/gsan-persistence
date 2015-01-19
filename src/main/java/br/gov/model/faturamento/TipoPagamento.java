package br.gov.model.faturamento;

public enum TipoPagamento {
    UM                    (1),
    DOCUMENTO_COBRANCA         (3),
    CONTA                      (3),
    GUIA_IMOVEL                (4),
    DOCUMENTO_COBRANCA_IMOVEL  (5),
    GUIA_CLIENTE               (6),
    FATURA_CLIENTE_RESPONSAVEL (7),
    DOCUMENTO_COBRANCA_CLIENTE (8),
    NOVE                  (9);
    
    private int id;
    
    private TipoPagamento(int id) {
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
