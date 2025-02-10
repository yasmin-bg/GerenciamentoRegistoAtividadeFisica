package dto;

import java.io.Serializable;

public class ExercicioDTO implements Serializable {

    private long id;
    private long idUsuario;
    private byte[] tipoExercicio;  
    private byte[] duracao;
    private byte[] caloriasQueimadas;
    
	public ExercicioDTO(long id, long idUsuario, byte[] tipoExercicio, byte[] duracao, byte[] caloriasQueimadas) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.tipoExercicio = tipoExercicio;
		this.duracao = duracao;
		this.caloriasQueimadas = caloriasQueimadas;
	}

	public ExercicioDTO() {
	
	}

	public ExercicioDTO(long id) {
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

	public byte[] getTipoExercicio() {
		return tipoExercicio;
	}

	public void setTipoExercicio(byte[] tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}

	public byte[] getDuracao() {
		return duracao;
	}

	public void setDuracao(byte[] duracao) {
		this.duracao = duracao;
	}

	public byte[] getCaloriasQueimadas() {
		return caloriasQueimadas;
	}

	public void setCaloriasQueimadas(byte[] caloriasQueimadas) {
		this.caloriasQueimadas = caloriasQueimadas;
	}   
}