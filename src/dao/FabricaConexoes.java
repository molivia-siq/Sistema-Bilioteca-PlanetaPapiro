package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
	public Connection getConnetion() {
		try {
			return (Connection)DriverManager.getConnection("jdbc:mysql://localhost/Biblioteca", "root", "molimysql");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
