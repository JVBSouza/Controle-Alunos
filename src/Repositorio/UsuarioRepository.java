package Repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.Usuario;

public class UsuarioRepository {

	public Usuario find(int idUser) {
		Statement stmt = null;
		String sql = "SELECT * FROM usuarios where cod_user =" + idUser;
		ResultSet rs = null;
		int codUser;
		String nome;
		String rg;
		String cpf;
		String telefone;
		LocalDate dataNasc;
		String endereco;
		String turno;
		String setor;
		String senha;
		Usuario user = null;

		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				codUser = rs.getInt("cod_user");
				nome = rs.getString("nome");
				cpf = rs.getString("cpf");
				rg = rs.getString("rg");
				dataNasc = rs.getDate("datanasc").toLocalDate();
				endereco = rs.getString("endereco");
				telefone = rs.getString("telefone");
				turno = rs.getString("turno");
				setor = rs.getString("setor");
				senha = rs.getString("senha");
				
				user = new Usuario(nome, cpf, rg, telefone, dataNasc, endereco, turno, setor);
				user.setCodUsuario(codUser);
				user.setSenha(senha);
			}
		} catch (SQLException ex) {

		} finally {
		}
		if (user == null) {
			final JFrame popup = new JFrame();
			JOptionPane.showMessageDialog(popup, "Código de usuário inválido", "Erro na matrícula",
					JOptionPane.ERROR_MESSAGE);
		}
		return user;
	}
}
