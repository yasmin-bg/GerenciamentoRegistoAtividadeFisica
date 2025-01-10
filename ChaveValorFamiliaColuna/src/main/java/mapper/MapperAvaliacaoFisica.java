package mapper;

import dto.AvaliacaoFisicaDTO;
import model.AvaliacaoFisica;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperAvaliacaoFisica {
	
    private ObjectMapper objectMapper;

    public MapperAvaliacaoFisica() {
        this.objectMapper = new ObjectMapper();
    }

    public AvaliacaoFisicaDTO toDTO(AvaliacaoFisica entity) {
        AvaliacaoFisicaDTO dto = new AvaliacaoFisicaDTO();
        dto.setId(entity.getId());
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setPeso(entity.getPeso());
        dto.setAltura(entity.getAltura());
        dto.setImc(entity.getImc());
        return dto;
    }

    public AvaliacaoFisica toEntity(AvaliacaoFisicaDTO dto) {
        AvaliacaoFisica entity = new AvaliacaoFisica();
        entity.setId(dto.getId());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setPeso(dto.getPeso());
        entity.setAltura(dto.getAltura());
        entity.setImc(dto.getImc());
        return entity;
    }

    public String toJson(AvaliacaoFisicaDTO dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter DTO para JSON", e);
        }
    }

    public AvaliacaoFisicaDTO fromJson(String json) {
        try {
            return objectMapper.readValue(json, AvaliacaoFisicaDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para DTO", e);
        }
    }
}