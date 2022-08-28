package br.com.devti.gestaotransportadora.view;

import java.util.List;

import javax.swing.JOptionPane;

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

		// ------------------------------LISTAR-------------------------
	
//		  List<UsuarioEntity> usuarios;
//		  
//		  try { usuarios= new UsuarioService().listarUsuario(); for(UsuarioEntity
//		  usuarioEntity: usuarios) { System.out.println("Código: " +
//		  usuarioEntity.getId() + "| Login: " + usuarioEntity.getLogin()); }
//		 
//		 } catch (NegocioException e) { // TODO Auto-generated catch block
//		 e.printStackTrace(); } List<ClienteEntity> clientes;
//		  
//		  try { clientes = new ClienteService().listarCliente(); for(ClienteEntity
//		  clienteEntity: clientes) { System.out.println("Código: " +
//		  clienteEntity.getId() + "| Nome: " + clienteEntity.getName() +
//		 "| Documento: " + clienteEntity.getCpf() + "| Email: " +
//		  clienteEntity.getEmail() + "| Data de nascimento: " +
//		  clienteEntity.getBirthday()); } } catch (NegocioException e) { // TODO
//		  Auto-generated catch block e.printStackTrace(); }
//		  
//		  List<ColaboradorEntity> colaboradores;
//		  
//		  try { colaboradores = new ColaboradorService().listarColaborador();
//		  for(ColaboradorEntity colaboradorEntity: colaboradores) {
//		  System.out.println("Código: " + colaboradorEntity.getId()+ "| Nome: " +
//		  colaboradorEntity.getName() + "| Documento: " + colaboradorEntity.getCpf() +
//		  "| Pis: " + colaboradorEntity.getPis() + "| Data de nascimento: " +
//		  colaboradorEntity.getBirthday()); } } catch (NegocioException e) { // TODO
//		  Auto-generated catch block e.printStackTrace(); } List<FornecedorEntity>
//		  fornecedores;
//		
//		  try { fornecedores = new FornecedorService().listarFornecedor();
//		  for(FornecedorEntity fornecedorEntity: fornecedores) {
//		  System.out.println("Código: " + fornecedorEntity.getId() + "| Nome: " +
//		  fornecedorEntity.getName() + "| Documento: " + fornecedorEntity.getCnpj() +
//		  "| Data de registro:" + fornecedorEntity.getBirthday()); } } catch
//		  (NegocioException e) { // TODO Auto-generated catch block
//		  e.printStackTrace(); }
//		 
//		  List<OrdemServicoEntity> ordensServico;
//		  
//		  try { ordensServico = new OrdemServicoService().listarOrdemServico();
//		  for(OrdemServicoEntity ordemServicoEntity: ordensServico) {
//		  System.out.println("Código: " + ordemServicoEntity.getId() + "| Cliente: " +
//		  ordemServicoEntity.getClienteId() + " | Colaborador: " +
//		  ordemServicoEntity.getColaboradorId() + "| Fornecedor: " +
//		  ordemServicoEntity.getFornecedorId() + "| Endereço: " +
//		  ordemServicoEntity.getEndereco() + "| Valor: " +
//		  ordemServicoEntity.getValor()); } } catch (NegocioException e) { // TODO
//		  Auto-generated catch block e.printStackTrace(); }
		
		// ----------------------------BUSCAR POR ID-------------------------
		
