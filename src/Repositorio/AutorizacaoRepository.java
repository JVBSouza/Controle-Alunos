package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

import modelo.Aluno;
import modelo.Autorizacao;

public class AutorizacaoRepository {
	
	public void persist(Autorizacao autorizacao) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO autorizacao (matricula, cod_resp, cod_user, data, descr, ativo, descr_cancel) VALUES " +
					"(?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = ConexaoBD.getConexao();) {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, autorizacao.getMatricula());
			ps.setInt(2, autorizacao.getCodResponsavel());
			ps.setInt(3, autorizacao.getCodUsuario());
			ps.setTimestamp(4, java.sql.Timestamp.valueOf(autorizacao.getData()));
			ps.setString(5, autorizacao.getDesc());
			ps.setBoolean(6, autorizacao.isAtivo());
			ps.setString(7, null);
			
			ps.executeUpdate();
			
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {
			
		}	
		
	}
	
	public Autorizacao find (int idAutoriza) {
		Statement stmt = null;
		String sql = "SELECT * FROM autorizacao where cod_autoriza =" + idAutoriza;
		ResultSet rs = null;
		
		Autorizacao autorizacao = null;
		
		int codAutoriza;
		int matricula;
		int codUser;
		int codResp;
		LocalDateTime hora;
		String descr;
		boolean ativo;
		
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				codAutoriza = rs.getInt("cod_autoriza");
				matricula = rs.getInt("Matricula");
				codResp = rs.getInt("cod_resp");
				codUser = rs.getInt("cod_user");
				descr = rs.getString("descr");
				hora = null;
				
				autorizacao = new Autorizacao(matricula, codResp, codUser, hora, descr);
			}
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {	}
		
		return autorizacao;
	}
	
	public void update(int idAutoriza, String descrCancel) {
		PreparedStatement ps = null;
		String sql = "UPDATE autorizacao SET ativo = false, descr_cancel = ? where cod_autoriza = ?";
		
		try (Connection conn = ConexaoBD.getConexao();) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, descrCancel);
			ps.setInt(2, idAutoriza);
			
			ps.executeUpdate();
			
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally { }
	}
	
	
}
