package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import modelo.Responsavel;

public class ResponsavelRepository {

	public void persist(Responsavel responsavel) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO responsaveis (nome, rg, cpf, telefone, datanasc, endereco, parentesco) VALUES " +
					"(?, ?, ?, ? , ?, ?, ?)";
		
//		Statement stmt = null;
//		String sql = "INSERT INTO responsaveis " +
//					 "(Nome, RG, CPF, Telefone, DataNasc, Endere�o, Parentesco) " +
//					 "Values ("+nome+","+rg +", "+cpf+", "+telefone+", "+datanasc+", "+endereco+", "+parentesco+ ") ";
		try (Connection conn = ConexaoBD.getConexao();) {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, responsavel.getNome());
			ps.setInt(2, responsavel.getRg());
			ps.setString(3, responsavel.getCpf());
			ps.setString(4, responsavel.getTelefone());
			ps.setDate(5, java.sql.Date.valueOf(responsavel.getDatanasc()));
			ps.setString(6, responsavel.getEndereco());
			ps.setString(7, responsavel.getParentesco());
			
			ps.executeUpdate();
			
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {
			
		}
	}

	public Responsavel find(int id) {
		Statement stmt = null;
		String sql = "Select * from responsaveis where codresp ="+id;
		ResultSet rs = null;
		
		int CodResp;
		String nome;
		int RG;
		String CPF;
		String telefone;
		LocalDate datanasc;
		String endereco;
		String parentesco;
		Responsavel responsavel = null;
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				
				CodResp = rs.getInt("codresp");
				nome = rs.getString("nome");
				RG = rs.getInt("rg");
				CPF = rs.getString("cpf");
				telefone = rs.getString("telefone");
				datanasc = rs.getDate("datanasc").toLocalDate();
				endereco = rs.getString("endereco");
				parentesco = rs.getString("parentesco");
				
				responsavel = new Responsavel(nome, CPF, RG, telefone, datanasc, endereco, parentesco);
				
//				System.out.println(CodResp +" "+ nome +" "+ RG +" "+ CPF +" "+ Telefone +" "+ datanasc +" "+ Endereco +" "+ Parentesco);
				
			}
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
			
		} finally {
			
		}
		
		return responsavel;
		
	}
	
	public void update(int id, Responsavel resp) {
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("Digite o novo nome");
//		String novoNome = scan.next();
//		System.out.println("Digite um novo telefone");
//		String novoTel = scan.next();
//		scan.close();
		
		PreparedStatement ps = null;
		String sql = "UPDATE responsaveis SET nome=? , rg= ?, cpf=? , telefone=? , datanasc=? , endereco=? , parentesco=? where codresp = ?";
				
		try (Connection conn = ConexaoBD.getConexao();) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, resp.getNome());
			ps.setInt(2, resp.getRg());
			ps.setString(3, resp.getCpf());
			ps.setString(4, resp.getTelefone());
			ps.setDate(5, java.sql.Date.valueOf(resp.getDatanasc()));
			ps.setString(6, resp.getEndereco());
			ps.setString(7, resp.getParentesco());
			ps.setInt(8, id);
			ps.executeUpdate();
			
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
			
		} finally {
			
		}
	}
	
	public void delete(int id) {
		Statement stmt = null;
		String sql = "Delete from responsaveis where CodResp = "+id;
		
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
