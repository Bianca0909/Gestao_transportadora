package br.com.devtigestaotransportadora.bo;

import br.com.devti.gestaotransportadora.DAO.ClienteDAO;
import br.com.devti.gestaotransportadora.DAO.OrdemServicoDAO;
import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.service.OrdemServicoService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import java.util.List;

public class OrdemServicoBO {

    private void validarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {
        if (ordemServico == null) {
            throw new NegocioException("O cliente nao pode ser nulo.");
        }
        if (ordemServico.getCliente() == null || ordemServico.getCliente().equals("")) {
            throw new NegocioException("O nome do cliente deve ser preenchido.");
        }
        if (ordemServico.getValor() == null || ordemServico.getValor().equals("")) {
            throw new NegocioException("O documento do cliente deve ser preenchido.");
        }

    }
      public String salvarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {

        validarOrdemServico(ordemServico);

        OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
        return ordemServicoDAO.salvarOrdemServico(ordemServico);
    }
      
      public String alterarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {

        validarOrdemServico(ordemServico);

        return new OrdemServicoDAO().alterarOrdemServico(ordemServico);
    }

  /*  public List<OrdemServicoEntity> listarOrdensServico() throws NegocioException {
        return new OrdemServicoDAO().listarOrdensServico();
    }

    public void excluirOrdemServico(Long id) throws NegocioException {
        new OrdemServicoDAO().excluirOrdemServico(id);
    }*/

    public OrdemServicoEntity buscarOrdemServicoPorId(Long id) throws NegocioException {
        return new OrdemServicoDAO().buscarOrdemServicoPorId(id);
    }
  
    

}
