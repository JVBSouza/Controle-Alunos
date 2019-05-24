package Repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Aluno;

public class AlunoRepository {

	public void persist(Aluno aluno) {
		int matricula = aluno.getMatricula();
		String nome = "'"+aluno.getNome()+"'";
		int rg = aluno.getRg();
		int cpf = aluno.getCpf();
		int dataNasc = aluno.getDataNasc();
		int telefone = aluno.getTelefone();
		String endereco = "'"+aluno.getEndereco()+"'";
		
		Statement stmt = null;
		String sql = "INSERT INTO alunos " +
					 "(matricula, nome, RG, CPF, Telefone, DataNasc, Endere�o) " +
					 "Values ("+matricula+", "+nome+","+rg +", "+cpf+", "+telefone+", "+dataNasc+", "+endereco+ ") ";
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {
			 
		}
		
	}
}
