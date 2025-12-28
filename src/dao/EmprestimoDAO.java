package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;import java.util.ArrayList;

import bean.Emprestimo;

public class EmprestimoDAO {

	private Connection connection;
	private ArrayList<Emprestimo> listaTodos=new ArrayList<>();

	public EmprestimoDAO() {
		connection = new FabricaConexoes().getConnetion();
	}

	public int inserir(Emprestimo em) {
		int inseriu = 0;
		String sql = "INSERT INTO Emprestimo VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			java.sql.Date data_sql = new java.sql.Date(em.getData().getTime());
			java.sql.Date data_fim_sql = new java.sql.Date(em.getDataFim().getTime());
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, em.getCPF_Cliente());
			stmt.setString(2, em.getISBN_Livro());
			stmt.setLong(3, em.getNumero());
			stmt.setDate(4, data_sql);
			stmt.setTime(5, em.getHora());
			stmt.setString(6, em.getCPF_Funcionario());
			stmt.setDate(7, data_fim_sql);
			stmt.setString(8, em.getTermoCompromisso());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}

	public Emprestimo buscaCPFISBNNumDataHora(String cpfCliente, String isbn, long numero, java.util.Date data, Time hora) {
		Emprestimo em = null;
		String sql = "SELECT * FROM Emprestimo WHERE CPF_cliente=? and ISBN_exemplar=? and numero_exemplar=? and data=? and hora=?";
		try {
			java.sql.Date data_sql = new java.sql.Date(data.getTime());
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpfCliente);
			stmt.setString(2, isbn);
			stmt.setLong(3, numero);
			stmt.setDate(4, data_sql);
			stmt.setTime(5, hora);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				java.util.Date dataFim = null;
				if (rs.getDate("data_fim") != null) {
					java.sql.Date data_fim_sql = rs.getDate("data_fim");
					dataFim = new java.util.Date(data_fim_sql.getTime());
				}
				String cpfFuncionario = rs.getString("CPF_Funcionario");
				String termoCompromisso = rs.getString("termo_compromisso");
				em = new Emprestimo(cpfCliente, isbn, numero, data, hora, cpfFuncionario, dataFim, termoCompromisso);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return em;
	}

	public int editar(Emprestimo em) {
		int editou = 0;
		String sql = "UPDATE Emprestimo SET CPF_funcionario=?, data_fim=?, termo_compromisso=?  WHERE CPF_cliente=? and ISBN_exemplar=? and numero_exemplar=? and data=? and hora=?";
		PreparedStatement stmt;
		try {
		    java.sql.Date data_sql = new java.sql.Date(em.getData().getTime());
		    java.sql.Date data_fim_sql = new java.sql.Date(em.getDataFim().getTime());
		    stmt=(PreparedStatement)connection.prepareStatement(sql);
			stmt.setString(1, em.getCPF_Funcionario());
			stmt.setDate(2, data_fim_sql);
			stmt.setString(3, em.getTermoCompromisso());
			stmt.setString(4, em.getCPF_Cliente());
			stmt.setString(5, em.getISBN_Livro());
			stmt.setLong(6, em.getNumero());
			stmt.setDate(7, data_sql);
			stmt.setTime(8, em.getHora());
			editou=stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return editou;
	}

	public int remover(Emprestimo em) {
		int removeu = 0;
		String sql = "DELETE FROM Emprestimo WHERE CPF_cliente=? and ISBN_exemplar=? and numero_exemplar=? and data=? and hora=?";
		PreparedStatement stmt;
		try {
		    java.sql.Date data_sql = new java.sql.Date(em.getData().getTime());
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, em.getCPF_Cliente());
			stmt.setString(2, em.getISBN_Livro());
			stmt.setLong(3, em.getNumero());
			stmt.setDate(4, data_sql);
			stmt.setTime(5, em.getHora());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}

	public ArrayList<Emprestimo> listarTodos() {
		listaTodos.clear();
		String sql = "SELECT * FROM Emprestimo";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
			    java.sql.Date data_sql = new java.sql.Date(rs.getDate("data").getTime());
                Emprestimo em=buscaCPFISBNNumDataHora(rs.getString("cpf_cliente"), rs.getString("ISBN_exemplar"), rs.getLong("numero_exemplar"), data_sql, rs.getTime("hora"));
				if(em!=null) {
					listaTodos.add(em);	
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTodos;
	}

}
