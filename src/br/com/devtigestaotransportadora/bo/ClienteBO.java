package br.com.devtigestaotransportadora.bo;

import java.util.List;

import br.com.devti.gestaotransportadora.DAO.ClienteDAO;
import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class ClienteBO {

    private void validarCliente(ClienteEntity cliente) throws NegocioException {
        if (cliente.getName() == null || cliente.getName().equals("")) {
            throw new NegocioException("O nome do cliente deve ser preenchido.");
        }
        if (cliente.getCpf() == null || cliente.getCpf().equals("")) {
            throw new NegocioException("O documento do cliente deve ser preenchido.");
        }
        if (cliente.getBirthday() == null || cliente.getBirthday().equals("")) {
        	throw new NegocioException("A data de nascimento do cliente deve ser preenchido.");
        }
        if (cliente.getEmail() == null || cliente.getEmail().equals("")) {
        	throw new NegocioException("A data de nascimento do cliente deve ser preenchido.");
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

    public void excluirCliente(Integer id) throws NegocioException {
        new ClienteDAO().excluirCliente(id);
    }

    public ClienteEntity buscarClientePorId(Integer id) throws NegocioException {
        return new ClienteDAO().buscarClientePorId(id);
    }
    public List<ClienteEntity> buscarClienteFiltrado(ClienteEntity cliente) throws NegocioException {
    	return new ClienteDAO().buscarUsuarioFiltrado(cliente);
    }
}
