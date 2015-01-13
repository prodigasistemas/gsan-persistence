package br.gov.model.cadastro;

public enum CodigoFebraban {
    CAEMA    ((short) 2), 
    CAER     ((short) 4), 
    CAERN    ((short) 6), 
    COMPESA  ((short) 18), 
    COSAMA   ((short) 21), 
    COSANPA  ((short) 22), 
    JUAZEIRO ((short) 135);
    
    private short id = 0;

    CodigoFebraban(short id){
        this.id = id;
    }

    public short getId() {
        return id;
    }    
}
