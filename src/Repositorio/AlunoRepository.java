package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import modelo.Aluno;

public class AlunoRepository {

	public void persist(Aluno aluno) {
				
		PreparedStatement ps = null;
		String sql = "INSERT INTO alunos (matricula, nome, rg, cpf, telefone, datanasc, endereco, responsavel_1, responsavel_2) VALUES " +
					"(?, ?, ?, ? , ?, ?, ?, ?, ?)";
		
		int count = count();
		int numero = 20190101 + count;
		
		try (Connection conn = ConexaoBD.getConexao();) {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, numero);
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getRg());
			ps.setString(4, aluno.getCpf());
			ps.setString(5, aluno.getTelefone());
			ps.setDate(6, java.sql.Date.valueOf(aluno.getDatanasc()));
			ps.setString(7, aluno.getEndereco());
			ps.setInt(8, aluno.getResponsavel1());
			ps.setInt(9, aluno.getResponsavel2());
			ps.executeUpdate();
			
		} catch (SQLException ex){
			System.out.println("Erro:" + ex.getMessage());
		} finally { }
	}

	public Aluno find(int matricula) {
		Statement stmt = null;
		String sql = "SELECT * FROM alunos where matricula ="+matricula;
		ResultSet rs = null;
		int valorMatricula;
		String nome;
		String rg;
		String cpf;
		String telefone;
		LocalDate dataNasc;
		String endereco;
		int resp1;
		int resp2;
		Aluno aluno = null;
		
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				valorMatricula = rs.getInt("matricula");
				nome = rs.getString("nome");
				rg = rs.getString("rg");
				cpf = rs.getString("cpf");
				telefone = rs.getString("telefone");
				dataNasc = rs.getDate("datanasc").toLocalDate();
				endereco = rs.getString("endereco");
				resp1 = rs.getInt("responsavel_1");
				resp2 = rs.getInt("responsavel_2");
				aluno = new Aluno(nome, cpf, rg, telefone, dataNasc, endereco, resp1, resp2);
				aluno.setMatricula(valorMatricula);
			}
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {	}
		
		return aluno;
	}

	public void update(int matricula, Aluno aluno) {
		PreparedStatement ps = null;
		String sql = "UPDATE alunos SET nome=?, rg= ?, cpf=?, telefone=?, datanasc=?, endereco=? where matricula = ?";
				
		try (Connection conn = ConexaoBD.getConexao();) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getRg());
			ps.setString(3, aluno.getCpf());
			ps.setString(4, aluno.getTelefone());
			ps.setDate(5, java.sql.Date.valueOf(aluno.getDatanasc()));
			ps.setString(6, aluno.getEndereco());
			ps.setInt(7, matricula);
			ps.executeUpdate();
			
		} catch (SQLException ex){
			System.out.println("Erro:" + ex.getMessage());
		} finally {		}
	}

	public void delete(int matricula) {
		Statement stmt = null;
		String sql = "Delete from alunos where matricula = "+matricula;
		
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException ex){
			System.out.println("Erro:" + ex.getMessage());
			
		} finally {}
	}
	
	public int count() {
		int count = 0;
		Statement stmt = null;
		String sql = "SELECT count(*) as total from alunos";
		ResultSet rs = null;
				
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("total");				
			}
		} catch (SQLException ex){
			System.out.println("Erro:" + ex.getMessage());
		} finally {}
		
		return count;
	}
}

