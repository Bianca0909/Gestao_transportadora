package br.com.devtigestaotransportadora.bo;

import java.util.List;

import br.com.devti.gestaotransportadora.DAO.OrdemServicoDAO;
import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class OrdemServicoBO {

	private void validarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {

		if (ordemServico.getClienteId() == null) {
			throw new NegocioException("O cliente deve ser informado.");
		}
		if (ordemServico.getValor() == null) {
			throw new NegocioException("O valor da ordem de serviço deve ser informada.");
		}

	}

	public void pagarOrdemServico(OrdemServicoEntity ordemServico) throws NegocioException {
		if (ordemServico.getValorPago() == ordemServico.getValor()) {
			ordemServico.setSituacao("PAGO");
			OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
			ordemServicoDAO.pagarOrdemServico(ordemServico);
		}
		if (ordemServico.getValorPago() > ordemServico.getValor()) {
			Double trocoOs = ordemServico.getValorPago() - ordemServico.getValor();
			ordemServico.setTroco(trocoOs);
			ordemServico.setSituacao("PAGO");
			OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
			ordemServicoDAO.pagarOrdemServico(ordemServico);
		}
		if (ordemServico.getValorPago() < ordemServico.getValor()) {
			Double restante = ordemServico.getValor() - ordemServico.getValorPago();
			ordemServico.setValorRestante(restante);
			ordemServico.setSituacao("PENDENTE");
			OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
			ordemServicoDAO.pagarOrdemServico(ordemServico);
		}
		if (ordemServico.getValorPago() == null) {
			ordemServico.setSituacao("PENDENTE");
			OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
			ordemServicoDAO.pagarOrdemServico(ordemServico);
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

	public List<OrdemServicoEntity> listarOrdensServico() throws NegocioException {
		return new OrdemServicoDAO().listarOrdensServico();
	}

	public void excluirOrdemServico(Integer id) throws NegocioException {
		new OrdemServicoDAO().excluirOrdemServico(id);
	}

	public OrdemServicoEntity buscarOrdemServicoPorId(Integer id) throws NegocioException {
		return new OrdemServicoDAO().buscarOrdemServicoPorId(id);
	}

	public List<OrdemServicoEntity> buscarOrdemServicoFiltrada(OrdemServicoEntity ordemServico)
			throws NegocioException {
		return new OrdemServicoDAO().buscarOrdemServicoFiltrada(ordemServico);
	}

}
