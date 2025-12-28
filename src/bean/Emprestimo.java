package bean;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class Emprestimo {
	
	private String CPF_Cliente;
	private String ISBN_Livro;
	private long numero;
	private java.util.Date data;
	private Time hora;
	private String CPF_Funcionario;
	private java.util.Date dataFim;
	private String termoCompromisso;
	
	public String getCPF_Cliente() {
		return CPF_Cliente;
	}

	public void setCPF_Cliente(String cPF_Cliente) {
		CPF_Cliente = cPF_Cliente;
	}

	public String getISBN_Livro() {
		return ISBN_Livro;
	}

	public void setISBN_Livro(String iSBN_Livro) {
		ISBN_Livro = iSBN_Livro;
	}

	public java.util.Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getCPF_Funcionario() {
		return CPF_Funcionario;
	}

	public void setCPF_Funcionario(String cPF_Funcionario) {
		CPF_Funcionario = cPF_Funcionario;
	}

	public java.util.Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getTermoCompromisso() {
		return termoCompromisso;
	}

	public void setTermoCompromisso(String termoCompromisso) {
		this.termoCompromisso = termoCompromisso;
	}

	public Emprestimo(String CPF_Cliente, String ISBN_Livro, long numero, java.util.Date data, Time hora,
			String CPF_Funcionario, java.util.Date dataFim, String termoCompromisso) {
		super();
		this.CPF_Cliente = CPF_Cliente;
		this.ISBN_Livro = ISBN_Livro;
		this.numero = numero;
		this.data = data;
		this.hora = hora;
		this.CPF_Funcionario = CPF_Funcionario;
		this.dataFim = dataFim;
		this.termoCompromisso = termoCompromisso;
	}

	public String toStringDataFim() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatoData.format(this.dataFim);
		return dataFormatada;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	

}
