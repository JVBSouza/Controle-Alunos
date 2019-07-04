package Repositorio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RelatorioRepository {

//	public static void main(String[] args) {
////		gravar(escolherArquivo());
//		gravarAluno(escolherArquivo());
//		gravarIrregular(escolherArquivo(), 20190102);
//		gravarTurma(escolherArquivo(), 1);
//		gravarMes(escolherArquivo(), 6);
//		gravarUser(escolherArquivo(), 1);
//	}

	// gravar arquivo
//	public void gravar(File arquivo) {
//		try (FileWriter fw = new FileWriter(arquivo)) {
//			fw.write("COLUNA 1;COLUNA 2;COLUNA3\r\n");
//			fw.write("José;Costa;43433\r\n");
//			fw.write("Joao;Rafael;43433\r\n");
//			fw.write("Pedro;Manoel;43433\r\n");
//			fw.flush();
//
//		} catch (IOException ex) {
//		}
//	}

	public static void gravarAluno(File arquivo) {
		Statement stmt = null;
		String sql = "SELECT alunos.matricula, alunos.nome, registros.hora, registros.tipo "
				+ "FROM registros, alunos " + "WHERE registros.matricula = alunos.matricula";
		ResultSet rs = null;
		List<String> saida = new LinkedList<String>();
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String coluna1 = rs.getString("matricula");
				String coluna2 = rs.getString("nome");
				String coluna3 = rs.getString("hora");
				String coluna4 = rs.getString("tipo");
				String linha = coluna1 + "	" + coluna2 + "	" + coluna3 + "	" + coluna4;
				saida.add(linha);
			}
		} catch (SQLException ex) {
			System.out.println("Erro:" + ex.getMessage());
		} finally {
		}
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("SOFTWARE CONTROLE\r\n**\r\nDesenvolvido por José e Rafael\r\n**\r\nRELATÓRIO DE REGISTRO DOS ALUNOS\r\n**\r\n\r\nMatricula	Nome	Data e Hora	Tipo\r\n");
			for (String linha : saida) {
				fw.write(linha + "\r\n");
				fw.flush();
			}
		} catch (IOException ex) {
			final JFrame popup = new JFrame();
			JOptionPane.showMessageDialog(popup, "Falha ao gerar o relatório", "Erro nos dados",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	public static void gravarIrregular(File arquivo, int matricula) {
		Statement stmt = null;
		String sql = "SELECT alunos.nome, registros.hora, autorizacao.descr, registros.tipo"
				+ " FROM registros, alunos, autorizacao " + "WHERE registros.matricula = " + matricula
				+ " AND registros.matricula = alunos.matricula "
				+ "AND autorizacao.cod_autoriza = registros.cod_autoriza";
		// Aqui ta pedindo a matrícula
		// Então tem que pedir a matrícula em algum lugar

		ResultSet rs = null;
		List<String> saida = new LinkedList<String>();
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String coluna1 = rs.getString("nome");
				String coluna2 = rs.getString("hora");
				String coluna3 = rs.getString("descr");
				String coluna4 = rs.getString("tipo");
				String linha = coluna1 + "	" + coluna2 + "	" + coluna3 + "	" + coluna4;
				saida.add(linha);
			}
		} catch (SQLException ex) {
			System.out.println("Erro:" + ex.getMessage());
		} finally {
		}
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("SOFTWARE CONTROLE\r\n**\r\nDesenvolvido por José e Rafael\r\n**\r\nRELATÓRIO DE REGISTROS IRREGULARES\r\n**\r\n\r\nNome	Horário	Descrição	Tipo\r\n");
			for (String linha : saida) {
				fw.write(linha + "\r\n");
				fw.flush();
			}
		} catch (IOException ex) {
		}
	}

	public static void gravarTurma(File arquivo, int turma) {
		Statement stmt = null;
		String sturma;

		if (turma < 10) {
			sturma = "0" + String.valueOf(turma);
		} else {
			sturma = String.valueOf(turma);
		}

		String sql = "Select alunos.matricula, alunos.nome " + "FROM alunos " + 
		" WHERE alunos.matricula like '2019"+sturma+"%'";

		// Aqui ta pedindo a matrícula
		// Então tem que pedir a matrícula em algum lugar

		ResultSet rs = null;
		List<String> saida = new LinkedList<String>();
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String coluna1 = rs.getString("matricula");
				String coluna2 = rs.getString("nome");
				String linha = coluna1 + "	" + coluna2;
				saida.add(linha);
			}
		} catch (SQLException ex) {
			System.out.println("Erro:" + ex.getMessage());
		} finally {
		}

		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("SOFTWARE CONTROLE\r\n**\r\nDesenvolvido por José e Rafael\r\n**\r\nRELATÓRIO DE TURMA\r\n**\r\nMatrícula	Nome\r\n");
			for (String linha : saida) {
				fw.write(linha + "\r\n");
				fw.flush();
			}
		} catch (IOException ex) {
		}
	}

	public static void gravarMes(File arquivo, int mes) {
		Statement stmt = null;
		String smes;
		if (mes < 10) {
			smes = String.valueOf(mes);
			smes = "0" + smes;
		} else {
			smes = String.valueOf(mes);
		}
		String sql = "SELECT alunos.nome as 'Nome Aluno', responsaveis.nome as 'Nome Responsável', autorizacao.data, autorizacao.descr "
				+ "FROM alunos, responsaveis, autorizacao " + "WHERE alunos.matricula = autorizacao.matricula "
				+ "AND autorizacao.cod_resp = responsaveis.cod_resp " + "AND autorizacao.data between '2019-" + smes
				+ "-01' and '2019-" + smes + "-30'";
		ResultSet rs = null;
		List<String> saida = new LinkedList<String>();
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String coluna1 = rs.getString("Nome Aluno");
				String coluna2 = rs.getString("Nome Responsável");
				String coluna3 = rs.getString("data");
				String coluna4 = rs.getString("descr");
				String linha = coluna1 + "	" + coluna2 + "	" + coluna3 + "	" + coluna4;
				saida.add(linha);
			}
		} catch (SQLException ex) {
			System.out.println("Erro:" + ex.getMessage());
		} finally {
		}
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("SOFTWARE CONTROLE\r\n**\r\nDesenvolvido por José e Rafael\r\n**\r\nRELATÓRIO DE AUTORIZAÇÕES DO MÊS\r\n**\r\nNome do Aluno	Nome do Responsável	Data	Descrição\r\n");
			for (String linha : saida) {
				fw.write(linha + "\r\n");
				fw.flush();
			}
		} catch (IOException ex) {
		}
	}

	public static void gravarUser(File arquivo, int user) {
		Statement stmt = null;
		String sUser = String.valueOf(user);
		String sql = "Select usuarios.nome, registros.hora, registros.tipo " + "FROM registros, usuarios "
				+ "WHERE registros.cod_user = usuarios.cod_user " + "AND usuarios.cod_user= " + sUser;
		ResultSet rs = null;
		List<String> saida = new LinkedList<String>();
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String coluna1 = rs.getString("nome");
				String coluna2 = rs.getString("hora");
				String coluna3 = rs.getString("tipo");
				String linha = coluna1 + "	" + coluna2 + "	" + coluna3;
				saida.add(linha);
			}
		} catch (SQLException ex) {
			System.out.println("Erro:" + ex.getMessage());
		} finally {
		}
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("SOFTWARE CONTROLE\r\n**\r\nDesenvolvido por José e Rafael\r\n**\r\nRELATÓRIO DE USUÁRIO\r\n**\r\nNome do operador	Hora	Tipo\r\n");
			for (String linha : saida) {
				fw.write(linha + "\r\n");
				fw.flush();
			}
		} catch (IOException ex) {
		}
	}

}
