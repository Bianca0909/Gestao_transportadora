package br.com.devtisul.gestaotransportadora.view.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.service.OrdemServicoService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOrdemServico extends JFrame {

	private JPanel contentPane;
	private JTextField clienteField;
	private JTextField colaboradorField;
	private JTextField fornecedorField;
	private JTextField enderecoField;
	private JTextField valorField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TelaOrdemServico frame = new TelaOrdemServico();
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
	public TelaOrdemServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Ordem de serviço");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));

		JLabel lblNewLabel_1 = new JLabel("Código do cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_2 = new JLabel("Código do fornecedor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_3 = new JLabel("Código do colaborador:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_4 = new JLabel("Endereço:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_5 = new JLabel("Valor:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));

		clienteField = new JTextField();
		clienteField.setColumns(10);

		colaboradorField = new JTextField();
		colaboradorField.setColumns(10);

		fornecedorField = new JTextField();
		fornecedorField.setColumns(10);

		enderecoField = new JTextField();
		enderecoField.setColumns(10);

		valorField = new JTextField();
		valorField.setColumns(10);

		JButton finalizarButton = new JButton("FINALIZAR");
		finalizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdemServicoEntity ordemServico = new OrdemServicoEntity();
				ordemServico.setClienteId(Integer.parseInt(clienteField.getText()));
				ordemServico.setColaboradorId(Integer.parseInt(colaboradorField.getText()));
				ordemServico.setFornecedorId(Integer.parseInt(fornecedorField.getText()));
				ordemServico.setEndereco(enderecoField.getText());
				ordemServico.setValor(Double.parseDouble(valorField.getText()));

				try {
					new OrdemServicoService().cadastrarOrdemServico(ordemServico);
					JOptionPane.showMessageDialog(null, "Ordem de Serviço finalizada com sucesso");
				} catch (NegocioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton receberButton = new JButton("RECEBER");

		JButton voltarButton = new JButton("VOLTAR");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addGap(52).addComponent(lblNewLabel_2).addGap(18)
								.addComponent(fornecedorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(544, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(52).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_4).addComponent(lblNewLabel_5))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(valorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(enderecoField, GroupLayout.PREFERRED_SIZE, 367,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_3).addComponent(lblNewLabel_1))
										.addGap(13)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
														.addComponent(colaboradorField, GroupLayout.PREFERRED_SIZE, 84,
																GroupLayout.PREFERRED_SIZE)
														.addGap(2))
												.addComponent(clienteField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(350))
				.addGroup(
						gl_contentPane.createSequentialGroup().addGap(189)
								.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(finalizarButton, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(receberButton, GroupLayout.PREFERRED_SIZE, 108,
										GroupLayout.PREFERRED_SIZE)
								.addGap(317))
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addGap(245)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(400, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(65)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(clienteField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
						.addComponent(colaboradorField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(fornecedorField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
						.addComponent(enderecoField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(valorField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
				.addGap(38)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(voltarButton, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(receberButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(finalizarButton, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
				.addGap(88)));
		contentPane.setLayout(gl_contentPane);
	}

}
