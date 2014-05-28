package br.gov.model;

public enum Status {
	ATIVO(1), INATIVO(2);
	
	private int id;
	
	Status(int s){
		this.id = s;
	}
	
	public int getId(){
		return id;
	}
	
	public static Status parse(int id) {
        Status status = null; // Default
        for (Status item : Status.values()) {
            if (item.getId() == id) {
                status = item;
                break;
            }
        }
        return status;
    }	
}