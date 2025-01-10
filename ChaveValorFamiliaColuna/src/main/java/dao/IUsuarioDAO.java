package dao;

import dto.UsuarioDTO;
import model.Usuario;

public interface IUsuarioDAO {
	
	public void adicionarUsuario(UsuarioDTO dto);
	public Usuario obterUsuario(UsuarioDTO dto);
	public void excluirUsuario(UsuarioDTO dto);
	public void atualizarUsuario(UsuarioDTO dto);
}