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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RelatorioRepository {

	// criacao de relatorios

	// abrir janela salvar
	public static void main(String[] args) {
//		gravar(escolherArquivo());
//		gravarAluno(escolherArquivo());
		escolherArquivo();
	}

	public static File escolherArquivo() {
		File relatorio = null;
		JFileChooser fc = new JFileChooser();
		int resp = fc.showSaveDialog(null);
		// fc.setAcceptAllFileFilterUsed(false);
		FileFilter csv = new FileNameExtensionFilter("comma separated value", "csv");
		fc.addChoosableFileFilter(csv);
		if (resp == JFileChooser.APPROVE_OPTION) {
			relatorio = fc.getSelectedFile();
		}
		System.out.println(relatorio.getAbsolutePath());
		return relatorio;

		// Para adicionar textbox com file em vez de fazer trocentos botões
		// https://docs.oracle.com/javase/8/docs/api/java/io/File.html
		// getAbsolutPath

	}

	// gravar arquivo
	public void gravar(File arquivo) {
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("COLUNA 1;COLUNA 2;COLUNA3\r\n");
			fw.write("José;Costa;43433\r\n");
			fw.write("Joao;Rafael;43433\r\n");
			fw.write("Pedro;Manoel;43433\r\n");
			fw.flush();

		} catch (IOException ex) {
		}
	}

	static void gravarAluno(File arquivo) {
		Statement stmt = null;
		String sql =  "SELECT alunos.matricula, alunos.nome, registros.hora, registros.tipo "
				+ "FROM registros, alunos, autorizacao "
				+ "WHERE registros.matricula = alunos.matricula";
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
				String linha = coluna1 + ";" + coluna2 + ";" + coluna3  + ";" + coluna4;
				saida.add(linha);
			}
		} catch (SQLException ex) {
			System.out.println("Erro:" + ex.getMessage());
		} finally {
		}
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("matricula;nome\r\n");
			for (String linha : saida) {
				fw.write(linha + "\r\n");
				fw.flush();
			}
		} catch (IOException ex) {
		}
	}

	static void gravarIrregular(File arquivo, int matricula) {
		Statement stmt = null;
		String sql = "SELECT alunos.nome, registros.hora, autorizacao.descr, registros.tipo"
				+ " FROM registros, alunos, autorizacao "
				+ "WHERE registros.matricula = "+ matricula + " AND registros.matricula = alunos.matricula "
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
				String linha = coluna1 + ";" + coluna2 + ";" + coluna3  + ";" + coluna4;
				saida.add(linha);
			}
		} catch (SQLException ex) {
			System.out.println("Erro:" + ex.getMessage());
		} finally {
		}
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("matricula;nome\r\n");
			for (String linha : saida) {
				fw.write(linha + "\r\n");
				fw.flush();
			}
		} catch (IOException ex) {
		}
	}

	static void gravarTurma(File arquivo, int turma) {
		Statement stmt = null;
		String sql = "Select alunos.matricula, alunos.nome "+
				"FROM alunos "+
				" WHERE alunos.matricula between 2019"+turma+"00 and 2019"+turma+"99";

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
				String linha = coluna1 + ";" + coluna2;
				saida.add(linha);
			}
		} catch (SQLException ex) {
			System.out.println("Erro:" + ex.getMessage());
		} finally {
		}
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("matricula;nome\r\n");
			for (String linha : saida) {
				fw.write(linha + "\r\n");
				fw.flush();
			}
		} catch (IOException ex) {
		}
	}
	
	static void gravarMes(File arquivo, int mes) {
		Statement stmt = null;
		String sql = "SELECT alunos.nome as 'Nome Aluno', responsaveis.nome as 'Nome Responsável', autorizacao.data, autorizacao.descr " + 
				"FROM alunos, responsaveis, autorizacao " + 
				"WHERE alunos.matricula = autorizacao.matricula " + 
				"AND autorizacao.cod_resp = responsaveis.cod_resp " + 
				"AND autorizacao.data between “2019-"+mes+"-01” and “2019-"+mes+"-30";
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
				String linha = coluna1 + ";" + coluna2 + ";" + coluna3  + ";" + coluna4;
				saida.add(linha);
			}
		} catch (SQLException ex) {
			System.out.println("Erro:" + ex.getMessage());
		} finally {
		}
		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("matricula;nome\r\n");
			for (String linha : saida) {
				fw.write(linha + "\r\n");
				fw.flush();
			}
		} catch (IOException ex) {
		}
	}
}
