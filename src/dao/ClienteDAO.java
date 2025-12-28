package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cliente;

public class ClienteDAO {
	private Connection connection;
	private ArrayList<Cliente> listaTodos=new ArrayList<>();
	
	public ClienteDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	
	public int inserir(Cliente c) {
		int inseriu=0;
		String sql="INSERT INTO Cliente VALUES(?,?);";
		PreparedStatement stmt;
		try {
		    java.util.Date data_cadastro = new java.util.Date();
		    java.sql.Date data_cadastro_sql = new java.sql.Date(data_cadastro.getTime());
		    stmt=(PreparedStatement)connection.prepareStatement(sql);
		    stmt.setString(1, c.getCPF());
			stmt.setDate(2, data_cadastro_sql);
			inseriu=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public Cliente buscaCPF(String cpf) {
	    Cliente c = null;
	    String sql = "SELECT * FROM Cliente c JOIN Pessoa p ON c.cpf_pessoa=p.cpf WHERE cpf_pessoa=?";
	    try {
	    	PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, cpf);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	java.util.Date data_cadastro=null;
	        	if(rs.getDate("data_cadastro")!=null) {
	        		java.sql.Date data_cadastro_sql = rs.getDate("data_cadastro");
		            data_cadastro = new java.util.Date(data_cadastro_sql.getTime());
	        	}
	        	String nome = rs.getString("nome");
	            java.util.Date data_nasc = null;
	           	if(rs.getDate("data_nasc")!=null) {
	           		java.sql.Date data_nasc_sql = rs.getDate("data_nasc"); 
		            data_nasc = new java.util.Date(data_nasc_sql.getTime());	
	           	}
	            String logradouro = rs.getString("logradouro");
	            String numero = rs.getString("numero");
	            String CEP = rs.getString("CEP");
	            String cidade = rs.getString("cidade");
	            String pais = rs.getString("pais");
                c = new Cliente(cpf, nome, data_nasc, logradouro, numero, CEP, cidade, pais, data_cadastro);
	        }
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return c;
	}

	public ArrayList<Cliente> listarTodos() {
		listaTodos.clear();
		String sql = "SELECT * FROM Cliente c JOIN Pessoa p ON c.cpf_pessoa=p.cpf";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
                Cliente c=buscaCPF(rs.getString("cpf"));
				if(c!=null) {
					listaTodos.add(c);	
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTodos;
	}
	
	public int remover(Cliente c){
		int removeu = 0;
		String sql = "DELETE FROM Emprestimo WHERE CPF_cliente=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getCPF());
			stmt.execute();
			stmt.close();		
			String sql2="DELETE FROM Cliente WHERE CPF_pessoa=?;";
			PreparedStatement stmt2=connection.prepareStatement(sql2);
			stmt2.setString(1, c.getCPF());
			removeu=stmt2.executeUpdate();
			stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
}
