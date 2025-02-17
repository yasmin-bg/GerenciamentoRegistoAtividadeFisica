package dto;

public class ExercicioDTO {

    private long id;
    private String tipoExercicio;
    
	public ExercicioDTO() {
	
	}

	public ExercicioDTO(long id, String tipoExercicio) {
		this.id = id;
		this.tipoExercicio = tipoExercicio;
	}

	public ExercicioDTO(long id) {
		super();
		this.id = id;
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