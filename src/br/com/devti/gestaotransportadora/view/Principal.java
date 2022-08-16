package br.com.devti.gestaotransportadora.view;

import br.com.devti.gestaotransportadora.entity.UsuarioEntity;
import br.com.devti.gestaotransportadora.service.UsuarioService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class Principal {

	public static void main(String[] args) {

		/*
		 * ClienteEntity cliente = new ClienteEntity(); cliente.setName("Bianca");
		 * cliente.setCpf("11122233355544"); cliente.setBirthday(" ");
		 * cliente.setEmail("Bianca@gmail.com"); try {
		 * JOptionPane.showMessageDialog(null, new
		 * ClienteService().cadastrarCliente(cliente)); } catch (NegocioException e) {
		 * JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro",
		 * JOptionPane.ERROR_MESSAGE); }
		 * 
		 * /* try { new ClienteService().excluirCliente(10); } catch (NegocioException
		 * e) { e.printStackTrace(); }
		 * 
		 * }
		 */
//
//		ClienteEntity clienteAlterado = new ClienteEntity();
//
//		clienteAlterado.SetId(13);
//		clienteAlterado.setName("Maria");
//		clienteAlterado.setBirthday("01-01-1995");
//		clienteAlterado.setCpf("111.222.333-55");
//		clienteAlterado.setEmail("Maria@gmail.com");
//		try {
//			new ClienteService().alterarCliente(clienteAlterado);
//
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			ClienteEntity clienteEncontrado = new ClienteService().buscarClientePorId(11);
//			JOptionPane.showMessageDialog(null, clienteEncontrado.getName());
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		UsuarioEntity usuario = new UsuarioEntity();
//		usuario.setLogin("Maria@123");
//		usuario.setSenha("12345678");
//		try {
//			new UsuarioService().cadastrarUsuario(usuario);
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		UsuarioEntity usuarioFiltro = new UsuarioEntity();
		usuarioFiltro.setLogin("Maria@123");
		try {
			new UsuarioService().buscarUsuarioFiltrado(usuarioFiltro);
		} catch (NegocioException e) {
			e.printStackTrace();
		}

	}
}
