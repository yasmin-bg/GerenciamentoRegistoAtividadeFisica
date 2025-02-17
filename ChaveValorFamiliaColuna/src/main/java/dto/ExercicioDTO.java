package dto;

import java.io.Serializable;

public class ExercicioDTO implements Serializable {

    private long id;
    private long idUsuario;

	private String tipoExercicio;
    
	public ExercicioDTO() {
	
	}

	public ExercicioDTO(long id, long idUsuario, String tipoExercicio) {
		this.id = id;
		this.idUsuario = idUsuario;
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
	
	public long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoExercicio() {
		return tipoExercicio;
	}

	public void setTipoExercicio(String tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}    
}