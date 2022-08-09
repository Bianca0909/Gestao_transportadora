package br.com.devti.gestaotransportadora.view;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class Principal {

	public static void main(String[] args) throws NegocioException {

		ClienteEntity cl = new ClienteEntity();
		cl.setName("Bianca");
		cl.setEmail("Bianca@gmail.com");
		cl.setBirthday("05-05-2004");
		cl.setCpf("11122233355544");
		try {
			JOptionPane.showMessageDialog(null, new ClienteService().salvarCliente(cl));
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		List<ClienteEntity> clientes;
		try {
			clientes = new ClienteService().listarCliente();
			for (ClienteEntity clienteEntity : clientes) {
				System.out.println("Nome " + clienteEntity.getName() + " - Código " + clienteEntity.getId());
			}
		} catch (NegocioException e) {
			e.printStackTrace();
		}

		/*
		 * try { new ClienteService().excluirCliente(10); } catch (NegocioException e) {
		 * e.printStackTrace(); }
		 * 
		 * }
		 */
	}
}