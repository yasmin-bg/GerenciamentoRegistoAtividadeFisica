package dto;

public class ExercicioDTO {
	
    private long id;
    private String tipoExercicio;
    private int duracao;
    private int caloriasQueimadas;

    public ExercicioDTO(long id, String tipoExercicio, int duracao, int caloriasQueimadas) {
        this.id = id;
        this.tipoExercicio = tipoExercicio;
        this.duracao = duracao;
        this.caloriasQueimadas = caloriasQueimadas;
    }
    
    public ExercicioDTO() {
    	
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