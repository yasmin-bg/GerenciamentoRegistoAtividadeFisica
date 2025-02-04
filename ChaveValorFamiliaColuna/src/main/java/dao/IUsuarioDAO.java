package dao;

import java.io.IOException;

import dto.UsuarioDTO;
import model.Usuario;

public interface IUsuarioDAO {
	
	public void adicionarUsuario(UsuarioDTO dto) throws IOException;
	public UsuarioDTO obterUsuario(UsuarioDTO dto) throws IOException, ClassNotFoundException;
}