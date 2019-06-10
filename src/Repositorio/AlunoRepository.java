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

	public void find(int matricula) {
		Statement stmt = null;
		String sql = "SELECT * FROM aluno where matricula ="+matricula;
		ResultSet rs = null;
		
		int valorMatricula;
		String nome;
		int RG;
		String CPF;
		String Telefone;
		LocalDate datanasc;
		String Endereco;
		
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				valorMatricula = rs.getInt("matricula");
				nome = rs.getString("nome");
				RG = rs.getInt("rg");
				CPF = rs.getString("cpf");
				Telefone = rs.getString("telefone");
				datanasc = rs.getDate("datanasc").toLocalDate();
				Endereco = rs.getString("endereco");
				System.out.println(valorMatricula +" "+ nome +" "+ RG +" "+ CPF +" "+ Telefone +" "+ datanasc +" "+ Endereco);
			}
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {
			
		}
			
	}

	public void update(int matricula ) {
		Scanner scan = new Scanner(System.in);
		//nome, RG, CPF, Telefone, DataNasc, Endereço
		System.out.println("Digite o novo nome");
		String novoNome = scan.next();
		System.out.println("Digite um novo telefone");
		String novoTel = scan.next();
		System.out.println("Digite um novo RG");
		int novoRG = scan.nextInt();
		System.out.println("Digite um novo CPF");
		String novoCPF = scan.next();
		System.out.println("Digite um novo Endereco");
		String novoEndereco = scan.next();
//		System.out.println("Digite a nova Data de Nascimento");
//		LocalDate novaData = scan.hasNext();
		//TEM Q VER COMO PEGAR A DATA DE NASCIMENTO
		scan.close();
		
		PreparedStatement ps = null;
		String sql = "UPDATE alunos SET nome=? , rg= ?, cpf=? , telefone=? ,  endereco=? where matricula = ?";
				
		try (Connection conn = ConexaoBD.getConexao();) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, novoNome);
			ps.setInt(2, novoRG);
			ps.setString(3, novoCPF);
			ps.setString(4, novoTel);
//			ps.setDate(5, java.sql.Date.valueOf(LocalDate.of(1994, 03, 20))); TEM Q ADICIONAR A DATA DEPOIS NO SQL
			ps.setString(5, novoEndereco);
			ps.setInt(6, matricula);
			ps.executeUpdate();
			
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
			
		} finally {
			
		}
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

