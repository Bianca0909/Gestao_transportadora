package br.com.devtisul.gestaotransportadora.view.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.com.devti.gestaotransportadora.entity.UsuarioEntity;
import br.com.devti.gestaotransportadora.service.UsuarioService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class TelaLoginUsuario extends JFrame {

	private JPanel senhaField;
	private JTextField loginField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginUsuario frame = new TelaLoginUsuario();
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
	public TelaLoginUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 397);
		senhaField = new JPanel();
		senhaField.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(senhaField);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		loginField = new JTextField();
		loginField.setColumns(10);
		
		JButton btnNewButton = new JButton("AUTENTICAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = loginField.getText();
				String senha = new String(passwordField.getPassword());
				
				try {
					UsuarioEntity usuarioAutenticado = new UsuarioService().autenticarUsuario(login, senha);
					if(usuarioAutenticado != null) {
						TelaMenu menu = new TelaMenu();
						menu.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
					}
				} catch (NegocioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		GroupLayout gl_senhaField = new GroupLayout(senhaField);
		gl_senhaField.setHorizontalGroup(
			gl_senhaField.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_senhaField.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_senhaField.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_senhaField.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(loginField, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
					.addContainerGap(238, Short.MAX_VALUE))
				.addGroup(gl_senhaField.createSequentialGroup()
					.addContainerGap(249, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(239))
				.addGroup(gl_senhaField.createSequentialGroup()
					.addGap(267)
					.addComponent(lblNewLabel_2)
					.addContainerGap(272, Short.MAX_VALUE))
		);
		gl_senhaField.setVerticalGroup(
			gl_senhaField.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_senhaField.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_senhaField.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_senhaField.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(60)
							.addComponent(loginField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addGap(25)
					.addGroup(gl_senhaField.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		senhaField.setLayout(gl_senhaField);
	}

}
