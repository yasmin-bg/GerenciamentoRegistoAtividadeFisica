package dao;

import dto.UsuarioDTO;
import redis.clients.jedis.Jedis;
import util.Serializador;
import java.io.IOException;

public class UsuarioDAO extends ConexaoRedis implements IUsuarioDAO {

    public void adicionarUsuario(UsuarioDTO dto) throws IOException {
        String chave = "usuario:" + dto.getId();
        byte[] dadosSerializados = Serializador.serializar(dto);
        
        try (Jedis jedis = getJedis()) {
            jedis.set(chave.getBytes(), dadosSerializados); 
        }
    }

    public UsuarioDTO obterUsuario(UsuarioDTO dto) throws IOException, ClassNotFoundException {
        String chave = "usuario:" + dto.getId();
        
        try (Jedis jedis = getJedis()) {
            byte[] dados = jedis.get(chave.getBytes()); 
            return (dados != null) ? Serializador.desserializar(dados, UsuarioDTO.class) : null;
        }
    }
    
    public void removerUsuario(UsuarioDTO dto) {
        String chave = "usuario:" + dto.getId();
        
        try (Jedis jedis = getJedis()) {
            jedis.del(chave.getBytes());  
        }
    }
}