package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Fisico;

public class FisicoDAO {
	private Connection connection;
	private ArrayList<Fisico> listaTodos=new ArrayList<>();
	
	public FisicoDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	
	public int inserir(Fisico fi) {
		int inseriu=0;
		String sql="INSERT INTO Fisico VALUES(?,?);";
		PreparedStatement stmt;
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setString(1, fi.getISBN());
			stmt.setInt(2, fi.getNum_copias_disponiveis());
			inseriu=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public Fisico buscaISBN(String ISBN) {
	    Fisico fi = null;
	    String sql = "SELECT * FROM Fisico WHERE ISBN_livro = ?";
	    try {
	    	PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, ISBN);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	int num_copias_disponiveis=rs.getInt("num_copias_disponiveis");
	            String sql2 = "SELECT * FROM Livro WHERE ISBN = ?";
	            PreparedStatement stmt2 = connection.prepareStatement(sql2);
	            stmt2.setString(1, ISBN);
	            ResultSet rs2 = stmt2.executeQuery();
	            if(rs2.next()) {
	            	String titulo = rs2.getString("titulo");
	                String sinopse = rs2.getString("sinopse");
	                float valorFloat = rs2.getFloat("valor");
	                String valor = String.valueOf(valorFloat);
	                String sql3 = "SELECT a.autor FROM Autor_livro a JOIN Fisico f ON a.ISBN_livro=f.ISBN_LIVRO WHERE f.ISBN_livro=?";
	                PreparedStatement stmt3 = connection.prepareStatement(sql3);
	                stmt3.setString(1, ISBN);
	                ResultSet rs3 = stmt3.executeQuery();
	                ArrayList <String> autores = new ArrayList <String>();
	                while(rs3.next()) {
	                	String autor = rs3.getString("autor");
	                	if(autor!=null) {
	                		autores.add(autor);
	                	}
	                }
	                rs3.close();
		            stmt3.close();
	                String sql4 = "SELECT g.genero FROM Genero_livro g JOIN Fisico f ON g.ISBN_livro=f.ISBN_LIVRO WHERE f.ISBN_livro=?";
	                PreparedStatement stmt4 = connection.prepareStatement(sql4);
	                stmt4.setString(1, ISBN);
	                ResultSet rs4 = stmt4.executeQuery();
	                ArrayList <String> generos = new ArrayList <String>();
	                while(rs4.next()) {
	                	String genero = rs4.getString("genero");
	                	if(genero!=null) {
	                		generos.add(genero);
	                	}
	                }
	                fi=new Fisico(ISBN, titulo, sinopse, valor, autores, generos, num_copias_disponiveis);
		            rs4.close();
		            stmt4.close();
	            }
	            rs2.close();
	            stmt2.close();
	        }
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return fi;
	}
	
	public ArrayList<Fisico> listarTodos() {
		listaTodos.clear();
		String sql = "SELECT * FROM Fisico f JOIN Livro l ON f.ISBN_livro=l.ISBN";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
                Fisico fi=buscaISBN(rs.getString("ISBN"));
				if(fi!=null) {
					listaTodos.add(fi);
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTodos;
	}
	
	public int remover(Fisico fi){
		int removeu = 0;
		String sql = "DELETE FROM Emprestimo WHERE ISBN_exemplar=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, fi.getISBN());
			stmt.execute();
			stmt.close();
			String sql2="DELETE FROM Exemplar WHERE ISBN_fisico=?";
			PreparedStatement stmt2=connection.prepareStatement(sql2);
			stmt2.setString(1, fi.getISBN());
			stmt2.execute();
			stmt2.close();
			String sql3="DELETE FROM Fisico WHERE ISBN_livro = ?";
			PreparedStatement stmt3=connection.prepareStatement(sql3);
			stmt3.setString(1, fi.getISBN());
			removeu=stmt3.executeUpdate();
			stmt3.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
}
