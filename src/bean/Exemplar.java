package bean;

public class Exemplar {
	private String ISBN_fisico;
	private long numero;
	private long edicao;
	private Boolean disponibilidade;
	private String estado_conservacao;
	private long ano_publicacao;
	
	public Exemplar(String ISBN, long numero, long edicao, Boolean disponibilidade, String estado_conservacao,long ano_publicacao) {
		this.ISBN_fisico=ISBN;
		this.numero=numero;
		this.edicao=edicao;
		this.disponibilidade=disponibilidade;
		this.estado_conservacao=estado_conservacao;
		this.ano_publicacao=ano_publicacao;
	}
	public String getISBN_fisico() {
		return ISBN_fisico;
	}
	public void setISBN_fisico(String iSBN_fisico) {
		ISBN_fisico = iSBN_fisico;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public long getEdicao() {
		return edicao;
	}
	public void setEdicao(long edicao) {
		this.edicao = edicao;
	}
	public Boolean getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public String getEstado_conservacao() {
		return estado_conservacao;
	}
	public void setEstado_conservacao(String estado_conservacao) {
		this.estado_conservacao = estado_conservacao;
	}
	public long getAno_publicacao() {
		return ano_publicacao;
	}
	public void setAno_publicacao(long ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
}
