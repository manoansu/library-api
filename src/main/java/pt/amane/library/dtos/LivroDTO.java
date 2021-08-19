package pt.amane.library.dtos;

import pt.amane.library.domain.Livro;

public class LivroDTO {

	private Long id;
	private String autor;
	private String titulo;
	private String texto;

	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.autor = livro.getAutor();
		this.titulo = livro.getTitulo();
		this.texto = livro.getTexto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
