package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Cliente;
import bean.Funcionario;

public class PessoaDAO {
	private Connection connection;
	
	public PessoaDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	
	public int inserirC(Cliente p) {
		int inseriu=0;
		String sql="INSERT INTO Pessoa(cpf, nome, data_nasc, logradouro, numero, CEP, cidade, pais) values(?,?,?,?,?,?,?,?);";
		PreparedStatement stmt;
		try {
			long numero=Long.parseLong(p.getNumero());    	
			java.util.Date data_nasc = p.getData_nasc();
			java.sql.Date data_nasc_sql = new java.sql.Date(data_nasc.getTime());
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, p.getCPF());
			stmt.setString(2, p.getNome());
			stmt.setDate(3, data_nasc_sql);
			stmt.setString(4, p.getLogradouro());
			stmt.setLong(5, numero);
			stmt.setString(6, p.getCEP());
			stmt.setString(7, p.getCidade());
			stmt.setString(8, p.getPais());
			inseriu=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int removerC(Cliente p){
		int removeu = 0;
		String sql = "DELETE FROM Pessoa WHERE CPF = ?;";
		PreparedStatement stmt;
		try {	
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, p.getCPF());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int editarC(Cliente p) {
		int editou = 0;
		String sql = "UPDATE Pessoa SET nome = ?, data_nasc = ?, logradouro = ?, numero = ?, CEP = ?, cidade = ?, pais = ? WHERE CPF = ?";
		PreparedStatement stmt;
		try {
			long numero=Long.parseLong(p.getNumero());
		    java.util.Date data_nasc = p.getData_nasc();
		    java.sql.Date data_nasc_sql = new java.sql.Date(data_nasc.getTime());
		    stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setDate(2, data_nasc_sql);
			stmt.setString(3, p.getLogradouro());
			stmt.setLong(4, numero);
			stmt.setString(5, p.getCEP());
			stmt.setString(6, p.getCidade());
			stmt.setString(7, p.getPais());
			stmt.setString(8, p.getCPF());
			editou=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return editou;
	}

	public int inserirF(Funcionario p) {
		int inseriu=0;
		String sql="INSERT INTO Pessoa(cpf, nome, data_nasc, logradouro, numero, CEP, cidade, pais) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			long numero=Long.parseLong(p.getNumero());
		    java.util.Date data_nasc = p.getData_nasc();
		    java.sql.Date data_nasc_sql = new java.sql.Date(data_nasc.getTime());
		    stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, p.getCPF());
			stmt.setString(2, p.getNome());
			stmt.setDate(3, data_nasc_sql);
			stmt.setString(4, p.getLogradouro());
			stmt.setLong(5, numero);
			stmt.setString(6, p.getCEP());
			stmt.setString(7, p.getCidade());
			stmt.setString(8, p.getPais());
			inseriu=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int editarF(Funcionario p) {
		int editou = 0;
		String sql = "UPDATE Pessoa SET nome = ?, data_nasc = ?, logradouro = ?, numero = ?, CEP = ?, cidade = ?, pais = ? WHERE CPF = ?";
		PreparedStatement stmt;
		try {
			long numero=Long.parseLong(p.getNumero());
		    java.util.Date data_nasc = p.getData_nasc();
		    java.sql.Date data_nasc_sql = new java.sql.Date(data_nasc.getTime());
		    stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setDate(2, data_nasc_sql);
			stmt.setString(3, p.getLogradouro());
			stmt.setLong(4, numero);
			stmt.setString(5, p.getCEP());
			stmt.setString(6, p.getCidade());
			stmt.setString(7, p.getPais());
			stmt.setString(8, p.getCPF());
			editou=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return editou;
	}
	
	public int removerF(Funcionario p){
		int removeu = 0;
		String sql = "DELETE FROM Pessoa WHERE CPF = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, p.getCPF());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
}
