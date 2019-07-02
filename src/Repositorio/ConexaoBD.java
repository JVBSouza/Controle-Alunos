package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	
	public static Connection getConexao() throws SQLException {
				
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/pi_controle?"+
				"user=root&password=" //xampp
				);
	}
}
