package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
