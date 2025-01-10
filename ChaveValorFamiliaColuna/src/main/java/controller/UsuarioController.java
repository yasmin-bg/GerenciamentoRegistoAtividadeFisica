package controller;

import dao.UsuarioDAO;
import dto.UsuarioDTO;
import mapper.MapperUsuario;
import model.Usuario;

public class UsuarioController {

    private UsuarioDAO dao;
    private MapperUsuario mapperUsuario;

    public UsuarioController() {
        this.dao = new UsuarioDAO();
        this.mapperUsuario = new MapperUsuario();
    }

    public void adicionarUsuario(UsuarioDTO dto) {
        dao.adicionarUsuario(dto);
    }

    public Usuario obterUsuario(UsuarioDTO dto) {
        return dao.obterUsuario(dto);
    }

    public void excluirUsuario(UsuarioDTO dto) {
        dao.excluirUsuario(dto);
    }

    public void atualizarUsuario(UsuarioDTO dto) {
        dao.atualizarUsuario(dto);
    }
}