package br.com.treinamento.manterCursos.response;

import java.time.LocalDate;

import br.com.treinamento.manterCursos.entities.Categoria;

public class CursoGetResponse {
	private int idCurso;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private Categoria categoria;
	public CursoGetResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CursoGetResponse(int idCurso, String descricao, LocalDate dataInicio, LocalDate dataTermino,
			Categoria categoria) {
		super();
		this.idCurso = idCurso;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.categoria = categoria;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
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
	