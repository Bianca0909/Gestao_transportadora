package br.com.devtisul.gestaotransportadora.view.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.UsuarioEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.service.UsuarioService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Color;

public class TelaListaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<UsuarioEntity> usuarios;

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
		setBounds(100, 100, 874, 577);
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

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(284)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addGap(2))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(voltarButton)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 67,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 803,
										GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(35, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(28).addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(47)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(excluirButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
										.addComponent(editarButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(sairButton, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addComponent(voltarButton, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
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
