package bean;

import java.util.ArrayList;

public class Livro {
	private String ISBN;
	private String titulo;
	private String sinopse;
	private String valor;
	private ArrayList <String> autor;
	private ArrayList <String> genero;
	
	public Livro(String ISBN, String titulo, String sinopse, String valor, ArrayList<String> autor, ArrayList<String> genero) {
		this.ISBN=ISBN;
		this.titulo=titulo;
		this.sinopse=sinopse;
		this.valor=valor;
		this.autor=autor;
		this.genero=genero;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public ArrayList<String> getAutor() {
		return autor;
	}
	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
	}
	public ArrayList<String> getGenero() {
		return genero;
	}
	public void setGenero(ArrayList<String> genero) {
		this.genero = genero;
	}
}
