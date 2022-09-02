package br.com.devti.gestaotransportadora.service;

import java.util.List;

import br.com.devti.gestaotransportadora.DAO.UsuarioDAO;
import br.com.devti.gestaotransportadora.entity.UsuarioEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devtigestaotransportadora.bo.UsuarioBO;

public class UsuarioService {
	
	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException{
		UsuarioBO usuarioBo = new UsuarioBO();
		return usuarioBo.salvarUsuario(usuario);
	}

    public String cadastrarUsuario(UsuarioEntity usuario) throws NegocioException {
    	UsuarioBO usuarioBo = new UsuarioBO();
        return usuarioBo.salvarUsuario(usuario);
    }

    public List<UsuarioEntity> listarUsuario() throws NegocioException {
        return new UsuarioBO().listarUsuarios();
    }

    public void excluirUsuario(Integer id) throws NegocioException {
        new UsuarioBO().excluirUsuario(id);
    }

    public String alterarUsuario(UsuarioEntity usuario) throws NegocioException {
        return new UsuarioBO().alterarUsuario(usuario);
    }

    public UsuarioEntity buscarUsuarioPorId(Integer id) throws NegocioException {
        return new UsuarioBO().buscarUsuarioPorId(id);
    }
    
    public List<UsuarioEntity> buscarUsuarioFiltrado(UsuarioEntity usuario) throws NegocioException {
    	return new UsuarioBO().buscarUsuarioFiltrado(usuario);
    	}
     public UsuarioEntity autenticarUsuario(String login, String senha) throws NegocioException {
		return new UsuarioDAO().autenticar(login, senha);
	}
    
}
