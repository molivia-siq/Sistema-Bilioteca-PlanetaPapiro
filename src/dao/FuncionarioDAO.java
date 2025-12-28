package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Funcionario;

public class FuncionarioDAO {
	
private Connection connection;
private ArrayList<Funcionario> listaTodos=new ArrayList<>();
	
	public FuncionarioDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	
	public int inserir(Funcionario f) {
		int inseriu = 0;
		String sql = "INSERT INTO Funcionario(cpf_pessoa, salario, data_admissao) VALUES(?,?,?);";
		PreparedStatement stmt;
		try {
			java.util.Date data_admissao = new java.util.Date();
		    java.sql.Date data_admissao_sql = new java.sql.Date(data_admissao.getTime());
		    stmt = (PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, f.getCPF());
			stmt.setString(2, f.getSalario());
			stmt.setDate(3, data_admissao_sql);
			inseriu = stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public Funcionario buscaCPF(String cpf) {
	    Funcionario f = null;
	    String sql = "SELECT * FROM Funcionario WHERE CPF_pessoa = ?";
	    try {
	    	PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, cpf);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	java.util.Date data_admissao = null;
	        	if(rs.getDate("data_admissao") != null) {
	        		java.sql.Date data_admissao_sql = rs.getDate("data_admissao");
		            data_admissao = new java.util.Date(data_admissao_sql.getTime());
	        	}
                String salario = rs.getString("salario");
	            String sql2 = "SELECT * FROM Pessoa WHERE CPF = ?";
	            PreparedStatement stmt2 = connection.prepareStatement(sql2);
	            stmt2.setString(1, cpf);
	            ResultSet rs2 = stmt2.executeQuery();
	            if(rs2.next()) {
	            	String nome = rs2.getString("nome");
	            	java.util.Date data_nasc = null;
	            	if(rs2.getDate("data_nasc") != null) {
	            		java.sql.Date data_nasc_sql = rs2.getDate("data_nasc"); 
		                data_nasc = new java.util.Date(data_nasc_sql.getTime());	
	            	}
	                String logradouro = rs2.getString("logradouro");
	                String numero = rs2.getString("numero");
	                String CEP = rs2.getString("CEP");
	                String cidade = rs2.getString("cidade");
	                String pais = rs2.getString("pais");
	                f = new Funcionario(cpf, nome, data_nasc, logradouro, numero, CEP, cidade, pais, salario, data_admissao);
	            }
	            rs2.close();
	            stmt2.close();
	        }
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return f;
	}
	
	public ArrayList<Funcionario> listarTodos() {
		listaTodos.clear();
		String sql = "SELECT * FROM Funcionario f JOIN Pessoa p ON f.cpf_pessoa=p.cpf";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
                Funcionario f=buscaCPF(rs.getString("cpf"));
				if(f!=null) {
					listaTodos.add(f);	
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTodos;
	}
	
	public int editar(Funcionario f) {
		int editou = 0;
		String sql = "UPDATE Funcionario SET salario = ? WHERE CPF_pessoa = ?";
		PreparedStatement stmt;
		try {
			float salario=Float.parseFloat(f.getSalario());
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setFloat(1, salario);
			stmt.setString(2, f.getCPF());
			editou=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return editou;
		
	}
	
	public int remover (Funcionario f){
		int removeu = 0;
		String sql = "DELETE FROM Emprestimo WHERE CPF_funcionario=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, f.getCPF());
			stmt.execute();
			stmt.close();
			String sql2="DELETE FROM Funcionario WHERE CPF_pessoa = ?;";
			PreparedStatement stmt2=connection.prepareStatement(sql2);
			stmt2.setString(1, f.getCPF());
			removeu=stmt2.executeUpdate();
			stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	

}
