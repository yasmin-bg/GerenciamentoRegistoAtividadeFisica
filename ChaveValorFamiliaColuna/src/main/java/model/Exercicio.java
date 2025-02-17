package model;

public class Exercicio {
	
    private long id;
    private String tipoExercicio;
    
	public Exercicio() {

	}

	public Exercicio(long id, String tipoExercicio) {
		this.id = id;
		this.tipoExercicio = tipoExercicio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoExercicio() {
		return tipoExercicio;
	}

	public void setTipoExercicio(String tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}  
}