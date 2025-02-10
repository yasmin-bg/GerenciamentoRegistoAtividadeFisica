package mapper;

import dto.ExercicioDTO;
import model.Exercicio;

public class MapperExercicio {

    public ExercicioDTO toDTO(Exercicio exercicio) {
        ExercicioDTO dto = new ExercicioDTO();
        dto.setId(exercicio.getId());
        dto.setIdUsuario(exercicio.getIdUsuario());
        dto.setTipoExercicio(exercicio.getTipoExercicio());
        dto.setDuracao(exercicio.getDuracao());
        dto.setCaloriasQueimadas(exercicio.getCaloriasQueimadas());
        return dto;
    }

    public Exercicio toEntity(ExercicioDTO dto) {
        Exercicio entity = new Exercicio();
        entity.setId(dto.getId());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setTipoExercicio(dto.getTipoExercicio());
        entity.setDuracao(dto.getDuracao());
        entity.setCaloriasQueimadas(dto.getCaloriasQueimadas());
        return entity;
    }
}