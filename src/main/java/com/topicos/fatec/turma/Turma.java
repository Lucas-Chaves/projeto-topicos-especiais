package com.topicos.fatec.turma;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long id;
	private String nomeTurma;
	private String horarioInicio;
	private String horarioFinal;
	private String semestre;
	@OneToMany(mappedBy = "turma")
	private List<Professor> professores;

	public Turma() {
	}

	public Turma(Long id, String nomeTurma, String horarioInicio, String horarioFinal, String semestre,
			List<Professor> professores) {
		super();
		this.id = id;
		this.nomeTurma = nomeTurma;
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
		this.semestre = semestre;
		this.professores = professores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", nomeTurma=" + nomeTurma + ", horarioInicio=" + horarioInicio + ", horarioFinal="
				+ horarioFinal + ", semestre=" + semestre + "]";
	}

}
