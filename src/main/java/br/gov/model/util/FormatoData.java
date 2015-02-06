package br.gov.model.util;

public enum FormatoData {
    DIA_MES_ANO          ("dd/MM/yyyy"),
    MES_ANO              ("MM/yyyy"),
    ANO_MES              ("yyyyMM"),
    ANO_MES_DIA          ("yyyyMMdd"),
    ANO_MES_DIA_SEPARADO("yyyy-MM-dd");
    
    String formato;
    
    FormatoData(String f) {
        this.formato = f;
    }

    public String getFormato() {
        return formato;
    }
}
