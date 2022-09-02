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

import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.service.ColaboradorService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class TelaListaColaboradores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<ColaboradorEntity> colaboradores;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField dataField;
	private JTextField documentoField;
	private JTextField pisField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaColaboradores frame = new TelaListaColaboradores();
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
	public TelaListaColaboradores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1236, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("Consulta de colaboradores");
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
		excluirButton.setBackground(Color.RED);
		excluirButton.setEnabled(false);
		excluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColaboradorEntity colaboradorSelecionado = colaboradores.get(table.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Deseja excluir o colaborador?") == JOptionPane.OK_OPTION) {

					try {
						new ColaboradorService().excluirColaborador(colaboradorSelecionado.getId());
						popularTabela();
					} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());
					}
				}
			}
		});

		JButton editarButton = new JButton("EDITAR");
		editarButton.setBackground(Color.BLUE);
		editarButton.setEnabled(false);
		editarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColaboradorEntity colaboradorSelecionado = colaboradores.get(table.getSelectedRow());
				TelaCadastroColaborador telaCadastroColaborador = new TelaCadastroColaborador();
				telaCadastroColaborador.carregarColaboradorPorId(colaboradorSelecionado.getId());
				telaCadastroColaborador.setVisible(true);
				dispose();
			}
		});

		JButton adicionarButton = new JButton("ADICIONAR");
		adicionarButton.setBackground(Color.GREEN);
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroColaborador cadastroColaborador = new TelaCadastroColaborador();
				cadastroColaborador.setVisible(true);
				dispose();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		codigoField = new JTextField();
		codigoField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		nomeField = new JTextField();
		nomeField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Data de nascimento:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		dataField = new JTextField();
		dataField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Documento:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		documentoField = new JTextField();
		documentoField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("PIS:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));

		pisField = new JTextField();
		pisField.setColumns(10);

		JButton filtrarButton = new JButton("FILTRAR");
		filtrarButton.setBackground(Color.YELLOW);
		filtrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColaboradorEntity colaboradorFiltro = new ColaboradorEntity();
				if (!codigoField.getText().equals("")) {
					colaboradorFiltro.setId(Integer.parseInt(codigoField.getText()));
				}
				if (!nomeField.getText().equals("")) {
					colaboradorFiltro.setName(nomeField.getText());
				}
				if (!dataField.getText().equals("")) {
					colaboradorFiltro.setBirthday(dataField.getText());
				}

				if (!documentoField.getText().equals("")) {
					colaboradorFiltro.setCpf(documentoField.getText());
				}
				if (!pisField.getText().equals("")) {
					colaboradorFiltro.setCpf(pisField.getText());
				}
				popularTabelaFiltrada(colaboradorFiltro);

			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(524, Short.MAX_VALUE)
						.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addGap(510))
				.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 1179, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(374)
								.addComponent(filtrarButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 413, Short.MAX_VALUE)
								.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 102,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 109,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGap(21))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(445, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
						.addGap(434))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(34).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(2).addComponent(lblNewLabel_4).addGap(2)
								.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 192,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblNewLabel_5).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(pisField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(nomeField)))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_3)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(dataField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(415, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(46)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(nomeField, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3)
								.addComponent(dataField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(30)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 27,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_4).addComponent(documentoField,
														GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
								.addGroup(
										gl_contentPane.createSequentialGroup().addGap(26).addComponent(pisField,
												GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup().addGap(26)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 33,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(18).addComponent(filtrarButton,
										GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(sairButton, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
								.addComponent(voltarButton, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
						.addGap(22)));

		table = new JTable();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(null, table.getSelectedRow());
//				ColaboradorEntity colaborador = colaboradores.get(table.getSelectedRow());
				excluirButton.setEnabled(true);
				editarButton.setEnabled(true);

			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00D3DIGO", "NOME", "CPF", "DATA DE NASCIMENTO", "PIS" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}

	private void popularTabelaFiltrada(ColaboradorEntity colaboradorFiltro) {
		try {
			colaboradores = new ColaboradorService().buscarColaboradorFiltrado(colaboradorFiltro);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (ColaboradorEntity colaboradorEntity : colaboradores) {
				model.addRow(new Object[] { colaboradorEntity.getId(), colaboradorEntity.getName(),
						colaboradorEntity.getCpf(), colaboradorEntity.getBirthday(), colaboradorEntity.getPis() });
			}
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void popularTabela() {
		try {
			colaboradores = new ColaboradorService().listarColaborador();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (ColaboradorEntity colaboradorEntity : colaboradores) {
				model.addRow(new Object[] { colaboradorEntity.getId(), colaboradorEntity.getName(),
						colaboradorEntity.getCpf(), colaboradorEntity.getPis(), colaboradorEntity.getBirthday() });
			}
		} catch (NegocioException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar colaboradores do banco de dados");
		}
	}
}
