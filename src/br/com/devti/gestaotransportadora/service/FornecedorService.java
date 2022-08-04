package br.com.devti.gestaotransportadora.service;

import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devtigestaotransportadora.bo.ColaboradorBO;
import br.com.devtigestaotransportadora.bo.FornecedorBO;
import java.util.List;

public class FornecedorService {
	

	  public String cadastrarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
        FornecedorBO fornecedorBo = new FornecedorBO();
        return fornecedorBo.salvarFornecedor(fornecedor);
    }

    public List<FornecedorEntity> listarFornecedor() throws NegocioException {
        return new FornecedorBO().listarFornecedores();
    }

    public void excluirColaborador(Long id) throws NegocioException {
        new FornecedorBO().excluirFornecedor(id);
    }

    public String alterarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
        return new FornecedorBO().alterarFornecedor(fornecedor);
    }

    public FornecedorEntity buscarFornecedorPorId(Long id) throws NegocioException {
        return new FornecedorBO().buscarFornecedorPorId(id);
    }

}
