package bean;

import java.util.ArrayList;

public class Fisico extends Livro{
	private Integer num_copias_disponiveis;

	public Fisico(String ISBN, String titulo, String sinopse, String valor, ArrayList<String> autores, ArrayList<String> generos, int num_copias_disponiveis) {
		super(ISBN, titulo, sinopse, valor, autores, generos);
		this.num_copias_disponiveis=num_copias_disponiveis;
	}

	public Integer getNum_copias_disponiveis() {
		return num_copias_disponiveis;
	}

	public void setNum_copias_disponiveis(Integer num_copias_disponiveis) {
		this.num_copias_disponiveis = num_copias_disponiveis;
	}
}
