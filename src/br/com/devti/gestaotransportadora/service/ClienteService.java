package br.com.devti.gestaotransportadora.service;

import java.util.List;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devtigestaotransportadora.bo.ClienteBO;

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

    public void excluirCliente(Integer id) throws NegocioException {
        new ClienteBO().excluirCliente(id);
    }

    public String alterarCliente(ClienteEntity cliente) throws NegocioException {
        return new ClienteBO().alterarCliente(cliente);
    }

    public ClienteEntity buscarClientePorId(Integer id) throws NegocioException {
        return new ClienteBO().buscarClientePorId(id);
    }
    public List<ClienteEntity> buscarClienteFiltrado(ClienteEntity cliente) throws NegocioException {
    	return new ClienteBO().buscarClienteFiltrado(cliente);
    	}
}
