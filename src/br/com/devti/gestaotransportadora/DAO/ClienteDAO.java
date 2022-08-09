package br.com.devti.gestaotransportadora.DAO;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	public String salvarCliente(ClienteEntity cliente) throws NegocioException {
		
		String sql = "INSERT INTO cliente (nome_cliente, email_cliente, data_nascimento_cliente, cpf_cliente) VALUES (?, ?, ?, ?)";

<<<<<<< HEAD
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, cliente.getName());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getBirthday());
			ps.setString(4, cliente.getCpf());
=======
        String sql = "INSERT INTO cliente (nome_cliente, email_cliente, data_nascimento_cliente, cpf_cliente) VALUES (?,?,?,?)";
>>>>>>> 976b5e088589bcedd18ccbbfc71c1cabe22c7137

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao tentar cadastrar no banco");
		} finally {

<<<<<<< HEAD
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
=======
            ps.execute();
        } catch (SQLException e) {
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
>>>>>>> 976b5e088589bcedd18ccbbfc71c1cabe22c7137

		}
		return "Cliente cadastrado com sucesso";
	}

	public List<ClienteEntity> listarClientes() throws NegocioException {

		String sql = "SELECT id_cliente, nome_cliente FROM cliente ORDER BY nome_cliente";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<ClienteEntity> resultado = new ArrayList<ClienteEntity>();

<<<<<<< HEAD
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
=======
            while (rs.next()) {
                ClienteEntity cliente
                        = new ClienteEntity(rs.getLong("id"),
                                rs.getString("nome_cliente"),
                                rs.getString("birthday"),
                                rs.getString("email"),
                                rs.getString("cpf"));
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
>>>>>>> 976b5e088589bcedd18ccbbfc71c1cabe22c7137

			while (rs.next()) {
				ClienteEntity cliente = new ClienteEntity(rs.getInt("id_cliente"), rs.getString("nome_cliente"));
				resultado.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao listar Grupo de Usuário");
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

	public void excluirCliente(int id) throws NegocioException {

		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

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

	public ClienteEntity buscarClientePorId(Long id) throws NegocioException {

		String sql = "SELECT id_cliente, nome_cliente FROM cliente WHERE id_cliente = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ClienteEntity clienteEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				clienteEncontrado = new ClienteEntity();
				clienteEncontrado.SetId(rs.getInt("id_cliente"));
				clienteEncontrado.setName(rs.getString("nome_cliente"));
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

		String sql = "UPDATE cliente SET nome_cliente, email_cliente, data_nascimento_cliente, cpf_cliente WHERE ID_GRUPO = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, cliente.getId());
			ps.setString(2, cliente.getName());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getBirthday());
			ps.setString(5, cliente.getCpf());
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

}
