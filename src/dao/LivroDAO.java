package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Fisico;

public class LivroDAO {
	private Connection connection;
	
	public LivroDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	
	public int inserirFi(Fisico fi) {
		int inseriu=0;
		String sql="INSERT INTO Livro VALUES(?,?,?,?);";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, fi.getISBN());
			stmt.setString(2, fi.getTitulo());
			stmt.setString(3, fi.getSinopse());
			stmt.setString(4, fi.getValor());
			inseriu=stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int inserirAutorFi(Fisico fi) {
		int inseriu=0;
		
		ArrayList <String> autores=fi.getAutor();
		
		String sql="INSERT INTO Autor_livro VALUES(?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			for(String autor:autores) {
				stmt.setString(1, fi.getISBN());
				stmt.setString(2, autor);
				inseriu=stmt.executeUpdate();
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int inserirGeneroFi(Fisico fi) {
		int inseriu=0;
		
		ArrayList <String> generos=fi.getGenero();
		
		String sql="INSERT INTO Genero_livro VALUES(?,?)";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			for(String genero:generos) {
				stmt.setString(1, fi.getISBN());
				stmt.setString(2, genero);
				inseriu=stmt.executeUpdate();
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int editarFi(Fisico fi) {
		int editou=0;
		String sql="UPDATE Livro SET titulo=?, sinopse=?, valor=? WHERE ISBN=?";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, fi.getTitulo());
			stmt.setString(2, fi.getSinopse());
			stmt.setString(3, fi.getValor());
			stmt.setString(4, fi.getISBN());
			editou=stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return editou;
	}
	
	public int editarAutorFi(Fisico fi) {
		int editou=0;
		String sql="DELETE FROM Autor_livro WHERE ISBN_livro=?";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, fi.getISBN());
			editou=stmt.executeUpdate();
			stmt.close();
			
			String sql2="INSERT INTO Autor_livro VALUES(?,?)";
			PreparedStatement stmt2=connection.prepareStatement(sql2);
			for(String autor:fi.getAutor()) {
				stmt2.setString(1, fi.getISBN());
				stmt2.setString(2, autor);
				editou=stmt2.executeUpdate();
			}
			stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return editou;
	}
	
	public int editarGeneroFi(Fisico fi) {
		int editou=0;
		String sql="DELETE FROM Genero_livro WHERE ISBN_livro=?";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, fi.getISBN());
			editou=stmt.executeUpdate();
			stmt.close();
			
			String sql2="INSERT INTO Genero_livro VALUES(?,?)";
			PreparedStatement stmt2=connection.prepareStatement(sql2);
			for(String genero:fi.getGenero()) {
				stmt2.setString(1, fi.getISBN());
				stmt2.setString(2, genero);
				editou=stmt2.executeUpdate();
			}
			stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return editou;
	}
	
	public int removerFi(Fisico fi){
		int removeu = 0;
			
		String sql = "DELETE FROM Livro WHERE ISBN = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, fi.getISBN());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int removerAutorFi(Fisico fi){
		int removeu = 0;
		
		String sql = "DELETE FROM Autor_livro WHERE ISBN_livro = ?;";
		PreparedStatement stmt;
		try {	
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, fi.getISBN());;
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int removerGeneroFi(Fisico fi){
		int removeu = 0;
		
		String sql = "DELETE FROM Genero_livro WHERE ISBN_livro = ?;";
		PreparedStatement stmt;
		try {	
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, fi.getISBN());;
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
}
