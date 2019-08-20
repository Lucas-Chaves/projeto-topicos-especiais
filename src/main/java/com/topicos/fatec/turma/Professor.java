package com.topicos.fatec.turma;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String sobreNome;
	private String cpf;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
	private Turma turma;
	private int idade;

	public Professor() {

	}

	public Professor(Long id, String nome, String sobreNome, String cpf, Turma turma, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.turma = turma;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", cpf=" + cpf + ", idade="
				+ idade + "]";
	}

}
