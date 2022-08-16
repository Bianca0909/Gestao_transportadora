package br.com.devti.gestaotransportadora.DAO;

import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        String sql = "SELECT id_fornecedor, nome_fornecedor, cnpj_fornecedor FROM fornecedor ORDER BY nome_fornecedor";

        PreparedStatement ps = null;
        ResultSet rs = null;

        List<FornecedorEntity> resultado = new ArrayList<FornecedorEntity>();

        try {
            ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                FornecedorEntity fornecedor
                        = new FornecedorEntity(rs.getInt("id_fornecedor"),
                                rs.getString("nome_fornecedor"),
                                rs.getString("cnpj_fornecedor"),
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

    public void excluirFornecedor(int id) throws NegocioException {

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

    public FornecedorEntity buscarFornecedorPorId(int id) throws NegocioException {

        String sql = "SELECT id_fornecedor, nome_fornecedor, cnpj_fornecedor FROM fornecedor WHERE id_fornecedor = ?";

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

        String sql = "UPDATE fornecedor SET nome_fornecedor, cnpj_fornecedor, data_registro_fornecedor WHERE ID_GRUPO = ?";

        PreparedStatement ps = null;

        try {
            ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setLong(1, fornecedor.getId());
            ps.setString(2, fornecedor.getName());
            ps.setString(3, fornecedor.getCnpj());
            ps.setString(4, fornecedor.getBirthday());
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

}