//		  try { UsuarioEntity usuarioEncontrado = new
//		  UsuarioService().buscarUsuarioPorId(1); JOptionPane.showMessageDialog(null,
//		  "Usuário encontrado: " + usuarioEncontrado.getLogin()); } catch
//		  (NegocioException e) { // TODO Auto-generated catch block
//		  e.printStackTrace(); }
//		 
//		
//		  try { ClienteEntity clienteEncontrado = new
//		  ClienteService().buscarClientePorId(2); JOptionPane.showMessageDialog(null,
//		  "Cliente encontrado: " + clienteEncontrado.getName()); } catch
//		  (NegocioException e) { // TODO Auto-generated catch block
//		  e.printStackTrace(); }
//		 
//		
//		  try { ColaboradorEntity colaboradorEncontrado = new
//		  ColaboradorService().buscarColaboradorPorId(2);
//		  JOptionPane.showMessageDialog(null, "Colaborador encontrado: " +
//		  colaboradorEncontrado.getName()); } catch (NegocioException e) { // TODO
//		  Auto-generated catch block e.printStackTrace(); }
//		 
//
//		
//		  try { FornecedorEntity fornecedorEncontrado = new
//		  FornecedorService().buscarFornecedorPorId(2);
//		  JOptionPane.showMessageDialog(null, "Fornecedor encontrado: " +
//		  fornecedorEncontrado.getName()); } catch (NegocioException e) { // TODO
//		  Auto-generated catch block e.printStackTrace(); }
//		 
//		
//		  try { OrdemServicoEntity osEncontrada = new
//		  OrdemServicoService().buscarOrdemServicoPorId(3);
//		  JOptionPane.showMessageDialog(null, "Ordem de serviço encontrada: " +
//		  osEncontrada.getValor()); } catch (NegocioException e) { // TODO
//		  Auto-generated catch block e.printStackTrace(); }
		 
		// ----------------------------PESQUISA FILTRADA------------------------
//		
//		 UsuarioEntity usuarioFiltro = new UsuarioEntity();
//		  usuarioFiltro.setLogin("Maria@123");
//		  
//		  try {
//		  
//		  List<UsuarioEntity> resultado = new
//		 UsuarioService().buscarUsuarioFiltrado(usuarioFiltro); for(UsuarioEntity
//		  usuarioEntity: resultado) { System.out.println("Nome: " +
//		  usuarioEntity.getLogin()); } } catch (NegocioException e) { // TODO
//		  Auto-generated catch block e.printStackTrace(); }
//		 
//		
//		  ClienteEntity clienteFiltro = new ClienteEntity();
//		  clienteFiltro.setName("Bianca");
//		  
//		  try {
//		  
//		  List<ClienteEntity> resultadoCliente = new
//		  ClienteService().buscarUsuarioFiltrado(clienteFiltro); for(ClienteEntity
//		  clienteEntity: resultadoCliente) { System.out.println("Nome: " +
//		  clienteEntity.getName()); } } catch (NegocioException e) { // TODO
//		  Auto-generated catch block e.printStackTrace(); }
//		 
//		
//		  FornecedorEntity fornecedorFiltro = new FornecedorEntity();
//		  fornecedorFiltro.setName("Distribuidora");
//		  
//		  try {
//		  
//		  List<FornecedorEntity> resultadoFornecedor = new
//		  FornecedorService().buscarUsuarioFiltrado(fornecedorFiltro);
//		  for(FornecedorEntity fornecedorEntity: resultadoFornecedor) {
//		  System.out.println("Nome: " + fornecedorEntity.getName()); } } catch
//		  (NegocioException e) { // TODO Auto-generated catch block
//		  e.printStackTrace(); }
//		 

//		
//		  ColaboradorEntity colaboradorFiltro = new ColaboradorEntity();
//		  colaboradorFiltro.setName("Júlia");
//		  
//		  try {
//		  
//		  List<ColaboradorEntity> resultadoColaborador = new
//		  ColaboradorService().buscarColaboradorFiltrado(colaboradorFiltro);
//		  for(ColaboradorEntity colaboradorEntity: resultadoColaborador) {
//		  System.out.println("Nome: " + colaboradorEntity.getName()); } } catch
//		  (NegocioException e) { // TODO Auto-generated catch block
//		  e.printStackTrace(); }
//		 
//
//		OrdemServicoEntity ordemServicoFiltro = new OrdemServicoEntity();
//		ordemServicoFiltro.setValor(50.00);
//		
//		try {
//			List<OrdemServicoEntity> resultadoOs = new OrdemServicoService()
//					.buscarOrdemServicoFiltrada(ordemServicoFiltro);
//			for (OrdemServicoEntity ordemServicoEntity : resultadoOs) {
//				System.out.println("| Valor: " + ordemServicoEntity.getValor());
//			}
//		} catch (NegocioException e) { // TODO Auto-generated catch block
//			e.printStackTrace();
//		}

}}
