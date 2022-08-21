package br.com.devti.gestaotransportadora.view;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.entity.UsuarioEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.service.ColaboradorService;
import br.com.devti.gestaotransportadora.service.FornecedorService;
import br.com.devti.gestaotransportadora.service.OrdemServicoService;
import br.com.devti.gestaotransportadora.service.UsuarioService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class Principal {

	public static void main(String[] args) {

		// -------------------------------TESTES--------------------------

		// ------------------------------CADASTRAR-------------------------

//		ClienteEntity cliente = new ClienteEntity();
//		cliente.setName("Maria");
//		cliente.setCpf("11122233355");
//		cliente.setEmail("Maria@gmail.com");
//		cliente.setBirthday("01-01-2022");
//
//		try {
//			new ClienteService().cadastrarCliente(cliente);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		ColaboradorEntity colaborador = new ColaboradorEntity();
//		colaborador.setName("João");
//		colaborador.setCpf("11122255566");
//		colaborador.setBirthday("01-01-1995");
//		colaborador.setPis("111.222.555-66");
//
//		try {
//			new ColaboradorService().cadastrarColaborador(colaborador);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		FornecedorEntity fornecedor = new FornecedorEntity();
//		fornecedor.setName("Distribuidora Teste");
//		fornecedor.setCnpj("111.222.555/0001-65");
//		fornecedor.setBirthday("01-01-1900");
//
//		try {
//			new FornecedorService().cadastrarFornecedor(fornecedor);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		UsuarioEntity usuario = new UsuarioEntity();
//		usuario.setLogin("ADMIN");
//		usuario.setSenha("ADMIN");
//
//		try {
//			new UsuarioService().cadastrarUsuario(usuario);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		OrdemServicoEntity os = new OrdemServicoEntity(); 
//		os.setClienteId(17);
//		os.setFornecedorId(3);
//		os.setColaboradorId(5);
//		os.setEndereco("Rua Teste, Cidade teste, CEP 88701-000");
//		os.setValor(50.00);
//		
//
//		try {
//			new OrdemServicoService().cadastrarOrdemServico(os);
//		} catch (NegocioException e) {
//			e.printStackTrace();
//		}

		// ------------------------------EXCLUIR-------------------------

//		try {
//			new ClienteService().excluirCliente(1);
//		} catch (NegocioException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			new ColaboradorService().excluirColaborador(1);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			new FornecedorService().excluirColaborador(1);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			new OrdemServicoService().excluirOrdemServico(1);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		try {
//			new UsuarioService().excluirUsuario(1);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// ------------------------------ALTERAR-------------------------
//		ClienteEntity clienteAlterado = new ClienteEntity();
//		clienteAlterado.setId(8);
//		clienteAlterado.setName("José");
//		clienteAlterado.setEmail("jose@email.com");
//		clienteAlterado.setBirthday("01-02-1995");
//		clienteAlterado.setCpf("111.222.555-88");
//
//		try {
//			new ClienteService().alterarCliente(clienteAlterado);
//		} catch (NegocioException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
////        UsuarioEntity usuarioAlterado = new UsuarioEntity();
////        usuarioAlterado.setId(2);
////        usuarioAlterado.setLogin("AAAA@123");
////        usuarioAlterado.setSenha("444666");
////	   try {
////		new UsuarioService().alterarUsuario(usuarioAlterado);
////	} catch (NegocioException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
//		
//	 ColaboradorEntity colaboradorAlterado = new ColaboradorEntity();
//	 colaboradorAlterado.setId(2);
//	 colaboradorAlterado.setName("Júlia");
//	 colaboradorAlterado.setCpf("11122255566");
//	 colaboradorAlterado.setBirthday("01-01-1995");
//	 colaboradorAlterado.setPis("111.222.555-66");
//	 try {
//		new ColaboradorService().alterarColaborador(colaboradorAlterado);
//	} catch (NegocioException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	 
//	 FornecedorEntity fornecedorAlterado = new FornecedorEntity();
//	 fornecedorAlterado.setId(2);
//	 fornecedorAlterado.setName("Distribuidora nova");
//	 fornecedorAlterado.setCnpj("111.222.333-55");
//	 fornecedorAlterado.setBirthday("01-01-2022");
//	 
//	 try {
//		new FornecedorService().alterarFornecedor(fornecedorAlterado);
//	} catch (NegocioException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		
//		OrdemServicoEntity osAlterado = new OrdemServicoEntity();
//		osAlterado.setEndereco("Rua Teste");
//		osAlterado.setClienteId(5);
//		osAlterado.setFornecedorId(5);
//		osAlterado.setColaboradorId(5);
//		osAlterado.setValor(60.00);
//		osAlterado.setId(2);
//	 
//		try {
//			new OrdemServicoService().alterarOrdemServico(osAlterado);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
