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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JTextField senhaField;

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
		setBounds(100, 100, 599, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\manutencao\\Desktop\\Gestão_de_Transportadora-removebg-preview.png"));
		
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
		
		JButton sairButton = new JButton("SAIR");
		sairButton.setBackground(Color.RED);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel lblNewLabel_4 = new JLabel("Cadastro de usuários");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setBackground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(47))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(277, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3)
					.addGap(250))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(184, Short.MAX_VALUE)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addGap(174))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(senhaLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(loginLabel)
							.addGap(7))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(9)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(loginField, Alignment.LEADING)
								.addComponent(senhaField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
							.addContainerGap(267, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(23))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(loginLabel)
								.addComponent(loginField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(senhaLabel)
								.addComponent(senhaField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(82))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
