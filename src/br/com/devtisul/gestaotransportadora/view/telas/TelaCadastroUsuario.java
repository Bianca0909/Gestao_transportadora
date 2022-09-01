package br.com.devtisul.gestaotransportadora.view.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.com.devti.gestaotransportadora.entity.UsuarioEntity;
import br.com.devti.gestaotransportadora.service.UsuarioService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JTextField senhaField;
	private JTextField codigoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon("C:\\Users\\manutencao\\Desktop\\Gestão_de_Transportadora-removebg-preview.png"));

		JLabel loginLabel = new JLabel("Login:");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel senhaLabel = new JLabel("Senha:");
		senhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		loginField = new JTextField();
		loginField.setColumns(10);

		senhaField = new JTextField();
		senhaField.setColumns(10);

		JButton voltarButton = new JButton("VOLTAR");
		voltarButton.setBackground(Color.ORANGE);
		voltarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMenuCadastro menuCadastro = new TelaMenuCadastro();
				menuCadastro.setVisible(true);
				dispose();
			}
		});

		JButton sairButton = new JButton("SAIR");
		sairButton.setBackground(Color.RED);
		sairButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JLabel lblNewLabel_3 = new JLabel("");

		JLabel lblNewLabel_4 = new JLabel("Cadastro de usuários");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setBackground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));

		JButton salvarButton = new JButton("SALVAR");
		salvarButton.setBackground(Color.GREEN);

		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuario = new UsuarioEntity();
				usuario.setLogin(loginField.getText());
				usuario.setSenha(senhaField.getText());

				try {
					if (codigoField.getText().equals("")) {
						new UsuarioService().salvarUsuario(usuario);

					} else {
						usuario.setId(Integer.parseInt(codigoField.getText()));
						new UsuarioService().alterarUsuario(usuario);
					}
					limparCampos();
					JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");

				} catch (NegocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		codigoField = new JTextField();
		codigoField.setColumns(10);

		JLabel codigoLabel = new JLabel("Código:");
		codigoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(374, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3).addGap(250))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(190)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 215,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(219, Short.MAX_VALUE))
						.addGroup(gl_contentPane
								.createSequentialGroup().addContainerGap(106, Short.MAX_VALUE).addComponent(lblNewLabel)
								.addGap(73))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(56)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(72)
												.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 101,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
												.addComponent(salvarButton, GroupLayout.PREFERRED_SIZE, 104,
														GroupLayout.PREFERRED_SIZE)
												.addGap(30)
												.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 91,
														GroupLayout.PREFERRED_SIZE)
												.addGap(136))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(codigoLabel).addComponent(loginLabel)
														.addComponent(senhaLabel))
												.addGap(18)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addComponent(senhaField)
														.addComponent(codigoField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(loginField, 156, 156, Short.MAX_VALUE))
												.addGap(332)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_3)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_4)
										.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
										.addComponent(codigoField, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
								.addComponent(codigoLabel))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(loginLabel)
								.addComponent(loginField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(senhaLabel)
								.addComponent(senhaField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(98)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(salvarButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(24)));
		contentPane.setLayout(gl_contentPane);
	}

	private void limparCampos() {
		codigoField.setText("");
		loginField.setText("");
		senhaField.setText("");

	}

	public void carregarUsuarioPorId(Integer id) {
		try {
			UsuarioEntity usuarioEncontrado = new UsuarioService().buscarUsuarioPorId(id);

			if (usuarioEncontrado == null) {
				JOptionPane.showMessageDialog(null, "Usuário não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				codigoField.setText(Integer.toString(usuarioEncontrado.getId()));
				loginField.setText(usuarioEncontrado.getLogin());
				senhaField.setText(usuarioEncontrado.getSenha());

			}

		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
