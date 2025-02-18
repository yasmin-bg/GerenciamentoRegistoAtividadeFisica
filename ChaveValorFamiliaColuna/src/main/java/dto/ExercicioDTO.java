package dto;

import java.io.Serializable;
import java.util.List;

public class ExercicioDTO implements Serializable {

    private long id;
    private List<Long> idUsuario;

	private String tipoExercicio;
    
	public ExercicioDTO() {
	
	}

	public ExercicioDTO(long id, List<Long> idUsuario, String tipoExercicio) {
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
	
	public List<Long> getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(List<Long> idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoExercicio() {
		return tipoExercicio;
	}

	public void setTipoExercicio(String tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}    
}