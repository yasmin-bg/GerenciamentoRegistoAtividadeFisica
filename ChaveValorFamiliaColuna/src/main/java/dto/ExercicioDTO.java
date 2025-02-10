package dto;

import java.io.Serializable;

public class ExercicioDTO implements Serializable {

    private long id;
    private long idUsuario;
    private String tipoExercicio;  
    private String duracao;
    private String caloriasQueimadas;
    
    public ExercicioDTO(long id, long idUsuario, String tipoExercicio, String duracao, String caloriasQueimadas) {
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

    public String getTipoExercicio() {
        return tipoExercicio;
    }

    public void setTipoExercicio(String tipoExercicio) {
        this.tipoExercicio = tipoExercicio;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getCaloriasQueimadas() {
        return caloriasQueimadas;
    }

    public void setCaloriasQueimadas(String caloriasQueimadas) {
        this.caloriasQueimadas = caloriasQueimadas;
    }   
}