package br.com.devti.gestaotransportadora.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;

public class OrdemServicoDAO {

	public String salvarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {

		String sql = "INSERT INTO os (cliente_id, fornecedor_id, colaborador_id, endereco_os, valor) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setInt(1, ordemServico.getClienteId());
			ps.setInt(2, ordemServico.getFornecedorId());
			ps.setInt(3, ordemServico.getColaboradorId());
			ps.setString(4, ordemServico.getEndereco());
			ps.setDouble(5, ordemServico.getValor());

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

	public List<OrdemServicoEntity> listarOrdensServico() throws NegocioException {

		String sql = "SELECT id_ordem_servico, cliente_id, fornecedor_id, colaborador_id, endereco_os, valor FROM os";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<OrdemServicoEntity> resultado = new ArrayList<OrdemServicoEntity>();

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				OrdemServicoEntity ordemServico = new OrdemServicoEntity(rs.getInt("id_ordem_servico"),
						rs.getString("endereco_os"), rs.getInt("cliente_id"), rs.getInt("fornecedor_id"),
						rs.getInt("colaborador_id"), rs.getDouble("valor"));
				resultado.add(ordemServico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao listar ordem de serviço");
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

	public void excluirOrdemServico(Integer id) throws NegocioException {

		String sql = "DELETE FROM os WHERE id_ordem_servico = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao excluir ordem de serviço");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public OrdemServicoEntity buscarOrdemServicoPorId(Integer id) throws NegocioException {

		String sql = "SELECT id_ordem_servico, endereco_os, cliente_id, fornecedor_id, colaborador_id, valor FROM os WHERE id_ordem_servico = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			OrdemServicoEntity ordemServicoEncontrada = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				ordemServicoEncontrada = new OrdemServicoEntity();
				ordemServicoEncontrada.setId(rs.getInt("id_ordem_servico"));
				ordemServicoEncontrada.setClienteId(rs.getInt("Cliente_id"));
				ordemServicoEncontrada.setColaboradorId(rs.getInt("Colaborador_id"));
				ordemServicoEncontrada.setFornecedorId(rs.getInt("Fornecedor_id"));
				ordemServicoEncontrada.setEndereco(rs.getString("Endereco_os"));
				ordemServicoEncontrada.setValor(rs.getDouble("valor"));

			}

			return ordemServicoEncontrada;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar ordem de serviço por ID");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String alterarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {

		String sql = "UPDATE os SET endereco_os = ?, cliente_id = ?, fornecedor_id = ?, colaborador_id = ?, valor = ? WHERE id_ordem_servico = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);

			ps.setString(1, ordemServico.getEndereco());
			ps.setInt(2, ordemServico.getClienteId());
			ps.setInt(3, ordemServico.getFornecedorId());
			ps.setInt(4, ordemServico.getColaboradorId());
			ps.setDouble(5, ordemServico.getValor());
			ps.setLong(6, ordemServico.getId());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao atualizar ordem de serviço");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "Ordem de serviço alterada com sucesso";
	}

	public List<OrdemServicoEntity> buscarOrdemServicoFiltrada(OrdemServicoEntity ordemServico)
			throws NegocioException {

		String sql = "SELECT id_ordem_servico, cliente_id, fornecedor_id, colaborador_id, endereco_os, valor FROM os";

		List<OrdemServicoEntity> resultado = new ArrayList<OrdemServicoEntity>();

		boolean adicionaWhere = true;

		if (ordemServico.getId() != null) {
			adicionaWhere = false;
			sql += " WHERE";
			sql += " id_ordem_servico = ?";
		}
		if (ordemServico.getClienteId() != null) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += "cliente_id LIKE ?";
		}
		if (ordemServico.getFornecedorId() != null) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " fornecedor_id LIKE ?";
		}
		if (ordemServico.getColaboradorId() != null) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " colaborador_id LIKE ?";
		}
		if (ordemServico.getEndereco() != null && !ordemServico.getEndereco().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " endereco_os LIKE ?";
		}
		if (ordemServico.getValor() != null) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " valor LIKE ?";
		}
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);

			int indice = 0;

			if (ordemServico != null) {
				if (ordemServico.getId() != null) {
					indice = indice + 1;
					ps.setLong(indice, ordemServico.getId());
				}
				if (ordemServico.getClienteId() != null) {
					indice = indice + 1;
					ps.setString(indice, ordemServico.getClienteId() + "%");
				}
				if (ordemServico.getColaboradorId() != null) {
					indice = indice + 1;
					ps.setString(indice, ordemServico.getColaboradorId() + "%");
				}
				if (ordemServico.getFornecedorId() != null) {
					indice = indice + 1;
					ps.setString(indice, ordemServico.getFornecedorId() + "%");
				}
				if (ordemServico.getEndereco() != null && !ordemServico.getEndereco().equals("")) {
					indice = indice + 1;
					ps.setString(indice, ordemServico.getEndereco() + "%");
				}
				if (ordemServico.getValor() != null) {
					indice = indice + 1;
					ps.setString(indice, ordemServico.getValor() + "%");
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				OrdemServicoEntity ordemServicoResultado = new OrdemServicoEntity();
				ordemServicoResultado.setId(rs.getInt("id_ordem_servico"));
				ordemServicoResultado.setClienteId(rs.getInt("cliente_id"));
				ordemServicoResultado.setFornecedorId(rs.getInt("fornecedor_id"));
				ordemServicoResultado.setColaboradorId(rs.getInt("colaborador_id"));
				ordemServicoResultado.setEndereco(rs.getString("endereco_os"));
				ordemServicoResultado.setValor(rs.getDouble("valor"));
				resultado.add(ordemServicoResultado);
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
