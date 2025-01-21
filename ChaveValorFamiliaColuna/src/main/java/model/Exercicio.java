package model;

public class Exercicio {
	
    private long id;
    private long idUsuario;
	private String tipoExercicio;
    private int duracao; 
    private int caloriasQueimadas;

    public Exercicio(long id, long idUsuario, String tipoExercicio, int duracao, int caloriasQueimadas) {
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

    public Long getIdUsuario() {
    	return idUsuario;
    }
    
    public void setIdUsuario(Long idUsuario) {
    	this.idUsuario = idUsuario;
    }
    
    public String getTipoExercicio() {
        return tipoExercicio;
    }

    public void setTipoExercicio(String tipoExercicio) {
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