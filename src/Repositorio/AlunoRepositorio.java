package Repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Aluno;

public class AlunoRepositorio {

	public void persist(Aluno aluno) {
		int matricula = aluno.getMatricula();
		String nome = "'"+aluno.getNome()+"'";
		int rg = aluno.getRg();
		int cpf = aluno.getCpf();
		int dataNasc = aluno.getDataNasc();
		int telefone = aluno.getTelefone();
		String endereco = "'"+aluno.getEndereco()+"'";
		
		
		Connection conn = ConexaoBD.getConexao();
		Statement stmt = null;
		String sql = "INSERT INTO alunos " +
					 "(matricula, nome, rg, cpf, telefone, dataNasc, Endereco, responsavel1, responsavel2) " +
					 "Values ("+matricula+", "+nome+","+rg +", "+cpf+", "+telefone+", "+dataNasc+", "+endereco+ ") ";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException ex){
			// tratar erros
		} finally {
			
		}
	}
}
