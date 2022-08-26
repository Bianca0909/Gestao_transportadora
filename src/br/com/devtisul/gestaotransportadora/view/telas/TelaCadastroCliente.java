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

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField dataField;
	private JTextField documentoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon("C:\\Users\\manutencao\\Desktop\\Gestão_de_Transportadora-removebg-preview.png"));

		JLabel lblNewLabel_1 = new JLabel("Cadastro de clientes");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));

		JLabel NomeLabel = new JLabel("Nome:");
		NomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel_4 = new JLabel("Data de nascimento:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel_5 = new JLabel("Documento:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));

		nomeField = new JTextField();
		nomeField.setColumns(10);

		emailField = new JTextField();
		emailField.setColumns(10);

		dataField = new JTextField();
		dataField.setColumns(10);

		documentoField = new JTextField();
		documentoField.setColumns(10);

		JButton voltarButton = new JButton("VOLTAR");
		voltarButton.setBackground(Color.ORANGE);
		voltarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMenuCadastro menu = new TelaMenuCadastro();
				menu.setVisible(true);
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

		JButton salvarButton = new JButton("SALVAR");
		salvarButton.setBackground(Color.GREEN);
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity cliente = new ClienteEntity();
				cliente.setName(nomeField.getText());
				cliente.setCpf(documentoField.getText());
				cliente.setBirthday(dataField.getText());
				cliente.setEmail(emailField.getText());

				try {
					new ClienteService().salvarCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
					nomeField.setText("");
					documentoField.setText("");
					dataField.setText("");
					emailField.setText("");
				} catch (NegocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(51)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_3).addGap(18)
										.addComponent(emailField, 513, 513, 513))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(NomeLabel, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(nomeField,
												GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(165)
										.addComponent(salvarButton, GroupLayout.PREFERRED_SIZE, 102,
												GroupLayout.PREFERRED_SIZE)
										.addGap(178).addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 85,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(Alignment.LEADING,
												gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_5)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(documentoField))
										.addGroup(Alignment.LEADING,
												gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_4)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(dataField, GroupLayout.PREFERRED_SIZE, 122,
																GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(23, Short.MAX_VALUE)).addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addGap(128))))
				.addGroup(Alignment.LEADING,
						gl_contentPane
								.createSequentialGroup().addGap(218).addComponent(lblNewLabel_1,
										GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(218, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(40)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(NomeLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
								.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
								.addComponent(dataField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
								.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 31,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(salvarButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
