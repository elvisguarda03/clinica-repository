package com.clinica.model;

public class Paciente {
	private Integer id;
	private String nome;
	private Integer idade;

	public Paciente(Integer id, String nome, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public Paciente(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}
	
}
