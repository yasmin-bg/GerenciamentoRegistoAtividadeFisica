package mapper;

import dto.AvaliacaoFisicaDTO;
import model.AvaliacaoFisica;

public class MapperAvaliacaoFisica {

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
}