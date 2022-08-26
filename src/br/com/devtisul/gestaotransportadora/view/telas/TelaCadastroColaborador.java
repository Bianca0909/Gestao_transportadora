package br.com.devtisul.gestaotransportadora.view.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.service.ColaboradorService;
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

public class TelaCadastroColaborador extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField documentoField;
	private JTextField dataField;
	private JTextField pisField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroColaborador frame = new TelaCadastroColaborador();
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
	public TelaCadastroColaborador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\manutencao\\Desktop\\Gestão_de_Transportadora-removebg-preview.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de colaborador");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		
		JLabel documentoLabel = new JLabel("Documento:");
		documentoLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		documentoField = new JTextField();
		documentoField.setColumns(10);
		
		JLabel dataLabel = new JLabel("Data de nascimento:");
		dataLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		dataField = new JTextField();
		dataField.setColumns(10);
		
		JLabel pisLabel = new JLabel("Pis:");
		pisLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		pisField = new JTextField();
		pisField.setColumns(10);
		
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
				ColaboradorEntity colaborador = new ColaboradorEntity();
				colaborador.setName(nomeField.getText());
				colaborador.setCpf(documentoField.getText());
				colaborador.setBirthday(dataField.getText());
				colaborador.setPis(pisField.getText());
				
				try {
					new ColaboradorService().cadastrarColaborador(colaborador);
					JOptionPane.showMessageDialog(null, "Colaborador salvo com sucesso");
					nomeField.setText("");
					documentoField.setText("");
					dataField.setText("");
					pisField.setText("");
				} catch (NegocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(nomeLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(dataLabel)
											.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
												.addGap(123)
												.addComponent(salvarButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
												.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(18)
												.addComponent(dataField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 271, Short.MAX_VALUE))))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(documentoLabel)
										.addGap(18)
										.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(pisLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(pisField, 131, 131, 131)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(107)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(210)
							.addComponent(lblNewLabel_1)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomeLabel))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(pisLabel)
						.addComponent(pisField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(documentoLabel))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(dataLabel)
								.addComponent(dataField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(95))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addComponent(salvarButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
