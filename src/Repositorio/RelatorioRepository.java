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
	
	//criacao de relatorios
	
	//abrir janela salvar
	public static void main(String[]args) {
//		gravar(escolherArquivo());
		gravarAluno(escolherArquivo());
	}
	
	public static File escolherArquivo () {
		File relatorio = null;
		JFileChooser fc = new JFileChooser();
		int resp = fc.showSaveDialog(null);
		//fc.setAcceptAllFileFilterUsed(false);
		FileFilter csv = new FileNameExtensionFilter("comma separated value", "csv");
		fc.addChoosableFileFilter(csv);
		if (resp == JFileChooser.APPROVE_OPTION) {
			relatorio = fc.getSelectedFile();
		}
		System.out.println(relatorio.getAbsolutePath());
		return relatorio;
		
		//Para adicionar textbox com file em vez de fazer trocentos botões https://docs.oracle.com/javase/8/docs/api/java/io/File.html
		// getAbsolutPath
		
		
	}
	//gravar arquivo
	public void gravar(File arquivo) {
		try (FileWriter fw = new FileWriter (arquivo)) {
			fw.write("COLUNA 1;COLUNA 2;COLUNA3\r\n");
			fw.write("José;Costa;43433\r\n");
			fw.write("Joao;Rafael;43433\r\n");
			fw.write("Pedro;Manoel;43433\r\n");
			fw.flush();
			
		} catch (IOException ex) {	}
	}
	
	static void gravarAluno(File arquivo/*, int matricula*/) {
		Statement stmt = null;
		String sql = "SELECT matricula, nome FROM alunos"; /*where matricula ="+matricula;*/
		ResultSet rs = null;
		String teste;
		List<String> saida = new LinkedList<String>();
		try (Connection conn = ConexaoBD.getConexao();) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String coluna1 = rs.getString("matricula");
				String coluna2 = rs.getString("nome");
				System.out.println(coluna1 + " " + coluna2);
				String linha = coluna1+";"+coluna2;
				saida.add(linha);				
				System.out.println(saida);
//				Aluno aluno = null;
//				saida.add(aluno);
			}
		} catch (SQLException ex){
			// tratar erros
			System.out.println("Erro:" + ex.getMessage());
		} finally {	}
		
		try (FileWriter fw = new FileWriter (arquivo)) {
			fw.write("matricula;nome\r\n");
			for (String linha : saida) {
				fw.write(linha+"\r\n");
			}
		} catch (IOException ex) {
		}
	}

}
