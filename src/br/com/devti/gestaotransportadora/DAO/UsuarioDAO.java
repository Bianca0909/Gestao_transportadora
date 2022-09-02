package br.com.devti.gestaotransportadora.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.gestaotransportadora.entity.UsuarioEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;

public class UsuarioDAO {

	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {

		String sql = "INSERT INTO usuario (login_usuario, senha_usuario) VALUES (?, ?)";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao tentar cadastrar no banco");
		} finally {

			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return "Cliente cadastrado com sucesso";
	}

	public List<UsuarioEntity> listarUsuarios() throws NegocioException {

		String sql = "SELECT id_usuario, login_usuario, senha_usuario FROM usuario ORDER BY login_usuario";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<UsuarioEntity> resultado = new ArrayList<UsuarioEntity>();

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				UsuarioEntity usuario = new UsuarioEntity(rs.getInt("id_usuario"), rs.getString("login_usuario"),
						rs.getString("senha_usuario"));
				resultado.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao listar usuario");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultado;
	}

	public void excluirUsuario(Integer id) throws NegocioException {

		String sql = "DELETE FROM usuario WHERE id_usuario = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao excluir usuario");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public UsuarioEntity buscarUsuarioPorId(Integer id) throws NegocioException {

		String sql = "SELECT id_usuario, login_usuario FROM usuario WHERE id_usuario = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			UsuarioEntity usuarioEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				usuarioEncontrado = new UsuarioEntity();
				usuarioEncontrado.setId(rs.getInt("id_usuario"));
				usuarioEncontrado.setLogin(rs.getString("login_usuario"));
			}

			return usuarioEncontrado;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar usuário por ID");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String alterarUsuario(UsuarioEntity usuario) throws NegocioException {

		String sql = "UPDATE usuario SET login_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);

			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getId());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao atualizar cliente");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "Cliente alterado com sucesso";
	}

	public List<UsuarioEntity> buscarUsuarioFiltrado(UsuarioEntity usuario) throws NegocioException {

		String sql = "SELECT id_usuario, login_usuario, senha_usuario FROM usuario";

		List<UsuarioEntity> resultado = new ArrayList<UsuarioEntity>();

		boolean adicionaWhere = true;

		if (usuario.getId() != null) {
			adicionaWhere = false;
			sql += " WHERE ";
			sql += " id_usuario = ?";
		}
		if (usuario.getLogin() != null && !usuario.getLogin().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " login_usuario LIKE ?";
		}
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);

			int indice = 0;

			if (usuario != null) {
				if (usuario.getId() != null) {
					indice = indice + 1;
					ps.setLong(indice, usuario.getId());
				}
				if (usuario.getLogin() != null && !usuario.getLogin().equals("")) {
					indice = indice + 1;
					ps.setString(indice, usuario.getLogin() + "%");
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				UsuarioEntity usuarioResultado = new UsuarioEntity();
				usuarioResultado.setId(rs.getInt("id_usuario"));
				usuarioResultado.setLogin(rs.getString("login_usuario"));
				resultado.add(usuarioResultado);
			}
		} catch (SQLException e) {
			throw new NegocioException("Busca inválida");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}

	public UsuarioEntity autenticar(String login, String senha) throws NegocioException {
		String sql = "SELECT id_usuario, loin_usuario, senha_usuario FROM usuario WHERE login_usuario = ? AND senha_usuario = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			
			UsuarioEntity usuarioAutenticado = null;
			if(rs.next()) {
				usuarioAutenticado = new UsuarioEntity();
				usuarioAutenticado.setLogin(rs.getString("login_usuario"));
				usuarioAutenticado.setSenha(rs.getString("senha_usuario"));
			}
			return usuarioAutenticado;
		} catch (SQLException e) {
	    throw new NegocioException("Erro ao tentar autenticar");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
