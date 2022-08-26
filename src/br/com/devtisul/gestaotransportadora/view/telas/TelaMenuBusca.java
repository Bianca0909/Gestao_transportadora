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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuBusca extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuBusca frame = new TelaMenuBusca();
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
	public TelaMenuBusca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon("C:\\Users\\manutencao\\Desktop\\Gestão_de_Transportadora-removebg-preview.png"));

		JButton buscaClienteButton = new JButton("CLIENTE");

		JLabel lblNewLabel_1 = new JLabel("Buscas");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));

		JButton fornecedorBuscaButton = new JButton("FORNECEDOR");

		JButton buscaColaboradorButton = new JButton("COLABORADOR");
		buscaColaboradorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton buscaUsuarioButton = new JButton("USUARIO");

		JButton voltarButton = new JButton("VOLTAR");
		voltarButton.setBackground(Color.ORANGE);
		voltarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMenu menu = new TelaMenu();
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(164).addComponent(
										lblNewLabel, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))
								.addGroup(
										gl_contentPane.createSequentialGroup().addGap(341)
												.addComponent(
														lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 101,
														GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(177, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(49).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
								.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buscaClienteButton, GroupLayout.PREFERRED_SIZE, 144,
										GroupLayout.PREFERRED_SIZE)
								.addGap(40)
								.addComponent(fornecedorBuscaButton, GroupLayout.PREFERRED_SIZE, 153,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
								.addComponent(buscaColaboradorButton, GroupLayout.PREFERRED_SIZE, 158,
										GroupLayout.PREFERRED_SIZE)
								.addGap(35).addComponent(buscaUsuarioButton, GroupLayout.PREFERRED_SIZE, 155,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(37)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(41)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(buscaClienteButton, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(buscaUsuarioButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(buscaColaboradorButton, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
						.addComponent(fornecedorBuscaButton, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
				.addGap(116)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

}
