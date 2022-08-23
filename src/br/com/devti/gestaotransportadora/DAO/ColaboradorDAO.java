package br.com.devti.gestaotransportadora.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;

public class ColaboradorDAO {

	public String salvarColaborador(ColaboradorEntity colaborador) throws NegocioException {

		String sql = "INSERT INTO colaborador (nome_colaborador, cpf_colaborador, data_nascimento_colaborador, pis_colaborador) VALUES (?, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, colaborador.getName());
			ps.setString(2, colaborador.getCpf());
			ps.setString(3, colaborador.getBirthday());
			ps.setString(4, colaborador.getPis());

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
		return "Grupo de Usuário cadastrado com sucesso";
	}

	public List<ColaboradorEntity> listarColaboradores() throws NegocioException {

		String sql = "SELECT id_colaborador, nome_colaborador, cpf_colaborador, pis_colaborador, data_nascimento_colaborador FROM colaborador ORDER BY nome_colaborador";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<ColaboradorEntity> resultado = new ArrayList<ColaboradorEntity>();

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ColaboradorEntity colaborador = new ColaboradorEntity(rs.getInt("id_colaborador"),
						rs.getString("nome_colaborador"), rs.getString("data_nascimento_colaborador"), rs.getString("pis_colaborador"), rs.getString("cpf_colaborador"));
				resultado.add(colaborador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao listar colaborador");
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

	public void excluirColaborador(Integer id) throws NegocioException {

		String sql = "DELETE FROM colaborador WHERE id_colaborador = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao excluir colaborador");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ColaboradorEntity buscarColaboradorPorId(Integer id) throws NegocioException {

		String sql = "SELECT id_colaborador, nome_colaborador, pis_colaborador FROM colaborador WHERE id_colaborador = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ColaboradorEntity colaboradorEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				colaboradorEncontrado = new ColaboradorEntity();
				colaboradorEncontrado.setId(rs.getInt("id_colaborador"));
				colaboradorEncontrado.setName(rs.getString("nome_colaborador"));
				colaboradorEncontrado.setPis(rs.getString("pis_colaborador"));
			}

			return colaboradorEncontrado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar colaborador por ID");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String alterarColaborador(ColaboradorEntity colaborador) throws NegocioException {

		String sql = "UPDATE colaborador SET nome_colaborador = ? , cpf_colaborador = ?, data_nascimento_colaborador = ?, pis_colaborador = ? WHERE id_colaborador = ?";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
		
			ps.setString(1, colaborador.getName());
			ps.setString(2, colaborador.getCpf());
			ps.setString(3, colaborador.getBirthday());
			ps.setString(4, colaborador.getPis());
			ps.setLong(5, colaborador.getId());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao atualizar colaborador");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "Colaborador alterado com sucesso";
	}

	public List<ColaboradorEntity> buscarUsuarioFiltrado(ColaboradorEntity colaborador) throws NegocioException {

		String sql = "SELECT id_colaborador, nome_colaborador, cpf_colaborador, data_nascimento_colaborador, psi_colaborador FROM colaborador";

		List<ColaboradorEntity> resultado = new ArrayList<ColaboradorEntity>();

		boolean adicionaWhere = true;

		if (colaborador.getId() != null) {
			adicionaWhere = false;
			sql += " WHERE";
			sql += " id_usuario = ?";
		}
		if (colaborador.getName() != null && !colaborador.getName().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " nome_colaborador LIKE ?";
		}
		if (colaborador.getCpf() != null && !colaborador.getCpf().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " cpf_colaborador LIKE ?";
		}
		if (colaborador.getBirthday() != null && !colaborador.getBirthday().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " data_nascimento_colaborador LIKE ?";
		}
		if (colaborador.getPis() != null && !colaborador.getPis().equals("")) {
			if (adicionaWhere) {
				sql += " WHERE ";
				adicionaWhere = false;
			} else {
				sql += " AND";
			}
			sql += " pis_colaborador LIKE ?";
		}
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);

			int indice = 0;

			if (colaborador != null) {
				if (colaborador.getId() != null) {
					indice = indice + 1;
					ps.setLong(indice, colaborador.getId());
				}
				if (colaborador.getName() != null && !colaborador.getName().equals("")) {
					indice = indice + 1;
					ps.setString(indice, colaborador.getName() + "%");
				}
				if (colaborador.getCpf() != null && !colaborador.getCpf().equals("")) {
					indice = indice + 1;
					ps.setString(indice, colaborador.getCpf() + "%");
				}
				if (colaborador.getBirthday() != null && !colaborador.getBirthday().equals("")) {
					indice = indice + 1;
					ps.setString(indice, colaborador.getBirthday() + "%");
				}
				if (colaborador.getPis() != null && !colaborador.getPis().equals("")) {
					indice = indice + 1;
					ps.setString(indice, colaborador.getPis() + "%");
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				ColaboradorEntity colaboradorResultado = new ColaboradorEntity();
				colaboradorResultado.setId(rs.getInt("id_usuario"));
				colaboradorResultado.setName(rs.getString("nome_colaborador"));
				colaboradorResultado.setCpf(rs.getString("cpf_colaborador"));
				colaboradorResultado.setBirthday(rs.getString("data_nascimento_colaborador"));
				colaborador.setPis(rs.getString("pis_colaborador"));
				resultado.add(colaboradorResultado);
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
