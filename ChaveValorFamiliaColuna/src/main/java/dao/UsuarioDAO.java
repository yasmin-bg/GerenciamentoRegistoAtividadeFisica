package dao;

import dto.UsuarioDTO;
import redis.clients.jedis.Jedis;
import java.io.IOException;

public class UsuarioDAO extends ConexaoRedis implements IUsuarioDAO {

    public void adicionarUsuario(UsuarioDTO dto) throws IOException {
        String chave = "usuario:" + dto.getId();
        String valor = dto.getNome();
        
        try (Jedis jedis = getJedis()) {
            jedis.set(chave, valor); 
        }
    }

    public UsuarioDTO obterUsuario(UsuarioDTO dto) throws IOException {
        String chave = "usuario:" + dto.getId();
        
        try (Jedis jedis = getJedis()) {
            String valor = jedis.get(chave); 
            return valor != null ? new UsuarioDTO(dto.getId(), valor) : null; 
        }
    }

    public void removerUsuario(UsuarioDTO dto) {
        String chave = "usuario:" + dto.getId();
        
        try (Jedis jedis = getJedis()) {
            jedis.del(chave); 
        }
    }
}
