package dao;

import dto.AvaliacaoFisicaDTO;
import redis.clients.jedis.Jedis;
import util.Serializador;
import java.io.IOException;

public class AvaliacaoFisicaDAO implements IAvaliacaoFisicaDAO {

    private Jedis jedis;

    public AvaliacaoFisicaDAO() {
        this.jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("senha");
    }

    public void adicionarAvaliacao(AvaliacaoFisicaDTO dto) throws IOException {
        String chave = "avaliacao:" + dto.getId();
        byte[] dadosSerializados = Serializador.serializar(dto);
        jedis.hset(chave.getBytes(), "dados".getBytes(), dadosSerializados);
    }

    public AvaliacaoFisicaDTO obterAvaliacao(AvaliacaoFisicaDTO dto) throws IOException, ClassNotFoundException {
        String chave = "avaliacao:" + dto.getId();
        byte[] dados = jedis.hget(chave.getBytes(), "dados".getBytes());
        return (dados != null) ? Serializador.desserializar(dados, AvaliacaoFisicaDTO.class) : null;
    }
}