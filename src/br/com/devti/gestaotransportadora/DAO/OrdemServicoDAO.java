package br.com.devti.gestaotransportadora.DAO;

import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {

    public String salvarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {

        String sql = "INSERT INTO ordem_servico (endereco_os, cliente_id, fornecedor_id, colaborador_id, valor, veiculo) VALUES (?)";

        PreparedStatement ps = null;

        try {
            ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setString(1, ordemServico.getEndereço());
            ps.setLong(2, ordemServico.getClienteId());
            ps.setLong(3, ordemServico.getFornecedorId());
            ps.setLong(4, ordemServico.getColaboradorId());
            ps.setDouble(5, ordemServico.getValor());

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
        return "Ordem de serviço cadastrada com sucesso";
    }

    public List<OrdemServicoEntity> listarOrdensServico() throws NegocioException {

        String sql = "SELECT endereco_os, cliente_id, fornecedor_id, colaborador_id, valor FROM ordem_servico";

        PreparedStatement ps = null;
        ResultSet rs = null;

        List<OrdemServicoEntity> resultado = new ArrayList<OrdemServicoEntity>();

        try {
            ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                OrdemServicoEntity ordemServico
                        = new OrdemServicoEntity(rs.getInt("id"),
                                rs.getString("endereco"),
                                rs.getLong("cliente"),
                                rs.getLong("fornecedor"),
                                rs.getLong("colaborador"),
                                rs.getDouble("valor"));
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

    public void excluirOrdemServico(int id) throws NegocioException {

        String sql = "DELETE FROM ordemServico WHERE id_ordem_servico = ?";

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

    public OrdemServicoEntity buscarOrdemServicoPorId(int id) throws NegocioException {

        String sql = "SELECT id_cliente, nome_cliente FROM cliente WHERE id_cliente = ?";

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

        String sql = "UPDATE ordem_servico SET endereco_os, cliente_id, fornecedor_id, colaborador_id, valor WHERE id_ordem_servico = ?";

        PreparedStatement ps = null;

        try {
            ps = ConexaoMySQL.getConexao().prepareStatement(sql);
            ps.setLong(1, ordemServico.getId());
            ps.setString(2, ordemServico.getEndereço());
            ps.setLong(3, ordemServico.getClienteId());
            ps.setLong(4, ordemServico.getFornecedorId());
            ps.setLong(5, ordemServico.getColaboradorId());
            ps.setDouble(6, ordemServico.getValor());
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

}
