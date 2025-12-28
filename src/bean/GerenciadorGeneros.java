package bean;

import java.util.ArrayList;

public class GerenciadorGeneros {
    private ArrayList<String> generosSelecionados;

    public GerenciadorGeneros() {
        this.generosSelecionados = new ArrayList<>();
    }

    public ArrayList<String> getGenerosSelecionados() {
        return generosSelecionados;
    }
    
    public void setGenerosSelecionados(ArrayList<String> generosSelecionados) {
		this.generosSelecionados = generosSelecionados;
	}

	public void addGenero(String genero) {
    	generosSelecionados.add(genero);
    }

    public void remGenero(String genero) {
    	generosSelecionados.remove(genero);
    }
}