package br.com.devti.gestaotransportadora.service;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devtigestaotransportadora.bo.ClienteBO;
import br.com.devtigestaotransportadora.bo.OrdemServicoBO;
import java.util.List;

public class OrdemServicoService {

	public String cadastrarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {
        OrdemServicoBO ordemServicoBo = new OrdemServicoBO();
        return ordemServicoBo.salvarOrdemServico(ordemServico);
    }

          public List<OrdemServicoEntity> listarOrdemServico() throws NegocioException {
        return new OrdemServicoBO().listarOrdensServico();
    }
	 public void excluirOrdemServico(Long id) throws NegocioException {
        new OrdemServicoBO().excluirOrdemServico(id);
    }

    public String alterarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {
        return new OrdemServicoBO().alterarOrdemServico(ordemServico);
    }

    public OrdemServicoEntity buscarOrdemServicoPorId(Long id) throws NegocioException {
        return new OrdemServicoBO().buscarOrdemServicoPorId(id);
    }
}
