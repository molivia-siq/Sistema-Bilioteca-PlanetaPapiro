package bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Pessoa{

	private Date data_cadastro;

	public Cliente(String CPF, String nome, Date data_nasc, String logradouro, String numero, String CEP, String cidade, String pais, Date data_cadastro) {
		super(CPF, nome, data_nasc, logradouro, numero, CEP, cidade, pais);
		this.data_cadastro = data_cadastro;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}	

	public String toStringData_cadastro() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String data_cadastro_String = format.format(data_cadastro);
		return data_cadastro_String;
	}
}
