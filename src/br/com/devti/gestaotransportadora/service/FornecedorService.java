package br.com.devti.gestaotransportadora.service;

import java.util.List;

import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devtigestaotransportadora.bo.FornecedorBO;

public class FornecedorService {
	

	  public String cadastrarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
        FornecedorBO fornecedorBo = new FornecedorBO();
        return fornecedorBo.salvarFornecedor(fornecedor);
    }

    public List<FornecedorEntity> listarFornecedor() throws NegocioException {
        return new FornecedorBO().listarFornecedores();
    }

    public void excluirColaborador(Integer id) throws NegocioException {
        new FornecedorBO().excluirFornecedor(id);
    }

    public String alterarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
        return new FornecedorBO().alterarFornecedor(fornecedor);
    }

    public FornecedorEntity buscarFornecedorPorId(Integer id) throws NegocioException {
        return new FornecedorBO().buscarFornecedorPorId(id);
    }
    
    public List<FornecedorEntity> buscarUsuarioFiltrado(FornecedorEntity fornecedor) throws NegocioException {
    	return new FornecedorBO().buscarUsuarioFiltrado(fornecedor);
    	}
}
