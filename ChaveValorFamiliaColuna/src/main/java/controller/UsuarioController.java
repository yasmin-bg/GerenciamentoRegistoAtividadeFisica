package controller;

import java.io.IOException;
import java.util.List;
import dao.UsuarioDAO;
import dto.UsuarioDTO;
import model.Usuario;

public class UsuarioController {

    private UsuarioDAO dao;

    public UsuarioController() {
        this.dao = new UsuarioDAO();
    }

    public void adicionarUsuario(UsuarioDTO dto) throws IOException {
        dao.adicionarUsuario(dto);
    }

    public UsuarioDTO obterUsuario(UsuarioDTO dto) throws IOException, ClassNotFoundException {
        return dao.obterUsuario(dto);
    }
    
    public void removerUsuario(UsuarioDTO dto) {
    	dao.removerUsuario(dto);
    }
}