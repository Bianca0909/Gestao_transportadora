package br.com.devtisul.gestaotransportadora.view.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class TelaListaClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<ClienteEntity> clientes;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField documentoField;
	private JTextField dataField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaClientes frame = new TelaListaClientes();
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
	public TelaListaClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1402, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblConsultaDeClientes = new JLabel("Consulta de clientes");
		lblConsultaDeClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));

		JButton voltarButton = new JButton("VOLTAR");
		voltarButton.setBackground(Color.ORANGE);
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuConsulta menu = new TelaMenuConsulta();
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

		JButton excluirButton = new JButton("EXCLUIR");
		excluirButton.setBackground(Color.MAGENTA);
		excluirButton.setEnabled(false);
		excluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity clienteSelecionado = clientes.get(table.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente?") == JOptionPane.OK_OPTION) {

					try {
						new ClienteService().excluirCliente(clienteSelecionado.getId());
						popularTabela();
					} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());
					}
				}
			}
		});

		JButton editarButton = new JButton("EDITAR");
		editarButton.setBackground(Color.PINK);
		editarButton.setEnabled(false);
		editarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity clienteSelecionado = clientes.get(table.getSelectedRow());
				TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
				telaCadastroCliente.carregarClientePorId(clienteSelecionado.getId());
				telaCadastroCliente.setVisible(true);
				dispose();
			}
		});

		JButton adicionarButton = new JButton("ADICIONAR");
		adicionarButton.setBackground(Color.GREEN);
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente cadastroCliente = new TelaCadastroCliente();
				cadastroCliente.setVisible(true);
				dispose();
			}
		});

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		codigoField = new JTextField();
		codigoField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		nomeField = new JTextField();
		nomeField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		emailField = new JTextField();
		emailField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Documento:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		documentoField = new JTextField();
		documentoField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Data de nascimento:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		dataField = new JTextField();
		dataField.setColumns(10);

		JButton filtrarButton = new JButton("FILTRAR");
		filtrarButton.setBackground(Color.YELLOW);
		filtrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity clienteFiltro = new ClienteEntity();
				if (!codigoField.getText().equals("")) {
					clienteFiltro.setId(Integer.parseInt(codigoField.getText()));
				}
				if (!nomeField.getText().equals("")) {
					clienteFiltro.setName(nomeField.getText());
				}
				if (!emailField.getText().equals("")) {
					clienteFiltro.setEmail(emailField.getText());
				}
				if (!dataField.getText().equals("")) {
					clienteFiltro.setBirthday(dataField.getText());
				}
				if (!documentoField.getText().equals("")) {
					clienteFiltro.setCpf(documentoField.getText());
				}
				popularTabelaFiltrada(clienteFiltro);
			}

		});

		JLabel lblNewLabel_5 = new JLabel("Filtrar por:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(540, Short.MAX_VALUE)
						.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addGap(631))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(40).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblNewLabel_3).addGap(18)
								.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 177,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_4)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(dataField,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_5)
												.addPreferredGap(ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
												.addComponent(lblConsultaDeClientes, GroupLayout.PREFERRED_SIZE, 252,
														GroupLayout.PREFERRED_SIZE)
												.addGap(77))
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(codigoField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(lblNewLabel_1)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(nomeField,
														GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)))))
						.addGap(480))
				.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup().addContainerGap().addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 1342, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(420)
								.addComponent(filtrarButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
								.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 97,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(excluirButton,
										GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
						.addGap(24)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(43).addComponent(lblNewLabel_5))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(
								lblConsultaDeClientes, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
				.addGap(30)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(dataField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(filtrarButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 31,
						Short.MAX_VALUE)
				.addGroup(
						gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addGap(20))
								.addGroup(
										gl_contentPane
												.createSequentialGroup().addComponent(sairButton,
														GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
												.addGap(22)))));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(null, table.getSelectedRow());
//				ClienteEntity cliente = clientes.get(table.getSelectedRow());
				excluirButton.setEnabled(true);
				editarButton.setEnabled(true);

			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00D3DIGO", "NOME", "EMAIL", "DATA DE NASCIMENTO", "CPF" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}

	private void popularTabelaFiltrada(ClienteEntity clienteFiltro) {
		try {
			clientes = new ClienteService().buscarClienteFiltrado(clienteFiltro);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (ClienteEntity clienteEntity : clientes) {
				model.addRow(new Object[] { clienteEntity.getId(), clienteEntity.getName(), clienteEntity.getEmail(),
						clienteEntity.getBirthday(), clienteEntity.getCpf() });
			}
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void popularTabela() {
		try {
			clientes = new ClienteService().listarCliente();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (ClienteEntity clienteEntity : clientes) {
				model.addRow(new Object[] { clienteEntity.getId(), clienteEntity.getName(), clienteEntity.getEmail(),
						clienteEntity.getBirthday(), clienteEntity.getCpf() });
			}
		} catch (NegocioException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar clientes do banco de dados");
		}
	}
}
