package com.clinica.principal;

import com.clinica.controller.PacienteController;
import com.clinica.dao.PacienteDAO;
import com.clinica.view.PacienteView;

public class Principal {

	public static void main(String[] args) {
		PacienteView pv = new PacienteView();
		pv.setVisible(true);
		PacienteDAO pDAO = new PacienteDAO();
		PacienteController pc = new PacienteController(pv, pDAO);
	}
}
