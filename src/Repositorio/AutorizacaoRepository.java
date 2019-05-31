package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Autorizacao;

public class AutorizacaoRepository {
	
	public void persist(Autorizacao autorizacao) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO autorizacoes (matricula, cod_responsavel, cod_usuario, data, descricao, ativo, desc_cancelado) VALUES " +
					"(?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = ConexaoBD.getConexao();) {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
			ps.setInt(1, autorizacao.getMatricula());
			ps.setInt(2, autorizacao.getCodResponsavel());
			ps.setInt(3, autorizacao.getCodUsuario());
			ps.setTimestamp(4, java.sql.Timestamp.valueOf(autorizacao.getData()));
			ps.setString(5, autorizacao.getDesc());
			ps.setBoolean(6, autorizacao.isAtivo());
			
			ps.executeUpdate();
			
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {
			
		}	
		
	}
	
}
