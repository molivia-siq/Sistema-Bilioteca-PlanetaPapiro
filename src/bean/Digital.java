package bean;

import java.util.ArrayList;

public class Digital {
	private String tipo_arquivo;
	private ArrayList<String> plataformas_compativeis;
	
	public String getTipo_arquivo() {
		return tipo_arquivo;
	}
	public void setTipo_arquivo(String tipo_arquivo) {
		this.tipo_arquivo = tipo_arquivo;
	}
	public ArrayList<String> getPlataformas_compativeis() {
		return plataformas_compativeis;
	}
	public void setPlataformas_compativeis(ArrayList<String> plataformas_compativeis) {
		this.plataformas_compativeis = plataformas_compativeis;
	}
}
