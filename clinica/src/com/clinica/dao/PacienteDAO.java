package com.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import com.clinica.model.ConnectionFactory;
import com.clinica.model.Paciente;

public class PacienteDAO {

	public boolean insert(Paciente paciente) {
		String sql = "insert into paciente (nome, idade) values (?,?)";
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
			stmt.setString(1, paciente.getNome());
			stmt.setInt(2, paciente.getIdade());
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return false;
	}

	public List<Paciente> list() {
		String sql = "select * from paciente;";
		List<Paciente> pacientes = new LinkedList<>();
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				pacientes.add(new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade")));
			}
			return pacientes;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		throw new NoSuchElementException("Não existe nenhum paciente cadastrado!");
	}

	public Paciente delete(Integer id) {
		Paciente paciente = search(id);
		String sql = "delete from paciente where id=?";
		if (paciente != null) {
			try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
				return paciente;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		throw new NoSuchElementException("O paciente não está cadastrado no sistema!");
	}

	private Paciente search(Integer id) {
		String sql = "select * from paciente where id=?";
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean update(Paciente paciente) {
		String sql = "update paciente set nome=?, idade=? where id=?";
		try(PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
			stmt.setString(1, paciente.getNome());
			stmt.setInt(2, paciente.getIdade());
			stmt.setInt(3, paciente.getId());
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return false;
	}
}
