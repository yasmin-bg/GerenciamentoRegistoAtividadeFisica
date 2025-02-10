package dao;

import dto.UsuarioDTO;
import redis.clients.jedis.Jedis;
import util.Serializador;
import java.io.IOException;

public class UsuarioDAO implements IUsuarioDAO {

    private Jedis jedis;

    public UsuarioDAO() {
        this.jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("senha");
    }

    public void adicionarUsuario(UsuarioDTO dto) throws IOException {
        String chave = "usuario:" + dto.getId();
        byte[] dadosSerializados = Serializador.serializar(dto);
        jedis.hset(chave.getBytes(), "dados".getBytes(), dadosSerializados);
    }

    public UsuarioDTO obterUsuario(UsuarioDTO dto) throws IOException, ClassNotFoundException {
        String chave = "usuario:" + dto.getId();
        byte[] dados = jedis.hget(chave.getBytes(), "dados".getBytes());
        return (dados != null) ? Serializador.desserializar(dados, UsuarioDTO.class) : null;
    }
    
    public void removerUsuario(UsuarioDTO dto) {
        String chave = "usuario:" + dto.getId();
        jedis.del(chave.getBytes());
    }
}