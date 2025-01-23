package controller;

import java.util.List;
import dao.UsuarioDAO;
import dto.UsuarioDTO;
import model.Usuario;

public class UsuarioController {

    private UsuarioDAO dao;

    public UsuarioController() {
        this.dao = new UsuarioDAO();
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
    
    public List<UsuarioDTO> listarTodosUsuarios() {
    	return dao.listarTodosUsuarios();
    }
}