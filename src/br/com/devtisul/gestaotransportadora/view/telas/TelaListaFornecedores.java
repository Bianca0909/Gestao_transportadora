package br.com.devtisul.gestaotransportadora.view.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.FornecedorEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.service.FornecedorService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import java.awt.Color;

public class TelaListaFornecedores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<FornecedorEntity> fornecedores;

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
		setBounds(100, 100, 908, 558);
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
		excluirButton.setEnabled(false);
		excluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FornecedorEntity fornecedorSelecionado = fornecedores.get(table.getSelectedRow());	
			if(	JOptionPane.showConfirmDialog(null, "Deseja excluir o fornecedor?") == JOptionPane.OK_OPTION) {
				
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
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaCadastroFornecedor cadastroFornecedor = new TelaCadastroFornecedor();
			cadastroFornecedor.setVisible(true);
			dispose();
			
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(291)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(305, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 528, Short.MAX_VALUE)
							.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(voltarButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 669, Short.MAX_VALUE)
							.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addGap(22))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(excluirButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(editarButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
							.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(voltarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(sairButton, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
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
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00D3DIGO", "NOME", "DATA DE REGISTRO", "CNPJ" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

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
			fornecedores = new FornecedorService().listarFornecedor();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (FornecedorEntity fornecedorEntity : fornecedores) {
				model.addRow(new Object[] { fornecedorEntity.getId(), fornecedorEntity.getName(),
						fornecedorEntity.getBirthday(), fornecedorEntity.getCnpj() });
			}
		} catch (NegocioException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedores do banco de dados");
		}
	}

}
