package model;

public class Exercicio {
	
    private long id;
    private long idUsuario;
    private byte[] tipoExercicio; 
    private int duracao; 
    private int caloriasQueimadas;

    public Exercicio(long id, long idUsuario, byte[] tipoExercicio, int duracao, int caloriasQueimadas) {
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getCaloriasQueimadas() {
        return caloriasQueimadas;
    }

    public void setCaloriasQueimadas(int caloriasQueimadas) {
        this.caloriasQueimadas = caloriasQueimadas;
    }
}