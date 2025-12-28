package bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcionario extends Pessoa{
	
	private String salario;
	private Date data_admissao;
	
	public Funcionario(String cpf, String nome, Date data_nasc, String logradouro, String numero, String cep,
			String cidade, String pais, String salario, Date data_admissao) {
		super(cpf, nome, data_nasc, logradouro, numero, cep, cidade, pais);
		this.salario = salario;
		this.data_admissao = data_admissao;
	}
	
	public String getSalario() {
		return salario;
	}
	
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	public Date getData_admissao() {
		return data_admissao;
	}
	
	public void setData_admissao(Date data_admissao) {
		this.data_admissao = data_admissao;
	}
	
	public String toStringData_admissao() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String data_admissao_String = format.format(data_admissao);
		return data_admissao_String;
	}
}
