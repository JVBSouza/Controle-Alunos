package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	
	public static Connection getConexao() {
		//retornar conexão com o banco de daods
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/senai?"+
					"user=host&password=master123"
					);
		} catch (SQLException ex) {
			//tratar erros
		}
		
		
		return conn;
	}
}
