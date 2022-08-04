package br.com.devtigestaotransportadora.bo;

import br.com.devti.gestaotransportadora.DAO.ClienteDAO;
import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import java.util.List;

public class ClienteBO {

    private void validarCliente(ClienteEntity cliente) throws NegocioException {
        if (cliente == null) {
            throw new NegocioException("O cliente nao pode ser nulo.");
        }
        if (cliente.getName() == null || cliente.getName().equals("")) {
            throw new NegocioException("O nome do cliente deve ser preenchido.");
        }
        if (cliente.getCpf() == null || cliente.getCpf().equals("")) {
            throw new NegocioException("O documento do cliente deve ser preenchido.");
        }

    }

    public String salvarCliente(ClienteEntity cliente) throws NegocioException {

        validarCliente(cliente);

        ClienteDAO clienteDao = new ClienteDAO();
        return clienteDao.salvarCliente(cliente);
    }

    public String alterarCliente(ClienteEntity cliente) throws NegocioException {

        validarCliente(cliente);

        return new ClienteDAO().alterarCliente(cliente);
    }

    public List<ClienteEntity> listarClientes() throws NegocioException {
        return new ClienteDAO().listarClientes();
    }

    public void excluirCliente(Long id) throws NegocioException {
        new ClienteDAO().excluirCliente(id);
    }

    public ClienteEntity buscarClientePorId(Long id) throws NegocioException {
        return new ClienteDAO().buscarClientePorId(id);
    }
}
