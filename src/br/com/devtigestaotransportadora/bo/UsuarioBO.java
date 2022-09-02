package br.com.devtigestaotransportadora.bo;

import java.util.List;

import br.com.devti.gestaotransportadora.DAO.UsuarioDAO;
import br.com.devti.gestaotransportadora.entity.UsuarioEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class UsuarioBO {

	private void validarUsuario(UsuarioEntity usuario) throws NegocioException {
		if (usuario.getLogin() == null || usuario.getLogin().equals("")) {
			throw new NegocioException("O login do usuário deve ser preenchido.");
		}
	
	}

	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {

		validarUsuario(usuario);

		UsuarioDAO usuarioDao = new UsuarioDAO();
		return usuarioDao.salvarUsuario(usuario);
	}

	public String alterarUsuario(UsuarioEntity usuario) throws NegocioException {
		
		validarUsuario(usuario);
		
		return new UsuarioDAO().alterarUsuario(usuario);
	}

	public List<UsuarioEntity> listarUsuarios() throws NegocioException {
		return new UsuarioDAO().listarUsuarios();
	}

	public void excluirUsuario(Integer id) throws NegocioException {
		new UsuarioDAO().excluirUsuario(id);
	}

	public UsuarioEntity buscarUsuarioPorId(Integer id) throws NegocioException {
		return new UsuarioDAO().buscarUsuarioPorId(id);
	}

	public List<UsuarioEntity> buscarUsuarioFiltrado(UsuarioEntity usuario) throws NegocioException {
		return new UsuarioDAO().buscarUsuarioFiltrado(usuario);
	}
	public UsuarioEntity autenticarUsuario(String login, String senha) throws NegocioException {
		return new UsuarioDAO().autenticar(login, senha);
	}
}
