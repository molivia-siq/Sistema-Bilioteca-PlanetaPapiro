package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaDAO {
	private Connection connection;
	
	public ConsultaDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	
	public ArrayList <ArrayList<Object>> totalEmprestimosF(){
		ArrayList <ArrayList<Object>> listaTotalEmpF=new  ArrayList<>();
		String sql="Select f.CPF_pessoa as CPF, p.nome, f.data_admissao, count(e.CPF_funcionario) as total_emprestimos from ((Funcionario f join Pessoa p on f.CPF_pessoa=p.CPF) join Emprestimo e on f.CPF_pessoa=e.CPF_funcionario) group by f.CPF_pessoa, p.nome;";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				ArrayList <Object> listaRs=new ArrayList<>();
				listaRs.add(rs.getString("CPF"));
				listaRs.add(rs.getString("nome"));
				java.util.Date data_admissao=null;
            	if(rs.getDate("data_admissao")!=null) {
            		java.sql.Date data_admissao_sql=rs.getDate("data_admissao"); 
            		data_admissao=new java.util.Date(data_admissao_sql.getTime());	
            	}
				listaRs.add(data_admissao);
				listaRs.add(rs.getInt("total_emprestimos"));
				listaTotalEmpF.add(listaRs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaTotalEmpF;
	}
	
	public ArrayList <ArrayList<Object>> totalEmprestimosC(){
		ArrayList <ArrayList<Object>> listaTotalEmpC=new  ArrayList<>();
		String sql="select c.CPF_pessoa as CPF, p.nome, c.data_cadastro, count(e.CPF_cliente) as total_emprestimos from ((Cliente c join Pessoa p on c.CPF_pessoa=p.CPF) join Emprestimo e on c.CPF_pessoa=e.CPF_cliente) group by c.CPF_pessoa, p.nome";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				ArrayList <Object> listaRs=new ArrayList<>();
				listaRs.add(rs.getString("CPF"));
				listaRs.add(rs.getString("nome"));
				java.util.Date data_cadastro=null;
            	if(rs.getDate("data_cadastro")!=null) {
            		java.sql.Date data_cadastro_sql=rs.getDate("data_cadastro"); 
            		data_cadastro=new java.util.Date(data_cadastro_sql.getTime());	
            	}
				listaRs.add(data_cadastro);
				listaRs.add(rs.getInt("total_emprestimos"));
				listaTotalEmpC.add(listaRs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaTotalEmpC;
	}
	
	public ArrayList <ArrayList<Object>> totalLivrosFG(){
		ArrayList <ArrayList<Object>> listaTotalLFG=new  ArrayList<>();
		String sql="Select g.genero, sum(lf.num_copias_disponiveis) as soma_copias_disponiveis from (Fisico lf join Genero_Livro g on lf.ISBN_livro=g.ISBN_livro) group by g.genero";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				ArrayList <Object> listaRs=new ArrayList<>();
				listaRs.add(rs.getString("genero"));
				listaRs.add(rs.getInt("soma_copias_disponiveis"));
				listaTotalLFG.add(listaRs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaTotalLFG;
	}
	
	public int totalEmprestimosHoje(){
		int totalEmpH=0;
		String sql="Select count(*) as total_emprestimos from Emprestimo e where e.data=curdate()";
		PreparedStatement stmt;
		try {
			stmt=(PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				totalEmpH=rs.getInt("total_emprestimos");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return totalEmpH;
	}
}
