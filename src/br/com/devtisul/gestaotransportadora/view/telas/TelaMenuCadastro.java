package br.com.devtisul.gestaotransportadora.view.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuCadastro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuCadastro frame = new TelaMenuCadastro();
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
	public TelaMenuCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon("C:\\Users\\manutencao\\Desktop\\Gestão_de_Transportadora-removebg-preview.png"));

		JLabel lblNewLabel_1 = new JLabel("Cadastros");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));

		JButton cadastroClienteButton = new JButton("CLIENTE");
		cadastroClienteButton.setBackground(Color.CYAN);
		cadastroClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente cadastroCliente = new TelaCadastroCliente();
				cadastroCliente.setVisible(true);
				dispose();

			}
		});

		JButton cadastroFornecedorButton = new JButton("FORNECEDOR");
		cadastroFornecedorButton.setBackground(Color.PINK);
		cadastroFornecedorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFornecedor cadastroFornecedor = new TelaCadastroFornecedor();
				cadastroFornecedor.setVisible(true);
				dispose();

			}
		});

		JButton cadastroUsuarioButton = new JButton("USUARIO");
		cadastroUsuarioButton.setBackground(Color.YELLOW);
		cadastroUsuarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
				cadastroUsuario.setVisible(true);
				dispose();

			}
		});

		JButton cadastroColaboradorButton = new JButton("COLABORADOR");
		cadastroColaboradorButton.setBackground(Color.MAGENTA);
		cadastroColaboradorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroColaborador cadastroColaborador = new TelaCadastroColaborador();
				cadastroColaborador.setVisible(true);
				dispose();
			}
		});

		JButton voltarButton = new JButton("VOLTAR");
		voltarButton.setBackground(Color.ORANGE);
		voltarButton.setForeground(Color.BLACK);
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu menu = new TelaMenu();
				menu.setVisible(true);
				dispose();

			}
		});

		JButton sairButton = new JButton("SAIR");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		sairButton.setBackground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(55).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(cadastroClienteButton, GroupLayout.PREFERRED_SIZE, 124,
										GroupLayout.PREFERRED_SIZE)
								.addGap(41)
								.addComponent(cadastroUsuarioButton, GroupLayout.PREFERRED_SIZE, 128,
										GroupLayout.PREFERRED_SIZE)
								.addGap(39)
								.addComponent(cadastroColaboradorButton, GroupLayout.PREFERRED_SIZE, 140,
										GroupLayout.PREFERRED_SIZE)
								.addGap(38).addComponent(cadastroFornecedorButton, GroupLayout.PREFERRED_SIZE, 146,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
						.addGap(63))
				.addGroup(
						gl_contentPane.createSequentialGroup().addContainerGap(331, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 136,
										GroupLayout.PREFERRED_SIZE)
								.addGap(307))
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addGap(177)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(142, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(14)
								.addComponent(cadastroFornecedorButton, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(18).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addComponent(cadastroUsuarioButton, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(cadastroClienteButton, GroupLayout.PREFERRED_SIZE, 109,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cadastroColaboradorButton, GroupLayout.DEFAULT_SIZE, 114,
												Short.MAX_VALUE)))))
				.addGap(82)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(sairButton, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
				.addGap(51)));
		contentPane.setLayout(gl_contentPane);
	}

}
