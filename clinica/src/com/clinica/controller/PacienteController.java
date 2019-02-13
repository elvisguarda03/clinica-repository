package com.clinica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.clinica.dao.PacienteDAO;
import com.clinica.model.Paciente;
import com.clinica.view.PacienteView;

public class PacienteController implements ActionListener {
	private PacienteView pv;
	private PacienteDAO pDAO;

	public PacienteController(PacienteView pv, PacienteDAO pDAO) {
		this.pv = pv;
		pv.btnAdicionar.addActionListener(this);
		pv.btnConfirmar.addActionListener(this);
		pv.btnConfirmar.setEnabled(false);
		pv.btnEditar.addActionListener(this);
		pv.btnExcluir.addActionListener(this);
		this.pDAO = pDAO;
		loadData();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == pv.btnAdicionar) {
			String nome;
			Integer idade;
			try {
				nome = pv.txtNome.getText().trim();
				idade = Integer.parseInt(pv.txtIdade.getText().trim());
				boolean isInsert = pDAO.insert(new Paciente(nome, idade));
				JOptionPane.showMessageDialog(pv,
						isInsert == true ? "Os dados foram inseridos com sucesso!!" : "Os dados não foram inseridos.");
				clearFields();
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}

		if (ae.getSource() == pv.btnEditar) {
			int selectedRow = pv.tblPaciente.getSelectedRow();
			int numberRow = pv.tblPaciente.getSelectedRowCount();
			if (selectedRow >= 0 && numberRow == 1) {
				pv.txtId.setText(pv.tblPaciente.getValueAt(selectedRow, 0).toString());
				pv.txtNome.setText(pv.tblPaciente.getValueAt(selectedRow, 1).toString());
				pv.txtIdade.setText(pv.tblPaciente.getValueAt(selectedRow, 2).toString());

				pv.btnAdicionar.setEnabled(false);
				pv.btnExcluir.setEnabled(false);
				pv.btnEditar.setEnabled(false);
				pv.btnConfirmar.setEnabled(true);
			}
			else
				JOptionPane.showMessageDialog(pv, "Selecione uma linha!");
		}

		if (ae.getSource() == pv.btnConfirmar) {
			Integer id;
			String nome;
			Integer idade;
			try {
				id = Integer.parseInt(pv.txtId.getText());
				nome = pv.txtNome.getText().trim();
				idade = Integer.parseInt(pv.txtIdade.getText().trim());
				boolean isInsert = pDAO.update(new Paciente(id, nome, idade));
				JOptionPane.showMessageDialog(pv,
						isInsert == true ? "Os dados foram atualizados com sucesso!" : "Os dados não foram atualizados!");
				clearFields();
				pv.btnAdicionar.setEnabled(true);
				pv.btnEditar.setEnabled(true);
				pv.btnExcluir.setEnabled(true);
				pv.btnConfirmar.setEnabled(false);
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}

		if (ae.getSource() == pv.btnExcluir) {
			int selectedRow = pv.tblPaciente.getSelectedRow();
			try {
				Integer id = Integer.parseInt(pv.tblPaciente.getValueAt(selectedRow, 0).toString());
				Paciente paciente = pDAO.delete(id);
				if (paciente != null)
					JOptionPane.showMessageDialog(pv,
							String.format("Paciente %s foi deletado com sucesso!", paciente.getNome()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(pv, "Erro: " + e.getMessage());
			}
		}
		loadData();
	}

	private void loadData() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Id");
		dtm.addColumn("Nome");
		dtm.addColumn("Idade");
		pv.tblPaciente.setModel(dtm);
		Object[] columns = new Object[3];
		try {
			for (Paciente p : pDAO.list()) {
				columns[0] = p.getId();
				columns[1] = p.getNome();
				columns[2] = p.getIdade();
				dtm.addRow(columns);
			}
		} catch (NoSuchElementException e) {
			JOptionPane.showMessageDialog(pv, "Erro: " + e.getMessage());
		}
	}

	private void clearFields() {
		pv.txtNome.setText("");
		pv.txtIdade.setText("");
		pv.txtId.setText("");
	}
}