package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Exemplar;

public class ExemplarDAO {
	private Connection connection;
	private ArrayList <Exemplar> listaTodos=new ArrayList<>();
	
	public ExemplarDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	
	public int inserir(Exemplar ex) {
		int inseriu=0;
		String sql="INSERT INTO Exemplar VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, ex.getISBN_fisico());
			stmt.setLong(2, ex.getNumero());
			stmt.setLong(3, ex.getEdicao());
			stmt.setBoolean(4, ex.getDisponibilidade());
			stmt.setString(5, ex.getEstado_conservacao());
			stmt.setLong(6, ex.getAno_publicacao());
			inseriu=stmt.executeUpdate();
			stmt.close();
			if(inseriu==1) {
				String sql2="SELECT num_copias_disponiveis from Fisico WHERE isbn_livro=?";
				PreparedStatement stmt2=connection.prepareStatement(sql2);
				stmt2.setString(1, ex.getISBN_fisico());
				ResultSet rs2=stmt2.executeQuery();
				if(rs2.next()) {
					int copias_disponiveis=rs2.getInt("num_copias_disponiveis");
					copias_disponiveis=copias_disponiveis+1;
					String sql3="UPDATE Fisico SET num_copias_disponiveis=? WHERE isbn_livro=?";
					PreparedStatement stmt3=connection.prepareStatement(sql3);
					stmt3.setInt(1, copias_disponiveis);
					stmt3.setString(2, ex.getISBN_fisico());
					stmt3.execute();
					stmt3.close();
				}
				stmt2.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public Exemplar buscaISBNNum(String ISBN, long numero) {
		Exemplar ex=null;
		String sql="SELECT * FROM Exemplar WHERE ISBN_fisico=? and numero=?;";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, ISBN);
			stmt.setLong(2, numero);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Integer edicao=rs.getInt("edicao");
				Boolean disponibilidade=rs.getBoolean("disponibilidade");
				String estado_conservacao=rs.getString("estado_conservacao");
				Integer ano_publicacao=rs.getInt("ano_publicacao");
				
				ex=new Exemplar(ISBN, numero, edicao, disponibilidade, estado_conservacao, ano_publicacao);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ex;
	}
	
	public ArrayList<Exemplar> listarTodos(){
		listaTodos.clear();
		String sql="SELECT ISBN_fisico, numero from Exemplar";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Exemplar ex=buscaISBNNum(rs.getString("ISBN_fisico"), rs.getInt("numero"));
				if(ex!=null) {
					listaTodos.add(ex);	
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaTodos;
	}
	
	public int editar(Exemplar ex) {
		int editou=0;
		String sql="UPDATE Exemplar SET edicao=?, disponibilidade=?, estado_conservacao=?, ano_publicacao=? WHERE ISBN_fisico=? and numero=?";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setLong(1, ex.getEdicao());
			stmt.setBoolean(2, ex.getDisponibilidade());
			stmt.setString(3, ex.getEstado_conservacao());
			stmt.setLong(4, ex.getAno_publicacao());
			stmt.setString(5, ex.getISBN_fisico());
			stmt.setLong(6, ex.getNumero());
			editou=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return editou;
	}
	
	public int remover(Exemplar ex) {
		int removeu=0;
		String sql="DELETE FROM Emprestimo WHERE ISBN_exemplar=? and numero_exemplar=?";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, ex.getISBN_fisico());
			stmt.setLong(2, ex.getNumero());
			stmt.execute();
			stmt.close();
			String sql2="DELETE FROM Exemplar WHERE ISBN_fisico=? and numero=?";
			PreparedStatement stmt2=connection.prepareStatement(sql2);
			stmt2.setString(1, ex.getISBN_fisico());
			stmt2.setLong(2, ex.getNumero());
			removeu=stmt2.executeUpdate();
			stmt2.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public boolean disponibilidade(String ISBN, long numero) {
		boolean disponivel=false;
		String sql="SELECT disponibilidade FROM Exemplar WHERE ISBN_fisico=? and numero=?";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, ISBN);
			stmt.setLong(2, numero);
			ResultSet rs=stmt.executeQuery();
			if (rs.next()) {
				disponivel=rs.getBoolean("disponibilidade");
			}
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return disponivel;
	}
	
	public int mudarDisponibilidade(String ISBN, long numero) {
		int mudou=0;
		String sql="UPDATE Exemplar SET disponibilidade=0 WHERE ISBN_fisico=? and numero=?";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, ISBN);
			stmt.setLong(2, numero);
			mudou=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return mudou;
	}
}
