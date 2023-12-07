package biblioteca;

import java.io.Serializable;

//Declaramos la clase prestamo con todas las variables y con su correspondiente constructor
public class libro implements Serializable{
	
	private int id_libro;
	private String titulo;
	private String autor;
	private int año_de_publicacion;
	private String genero;
	
	public libro(int id_libro, String titulo, String autor, int año_de_publicacion, String genero) {
		super();
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.autor = autor;
		this.año_de_publicacion = año_de_publicacion;
		this.genero = genero;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAño_de_publicacion() {
		return año_de_publicacion;
	}

	public void setAño_de_publicacion(int año_de_publicacion) {
		this.año_de_publicacion = año_de_publicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	// Usamos este método para representar el objeto como una cadena de texto 
	public String toString() {
	    return "Libro nº " + id_libro+ " {" +
	            "ID: " + id_libro +
	            ", Titulo: '" + titulo + '\'' +
	            ", Autor: '" + autor + '\'' +
	            ", Año de publicación: " + año_de_publicacion +
	            ", Género: '" + genero + '\'' + '}';
	}
	
}