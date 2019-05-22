package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import modelo.Responsavel;

public class ResponsavelRepositorio {

	public void persist(Responsavel responsavel) {
		int cod = responsavel.getCodResponsavel();
		String nome = "'"+responsavel.getNome()+"'";
		int rg = responsavel.getRg();
		int cpf = responsavel.getCpf(); // cpf para string
		int dataNasc = responsavel.getDataNasc(); // data para date
		int telefone = responsavel.getTelefone(); // telefone para string
		String endereco = "'"+responsavel.getEndereco()+"'";
		String parentesco = "'"+responsavel.getParentesco()+"'";
		
		Statement stmt = null;
		String sql = "INSERT INTO responsaveis " +
					 "(CodResp, Nome, RG, CPF, Telefone, DataNasc, Endereço, Parentesco) " +
					 "Values ("+cod+", "+nome+","+rg +", "+cpf+", "+telefone+", "+dataNasc+", "+endereco+", "+parentesco+ ") ";
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {
			
		}
	}

	public void find(int id) {
		Statement stmt = null;
		String sql = "Select * from responsaveis where CodResp ="+id;
		ResultSet rs = null;
		
		int CodResp;
		String nome;
		int RG;
		int CPF;
		int Telefone;
		int DataNasc;
		String Endereco;
		String Parentesco;
		
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CodResp = rs.getInt("CodResp");
				nome = rs.getString("nome");
				RG = rs.getInt("RG");
				CPF = rs.getInt("CPF");
				Telefone = rs.getInt("Telefone");
				DataNasc = rs.getInt("DataNasc");
				Endereco = rs.getString("Endereço");
				Parentesco = rs.getString("Parentesco");
				System.out.println(CodResp +" "+ nome +" "+ RG +" "+ CPF +" "+ Telefone +" "+ DataNasc +" "+ Endereco +" "+ Parentesco);
				
			}
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
			
		} finally {
			
		}
			
	}
	
	public void update(int id) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o novo nome");
		String novoNome = scan.next();
		System.out.println("Digite um novo telefone");
		int novoTel = scan.nextInt();
		scan.close();
		
		PreparedStatement ps = null;
		String sql = "UPDATE responsaveis SET nome=? , RG= ?, CPF=? , Telefone=? , DataNasc=? , Endereço=? , Parentesco=? where CodResp = ?";
				
		try (Connection conn = ConexaoBD.getConexao();) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, novoNome);
			ps.setInt(2, 123456789);
			ps.setInt(3, 1234567);
			ps.setInt(4, novoTel);
			ps.setInt(5, 20190101);
			ps.setString(6, "Novo endereço");
			ps.setString(7, "PAI");
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
