package br.com.devti.gestaotransportadora.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;

public class ClienteDAO {

	public String salvarCliente(ClienteEntity cliente) throws NegocioException {

		String sql = "INSERT INTO cliente (nome_cliente, email_cliente, data_nascimento_cliente, cpf_cliente) VALUES (?, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, cliente.getName());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getBirthday());
			ps.setString(4, cliente.getCpf());

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

	public List<ClienteEntity> listarClientes() throws NegocioException {

		String sql = "SELECT id_cliente, nome_cliente, email_cliente, data_nascimento_cliente, cpf_cliente FROM cliente ORDER BY nome_cliente";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<ClienteEntity> resultado = new ArrayList<ClienteEntity>();

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ClienteEntity cliente = new ClienteEntity(rs.getInt("id_cliente"), rs.getString("nome_cliente"), rs.getString("email_cliente"), rs.getString("data_nascimento_cliente"), rs.getString("cpf_cliente"));
				resultado.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao listar cliente");
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

	public void excluirCliente(Integer id) throws NegocioException {

		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao excluir cliente");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ClienteEntity buscarClientePorId(Integer id) throws NegocioException {

		String sql = "SELECT id_cliente, nome_cliente, email_cliente, data_nascimento_cliente, cpf_cliente FROM cliente WHERE id_cliente = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ClienteEntity clienteEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				clienteEncontrado = new ClienteEntity();
				clienteEncontrado.setId(rs.getInt("id_cliente"));
				clienteEncontrado.setName(rs.getString("nome_cliente"));
				clienteEncontrado.setEmail(rs.getString("email_cliente"));
				clienteEncontrado.setBirthday(rs.getString("data_nascimento_cliente"));
				clienteEncontrado.setCpf(rs.getString("cpf_cliente"));
			}

			return clienteEncontrado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar cliente por ID");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String alterarCliente(ClienteEntity cliente) throws NegocioException {

		String sql = "UPDATE cliente SET nome_cliente = ?, email_cliente = ?, data_nascimento_cliente = ? , cpf_cliente = ? WHERE id_cliente = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);

			ps.setString(1, cliente.getName());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getBirthday());
			ps.setString(4, cliente.getCpf());
			ps.setLong(5, cliente.getId());
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

	public List<ClienteEntity> buscarUsuarioFiltrado(ClienteEntity cliente) throws NegocioException {

		String sql = "SELECT id_cliente, nome_cliente, email_cliente, data_nascimento_cliente, cpf_cliente FROM cliente";

		List<ClienteEntity> resultado = new ArrayList<ClienteEntity>();

		boolean adicionaWhere = true;

		if (cliente.getId() != null) {
			adicionaWhere = false;
			sql += " WHERE ";
			sql += " id_cliente = ?";
		}
		if (cliente.getName() != null && !cliente.getName().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " nome_cliente LIKE ?";
		}
		if(cliente.getEmail() != null && !cliente.getEmail().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " email_cliente LIKE ?";
		}
		if(cliente.getBirthday() != null && !cliente.getBirthday().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " data_nascimento_cliente LIKE ?";
		}
		if(cliente.getCpf() != null && !cliente.getCpf().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " cpf_cliente LIKE ?";
		}
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);

			int indice = 0;

			if (cliente != null) {
				if (cliente.getId() != null) {
					indice = indice + 1;
					ps.setLong(indice, cliente.getId());
				}
				if (cliente.getName() != null && !cliente.getName().equals("")) {
					indice = indice + 1;
					ps.setString(indice, cliente.getName() + "%");
				}
				if (cliente.getEmail() != null && !cliente.getEmail().equals("")) {
					indice = indice + 1;
					ps.setString(indice, cliente.getEmail() + "%");
				}
				if (cliente.getBirthday() != null && !cliente.getBirthday().equals("")) {
					indice = indice + 1;
					ps.setString(indice, cliente.getBirthday() + "%");
				}
				if (cliente.getCpf() != null && !cliente.getCpf().equals("")) {
					indice = indice + 1;
					ps.setString(indice, cliente.getCpf() + "%");
				}
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				ClienteEntity clienteResultado = new ClienteEntity();
				clienteResultado.setId(rs.getInt("id_cliente"));
				clienteResultado.setName(rs.getString("nome_cliente"));
				clienteResultado.setEmail(rs.getString("email_cliente"));
				clienteResultado.setBirthday(rs.getString("data_nascimento_cliente"));
				clienteResultado.setCpf(rs.getString("cpf_cliente"));
				
				
				resultado.add(clienteResultado);
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

}
