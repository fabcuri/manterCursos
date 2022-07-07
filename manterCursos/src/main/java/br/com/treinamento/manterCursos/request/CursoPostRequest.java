package br.com.treinamento.manterCursos.request;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.treinamento.manterCursos.entities.Categoria;

public class CursoPostRequest {
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private Categoria categoria;
	public CursoPostRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CursoPostRequest(String descricao, LocalDate dataInicio, LocalDate dataTermino, Categoria categoria) {
		super();
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

}