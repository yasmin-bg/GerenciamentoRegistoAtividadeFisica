package mapper;

import dto.UsuarioDTO;
import model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperUsuario {

    private ObjectMapper objectMapper;

    public MapperUsuario() {
        this.objectMapper = new ObjectMapper();
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        return entity;
    }

    public String toJson(UsuarioDTO dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter DTO para JSON", e);
        }
    }

    public UsuarioDTO fromJson(String json) {
        try {
            return objectMapper.readValue(json, UsuarioDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para DTO", e);
        }
    }
}