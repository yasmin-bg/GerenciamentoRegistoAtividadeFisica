package model;

import java.util.List;

public class Exercicio {
	
    private long id;
    private List<Long> idUsuario;
    private String tipoExercicio;
    
	public Exercicio() {

	}

	public Exercicio(long id, List<Long> idUsuario, String tipoExercicio) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.tipoExercicio = tipoExercicio;
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