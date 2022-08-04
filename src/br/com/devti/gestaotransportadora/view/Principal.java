package br.com.devti.gestaotransportadora.view;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;

public class Principal {

	public static void main(String[] args) {
		
		ClienteEntity cliente = new ClienteEntity();
		cliente.setName("Bianca");
		cliente.setCpf("11122233355544");
		cliente.setBirthday();
		cliente.setEmail("Bianca@gmail.com");
		
		

	}

}
