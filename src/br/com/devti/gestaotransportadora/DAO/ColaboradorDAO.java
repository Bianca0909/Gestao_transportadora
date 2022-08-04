package br.com.devti.gestaotransportadora.DAO;

import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        String sql = "SELECT id_colaborador, nome_colaborador, pis_colaborador FROM colaborador ORDER BY nome_colaborador";

        PreparedStatement ps = null;
        ResultSet rs = null;

        List<ColaboradorEntity> resultado = new ArrayList<ColaboradorEntity>();

        try {
            ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ColaboradorEntity colaborador
                        = new ColaboradorEntity(rs.getLong("id_colaborador"),
                                rs.getString("nome_colaborador"),
                                rs.getString("cpf_colaborador"),
                                rs.getString("data_nascimento_colaborador"),
                                rs.getString("pis_colaborador"));
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

    public void excluirColaborador(Long id) throws NegocioException {

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

    public ColaboradorEntity buscarColaboradorPorId(Long id) throws NegocioException {

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
                colaboradorEncontrado.setId(rs.getLong("id_colaborador"));
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

        String sql = "UPDATE colaborador SET nome_colaborador, cpf_colaborador, data_nascimento_colaborador, pis_colaborador WHERE ID_GRUPO = ?";

        PreparedStatement ps = null;

        try {
            ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setLong(1, colaborador.getId());
            ps.setString(2, colaborador.getName());
            ps.setString(3, colaborador.getCpf());
            ps.setString(4, colaborador.getBirthday());
            ps.setString(5, colaborador.getPis());
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
}
