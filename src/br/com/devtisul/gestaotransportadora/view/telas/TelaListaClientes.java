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
		setBounds(100, 100, 895, 558);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(277)
								.addComponent(lblConsultaDeClientes, GroupLayout.PREFERRED_SIZE, 222,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
								.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(excluirButton,
										GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(53, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 96,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 111,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 770,
												GroupLayout.PREFERRED_SIZE))))
				.addGap(46)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(35)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblConsultaDeClientes).addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)))
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE).addGap(43)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(sairButton, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(voltarButton, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
				.addGap(21)));

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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "NOME", "CPF", "EMAIL", "DATA DE NASCIMENTO"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
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
