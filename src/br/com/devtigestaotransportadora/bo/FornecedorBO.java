package br.com.devtigestaotransportadora.bo;

import br.com.devti.gestaotransportadora.DAO.ColaboradorDAO;
import br.com.devti.gestaotransportadora.DAO.FornecedorDAO;
import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import java.util.List;

public class FornecedorBO {

    private void validarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
        if (fornecedor == null) {
            throw new NegocioException("O fornecedor nao pode ser nulo.");
        }
        if (fornecedor.getName() == null || fornecedor.getName().equals("")) {
            throw new NegocioException("O nome do fornecedor deve ser preenchido.");
        }
        if (fornecedor.getCnpj() == null || fornecedor.getCnpj().equals("")) {
            throw new NegocioException("O documento do fornecedor deve ser preenchido.");
        }

    }

    public String salvarFornecedor(FornecedorEntity fornecedor) throws NegocioException {

        validarFornecedor(fornecedor);

        FornecedorDAO fornecedorDao = new FornecedorDAO();
        return fornecedorDao.salvarFornecedor(fornecedor);
    }

    public String alterarFornecedor(FornecedorEntity fornecedor) throws NegocioException {

        validarFornecedor(fornecedor);

        return new FornecedorDAO().alterarFornecedor(fornecedor);
    }

    public List<FornecedorEntity> listarFornecedores() throws NegocioException {
        return new FornecedorDAO().listarFornecedores();
    }
    public void excluirFornecedor(int id) throws NegocioException {
        new FornecedorDAO().excluirFornecedor(id);
    }
    
     public FornecedorEntity buscarFornecedorPorId(int id) throws NegocioException {
        return new FornecedorDAO().buscarFornecedorPorId(id);
    }
}
