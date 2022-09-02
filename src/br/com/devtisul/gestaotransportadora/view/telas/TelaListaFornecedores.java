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

import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.service.FornecedorService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class TelaListaFornecedores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<FornecedorEntity> fornecedores;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField documentoField;
	private JTextField dataField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaFornecedores frame = new TelaListaFornecedores();
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
	public TelaListaFornecedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1239, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("Consulta de fornecedores");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));

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
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		JButton excluirButton = new JButton("EXCLUIR");
		excluirButton.setBackground(Color.MAGENTA);
		excluirButton.setEnabled(false);
		excluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorEntity fornecedorSelecionado = fornecedores.get(table.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Deseja excluir o fornecedor?") == JOptionPane.OK_OPTION) {

					try {
						new FornecedorService().excluirFornecedor(fornecedorSelecionado.getId());
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
				FornecedorEntity fornecedorSelecionado = fornecedores.get(table.getSelectedRow());
				TelaCadastroFornecedor telaCadastroFornecedor = new TelaCadastroFornecedor();
				telaCadastroFornecedor.carregarFornecedorPorId(fornecedorSelecionado.getId());
				telaCadastroFornecedor.setVisible(true);
				dispose();
			}
		});

		JButton adicionarButton = new JButton("ADICIONAR");
		adicionarButton.setBackground(Color.GREEN);
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFornecedor cadastroFornecedor = new TelaCadastroFornecedor();
				cadastroFornecedor.setVisible(true);
				dispose();

			}
		});

		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		codigoField = new JTextField();
		codigoField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));

		nomeField = new JTextField();
		nomeField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Documento:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		documentoField = new JTextField();
		documentoField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Data de registro");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		dataField = new JTextField();
		dataField.setColumns(10);

		JButton filtrarButton = new JButton("FILTRAR");
		filtrarButton.setBackground(Color.YELLOW);
		filtrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorEntity fornecedorFiltro = new FornecedorEntity();

				if (!codigoField.getText().equals("")) {
					fornecedorFiltro.setId(Integer.parseInt(codigoField.getText()));
				}
				if (!nomeField.getText().equals("")) {
					fornecedorFiltro.setName(nomeField.getText());
				}
				if (!documentoField.getText().equals("")) {
					fornecedorFiltro.setCnpj(documentoField.getText());
				}
				if (!dataField.getText().equals("")) {
					fornecedorFiltro.setBirthday(dataField.getText());
				}
				
				popularTabelaFiltrada(fornecedorFiltro);
			}

		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 987, Short.MAX_VALUE)
					.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(871, Short.MAX_VALUE)
					.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(472, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addGap(463))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nomeField))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(filtrarButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(dataField, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(633, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(codigoField, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(lblNewLabel_2)
							.addComponent(nomeField, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(documentoField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
							.addComponent(lblNewLabel_4)
							.addComponent(dataField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(filtrarButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(null, table.getSelectedRow());
//				FornecedorEntity fornecedor = fornecedores.get(table.getSelectedRow());
				excluirButton.setEnabled(true);
				editarButton.setEnabled(true);

			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "CNPJ", "NOME", "DATA DE NASCIMENTO"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}

	private void popularTabelaFiltrada(FornecedorEntity fornecedorFiltro) {
		try {
			fornecedores = new FornecedorService().buscarFornecedorFiltrado(fornecedorFiltro);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (FornecedorEntity fornecedorEntity : fornecedores) {
				model.addRow(new Object[] { fornecedorEntity.getId(), fornecedorEntity.getName(),
						fornecedorEntity.getCnpj(), fornecedorEntity.getBirthday() });
			}
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void popularTabela() {
		try {
			fornecedores = new FornecedorService().listarFornecedor();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (FornecedorEntity fornecedorEntity : fornecedores) {
				model.addRow(new Object[] { fornecedorEntity.getId(), fornecedorEntity.getName(),
						fornecedorEntity.getCnpj(), fornecedorEntity.getBirthday()});
			}
		} catch (NegocioException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedores do banco de dados");
		}
	}
}
