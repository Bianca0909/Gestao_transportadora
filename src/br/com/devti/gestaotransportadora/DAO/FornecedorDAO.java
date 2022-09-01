package br.com.devti.gestaotransportadora.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;

public class FornecedorDAO {

	public String salvarFornecedor(FornecedorEntity fornecedor) throws NegocioException {

		String sql = "INSERT INTO fornecedor (nome_fornecedor, cnpj_fornecedor, data_registro_fornecedor) VALUES (?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, fornecedor.getName());
			ps.setString(2, fornecedor.getCnpj());
			ps.setString(3, fornecedor.getBirthday());

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
		return "Fornecedor cadastrado com sucesso";
	}

	public List<FornecedorEntity> listarFornecedores() throws NegocioException {

		String sql = "SELECT id_fornecedor, nome_fornecedor, cnpj_fornecedor, data_registro_fornecedor FROM fornecedor ORDER BY id_fornecedor";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<FornecedorEntity> resultado = new ArrayList<FornecedorEntity>();

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				FornecedorEntity fornecedor = new FornecedorEntity(rs.getInt("id_fornecedor"),
						 rs.getString("nome_fornecedor"), rs.getString("cnpj_fornecedor"),
						rs.getString("data_registro_fornecedor"));

				resultado.add(fornecedor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao listar fornecedor");
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

	public void excluirFornecedor(Integer id) throws NegocioException {

		String sql = "DELETE FROM fornecedor WHERE id_fornecedor = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao excluir fornecedor");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public FornecedorEntity buscarFornecedorPorId(Integer id) throws NegocioException {

		String sql = "SELECT id_fornecedor, nome_fornecedor, cnpj_fornecedor, data_registro_fornecedor FROM fornecedor WHERE id_fornecedor = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			FornecedorEntity fornecedorEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				fornecedorEncontrado = new FornecedorEntity();
				fornecedorEncontrado.setId(rs.getInt("id_fornecedor"));
				fornecedorEncontrado.setName(rs.getString("nome_fornecedor"));
				fornecedorEncontrado.setCnpj(rs.getString("cnpj_fornecedor"));
				fornecedorEncontrado.setBirthday(rs.getString("data_registro_fornecedor"));
			}

			return fornecedorEncontrado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar fornecedor por ID");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String alterarFornecedor(FornecedorEntity fornecedor) throws NegocioException {

		String sql = "UPDATE fornecedor SET nome_fornecedor = ?, cnpj_fornecedor = ?, data_registro_fornecedor = ? WHERE id_fornecedor = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);

			ps.setString(1, fornecedor.getName());
			ps.setString(2, fornecedor.getCnpj());
			ps.setString(3, fornecedor.getBirthday());
			ps.setLong(4, fornecedor.getId());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao atualizar fornecedor");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "Fornecedor alterado com sucesso";
	}

	public List<FornecedorEntity> buscarFornecedorFiltrado(FornecedorEntity fornecedor) throws NegocioException {

		String sql = "SELECT id_fornecedor, nome_fornecedor, cnpj_fornecedor, data_registro_fornecedor FROM fornecedor";

		List<FornecedorEntity> resultado = new ArrayList<FornecedorEntity>();

		boolean adicionaWhere = true;

		if (fornecedor.getId() != null) {
			adicionaWhere = false;
			sql += " WHERE ";
			sql += " id_fornecedor = ?";
		}
		if (fornecedor.getName() != null && !fornecedor.getName().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " nome_fornecedor LIKE ?";
		}
		if (fornecedor.getCnpj() != null && !fornecedor.getCnpj().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " cnpj_fornecedor LIKE ?";
		}
		if (fornecedor.getBirthday() != null && !fornecedor.getBirthday().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " data_registro_fornecedor LIKE ?";
		}
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);

			int indice = 0;

			if (fornecedor != null) {
				if (fornecedor.getId() != null) {
					indice = indice + 1;
					ps.setLong(indice, fornecedor.getId());
				}
				if (fornecedor.getName() != null && !fornecedor.getName().equals("")) {
					indice = indice + 1;
					ps.setString(indice, fornecedor.getName() + "%");
				}
				if (fornecedor.getCnpj() != null && !fornecedor.getCnpj().equals("")) {
					indice = indice + 1;
					ps.setString(indice, fornecedor.getName() + "%");
				}
				if (fornecedor.getBirthday() != null && !fornecedor.getBirthday().equals("")) {
					indice = indice + 1;
					ps.setString(indice, fornecedor.getName() + "%");
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				FornecedorEntity fornecedorResultado = new FornecedorEntity();
				fornecedorResultado.setId(rs.getInt("id_fornecedor"));
				fornecedorResultado.setName(rs.getString("nome_fornecedor"));
				fornecedorResultado.setCnpj(rs.getString("cnpj_fornecedor"));
				fornecedorResultado.setBirthday(rs.getString("data_registro_fornecedor"));
				
				resultado.add(fornecedorResultado);
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
