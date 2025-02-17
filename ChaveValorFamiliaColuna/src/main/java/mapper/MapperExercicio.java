package mapper;

import dto.ExercicioDTO;
import model.Exercicio;

public class MapperExercicio {

    public ExercicioDTO toDTO(Exercicio exercicio) {
        ExercicioDTO dto = new ExercicioDTO();
        dto.setId(exercicio.getId());
        dto.setTipoExercicio(exercicio.getTipoExercicio());
        return dto;
    }

    public Exercicio toEntity(ExercicioDTO dto) {
        Exercicio entity = new Exercicio();
        entity.setId(dto.getId());
        entity.setTipoExercicio(dto.getTipoExercicio());
        return entity;
    }
}