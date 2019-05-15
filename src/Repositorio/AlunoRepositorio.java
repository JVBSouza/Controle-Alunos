package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlunoRepositorio {

	public void persist() {
		Connection conn = ConexaoBD.getConexao();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO alunos " +
					 "(matricula, nome, rg, cpf, telefone, dataNasc, Endereco, responsavel1, responsavel2) " +
					 "Values () ";
		
	}
}
