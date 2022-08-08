package br.com.devti.gestaotransportadora.view;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.service.ColaboradorService;
import br.com.devti.gestaotransportadora.service.FornecedorService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		ClienteEntity cliente = new ClienteEntity();
		cliente.setName("Bianca");
		cliente.setCpf("11122233355544");
		cliente.setBirthday();
		cliente.setEmail("Bianca@gmail.com");
                try {
			JOptionPane.showMessageDialog(null, 
					new ClienteService().cadastrarCliente(cliente));
		}  catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		ColaboradorEntity colaborador = new ColaboradorEntity();
		colaborador.setName("Jorgezinho");
		colaborador.setCpf("22233355566");
		colaborador.setPis("222.333222.66-99");
		colaborador.setBirthday(" ");

                try {
			JOptionPane.showMessageDialog(null, 
					new ColaboradorService().cadastrarColaborador(colaborador));
		}  catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
                
		FornecedorEntity fornecedor = new FornecedorEntity();
		fornecedor.setName("Maria drogaria LTDA");
		fornecedor.setCnpj("20.278.683/0001-50");
		fornecedor.setBirthday(" ");
		
                try {
			JOptionPane.showMessageDialog(null, 
					new FornecedorService().cadastrarFornecedor(fornecedor));
		}  catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

}
