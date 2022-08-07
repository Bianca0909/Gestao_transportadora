package br.com.devti.gestaotransportadora.view;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;

public class Principal {

	public static void main(String[] args) {
		
		ClienteEntity cliente = new ClienteEntity();
		cliente.setName("Bianca");
		cliente.setCpf("11122233355544");
		cliente.setBirthday();
		cliente.setEmail("Bianca@gmail.com");
		
                ColaboradorEntity colaborador = new ColaboradorEntity();
                colaborador.setName("Jorgezinho");
                colaborador.setCpf("22233355566");
                colaborador.setPis("222.333222.66-99");
                colaborador.setBirthday(" ");
		
                FornecedorEntity fornecedor = new FornecedorEntity();
                fornecedor.setName("Maria drogaria LTDA");
                fornecedor.setCnpj("20.278.683/0001-50");
                fornecedor.setBirthday(" ");
                
               
	}

}
