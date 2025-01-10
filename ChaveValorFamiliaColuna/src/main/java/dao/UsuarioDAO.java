package dao;

import dto.UsuarioDTO;
import mapper.MapperUsuario;
import model.Usuario;
import redis.clients.jedis.Jedis;

public class UsuarioDAO implements IUsuarioDAO {

    private Jedis jedis;
    private MapperUsuario mapperUsuario;

    public UsuarioDAO() {
    	this.jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("senha");
        this.mapperUsuario = new MapperUsuario();
    }

    public void adicionarUsuario(UsuarioDTO dto) {
        String chave = "usuario:" + dto.getId();
        String valor = mapperUsuario.toJson(dto);
        jedis.set(chave, valor);
    }

    public void atualizarUsuario(UsuarioDTO dto) {
        String chave = "usuario:" + dto.getId();
        String valor = mapperUsuario.toJson(dto);
        jedis.set(chave, valor);
    }

    public Usuario obterUsuario(UsuarioDTO dto) {
        String chave = "usuario:" + dto.getId();
        String avaliacaoJson = jedis.get(chave);
        if (avaliacaoJson != null) {
            UsuarioDTO avaliacaoDTO = mapperUsuario.fromJson(avaliacaoJson);
            return mapperUsuario.toEntity(avaliacaoDTO);
        }
        return null;
    }

    public void excluirUsuario(UsuarioDTO dto) {
        String chave = "usuario:" + dto.getId();
        jedis.del(chave);
    }
}