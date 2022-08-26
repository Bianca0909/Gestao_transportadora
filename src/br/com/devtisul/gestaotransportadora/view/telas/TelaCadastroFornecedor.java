package br.com.devtisul.gestaotransportadora.view.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.service.FornecedorService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField documentoField;
	private JTextField dataRegistroField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFornecedor frame = new TelaCadastroFornecedor();
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
	public TelaCadastroFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\manutencao\\Desktop\\Gestão_de_Transportadora-removebg-preview.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de fornecedores");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		
		JLabel documentoLabel = new JLabel("Documento:");
		documentoLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		documentoField = new JTextField();
		documentoField.setColumns(10);
		
		JLabel dataRegistroLabel = new JLabel("Data de registro:");
		dataRegistroLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		dataRegistroField = new JTextField();
		dataRegistroField.setColumns(10);
		

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
				FornecedorEntity fornecedor = new FornecedorEntity();
				fornecedor.setName(nomeField.getText());
				fornecedor.setCnpj(documentoField.getText());
				fornecedor.setBirthday(dataRegistroField.getText());
				
				
				try {
					new FornecedorService().cadastrarFornecedor(fornecedor);
					JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso");
					nomeField.setText("");
					documentoField.setText("");
					dataRegistroField.setText("");
	
				} catch (NegocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(169))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(voltarButton)
							.addGap(153)
							.addComponent(salvarButton, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
							.addGap(136)
							.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(nomeLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nomeField, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(dataRegistroLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(dataRegistroField))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(documentoLabel)
										.addGap(18)
										.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(18, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nomeLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(documentoLabel)
						.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(dataRegistroLabel)
						.addComponent(dataRegistroField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(sairButton, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
						.addComponent(salvarButton, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
