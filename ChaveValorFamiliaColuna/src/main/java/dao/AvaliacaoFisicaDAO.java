package dao;

import dto.AvaliacaoFisicaDTO;
import redis.clients.jedis.Jedis;
import util.Serializador;
import java.io.IOException;

public class AvaliacaoFisicaDAO extends ConexaoRedis implements IAvaliacaoFisicaDAO {

    public void adicionarAvaliacao(AvaliacaoFisicaDTO dto) throws IOException {
        String chave = "avaliacao:" + dto.getId();
        byte[] dadosSerializados = Serializador.serializar(dto);
        
        try (Jedis jedis = getJedis()) {
            jedis.set(chave.getBytes(), dadosSerializados);
        }
    }

    public AvaliacaoFisicaDTO obterAvaliacao(AvaliacaoFisicaDTO dto) throws IOException, ClassNotFoundException {
        String chave = "avaliacao:" + dto.getId(); 
        
        try (Jedis jedis = getJedis()) {
            byte[] dados = jedis.get(chave.getBytes());
            return (dados != null) ? Serializador.desserializar(dados, AvaliacaoFisicaDTO.class) : null;
        }
    }

    public void removerAvaliacao(AvaliacaoFisicaDTO dto) {
        String chave = "avaliacao:" + dto.getId();
        
        try (Jedis jedis = getJedis()) {
            jedis.del(chave.getBytes());
        }
    }
}