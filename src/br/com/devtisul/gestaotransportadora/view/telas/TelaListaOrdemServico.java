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
import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.entity.OrdemServicoEntity;
import br.com.devti.gestaotransportadora.service.ClienteService;
import br.com.devti.gestaotransportadora.service.ColaboradorService;
import br.com.devti.gestaotransportadora.service.OrdemServicoService;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaListaOrdemServico extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<OrdemServicoEntity> ordens;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaOrdemServico frame = new TelaListaOrdemServico();
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
	public TelaListaOrdemServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuConsulta consultaMenu = new TelaMenuConsulta();
				consultaMenu.setVisible(true);
				dispose();
			}
		});

		JButton btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton excluirButton = new JButton("EXCLUIR");
		excluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdemServicoEntity osSelecionada = ordens.get(table.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Deseja excluir a ordem de serviço?") == JOptionPane.OK_OPTION) {

					try {
						new OrdemServicoService().excluirOrdemServico(osSelecionada.getId());
						popularTabela();
					} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());
					}
				}
			}

		});

		JButton adicionarButton = new JButton("ADICIONAR");
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOrdemServico novaOs = new TelaOrdemServico();
				novaOs.setVisible(true);
				dispose();
			}
		});

		JLabel lblNewLabel = new JLabel("Ordens de serviço");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(559)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(497, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1203, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(adicionarButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(25))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(522, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(511))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(excluirButton, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addComponent(adicionarButton, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				excluirButton.setEnabled(true);

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CODIGO", "CLIENTE", "FORNECEDOR",
				"COLABORADOR", "ENDERE\u00C7O", "VALOR", "SITUACAO", "VALOR PAGO", "VALOR RECEBIDO" }));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}

	private void popularTabela() {
		try {
			ordens = new OrdemServicoService().listarOrdemServico();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (OrdemServicoEntity OrdemServicoEntity : ordens) {
				model.addRow(new Object[] { OrdemServicoEntity.getId(), OrdemServicoEntity.getClienteId(),
						OrdemServicoEntity.getColaboradorId(), OrdemServicoEntity.getFornecedorId(),
						OrdemServicoEntity.getEndereco(), OrdemServicoEntity.getValor(),
						OrdemServicoEntity.getSituacao(), OrdemServicoEntity.getValorPago(),
						OrdemServicoEntity.getValorRestante() });
			}
		} catch (NegocioException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar ordens de serviço do banco de dados");
		}
	}
}
