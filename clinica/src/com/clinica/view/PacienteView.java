package com.clinica.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.clinica.controller.PacienteController;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PacienteView extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=71,339
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
	public JTextField txtId;
	public JTextField txtNome;
	private JLabel lblNome;
	public JTextField txtIdade;
	public JButton btnConfirmar;
	public JButton btnEditar;
	public JButton btnAdicionar;
	public JButton btnExcluir;
	public final JTable tblPaciente = new JTable();
	private JScrollPane scrollPane;
	
	/**
	 * Create the frame.
	 */
	
	public PacienteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 322);
		contentPane =  new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Arial", Font.PLAIN, 15));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Idade");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		btnAdicionar = new JButton("Adicionar");
		
		btnEditar = new JButton("Editar");
		
		btnConfirmar = new JButton("Confirmar Edi\u00E7\u00E3o");
		
		btnExcluir = new JButton("Excluir");
		
		scrollPane = new JScrollPane();
		tblPaciente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Id", "Nome", "Idade"
			}
		));
		tblPaciente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPaciente);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
				.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIdade, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
					.addGap(63)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addGap(2))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(104)
					.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(btnConfirmar)
					.addGap(15)
					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}