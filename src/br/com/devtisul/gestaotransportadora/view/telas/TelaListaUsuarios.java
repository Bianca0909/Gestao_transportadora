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

import br.com.devti.gestaotransportadora.entity.UsuarioEntity;
import br.com.devti.gestaotransportadora.service.UsuarioService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

public class TelaListaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<UsuarioEntity> usuarios;
	private JTextField codigoField;
	private JTextField loginField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaUsuarios frame = new TelaListaUsuarios();
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
	public TelaListaUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1119, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("Consulta de usuários");
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
		excluirButton.setEnabled(false);
		excluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuarioSelecionado = usuarios.get(table.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Deseja excluir o usuário?") == JOptionPane.OK_OPTION) {

					try {
						new UsuarioService().excluirUsuario(usuarioSelecionado.getId());
						popularTabela();
					} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());
					}
				}
			}
		});

		JButton editarButton = new JButton("EDITAR");
		editarButton.setEnabled(false);
		editarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuarioSelecionado = usuarios.get(table.getSelectedRow());
				TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
				telaCadastroUsuario.carregarUsuarioPorId(usuarioSelecionado.getId());

				telaCadastroUsuario.setVisible(true);
				dispose();

			}
		});

		JButton adicionarButton = new JButton("ADICIONAR");
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
				cadastroUsuario.setVisible(true);
				dispose();

			}
		});

		JLabel codigoPesquisaLabel = new JLabel("Código:");
		codigoPesquisaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		codigoField = new JTextField();
		codigoField.setColumns(10);

		loginField = new JTextField();
		loginField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Filtrar por:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnNewButton = new JButton("FILTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuarioFiltro = new UsuarioEntity();
				usuarioFiltro.setLogin(loginField.getText());
				if(!codigoField.getText().equals("")) {
					usuarioFiltro.setId(Integer.parseInt(codigoField.getText()));
				}
				
				popularTabelaFiltrada(usuarioFiltro);
			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup()
												.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 90,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 89,
														GroupLayout.PREFERRED_SIZE)
												.addGap(426))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup()
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1061,
														Short.MAX_VALUE)
												.addGap(22))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(codigoPesquisaLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
														.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 86,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 99,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 85,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 92,
																GroupLayout.PREFERRED_SIZE)
														.addGap(20))
												.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
														.addComponent(loginField, GroupLayout.PREFERRED_SIZE, 156,
																GroupLayout.PREFERRED_SIZE)
														.addGap(869))))))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(432)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(434, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(24).addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_2).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(codigoPesquisaLabel)
						.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(loginField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(excluirButton, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(adicionarButton, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(sairButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(voltarButton, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
				.addContainerGap()));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(null,table.getSelectedRow());
//				UsuarioEntity usuario = usuarios.get(table.getSelectedRow());
				excluirButton.setEnabled(true);
				editarButton.setEnabled(true);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00D3DIGO", "LOGIN" }) {
			boolean[] columnEditables = new boolean[] { false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}

	private void popularTabelaFiltrada(UsuarioEntity usuarioFiltro) {
		try {
			usuarios = new UsuarioService().buscarUsuarioFiltrado(usuarioFiltro);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (UsuarioEntity usuarioEntity : usuarios) {
				model.addRow(new Object[] { usuarioEntity.getId(), usuarioEntity.getLogin() });
			}
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void popularTabela() {
		try {
			usuarios = new UsuarioService().listarUsuario();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (UsuarioEntity usuarioEntity : usuarios) {
				model.addRow(new Object[] { usuarioEntity.getId(), usuarioEntity.getLogin() });
			}
		} catch (NegocioException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar usuários do banco de dados");
		}
	}
}
