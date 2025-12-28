package bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	private String CPF;
	private String nome;
	private Date data_nasc;
	private Integer idade;
	private String logradouro;
	private String numero;
	private String CEP;
	private String cidade;
	private String pais;
	
	public Pessoa(String CPF, String nome, Date data_nasc, String logradouro, String numero, String CEP,String cidade, String pais) {
		this.CPF = CPF;
		this.nome = nome;
		this.data_nasc = data_nasc;
		this.logradouro = logradouro;
		this.numero = numero;
		this.CEP = CEP;
		this.cidade = cidade;
		this.pais = pais;
	}
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String toStringData_nasc() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String data_nasc_String = format.format(data_nasc);
		return data_nasc_String;
	}
}
