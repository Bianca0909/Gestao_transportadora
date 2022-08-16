package br.com.devti.gestaotransportadora.service;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devtigestaotransportadora.bo.ClienteBO;
import java.util.List;

public class ClienteService {
	
	public String salvarCliente(ClienteEntity cliente) throws NegocioException{
		ClienteBO clienteBo = new ClienteBO();
		return clienteBo.salvarCliente(cliente);
	}

    public String cadastrarCliente(ClienteEntity cliente) throws NegocioException {
        ClienteBO clienteBo = new ClienteBO();
        return clienteBo.salvarCliente(cliente);
    }

    public List<ClienteEntity> listarCliente() throws NegocioException {
        return new ClienteBO().listarClientes();
    }

    public void excluirCliente(int id) throws NegocioException {
        new ClienteBO().excluirCliente(id);
    }

    public String alterarCliente(ClienteEntity cliente) throws NegocioException {
        return new ClienteBO().alterarCliente(cliente);
    }

    public ClienteEntity buscarClientePorId(int id) throws NegocioException {
        return new ClienteBO().buscarClientePorId(id);
    }
}
