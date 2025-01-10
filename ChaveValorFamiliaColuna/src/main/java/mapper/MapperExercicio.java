package mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ExercicioDTO;
import model.Exercicio;

public class MapperExercicio {
    private ObjectMapper objectMapper;

    public MapperExercicio() {
        this.objectMapper = new ObjectMapper();
    }

    public ExercicioDTO toDTO(Exercicio exercicio) {
        ExercicioDTO dto = new ExercicioDTO();
        dto.setId(exercicio.getId());
        dto.setTipoExercicio(exercicio.getTipoExercicio());
        dto.setDuracao(exercicio.getDuracao());
        dto.setCaloriasQueimadas(exercicio.getCaloriasQueimadas());
        return dto;
    }

    public Exercicio toEntity(ExercicioDTO exercicioDTO) {
        Exercicio entity = new Exercicio();
        entity.setId(exercicioDTO.getId());
        entity.setTipoExercicio(exercicioDTO.getTipoExercicio());
        entity.setDuracao(exercicioDTO.getDuracao());
        entity.setCaloriasQueimadas(exercicioDTO.getCaloriasQueimadas());
        return entity;
    }

    public String toJson(ExercicioDTO dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter DTO para JSON", e);
        }
    }

    public ExercicioDTO fromJson(String json) {
        try {
            return objectMapper.readValue(json, ExercicioDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para DTO", e);
        }
    }
}