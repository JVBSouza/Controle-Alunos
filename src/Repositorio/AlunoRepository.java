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
		String sql = "INSERT INTO alunos (matricula, nome, rg, cpf, telefone, datanasc, endereco) VALUES " +
					"(?, ?, ?, ? , ?, ?, ?)";
		
//		Statement stmt = null;
//		String sql = "INSERT INTO responsaveis " +
//					 "(Nome, RG, CPF, Telefone, DataNasc, Endere�o, Parentesco) " +
//					 "Values ("+nome+","+rg +", "+cpf+", "+telefone+", "+datanasc+", "+endereco+", "+parentesco+ ") ";
		try (Connection conn = ConexaoBD.getConexao();) {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, aluno.getNome());
			ps.setInt(3, aluno.getRg());
			ps.setString(4, aluno.getCpf());
			ps.setString(5, aluno.getTelefone());
			ps.setDate(6, java.sql.Date.valueOf(aluno.getDatanasc()));
			ps.setString(7, aluno.getEndereco());
			ps.executeUpdate();
			
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {
			
		}
		
	}

	public Aluno find(int matricula) {
		Statement stmt = null;
		String sql = "SELECT * FROM alunos where matricula ="+matricula;
		ResultSet rs = null;
		
		int valorMatricula;
		String nome;
		int rg;
		String cpf;
		String telefone;
		LocalDate dataNasc;
		String endereco;
		
		Aluno aluno = null;
		
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				valorMatricula = rs.getInt("matricula");
				nome = rs.getString("nome");
				rg = rs.getInt("rg");
				cpf = rs.getString("cpf");
				telefone = rs.getString("telefone");
				dataNasc = rs.getDate("datanasc").toLocalDate();
				endereco = rs.getString("endereco");
				
				aluno = new Aluno(nome, cpf, rg, telefone, dataNasc, endereco);
				
//				System.out.println(valorMatricula +" "+ nome +" "+ RG +" "+ CPF +" "+ Telefone +" "+ datanasc +" "+ Endereco);
			}
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {
			
		}
		
		return aluno;
		
	}

	public void update(int matricula, Aluno aluno) {
		PreparedStatement ps = null;
		String sql = "UPDATE alunos SET nome=?, rg= ?, cpf=?, telefone=?, datanasc=?, endereco=? where matricula = ?";
				
		try (Connection conn = ConexaoBD.getConexao();) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setInt(2, aluno.getRg());
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
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
			
		} finally {
			
		}
	}
}

