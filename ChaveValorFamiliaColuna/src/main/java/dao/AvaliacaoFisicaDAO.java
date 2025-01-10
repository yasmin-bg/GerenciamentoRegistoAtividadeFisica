package dao;

import dto.AvaliacaoFisicaDTO;
import mapper.MapperAvaliacaoFisica;
import model.AvaliacaoFisica;
import redis.clients.jedis.Jedis;

public class AvaliacaoFisicaDAO implements IAvaliacaoFisicaDAO {

    private Jedis jedis;
    private MapperAvaliacaoFisica mapperAvaliacaoFisica;

    public AvaliacaoFisicaDAO() {
    	this.jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("senha");
        this.mapperAvaliacaoFisica = new MapperAvaliacaoFisica();
    }

    public void adicionarAvaliacao(AvaliacaoFisicaDTO dto) {
        String chave = "avaliacao:" + dto.getId();
        String valor = mapperAvaliacaoFisica.toJson(dto);
        jedis.set(chave, valor);
    }

    public void atualizarAvaliacao(AvaliacaoFisicaDTO dto) {
        String chave = "avaliacao:" + dto.getId();
        String valor = mapperAvaliacaoFisica.toJson(dto);
        jedis.set(chave, valor);
    }

    public AvaliacaoFisica obterAvaliacao(AvaliacaoFisicaDTO dto) {
        String chave = "avaliacao:" + dto.getId();
        String avaliacaoJson = jedis.get(chave);
        if (avaliacaoJson != null) {
            AvaliacaoFisicaDTO avaliacaoDTO = mapperAvaliacaoFisica.fromJson(avaliacaoJson);
            return mapperAvaliacaoFisica.toEntity(avaliacaoDTO);
        }
        return null;
    }

    public void excluirAvaliacao(AvaliacaoFisicaDTO dto) {
        String chave = "avaliacao:" + dto.getId();
        jedis.del(chave);
    }
}