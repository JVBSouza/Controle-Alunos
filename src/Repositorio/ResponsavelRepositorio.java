package Repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Parentesco;
import modelo.Responsavel;

public class ResponsavelRepositorio {

	public void persist(Responsavel responsavel) {
		int cod = responsavel.getCodResponsavel();
		String nome = "'"+responsavel.getNome()+"'";
		int rg = responsavel.getRg();
		int cpf = responsavel.getCpf();
		int dataNasc = responsavel.getDataNasc();
		int telefone = responsavel.getTelefone();
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
	
}
