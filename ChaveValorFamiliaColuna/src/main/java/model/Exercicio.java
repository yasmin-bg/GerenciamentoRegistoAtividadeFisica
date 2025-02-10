package model;

public class Exercicio {
	
    private long id;
    private long idUsuario;
    private byte[] tipoExercicio; 
    private byte[] duracao; 
    private byte[] caloriasQueimadas;
    
	public Exercicio(long id, long idUsuario, byte[] tipoExercicio, byte[] duracao, byte[] caloriasQueimadas) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.tipoExercicio = tipoExercicio;
		this.duracao = duracao;
		this.caloriasQueimadas = caloriasQueimadas;
	}

	public Exercicio() {

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