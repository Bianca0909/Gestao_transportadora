package br.com.devti.gestaotransportadora.service;

import java.util.List;

import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devtigestaotransportadora.bo.OrdemServicoBO;

public class OrdemServicoService {

	public String cadastrarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {
		OrdemServicoBO ordemServicoBo = new OrdemServicoBO();
		return ordemServicoBo.salvarOrdemServico(ordemServico);
	}

	public List<OrdemServicoEntity> listarOrdemServico() throws NegocioException {
		return new OrdemServicoBO().listarOrdensServico();
	}

	public void excluirOrdemServico(Integer id) throws NegocioException {
		new OrdemServicoBO().excluirOrdemServico(id);
	}

	public String alterarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {
		return new OrdemServicoBO().alterarOrdemServico(ordemServico);
	}

	public OrdemServicoEntity buscarOrdemServicoPorId(Integer id) throws NegocioException {
		return new OrdemServicoBO().buscarOrdemServicoPorId(id);
	}

	public List<OrdemServicoEntity> buscarOrdemServicoFiltrada(OrdemServicoEntity ordemServico)
			throws NegocioException {
		return new OrdemServicoBO().buscarOrdemServicoFiltrada(ordemServico);
	}
}
