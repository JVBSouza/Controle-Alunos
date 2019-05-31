package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

import modelo.Registro;

public class RegistroRepository {

	public void persist(Registro registro) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO registros (cod_operador, cod_autorizacao, matricula, data, tipo) VALUES " +
					"(?, ?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.getConexao();) {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, registro.getCodOperador());
			ps.setInt(2, registro.getCodAutoriza());
			ps.setInt(3, registro.getMatricula());
			ps.setTimestamp(4, java.sql.Timestamp.valueOf(registro.getData()));
			ps.setString(5, registro.getTipo());
			ps.executeUpdate();
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally { }
	}

	public void find(int id) {
		Statement stmt = null;
		String sql = "Select * from registros where cod_registro ="+id;
		ResultSet rs = null;
		int codReg;
		int codOperador;
		int codAutoriza;
		int matricula;
		LocalDateTime data;
		String tipo;
		
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				codReg = rs.getInt("cod_registro");
				codOperador = rs.getInt("cod_operador");
				codAutoriza = rs.getInt("cod_autorizacao");
				matricula = rs.getInt("matricula");
				data = rs.getTimestamp("data").toLocalDateTime();
				tipo = rs.getString("tipo");
				
				System.out.println(codReg +" "+ codOperador +" "+ codAutoriza +" "+ matricula +" "+ data +" "+ tipo);
				
			}
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
			
		} finally {
			
		}
		
	}
	
}
