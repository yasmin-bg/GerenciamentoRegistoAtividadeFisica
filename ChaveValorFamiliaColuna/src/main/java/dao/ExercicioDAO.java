package dao;

import dto.ExercicioDTO;
import redis.clients.jedis.Jedis;
import util.Serializador;
import java.io.IOException;

public class ExercicioDAO implements IExercicioDAO {

    private Jedis jedis;

    public ExercicioDAO() {
        this.jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("senha");
    }

    public void adicionarExercicio(ExercicioDTO dto) throws IOException {
        String chave = "exercicio:" + dto.getId();
        byte[] dadosSerializados = Serializador.serializar(dto);
        jedis.hset(chave.getBytes(), "dados".getBytes(), dadosSerializados);
    }

    public ExercicioDTO obterExercicio(ExercicioDTO dto) throws IOException, ClassNotFoundException {
        String chave = "exercicio:" + dto.getId();
        byte[] dados = jedis.hget(chave.getBytes(), "dados".getBytes());
        return (dados != null) ? Serializador.desserializar(dados, ExercicioDTO.class) : null;
    }
}